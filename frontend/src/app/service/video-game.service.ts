import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {VideoGame} from "../model/VideoGame";

@Injectable({
  providedIn: 'root'
})
export class VideoGameService {

  public selectedVideoGame?: VideoGame

  constructor(private http: HttpClient) { }

  public getAllVideoGames(userId?: number): Observable<VideoGame[]> {
    if (userId) {
      return this.http.get<VideoGame[]>('http://localhost:8080/video_game/all', {
        params: {
          userId: userId
        }
      })
    } else {
      return this.http.get<VideoGame[]>('http://localhost:8080/video_game/all')
    }
  }

  public getAllAssignedVideoGames(userId: number): Observable<VideoGame[]> {
    return this.http.get<VideoGame[]>('http://localhost:8080/video_game/assigned', {
      params: {
        userId: userId
      }
    })
  }

  public persistVideoGameRelation(userId: number, videoGameId: number, conceptId: number): Observable<any> {
    return this.http.post('http://localhost:8080/video_game/relation/persist', undefined, {
      params: {
        userId: userId,
        videoGameId: videoGameId,
        conceptId: conceptId
      }
    })
  }

}
