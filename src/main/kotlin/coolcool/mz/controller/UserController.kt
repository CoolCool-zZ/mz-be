package coolcool.mz.controller

import coolcool.mz.dto.ResponseDto
import coolcool.mz.entity.User
import coolcool.mz.service.UserService
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import jakarta.validation.constraints.Positive
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@Tag(name = "user")
@Validated
@RestController
class UserController(
    private val userService: UserService,
) {
    @Operation(description = "get user detail")
    @GetMapping("/user/{userId}")
    fun getUserDetail(
        @PathVariable(name = "userId") @Positive(message = "userId should be positive") userId: Long,
    ): ResponseDto<User> {
        return ResponseDto.ofSuccess(userService.getUserDetail(userId))
    }
}
