package coolcool.mz.service

import coolcool.mz.entity.User
import coolcool.mz.repository.UserRepository
import org.springframework.stereotype.Service

@Service
class UserService(
    private val userRepository: UserRepository,
) {
    fun getUserDetail(userId: Long): User {
        val user = userRepository.findByUserId(userId) ?: throw IllegalArgumentException("userId $userId does not exist")

        return user
    }
}
