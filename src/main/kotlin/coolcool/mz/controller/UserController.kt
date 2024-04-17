package coolcool.mz.controller

import coolcool.mz.dto.ResponseDto
import coolcool.mz.dto.user.UserDetailRes
import coolcool.mz.service.UserService
import jakarta.validation.constraints.Positive
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@Validated
@RestController
class UserController(
    private val userService: UserService,
) {
    @GetMapping("/user/{userId}")
    fun getUserDetail(
        @PathVariable(name = "userId") @Positive(message = "userId should be positive") userId: Long,
    ): ResponseDto<UserDetailRes> {
        return ResponseDto.ofSuccess(userService.getUserDetail(userId))
    }
}
