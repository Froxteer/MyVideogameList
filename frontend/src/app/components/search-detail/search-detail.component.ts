import { Component, OnInit } from '@angular/core';
import {VideoGame} from "../../model/VideoGame";
import {VideoGameService} from "../../service/video-game.service";
import {Location} from "@angular/common";

@Component({
  selector: 'app-search-detail',
  templateUrl: './search-detail.component.html',
  styleUrls: ['./search-detail.component.scss']
})
export class SearchDetailComponent implements OnInit {

  public videoGame?: VideoGame

  constructor(
    private videoGameService: VideoGameService,
    private location: Location
  ) { }

  ngOnInit(): void {
    this.videoGame = this.videoGameService.selectedVideoGame
  }

  goBack() {
    this.location.back()
  }
}
