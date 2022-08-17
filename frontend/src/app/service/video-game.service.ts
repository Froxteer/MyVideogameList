import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {VideoGame} from "../model/VideoGame";

@Injectable({
  providedIn: 'root'
})
export class VideoGameService {

  constructor(private http: HttpClient) { }

  public getAllVideoGames(): Observable<VideoGame[]> {
    return this.http.get<VideoGame[]>('http://localhost:8080/video_game/all')
  }

}
