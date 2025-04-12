package kr.mooner510.dsmpractice.security.component

import io.jsonwebtoken.ExpiredJwtException
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.UnsupportedJwtException
import io.jsonwebtoken.security.Keys
import kr.mooner510.dsmpractice.global.error.ErrorCode
import kr.mooner510.dsmpractice.global.error.data.GlobalError
import kr.mooner510.dsmpractice.security.data.entity.user.User
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component
import java.time.Instant
import java.util.*

@Component
class TokenProvider(
    @Value("\${security.key}") private val keyString: String,
    @Value("\${security.access}") private val accessTime: Long,
    @Value("\${security.refresh}") private val refreshTime: Long,
) {
    private val key = Keys.hmacShaKeyFor(keyString.toByteArray())
    private val parser = Jwts.parser().verifyWith(key).build()

    fun newAccess(user: User): String {
        // 유저에 대한 간략한 정보 = id, name
        // 발급 시간
        // 만료 시간

        val now = Instant.now() // 현재 시간을 구하는 코드

        return Jwts.builder()
            .id(user.id.toString()) // 유저의 id
            .subject("acc") // 토큰의 사용 용도
            .claim("name", user.name) // 유저의 이름
            .issuedAt(Date.from(now)) // 토큰 발급일
            .expiration(Date.from(now.plusSeconds(accessTime))) // 토큰 만료일
            .signWith(key) // 암호화할 키
            .compact()
    }

    fun newRefresh(user: User): String {
        throw NotImplementedError()
    }

    fun getUser(token: String, isAccessToken: Boolean): User {
        try {
            val claims = parser.parseSignedClaims(token).payload

            if(isAccessToken && claims.subject != "acc") {
                throw GlobalError(ErrorCode.UNSUPPORTED_TOKEN)
            }

            return User(
                claims.id.toLong(),
                claims.get("name", String::class.java),
                ""
            )
        } catch (e: Exception) {
            e.printStackTrace()
            if (e is UnsupportedJwtException) {
                throw GlobalError(ErrorCode.UNSUPPORTED_TOKEN)
            } else if (e is ExpiredJwtException) {
                throw GlobalError(ErrorCode.EXPIRED_TOKEN)
            }
            throw e
        }
    }
}
