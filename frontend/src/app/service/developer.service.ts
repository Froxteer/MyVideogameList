import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Developer} from "../model/Developer";

@Injectable({
  providedIn: 'root'
})
export class DeveloperService {

  constructor(private http: HttpClient) { }

  public getAllDevelopers(): Observable<Developer[]> {
    return this.http.get<Developer[]>('http://localhost:8080/developer/all')
  }

}
