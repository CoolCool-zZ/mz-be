package coolcool.mz.exception

import com.fasterxml.jackson.databind.exc.MismatchedInputException
import coolcool.mz.dto.ResponseDto
import jakarta.validation.ConstraintViolationException
import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.http.converter.HttpMessageNotReadableException
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class GlobalExceptionHandler {
    private val log = LoggerFactory.getLogger(this.javaClass)!!

    @ExceptionHandler(MethodArgumentNotValidException::class)
    fun handleMethodArgumentNotValidException(exception: MethodArgumentNotValidException): ResponseEntity<ResponseDto<String>> {
        log.debug(exception.localizedMessage)

        val invalidFieldName = exception.fieldError?.field
        val errorMessage = "$invalidFieldName is invalid"
        return ResponseEntity(ResponseDto.ofError(errorMessage), HttpStatus.BAD_REQUEST)
    }

    @ExceptionHandler(HttpMessageNotReadableException::class)
    fun handleHttpMessageNotReadableException(exception: HttpMessageNotReadableException): ResponseEntity<ResponseDto<String>> {
        log.debug(exception.localizedMessage)

        val invalidFieldName = (exception.cause as MismatchedInputException).path?.first()?.fieldName
        val errorMessage = "$invalidFieldName is invalid"
        return ResponseEntity(ResponseDto.ofError(errorMessage), HttpStatus.BAD_REQUEST)
    }

    @ExceptionHandler(ConstraintViolationException::class)
    fun handleConstraintViolationException(exception: ConstraintViolationException): ResponseEntity<ResponseDto<String>> {
        log.debug(exception.localizedMessage)

        val errorMessage = exception.constraintViolations.toList().first().message
        return ResponseEntity(ResponseDto.ofError(errorMessage), HttpStatus.BAD_REQUEST)
    }

    @ExceptionHandler(IllegalArgumentException::class)
    fun handleIllegalArgumentException(exception: IllegalArgumentException): ResponseEntity<ResponseDto<String>> {
        log.debug(exception.localizedMessage)

        return ResponseEntity(ResponseDto.ofError(exception.localizedMessage), HttpStatus.BAD_REQUEST)
    }

    @ExceptionHandler(Exception::class)
    fun handleException(exception: Exception): ResponseEntity<ResponseDto<String>> {
        log.debug(exception.localizedMessage)

        return ResponseEntity(ResponseDto.ofError("Internal server error occurs"), HttpStatus.INTERNAL_SERVER_ERROR)
    }
}
