package coolcool.mz.service

import coolcool.mz.dto.mzlist.MzlistDetailReq
import coolcool.mz.dto.mzlist.MzlistDetailRes
import coolcool.mz.entity.Mzlist
import coolcool.mz.repository.MzlistRepository
import org.springframework.stereotype.Service

@Service
class MzlistService(
    private val mzlistRepository: MzlistRepository,
    private val sessionService: SessionService,
) {
    private fun getMzlistDetailOrThrowIfNotExist(mzlistId: Long): Mzlist {
        val mzlist = mzlistRepository.findById(mzlistId).orElseThrow { throw IllegalArgumentException("mzlistId $mzlistId not exist") }

        return mzlist
    }

    private fun getMyOwnedMzlistDetailOrThrowIfNotOwned(mzlistId: Long): Mzlist {
        val userId = sessionService.getUserIdFromSession()
        val mzlist = getMzlistDetailOrThrowIfNotExist(mzlistId)

        if (userId != mzlist.mzlistOwnerId) {
            throw IllegalArgumentException("user does not owned mzlist with mzlistId $mzlistId")
        }

        return mzlist
    }

    fun createMzlist(mzlistDetailReq: MzlistDetailReq): Long {
        val userId = sessionService.getUserIdFromSession()

        return mzlistRepository.save(Mzlist.ofCreate(userId, mzlistDetailReq)).mzlistId
    }

    fun updateMzlist(mzlistId: Long, mzlistDetailReq: MzlistDetailReq): Long {
        val userId = sessionService.getUserIdFromSession()
        if (userId != mzlistDetailReq.mzlistOwnerId) {
            throw IllegalArgumentException("only update owned mzlist")
        }

        val mzlist = getMyOwnedMzlistDetailOrThrowIfNotOwned(mzlistId)

        return mzlistRepository.save(Mzlist.ofUpdate(mzlistId, userId, mzlist, mzlistDetailReq)).mzlistId
    }

    fun deleteMzlist(mzlistId: Long) {
        getMyOwnedMzlistDetailOrThrowIfNotOwned(mzlistId)

        mzlistRepository.deleteById(mzlistId)
    }

    fun getMyOwnedMzlistDetail(mzlistId: Long): MzlistDetailRes {
        return MzlistDetailRes.from(getMyOwnedMzlistDetailOrThrowIfNotOwned(mzlistId))
    }

    fun getMyOwnedMzlistList(): List<MzlistDetailRes> {
        val userId = sessionService.getUserIdFromSession()

        return mzlistRepository.findMzlistByMzlistOwnerId(userId)
            .map(MzlistDetailRes::from)
    }
}
