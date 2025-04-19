package kr.mooner510.dsmpractice.domain_page.data.entity

import jakarta.persistence.*

@Entity
data class Tag (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    @Column(nullable = false, unique = true)
    var name: String,


    @ManyToMany(mappedBy = "tags")
    val posts: List<Post> = listOf()
)