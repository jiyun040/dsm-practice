package kr.mooner510.dsmpractice.domain_page.data.repository

import kr.mooner510.dsmpractice.domain_page.data.entity.Post
import org.springframework.data.jpa.repository.JpaRepository

interface PostRepository: JpaRepository<Post, Long> {
    fun findByTitle(title: String): List<Post>
    fun findByContent(content: String): List<Post>
}