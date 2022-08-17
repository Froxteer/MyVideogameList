import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Platform} from "../model/Platform";

@Injectable({
  providedIn: 'root'
})
export class PlatformService {

  constructor(private http: HttpClient) { }

  public getAllPlatforms(): Observable<Platform[]> {
    return this.http.get<Platform[]>('http://localhost:8080/platform/all')
  }

}
