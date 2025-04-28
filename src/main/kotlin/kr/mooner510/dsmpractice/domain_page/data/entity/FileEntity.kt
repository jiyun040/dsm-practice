package kr.mooner510.dsmpractice.domain_page.data.entity

import jakarta.persistence.*
import java.util.UUID

@Entity
@Table(name = "file")
class FileEntity(
    @Column(nullable = false, updatable = false, columnDefinition = "BINARY(16)")
    val userId: Long,

    @Column(nullable = false, updatable = false)
    val title: String,

    @Lob
    @Basic(fetch = FetchType.LAZY)
    @Column(nullable = false, updatable = false)
    val content: ByteArray,

    @Id
    @Column(columnDefinition = "BINARY(16)")
    val id: UUID = UUID.randomUUID(),
)
