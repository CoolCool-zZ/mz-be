package coolcool.mz.service

import coolcool.mz.constant.CommonConstant.YesNo
import coolcool.mz.dto.user.UserDetailRes
import coolcool.mz.repository.UserRepository
import org.springframework.stereotype.Service

@Service
class UserService(
    private val userRepository: UserRepository,
    private val sessionService: SessionService,
) {
    fun getUserDetail(userId: Long): UserDetailRes {
        val userDetailRes = UserDetailRes.from(userRepository.findByUserId(userId) ?: throw IllegalArgumentException("userId $userId does not exist"))
        if (YesNo.NO.code == userDetailRes.useYn) {
            throw IllegalArgumentException("userId $userId does not exist")
        }

        return userDetailRes
    }

    fun getUserFromSession(): UserDetailRes {
        val userId = sessionService.getUserIdFromSession()
        return getUserDetail(userId)
    }
}
