import { Component, OnInit } from '@angular/core';
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {UserService} from "../../service/user.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-login-register',
  templateUrl: './login-register.component.html',
  styleUrls: ['./login-register.component.scss']
})
export class LoginRegisterComponent implements OnInit {

  logInForm: FormGroup
  registerForm: FormGroup

  failedLogin: boolean = false
  failedRegister: boolean = false

  constructor(
    private userService: UserService,
    private router: Router
  ) {
    this.logInForm = new FormGroup<any>({
      'username': new FormControl(null, Validators.required),
      'password': new FormControl(null, Validators.required)
    })

    this.registerForm = new FormGroup<any>({
      'username': new FormControl(null, Validators.required),
      'email': new FormControl(null, [Validators.email, Validators.required]),
      'password': new FormControl(null, [Validators.min(8), Validators.required]),
      'repeat': new FormControl(null, [Validators.min(8), Validators.required])
    })
  }

  ngOnInit(): void {
  }

  logIn() {
    const userForm = this.logInForm.getRawValue()
    this.userService.logIn(userForm.username, userForm.password)
      .subscribe({
        next: user => {
          this.userService.currentUserId = user.id
          this.userService.currentUsername = user.username
          this.userService.loggedIn = true
          this.router.navigateByUrl('/search').then()
        },
        error: () => {
          this.failedLogin = true
        }
      })
  }

  signUp() {
    const userForm = this.registerForm.getRawValue()
    this.userService.registerUser({
      id: undefined,
      username: userForm.username,
      email: userForm.email,
      password: userForm.password,
      videoGameUsers: undefined
    }).subscribe({
      next: user => {
        this.userService.currentUserId = user.id
        this.userService.currentUsername = user.username
        this.userService.loggedIn = true
        this.router.navigateByUrl('/search').then()
      },
      error: () => {
        this.failedRegister = true
      }
    })
  }

}
