package kr.mooner510.dsmpractice.domain_page.data.entity

import jakarta.persistence.*
import org.springframework.cglib.core.Local
import java.time.LocalDateTime

@Entity
data class Comment (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long?,

    @Column(nullable = false)
    val author: String,

    @Column(nullable = false)
    val content: String,

    @Column(name = "created_at", nullable = false)
    val createdAt: LocalDateTime = LocalDateTime.now(),

    @ManyToOne
    val post: Post
)