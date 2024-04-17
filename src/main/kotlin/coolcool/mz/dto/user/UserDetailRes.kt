package coolcool.mz.dto.user

import coolcool.mz.entity.User
import java.time.LocalDate

class UserDetailRes private constructor(
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
        fun from(user: User): UserDetailRes {
            return UserDetailRes(
                userId = user.userId,
                name = user.name,
                nickname = user.nickname,
                password = user.password,
                birthday = user.birthday,
                gender = user.gender,
                authorityCode = user.authorityCode,
                useYn = user.useYn,
            )
        }
    }
}
