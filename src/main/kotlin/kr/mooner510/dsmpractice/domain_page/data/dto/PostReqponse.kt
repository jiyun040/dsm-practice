package kr.mooner510.dsmpractice.domain_page.data.dto

data class PostResponse(
    val id: Long,
    val title: String,
    val content: String,
    val tag: String?
)