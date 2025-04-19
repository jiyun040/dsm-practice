package kr.mooner510.dsmpractice.domain_page.controller

import kr.mooner510.dsmpractice.domain_page.data.entity.Tag
import kr.mooner510.dsmpractice.domain_page.data.service.TagService
import org.springframework.web.bind.annotation.*

class TagController (
    private val tagService: TagService
) {
    @GetMapping
    fun getAllTags(): List<Tag> {
        return tagService.getAllTags()
    }

    @PostMapping
    fun createTag(@RequestBody tag: Tag): Tag {
        return tagService.createTag(tag)
    }

    @GetMapping("/{id}")
    fun getTagById(@PathVariable id: Long): Tag? {
        return tagService.getTagById(id)
    }

    @DeleteMapping("/{id}")
    fun deleteTag(@PathVariable id: Long) {
        return tagService.deleteTagById(id)
    }
}