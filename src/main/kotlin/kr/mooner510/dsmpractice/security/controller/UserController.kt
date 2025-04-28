package kr.mooner510.dsmpractice.security.controller

import io.swagger.v3.oas.annotations.Operation
import kr.mooner510.dsmpractice.security.data.entity.user.User
import kr.mooner510.dsmpractice.security.service.UserService
import org.springframework.http.MediaType
import org.springframework.security.core.annotation.AuthenticationPrincipal
import org.springframework.web.bind.annotation.*
import org.springframework.web.multipart.MultipartFile

@RestController
@RequestMapping("/api/user")
class UserController(
    private val userService: UserService
) {
    @Operation(summary = "유저 썸네일 업로드")
    @PostMapping("/thumbnail", consumes = [MediaType.MULTIPART_FORM_DATA_VALUE, MediaType.APPLICATION_JSON_VALUE])
    fun updateThumbnail(
        @AuthenticationPrincipal user: User,
        @RequestPart file: MultipartFile,
    ) {
        userService.updateThumbnail(user, file)
    }
}