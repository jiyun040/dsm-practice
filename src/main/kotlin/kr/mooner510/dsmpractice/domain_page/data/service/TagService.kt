package kr.mooner510.dsmpractice.domain_page.data.service

import kr.mooner510.dsmpractice.domain_page.data.entity.Tag
import kr.mooner510.dsmpractice.domain_page.data.repository.TagRepository
import org.springframework.stereotype.Service

@Service
class TagService(
    private val tagRepository: TagRepository
) {
    fun createTag(tag: Tag): Tag {
        return tagRepository.save(tag)
    }

    fun getAllTags(): List<Tag> {
        return tagRepository.findAll()
    }

    fun getTagById(id: Long): Tag? {
        return tagRepository.findById(id).orElse(null)
    }

    fun deleteTagById(id: Long) {
        return tagRepository.deleteById(id)
    }
}