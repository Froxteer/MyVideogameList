package entity

import com.fasterxml.jackson.annotation.JsonBackReference
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.ManyToMany
import javax.persistence.Table

@Entity
@Table(name = "genres")
class Genre(
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int,

    @Column(name = "name", nullable = false)
    var name: String,

    @ManyToMany(mappedBy = "genres")
    @JsonBackReference("video_game_genre")
    var videoGames: Set<VideoGame>?
)