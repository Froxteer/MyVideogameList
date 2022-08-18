import { Component, OnInit } from '@angular/core';
import {GenreService} from "../../service/genre.service";
import {Genre} from "../../model/Genre";
import {Platform} from "../../model/Platform";
import {PlatformService} from "../../service/platform.service";
import {Developer} from "../../model/Developer";
import {DeveloperService} from "../../service/developer.service";
import {VideoGame} from "../../model/VideoGame";
import {VideoGameService} from "../../service/video-game.service";
import {FormControl, FormGroup} from "@angular/forms";

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.scss']
})
export class SearchComponent implements OnInit {

  public genres?: Genre[]
  public platforms?: Platform[]
  public developers?: Developer[]
  public videoGames?: VideoGame[]
  public filteredVideoGames?: VideoGame[]

  public filterForm: FormGroup

  constructor(
    private genreService: GenreService,
    private platformService: PlatformService,
    private developerService: DeveloperService,
    private videoGameService: VideoGameService
  ) {
    this.filterForm = new FormGroup<any>({
      'title': new FormControl(null),
      'genre': new FormControl(0),
      'platform': new FormControl(0),
      'developer': new FormControl(0)
    })
  }

  ngOnInit(): void {
    this.genreService.getAllGenres().subscribe(genres => this.genres = genres)
    this.platformService.getAllPlatforms().subscribe(platforms => this.platforms = platforms)
    this.developerService.getAllDevelopers().subscribe(developers => this.developers = developers)
    this.videoGameService.getAllVideoGames().subscribe(videoGames => {
      this.videoGames = videoGames
      this.filteredVideoGames = videoGames
    })
  }

  filterVideoGames() {
    let filterMap = this.filterForm.getRawValue()
    this.filteredVideoGames = []

    this.videoGames?.forEach(videoGame => {
      if (filterMap.title && !videoGame.title.toUpperCase().includes(filterMap.title.toUpperCase())) {
        console.log('title')
        return
      } else if (+filterMap.genre !== 0 && !videoGame.genres?.filter(genre => genre.id === +filterMap.genre).length) {
        console.log(filterMap.genre)
        return
      } else if (+filterMap.platform !== 0 && !videoGame.platforms?.filter(platform => platform.id === +filterMap.platform).length) {
        console.log('platform')
        return
      } else if (+filterMap.developer !== 0 && videoGame.developer?.id !== +filterMap.developer) {
        console.log('developer')
        return
      } else {
        console.log('inserted!')
        this.filteredVideoGames?.push(videoGame)
      }
    })
  }

  resetVideoGames() {
    this.filteredVideoGames = this.videoGames
  }

  selectVideoGame(videoGame: VideoGame) {
    this.videoGameService.selectedVideoGame = videoGame
  }
}
