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
@Table(name = "mat_zips")
data class MatZip(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "mat_zip_id")
    val matZipId: Int = 0,

    @Column(name = "name", nullable = false)
    var name: String,

    @Column(name = "address")
    var address: String? = null,

    @Column(name = "description", columnDefinition = "TEXT")
    var description: String? = null,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "added_user_id", nullable = false)
    val addedUser: User,

    // Relationships
    @OneToMany(mappedBy = "matZip", cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
    val matZipTags: MutableList<MatZipTag> = mutableListOf(),

    @OneToMany(mappedBy = "matZip", cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
    val listItems: MutableList<MatZipListItem> = mutableListOf(),
) : BaseAuditEntity()
