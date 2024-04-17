package coolcool.mz.dto

class ResponseDto<T> private constructor(
    val status: ResponseStatus,
    val data: T?,
) {
    enum class ResponseStatus {
        SUCCESS,
        FAIL,
        ERROR,
    }

    companion object {
        fun <T> ofSuccess(data: T): ResponseDto<T> {
            return ResponseDto(status = ResponseStatus.SUCCESS, data = data)
        }

        fun ofSuccessWithoutData(): ResponseDto<*> {
            return ResponseDto(status = ResponseStatus.SUCCESS, data = null)
        }

        fun ofFail(data: String): ResponseDto<String> {
            return ResponseDto(status = ResponseStatus.FAIL, data = data)
        }

        fun ofError(data: String): ResponseDto<String> {
            return ResponseDto(status = ResponseStatus.ERROR, data = data)
        }
    }
}
