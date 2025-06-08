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
@Table(name = "tags")
data class Tag(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tag_id")
    val tagId: Int = 0,

    @Column(name = "tag_name", nullable = false)
    var tagName: String,

    @Column(name = "color")
    var color: String? = null,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "created_user_id", nullable = false)
    val createdUser: User,

    // Relationships
    @OneToMany(mappedBy = "tag", cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
    val matZipTags: MutableList<MatZipTag> = mutableListOf(),
) : BaseAuditEntity()
