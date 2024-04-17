package coolcool.mz.entity

import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.time.LocalDate

@Entity
@Table(name = "tb_user")
class User(
    @Id
    val userId: Long,
    val name: String,
    val nickname: String?,
    val password: String,
    val birthday: LocalDate,
    val gender: String,
    val authorityCode: String,
    val useYn: String,
) {
    companion object {
        fun getSystemUser(): User {
            return User(
                userId = -1,
                name = "SYSTEM",
                nickname = null,
                password = "",
                birthday = LocalDate.MAX,
                gender = "",
                authorityCode = "",
                useYn = "",
            )
        }
    }
}
