import { Component, OnInit } from '@angular/core';
import {UserService} from "../../service/user.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.scss']
})
export class NavbarComponent implements OnInit {

  constructor(
    public userService: UserService,
    private router: Router
  ) { }

  ngOnInit(): void {
  }

  logOut() {
    this.router.navigateByUrl('/login_register').then()
    this.userService.logOut()
  }

}
