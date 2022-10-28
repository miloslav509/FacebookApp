import { Component, OnInit } from '@angular/core';
import { AppService } from '../app.service';
import { Post } from '../common.models';

@Component({
  selector: 'app-post-list',
  templateUrl: './post-list.component.html',
  styleUrls: ['./post-list.component.css']
})
export class PostListComponent implements OnInit {

  public posts: Post[];

  constructor(private appService: AppService) { 
    this.posts = [];

  }

  ngOnInit(): void {
    this.getPosts();
  }

  getPosts() {
     this.appService.getPosts().subscribe(res => {this.posts = res.content})
  }
}
