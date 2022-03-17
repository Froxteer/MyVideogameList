package entity

import com.fasterxml.jackson.annotation.JsonBackReference
import java.util.Date
import javax.persistence.*

@Entity
@Table(name = "Companies")
class Company(
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int,

    @Column(name = "name")
    val name: String,

    @Column(name = "foundation_date")
    val foundationDate: Date,

    @Column(name = "localization")
    val localization: String,

    @OneToMany(mappedBy = "developer")
    @JsonBackReference
    val platforms: Set<Platform>?,

    @ManyToMany(mappedBy = "companies")
    @JsonBackReference
    val videoGames: Set<VideoGame>?
)