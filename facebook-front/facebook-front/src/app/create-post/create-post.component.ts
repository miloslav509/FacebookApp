import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AppService } from '../app.service';
import { Post } from '../common.models';

@Component({
  selector: 'app-create-post',
  templateUrl: './create-post.component.html',
  styleUrls: ['./create-post.component.css']
})
export class CreatePostComponent implements OnInit {

  public newPost: Post;

  constructor(private appService: AppService, private router: Router) { 
    this.newPost = new Post({
      description: '',
      username: window.localStorage.getItem('username'),
      videoPath: '',
      picturePath: '',
      dateTime: '',
      likesDislikes: [],
      views: 0
    })
  }

  ngOnInit(): void {
  }

  addPost() {
    console.log(this.newPost);
    if(localStorage.getItem('username') === null){
      this.router.navigate(['login']);
    } else {  
      this.appService.addPost(this.newPost).subscribe((res: Post) => {
        this.newPost = res;
        this.router.navigate(['home']);
        this.reset();
        console.log(this.newPost);
      })
    }
  }

  reset() {
    this.newPost = new Post({
      description: '',
      username: '',
      videoPath: '',
      picturePath: '',
      dateTime: '',
      likesDislikes: [],
      views: 0
    })
  }
}
