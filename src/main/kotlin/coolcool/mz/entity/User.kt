package coolcool.mz.entity

import jakarta.persistence.CascadeType
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.OneToMany
import jakarta.persistence.Table
import java.time.LocalDateTime

@Entity
@Table(name = "users")
data class User(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    val userId: Int = 0,

    @Column(name = "username", unique = true, nullable = false)
    var username: String,

    @Column(name = "email", unique = true, nullable = false)
    var email: String,

    @Column(name = "password", nullable = false)
    var password: String,

    @Column(name = "phone_number")
    var phoneNumber: String? = null,

    @Column(name = "full_name")
    var fullName: String? = null,

    @Column(name = "is_active")
    var isActive: Boolean = true,

    @Column(name = "last_login_at")
    var lastLoginAt: LocalDateTime? = null,

    @Column(name = "email_verified_at")
    var emailVerifiedAt: LocalDateTime? = null,

    @Column(name = "email_verification_token")
    var emailVerificationToken: String? = null,

    @Column(name = "password_reset_token")
    var passwordResetToken: String? = null,

    @Column(name = "password_reset_expired_at")
    var passwordResetExpiredAt: LocalDateTime? = null,

    // Relationships
    @OneToMany(mappedBy = "user", cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
    val userHistories: MutableList<UserHistory> = mutableListOf(),

    @OneToMany(mappedBy = "user", cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
    val loginHistories: MutableList<LoginHistory> = mutableListOf(),

    @OneToMany(mappedBy = "addedUser", cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
    val addedMatZips: MutableList<MatZip> = mutableListOf(),

    @OneToMany(mappedBy = "owner", cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
    val ownedLists: MutableList<MatZipList> = mutableListOf(),

    @OneToMany(mappedBy = "createdUser", cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
    val createdTags: MutableList<Tag> = mutableListOf(),
) : BaseAuditEntity()
