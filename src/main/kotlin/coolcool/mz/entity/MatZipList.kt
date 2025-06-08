package coolcool.mz.entity

import jakarta.persistence.CascadeType
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.OneToMany
import jakarta.persistence.Table

@Entity
@Table(name = "mat_zip_lists")
data class MatZipList(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "list_id")
    val listId: Int = 0,

    @Column(name = "list_name", nullable = false)
    var listName: String,

    @Column(name = "description", columnDefinition = "TEXT")
    var description: String? = null,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "owner_id", nullable = false)
    var owner: User,

    // Relationships
    @OneToMany(mappedBy = "list", cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
    val listItems: MutableList<MatZipListItem> = mutableListOf(),

    @OneToMany(mappedBy = "list", cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
    val listHistories: MutableList<MatZipListHistory> = mutableListOf(),

    @OneToMany(mappedBy = "list", cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
    val shares: MutableList<MatZipListShare> = mutableListOf(),
) : BaseAuditEntity()
