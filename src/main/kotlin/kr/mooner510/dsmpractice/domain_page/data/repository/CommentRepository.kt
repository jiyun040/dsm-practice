package kr.mooner510.dsmpractice.domain_page.data.repository

import kr.mooner510.dsmpractice.domain_page.data.entity.Comment
import org.springframework.data.jpa.repository.JpaRepository

interface CommentRepository: JpaRepository<Comment, Long> {
}