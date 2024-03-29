import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {HomeComponent} from "./components/home/home.component";
import {SearchComponent} from "./components/search/search.component";
import {SearchDetailComponent} from "./components/search-detail/search-detail.component";
import {LoginRegisterComponent} from "./components/login-register/login-register.component";
import {ListComponent} from "./components/list/list.component";

const routes: Routes = [
  { path: '', redirectTo: '/search', pathMatch: 'full' },
  { path: 'home', component: HomeComponent },
  { path: 'search', component: SearchComponent },
  { path: 'search/:title', component: SearchDetailComponent },
  { path: 'login_register', component: LoginRegisterComponent },
  { path: 'list', component: ListComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
