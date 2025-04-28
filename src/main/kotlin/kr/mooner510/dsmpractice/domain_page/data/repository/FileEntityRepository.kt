package kr.mooner510.dsmpractice.domain_page.data.repository

import kr.mooner510.dsmpractice.domain_page.data.entity.FileEntity
import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID

interface FileEntityRepository: JpaRepository<FileEntity, UUID> {
}