package kr.mooner510.dsmpractice.domain_page.controller

import kr.mooner510.dsmpractice.domain_page.data.entity.Post
import kr.mooner510.dsmpractice.domain_page.data.service.PostService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/posts")
class PostController(
    private val postService: PostService
) {
    @GetMapping
    fun search(
        @RequestParam(required = false) title: String?,
        @RequestParam(required = false) content: String?,
        @RequestParam(required = false) tag: String?,
    ): List<Post> {
        val posts = mutableSetOf<Post>()

        title?.let { posts.addAll(postService.searchPostByTitle(it)) }
        content?.let { posts.addAll(postService.searchPostByContent(it)) }
        tag?.let { posts.addAll(postService.searchPostByTag(it)) }

        return posts.toList()
    }
}