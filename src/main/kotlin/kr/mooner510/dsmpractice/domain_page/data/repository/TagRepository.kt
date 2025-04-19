package kr.mooner510.dsmpractice.domain_page.data.repository

import kr.mooner510.dsmpractice.domain_page.data.entity.Tag
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface TagRepository : JpaRepository<Tag, Long> {
    fun findByName(name: String): Tag
}