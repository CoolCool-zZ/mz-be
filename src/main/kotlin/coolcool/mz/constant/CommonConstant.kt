package coolcool.mz.constant

class CommonConstant {
    enum class YesNo(
        val code: String,
    ) {
        YES("Y"),
        NO("N"),
    }

    enum class SpecialUserId(
        val userId: Long,
    ) {
        SYSTEM_USER_ID(-1L),
    }
}
