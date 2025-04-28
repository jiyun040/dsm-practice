package kr.mooner510.dsmpractice.domain_page.controller

import io.swagger.v3.oas.annotations.Operation
import kr.mooner510.dsmpractice.domain_page.data.dto.CreatePostRequest
import kr.mooner510.dsmpractice.domain_page.data.dto.PostResponse
import kr.mooner510.dsmpractice.domain_page.data.entity.Post
import kr.mooner510.dsmpractice.domain_page.data.service.PostService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/posts")
class PostController(
    private val postService: PostService
) {
    @Operation (
        summary = "게시글 작성",
        description = "새로운 게시글을 생성합니다."
    )
    @PostMapping
    fun createPost(@RequestBody request: CreatePostRequest): PostResponse {
        return postService.createP(request)
    }

    @Operation(
        summary = "게시글 검색",
        description = "제목, 내용, 태그를 이용해서 게시글을 검색합니다."
    )
    @GetMapping
    fun search(
        @RequestParam(required = false) title: String?,
        @RequestParam(required = false) content: String?,
        @RequestParam(required = false) tag: String?,
    ): List<Post> {
        val posts = mutableSetOf<Post>()

        title?.let { posts.addAll(postService.searchPostByTitle(it)) }
        content?.let { posts.addAll(postService.searchPostByContent(it)) }
        tag?.let { posts.addAll(postService.searchPostByTag(it)) }

        return posts.toList()
    }
}