package coolcool.mz.entity

import coolcool.mz.dto.mzlist.MzlistDetailReq
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.time.LocalDateTime

@Entity
@Table(name = "tb_mzlist")
class Mzlist(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val mzlistId: Long,
    val mzlistOwnerId: Long,
    val mzlistName: String,
    val mzlistDescription: String?,
    val mzlistIcon: String?,
    val createDate: LocalDateTime,
    val createUser: Long,
    val updateDate: LocalDateTime,
    val updateUser: Long,
) {
    companion object {
        fun ofCreate(userId: Long, mzlistDetailReq: MzlistDetailReq): Mzlist {
            val now = LocalDateTime.now()

            return Mzlist(
                mzlistId = 0L,
                mzlistOwnerId = userId,
                mzlistName = mzlistDetailReq.mzlistName,
                mzlistDescription = mzlistDetailReq.mzlistDescription,
                mzlistIcon = mzlistDetailReq.mzlistIcon,
                createDate = now,
                createUser = userId,
                updateDate = now,
                updateUser = userId,
            )
        }

        fun ofUpdate(mzlistId: Long, userId: Long, mzlist: Mzlist, mzlistDetailReq: MzlistDetailReq): Mzlist {
            val now = LocalDateTime.now()

            return Mzlist(
                mzlistId = mzlistId,
                mzlistOwnerId = userId,
                mzlistName = mzlistDetailReq.mzlistName,
                mzlistDescription = mzlistDetailReq.mzlistDescription,
                mzlistIcon = mzlistDetailReq.mzlistIcon,
                createDate = mzlist.createDate,
                createUser = mzlist.createUser,
                updateDate = now,
                updateUser = userId,
            )
        }
    }
}
