import { Component, OnInit } from '@angular/core';
import {GenreService} from "../../service/genre.service";
import {Genre} from "../../model/Genre";
import {Platform} from "../../model/Platform";
import {PlatformService} from "../../service/platform.service";
import {Developer} from "../../model/Developer";
import {DeveloperService} from "../../service/developer.service";
import {VideoGame} from "../../model/VideoGame";
import {VideoGameService} from "../../service/video-game.service";

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

  constructor(
    private genreService: GenreService,
    private platformService: PlatformService,
    private developerService: DeveloperService,
    private videoGameService: VideoGameService
  ) { }

  ngOnInit(): void {
    this.genreService.getAllGenres().subscribe(genres => this.genres = genres)
    this.platformService.getAllPlatforms().subscribe(platforms => this.platforms = platforms)
    this.developerService.getAllDevelopers().subscribe(developers => this.developers = developers)
    this.videoGameService.getAllVideoGames().subscribe(videoGames => this.videoGames = videoGames)
  }

}
