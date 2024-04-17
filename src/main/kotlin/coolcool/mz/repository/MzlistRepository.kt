package coolcool.mz.repository

import coolcool.mz.entity.Mzlist
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface MzlistRepository : JpaRepository<Mzlist, Long> {
    fun findMzlistByMzlistOwnerId(mzlistOwnerId: Long): List<Mzlist>
}
