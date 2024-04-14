package coolcool.mz.exception

import jakarta.validation.ConstraintViolationException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class GlobalExceptionHandler {
    @ExceptionHandler(ConstraintViolationException::class)
    fun handleConstraintViolationException(exception: ConstraintViolationException): ResponseEntity<ErrorResponse> {
        // TODO errorMessage 이렇게 가져오는 게 맞는지 체크 필요
        val errorMessage = exception.constraintViolations.toList().first().message
        val errorResponse = ErrorResponse(errorCode = "BAD_REQUEST", errorMessage = errorMessage)
        return ResponseEntity(errorResponse, HttpStatus.BAD_REQUEST)
    }

    @ExceptionHandler(Exception::class)
    fun handleException(exception: Exception): ResponseEntity<ErrorResponse> {
        val errorResponse = ErrorResponse(errorCode = "INTERNAL_SERVER_ERROR", errorMessage = "Internal server error occurs")
        return ResponseEntity(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR)
    }
}
