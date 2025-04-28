package kr.mooner510.dsmpractice.domain_page.data.dto

data class CreatePostRequest(
    val title: String,
    val content: String,
    val tag: String,
)