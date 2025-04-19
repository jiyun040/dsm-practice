package kr.mooner510.dsmpractice.domain_page.data.entity

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
data class Post(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @Column(nullable = false)
    val title: String,

    @Column(nullable = false)
    val content: String,

    @ManyToMany
    @JoinTable(
        name = "post_tag",
        joinColumns = [JoinColumn(name = "post_id")],
        inverseJoinColumns = [JoinColumn(name = "tag_id")]
    )
    val tags: List<Tag> = listOf(),

    @Column(name = "created_at", nullable = false)
    val createdAt: LocalDateTime = LocalDateTime.now(),

    @Column(name = "updated_at", nullable = false)
    val updatedAt: LocalDateTime = LocalDateTime.now()
)