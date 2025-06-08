package coolcool.mz.entity

import jakarta.persistence.Column
import jakarta.persistence.MappedSuperclass
import java.time.LocalDateTime

@MappedSuperclass
abstract class BaseAuditEntity {
    @Column(name = "created_by")
    var createdBy: Int? = null

    @Column(name = "created_at")
    var createdAt: LocalDateTime = LocalDateTime.now()

    @Column(name = "updated_by")
    var updatedBy: Int? = null

    @Column(name = "updated_at")
    var updatedAt: LocalDateTime = LocalDateTime.now()
}
