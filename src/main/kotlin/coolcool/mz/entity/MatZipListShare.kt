package coolcool.mz.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table
import java.time.LocalDateTime

@Entity
@Table(name = "mat_zip_list_shares")
data class MatZipListShare(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "share_id")
    val shareId: Int = 0,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "list_id", nullable = false)
    val list: MatZipList,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "shared_user_id", nullable = false)
    val sharedUser: User,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "shared_by_user_id", nullable = false)
    val sharedByUser: User,

    @Column(name = "can_edit_list_info")
    var canEditListInfo: Boolean = false,

    @Column(name = "can_edit_list_items")
    var canEditListItems: Boolean = false,

    @Column(name = "can_edit_shared_users")
    var canEditSharedUsers: Boolean = false,

    @Column(name = "shared_at")
    var sharedAt: LocalDateTime = LocalDateTime.now(),
) : BaseAuditEntity()
