package entity

import com.fasterxml.jackson.annotation.JsonBackReference
import java.util.Date
import javax.persistence.*

@Entity
@Table(name = "developers")
class Developer(
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int,

    @Column(name = "name")
    var name: String,

    @Column(name = "foundation_date")
    var foundationDate: Date,

    @Column(name = "localization")
    var localization: String,

    @OneToMany(mappedBy = "developer")
    @JsonBackReference("platform_company")
    var platforms: Set<Platform>?,

    @OneToMany(mappedBy = "developer")
    @JsonBackReference("video_game_company")
    var videoGames: Set<VideoGame>?
)