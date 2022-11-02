import { Component, Input, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { AppService } from '../app.service';
import { CommentInterface } from '../common.models';

@Component({
  selector: 'app-comment',
  templateUrl: './comment.component.html',
  styleUrls: ['./comment.component.css']
})
export class CommentComponent implements OnInit {

  @Input() comment: CommentInterface;

  constructor(private appService: AppService,private router: Router, private route: ActivatedRoute) {
    this.comment = {
      username: '',
      description: '',
      postId: -1,
    };  
   }

  ngOnInit(): void {
  }

  delete(id: number) {
    this.appService.deleteComment(id).subscribe(res => {
      alert("Komentar je obrisan");
    });  
}
}
