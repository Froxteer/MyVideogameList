package entity

import com.fasterxml.jackson.annotation.JsonBackReference
import com.fasterxml.jackson.annotation.JsonManagedReference
import java.sql.Date
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.ManyToMany
import javax.persistence.ManyToOne
import javax.persistence.Table

@Entity
@Table(name = "platforms")
class Platform(
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int,

    @Column(name = "name", nullable = false)
    var name: String,

    @ManyToOne
    @JoinColumn(name = "developer")
    @JsonManagedReference("platform_company")
    var developer: Developer?,

    @Column(name = "release_date", nullable = true)
    var releaseDate: Date?,

    @ManyToMany(mappedBy = "platforms")
    @JsonBackReference("video_game_platform")
    var videoGames: Set<VideoGame>?
)