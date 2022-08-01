import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.scss']
})
export class SearchComponent implements OnInit {

  placeholderList = [
    { title: 'title1', description: 'description1' },
    { title: 'title2', description: 'description2' },
    { title: 'title3', description: 'description3' },
    { title: 'title4', description: 'description4' },
    { title: 'title5', description: 'description5' }
  ]

  constructor() { }

  ngOnInit(): void {
  }

}
