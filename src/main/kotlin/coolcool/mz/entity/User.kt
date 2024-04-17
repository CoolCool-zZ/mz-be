package coolcool.mz.entity

import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.time.LocalDate
import java.time.LocalDateTime

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
    val createDate: LocalDateTime,
    val createUser: Long,
    val updateDate: LocalDateTime,
    val updateUser: Long,
)
