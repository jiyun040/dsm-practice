package kr.mooner510.dsmpractice.domain_page.data.service

import kr.mooner510.dsmpractice.domain_page.data.entity.Comment
import kr.mooner510.dsmpractice.domain_page.data.repository.CommentRepository
import org.springframework.stereotype.Service

@Service
class CommentService (
    private val commentRepository: CommentRepository
) {
    fun createComment(comment: Comment): Comment{
        return commentRepository.save(comment)
    }

    fun getAllComments(): List<Comment> {
        return commentRepository.findAll()
    }
}