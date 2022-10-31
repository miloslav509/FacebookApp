import { Component, OnInit } from '@angular/core';
import { AppService } from '../app.service';
import { Page, Post } from '../common.models';

@Component({
  selector: 'app-post-list',
  templateUrl: './post-list.component.html',
  styleUrls: ['./post-list.component.css']
})
export class PostListComponent implements OnInit {

  public posts: Post[];

  public totalPages: number = 0;
  public pageNo: number = 0;

  constructor(private appService: AppService) { 
    this.posts = [];

  }

  ngOnInit(): void {
    this.getPosts();
  }

  getPosts() {
     this.appService.getPostsPage(this.pageNo)
     .subscribe(res => {this.posts = res.content, this.totalPages = res.totalPages});
     console.log(this.totalPages);
  }

  changePage(page: Page) {
    console.log(page);
    if (page == 0) {
      this.pageNo = this.pageNo - 1;
    } else {
      this.pageNo = this.pageNo + 1;
    }
    console.log(this.pageNo);
    this.getPosts();

  }
}
