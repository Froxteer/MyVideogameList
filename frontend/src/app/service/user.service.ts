import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {User} from "../model/User";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class UserService {

  loggedIn: boolean = false
  currentUserId?: number
  currentUsername?: string

  constructor(private http: HttpClient) { }

  public logIn(username: string, password: string): Observable<User> {
    return this.http.get<User>('http://localhost:8080/user/login', {
      params: { username: username, password: password }
    })
  }

  public logOut() {
    this.loggedIn = false
    this.currentUserId = undefined
    this.currentUsername = undefined
  }

  public registerUser(user: User): Observable<User> {
    return this.http.post<User>('http://localhost:8080/user/save', user)
  }
}
