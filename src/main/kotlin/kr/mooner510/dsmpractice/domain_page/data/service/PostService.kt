package kr.mooner510.dsmpractice.domain_page.data.service

import kr.mooner510.dsmpractice.domain_page.data.dto.CreatePostRequest
import kr.mooner510.dsmpractice.domain_page.data.dto.PostResponse
import kr.mooner510.dsmpractice.domain_page.data.entity.Post
import kr.mooner510.dsmpractice.domain_page.data.repository.PostRepository
import kr.mooner510.dsmpractice.domain_page.data.repository.TagRepository
import org.springframework.stereotype.Service
import kotlin.reflect.jvm.internal.impl.descriptors.Visibilities.Private

@Service
class PostService (
    private val postRepository: PostRepository,
    private val tagRepository: TagRepository
) {
    fun searchPostByTitle(title: String): List<Post> {
        return postRepository.findByTitle(title)
    }

    fun searchPostByContent(content: String): List<Post> {
        return postRepository.findByContent(content)
    }

    fun searchPostByTag(tag: String): List<Post> {
        return tagRepository.findByName(tag).posts
    }
}