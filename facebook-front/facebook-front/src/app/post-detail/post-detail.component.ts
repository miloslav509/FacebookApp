import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { AppService } from '../app.service';
import { Post } from '../common.models';

@Component({
  selector: 'app-post-detail',
  templateUrl: './post-detail.component.html',
  styleUrls: ['./post-detail.component.css']
})
export class PostDetailComponent implements OnInit {

  public postInfo: Post;
  public username = window.localStorage.getItem('username');
  public id: number = -1;

  constructor(private route: ActivatedRoute, private appService: AppService, private router: Router) { 
    this.postInfo = new Post({
      description: '',
      username: '',
      videoPath: '',
      picturePath: '',
      dateTime: '',
      likesDislikes: [],
      views: 0,
      commentsDTO: []
    })
  }

  ngOnInit(): void {
    this.id = parseInt(JSON.parse(this.route.snapshot.paramMap.get('id') as string));
    this.getPost(this.id);
  }

  getPost(id: number) {
    this.appService.getPost(this.id).subscribe(res => {
      this.postInfo = res;
    });
    console.log(this.postInfo);
  }

  deletePost(id: number){
    this.appService.deletePost(id).subscribe(() => {
      alert("Post je obrisan");
      this.router.navigate(['home']);
    });
  }
}
