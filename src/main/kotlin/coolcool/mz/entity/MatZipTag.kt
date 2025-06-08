package coolcool.mz.entity

import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.Id
import jakarta.persistence.IdClass
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table

@Entity
@Table(name = "mat_zip_tags")
@IdClass(MatZipTagId::class)
data class MatZipTag(
    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mat_zip_id")
    val matZip: MatZip,

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tag_id")
    val tag: Tag,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "added_user_id", nullable = false)
    val addedUser: User,
) : BaseAuditEntity()

// Composite key for MatZipTag
data class MatZipTagId(
    val matZip: Int = 0,
    val tag: Int = 0,
) : java.io.Serializable
