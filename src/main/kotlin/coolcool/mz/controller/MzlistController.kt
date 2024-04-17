package coolcool.mz.controller

import coolcool.mz.dto.ResponseDto
import coolcool.mz.dto.mzlist.MzlistDetailReq
import coolcool.mz.dto.mzlist.MzlistDetailRes
import coolcool.mz.service.MzlistService
import jakarta.validation.Valid
import jakarta.validation.constraints.Positive
import org.springframework.http.MediaType
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@Validated
@RestController
class MzlistController(
    private val mzlistService: MzlistService,
) {
    @PostMapping("/mzlist", consumes = [MediaType.APPLICATION_JSON_VALUE])
    fun createMzlist(
        @Valid @RequestBody mzlistDetailReq: MzlistDetailReq,
    ): ResponseDto<Long> {
        return ResponseDto.ofSuccess(mzlistService.createMzlist(mzlistDetailReq))
    }

    @PutMapping("/mzlist/{mzlistId}", consumes = [MediaType.APPLICATION_JSON_VALUE])
    fun updateMzlist(
        @PathVariable("mzlistId") @Positive(message = "mzlistId should be positive") mzlistId: Long,
        @Valid @RequestBody mzlistDetailReq: MzlistDetailReq,
    ): ResponseDto<Long> {
        if (mzlistDetailReq.isInvalidForUpdate()) {
            throw IllegalArgumentException("mzlistOwnerId should not be null")
        }

        return ResponseDto.ofSuccess(mzlistService.updateMzlist(mzlistId, mzlistDetailReq))
    }

    @DeleteMapping("/mzlist/{mzlistId}")
    fun deleteMzlist(
        @PathVariable("mzlistId") @Positive(message = "mzlistId should be positive") mzlistId: Long,
    ): ResponseDto<*> {
        mzlistService.deleteMzlist(mzlistId)

        return ResponseDto.ofSuccessWithoutData()
    }

    @GetMapping("/mzlist/owned")
    fun getMyOwnedMzlistList(): ResponseDto<List<MzlistDetailRes>> {
        return ResponseDto.ofSuccess(mzlistService.getMyOwnedMzlistList())
    }

    @GetMapping("/mzlist/owned/{mzlistId}")
    fun getMyOwnedMzlistDetail(
        @PathVariable("mzlistId") @Positive(message = "mzlistId should be positive") mzlistId: Long,
    ): ResponseDto<MzlistDetailRes> {
        return ResponseDto.ofSuccess(mzlistService.getMyOwnedMzlistDetailOrThrowIfNotOwned(mzlistId))
    }
}
