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
    val id: Int,

    @Column(name = "name", nullable = false)
    val name: String,

    @ManyToOne
    @JoinColumn(name = "developer")
    @JsonManagedReference("platform_company")
    val developer: Company?,

    @Column(name = "release_date", nullable = true)
    val releaseDate: Date?,

    @ManyToMany(mappedBy = "platforms")
    @JsonBackReference("video_game_platform")
    val videoGames: Set<VideoGame>?
)