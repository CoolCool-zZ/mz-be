package coolcool.mz.exception

import coolcool.mz.dto.ResponseDto
import jakarta.validation.ConstraintViolationException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class GlobalExceptionHandler {
    @ExceptionHandler(ConstraintViolationException::class)
    fun handleConstraintViolationException(exception: ConstraintViolationException): ResponseEntity<ResponseDto<String>> {
        // TODO errorMessage 이렇게 가져오는 게 맞는지 체크 필요
        val errorMessage = exception.constraintViolations.toList().first().message
        return ResponseEntity(ResponseDto.ofError(errorMessage), HttpStatus.BAD_REQUEST)
    }

    @ExceptionHandler(IllegalArgumentException::class)
    fun handleIllegalArgumentException(exception: IllegalArgumentException): ResponseEntity<ResponseDto<String>> {
        return ResponseEntity(ResponseDto.ofError(exception.localizedMessage), HttpStatus.BAD_REQUEST)
    }

    @ExceptionHandler(Exception::class)
    fun handleException(exception: Exception): ResponseEntity<ResponseDto<String>> {
        return ResponseEntity(ResponseDto.ofError("Internal server error occurs"), HttpStatus.INTERNAL_SERVER_ERROR)
    }
}
