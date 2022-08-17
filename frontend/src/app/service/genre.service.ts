import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Genre} from "../model/Genre";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class GenreService {

  constructor(private http: HttpClient) { }

  public getAllGenres(): Observable<Genre[]> {
    return this.http.get<Genre[]>('http://localhost:8080/genre/all')
  }

}
