package coolcool.mz.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.FetchType
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table

@Entity
@Table(name = "mat_zip_list_histories")
data class MatZipListHistory(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "list_history_id")
    val listHistoryId: Int = 0,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "list_id", nullable = false)
    val list: MatZipList,

    @Column(name = "list_name")
    var listName: String? = null,

    @Column(name = "description")
    var description: String? = null,

    @Column(name = "owner_id")
    var ownerId: Int? = null,

    @Column(name = "ownership_transferred_by")
    var ownershipTransferredBy: Int? = null,

    @Enumerated(EnumType.STRING)
    @Column(name = "change_type", nullable = false)
    var changeType: ChangeType,
) : BaseAuditEntity()
