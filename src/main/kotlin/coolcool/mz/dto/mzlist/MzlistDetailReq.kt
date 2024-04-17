package coolcool.mz.dto.mzlist

import jakarta.validation.constraints.Positive
import jakarta.validation.constraints.Size

class MzlistDetailReq(
    @field:Positive(message = "mzlistOwnerId should be positive")
    val mzlistOwnerId: Long?,
    @field:Size(max = 40)
    val mzlistName: String,
    @field:Size(max = 100)
    val mzlistDescription: String?,
    @field:Size(max = 40)
    val mzlistIcon: String?,
) {
    fun isInvalidForUpdate(): Boolean {
        return mzlistOwnerId == null
    }
}
