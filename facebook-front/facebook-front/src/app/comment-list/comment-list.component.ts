import { Component, Input, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { AppService } from '../app.service';

@Component({
  selector: 'app-comment-list',
  templateUrl: './comment-list.component.html',
  styleUrls: ['./comment-list.component.css']
})
export class CommentListComponent implements OnInit {
  
  
  @Input() comments: Comment[];
  

  constructor(private appService: AppService, private route: ActivatedRoute) { 
    this.comments = [];
  }

  ngOnInit() {
    console.log(this.comments);
  }

}
