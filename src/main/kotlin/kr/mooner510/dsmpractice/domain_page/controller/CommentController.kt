package kr.mooner510.dsmpractice.domain_page.controller

import kr.mooner510.dsmpractice.domain_page.data.entity.Comment
import kr.mooner510.dsmpractice.domain_page.data.service.CommentService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/comments")
class CommentController (
    private val commentService: CommentService
) {
    @PostMapping
    fun createComment(@RequestBody comment: Comment): Comment {
        return commentService.createComment(comment)
    }

    @GetMapping
    fun getAllComments(): List<Comment> {
        return commentService.getAllComments()
    }
}