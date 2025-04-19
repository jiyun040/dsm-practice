package kr.mooner510.dsmpractice.security.data.entity.user

import jakarta.persistence.*
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.userdetails.UserDetails

@Entity
class User(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    val id: Long,

    @Column(nullable = false)
    val name: String,

    @Column(nullable = false)
    val _password: String
): UserDetails {
    override fun getAuthorities(): Collection<GrantedAuthority> {
        return emptyList()
    }

    override fun getPassword(): String {
        return _password
    }

    override fun getUsername(): String {
        return name
    }
}