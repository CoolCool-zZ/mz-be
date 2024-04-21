package coolcool.mz.entity

import coolcool.mz.constant.CommonConstant.SpecialUserId
import jakarta.persistence.MappedSuperclass
import java.time.LocalDateTime

@MappedSuperclass
open class BaseEntity(
    protected val createDate: LocalDateTime = LocalDateTime.now(),
    protected val createUser: Long = SpecialUserId.SYSTEM_USER_ID.userId,
    protected val updateDate: LocalDateTime = LocalDateTime.now(),
    protected val updateUser: Long = SpecialUserId.SYSTEM_USER_ID.userId,
)
