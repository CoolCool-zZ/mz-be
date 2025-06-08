package coolcool.mz.entity

import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.Id
import jakarta.persistence.IdClass
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table

@Entity
@Table(name = "mat_zip_list_items")
@IdClass(MatZipListItemId::class)
data class MatZipListItem(
    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "list_id")
    val list: MatZipList,

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mat_zip_id")
    val matZip: MatZip,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "added_user_id", nullable = false)
    val addedUser: User,
) : BaseAuditEntity()

// Composite key for MatZipListItem
data class MatZipListItemId(
    val list: Int = 0,
    val matZip: Int = 0,
) : java.io.Serializable
