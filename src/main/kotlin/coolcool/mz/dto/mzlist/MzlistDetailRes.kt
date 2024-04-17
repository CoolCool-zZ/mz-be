package coolcool.mz.dto.mzlist

import coolcool.mz.entity.Mzlist

class MzlistDetailRes private constructor(
    val mzlistId: Long,
    val mzlistOwnerId: Long,
    val mzlistName: String,
    val mzlistDescription: String?,
    val mzlistIcon: String?,
) {
    companion object {
        fun from(mzlist: Mzlist): MzlistDetailRes {
            return MzlistDetailRes(
                mzlistId = mzlist.mzlistId,
                mzlistOwnerId = mzlist.mzlistOwnerId,
                mzlistName = mzlist.mzlistName,
                mzlistDescription = mzlist.mzlistDescription,
                mzlistIcon = mzlist.mzlistIcon,
            )
        }
    }
}
