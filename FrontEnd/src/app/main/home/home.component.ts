import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {

  basicList = [
    {title: 'First Sample', description: 'Description or something'},
    {title: 'Second Sample', description: 'Well yes'},
    {title: 'Third Sample', description: 'Well nope'}
  ];

  constructor() { }

  ngOnInit(): void {
  }

}
