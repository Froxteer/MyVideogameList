import {Component, OnInit} from '@angular/core';
import {VideoGameService} from "../../service/video-game.service";
import {UserService} from "../../service/user.service";
import {VideoGame} from "../../model/VideoGame";
import {Router} from "@angular/router";

@Component({
  selector: 'app-list',
  templateUrl: './list.component.html',
  styleUrls: ['./list.component.scss']
})
export class ListComponent implements OnInit {

  onQueueList: VideoGame[] = []
  playingList: VideoGame[] = []
  playedList: VideoGame[] = []

  constructor(
    private videoGameService: VideoGameService,
    private userService: UserService,
    private router: Router
  ) { }

  ngOnInit(): void {
    if (this.userService.currentUserId) {
      this.videoGameService.getAllAssignedVideoGames(this.userService.currentUserId)
        .subscribe(videoGames => {
          videoGames.forEach(videoGame => {
            switch (videoGame.videoGameUsers[0].listConcept.toString()) {
              case 'ON_QUEUE': this.onQueueList.push(videoGame); break
              case 'PLAYING': this.playingList.push(videoGame); break
              case 'PLAYED': this.playedList.push(videoGame); break
            }
          })
        })
    }
  }

  selectVideoGame(videoGame: VideoGame) {
    this.videoGameService.selectedVideoGame = videoGame
    this.router.navigateByUrl('/search/' + videoGame.title).then()
  }
}
