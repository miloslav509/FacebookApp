import { Component, OnInit, Input} from '@angular/core';
import { AppService } from '../app.service';
import { Post } from '../common.models';

@Component({
  selector: 'app-post-preview',
  templateUrl: './post-preview.component.html',
  styleUrls: ['./post-preview.component.css']
})
export class PostPreviewComponent implements OnInit {

  @Input() postInfo: Post;
  public username = window.localStorage.getItem('username');

  constructor(private appService: AppService) {
    this.postInfo = new Post({
      description: '',
      username: '',
      videoPath: '',
      picturePath: '',
      dateTime: '',
      likesDislikes: [],
      views: 0
    })
  }
    
  ngOnInit(): void {
    this.username = localStorage.getItem('username');
    console.log(this.postInfo);
  }

 deletePost(id: any){
   this.appService.deletePost(id).subscribe(res => {
     alert("Post je obrisan");
   });
 }

}
