package coolcool.mz.repository

import coolcool.mz.entity.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository : JpaRepository<User, Long> {
    fun findByUserId(userId: Long): User
}
