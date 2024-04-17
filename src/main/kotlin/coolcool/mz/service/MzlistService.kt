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
    fun createMzlist(mzlistDetailReq: MzlistDetailReq): Long {
        val userId = sessionService.getUserIdFromSession()

        return mzlistRepository.save(Mzlist.ofCreate(userId, mzlistDetailReq)).mzlistId
    }

    fun updateMzlist(mzlistId: Long, mzlistDetailReq: MzlistDetailReq): Long {
        val userId = sessionService.getUserIdFromSession()
        if (userId != mzlistDetailReq.mzlistOwnerId) {
            throw IllegalArgumentException("only update owned mzlist")
        }

        getMyOwnedMzlistDetailOrThrowIfNotOwned(mzlistId)

        return mzlistRepository.save(Mzlist.ofUpdate(mzlistId, userId, mzlistDetailReq)).mzlistId
    }

    fun deleteMzlist(mzlistId: Long) {
        getMyOwnedMzlistDetailOrThrowIfNotOwned(mzlistId)

        mzlistRepository.deleteById(mzlistId)
    }

    private fun getMzlistDetailOrThrowIfNotExist(mzlistId: Long): MzlistDetailRes {
        val mzlist = mzlistRepository.findById(mzlistId).orElseThrow { throw IllegalArgumentException("mzlistId $mzlistId not exist") }

        return MzlistDetailRes.from(mzlist)
    }

    fun getMyOwnedMzlistDetailOrThrowIfNotOwned(mzlistId: Long): MzlistDetailRes {
        val userId = sessionService.getUserIdFromSession()
        val mzlistDetailRes = getMzlistDetailOrThrowIfNotExist(mzlistId)

        if (userId != mzlistDetailRes.mzlistOwnerId) {
            throw IllegalArgumentException("user does not owned mzlist with mzlistId $mzlistId")
        }

        return mzlistDetailRes
    }

    fun getMyOwnedMzlistList(): List<MzlistDetailRes> {
        val userId = sessionService.getUserIdFromSession()

        return mzlistRepository.findMzlistByMzlistOwnerId(userId).stream()
            .map(MzlistDetailRes::from)
            .toList()
    }
}
