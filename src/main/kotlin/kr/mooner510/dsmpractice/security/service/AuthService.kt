package kr.mooner510.dsmpractice.security.service

import kr.mooner510.dsmpractice.global.error.ErrorCode
import kr.mooner510.dsmpractice.global.error.data.GlobalError
import kr.mooner510.dsmpractice.security.component.TokenProvider
import kr.mooner510.dsmpractice.security.data.entity.user.User
import kr.mooner510.dsmpractice.security.data.request.LoginRequest
import kr.mooner510.dsmpractice.security.data.response.TokenResponse
import kr.mooner510.dsmpractice.security.data.response.TokenResponseAccessOnly
import kr.mooner510.dsmpractice.security.repository.UserRepository
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
import java.util.*
import kotlin.jvm.optionals.getOrNull

@Service
class AuthService(
    private val userRepository: UserRepository,
    private val passwordEncoder: PasswordEncoder,
    private val tokenProvider: TokenProvider
) {
    fun login(req: LoginRequest): TokenResponse {
        val user = userRepository.findByName(req.id).getOrNull() ?: throw GlobalError(ErrorCode.USER_NOT_FOUND)

        if(passwordEncoder.matches(req.password, user.password)){
            val token = tokenProvider.newAccess(user)
            return TokenResponse(token, refreshToken = "")
        }

        throw GlobalError(ErrorCode.LOGIN_FAILED)
    }

    fun signUp(req: LoginRequest) {
        if (userRepository.existsByName(req.id)) {
            throw GlobalError(ErrorCode.USER_ALREADY_EXISTS)
        }

        userRepository.save(
            User(0, req.id, passwordEncoder.encode(req.password)))
    }

//    fun reissue(req: ReissueRequest): TokenResponseAccessOnly {
//        throw NotImplementedError()
//    }
}
