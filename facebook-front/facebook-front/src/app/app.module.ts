import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';
import { RouterModule, Routes } from '@angular/router';
import { HttpClientModule } from '@angular/common/http';
 
import { AppComponent } from './app.component';
import { ChangePageComponent } from './change-page/change-page.component';
import { LoginComponent } from './login/login.component';
import { PostListComponent } from './post-list/post-list.component';
import { PostPreviewComponent } from './post-preview/post-preview.component';
import { HomeComponent } from './home/home.component';
import { CreatePostComponent } from './create-post/create-post.component';
import { CommentListComponent } from './comment-list/comment-list.component';
import { CreateCommentComponent } from './create-comment/create-comment.component';
import { PostDetailComponent } from './post-detail/post-detail.component';
import { CommentComponent } from './comment/comment.component';


const appRoutes: Routes = [
  { path: 'home', component: HomeComponent },
  { path: 'login', component: LoginComponent },
  {path: 'post/:id', component: PostDetailComponent},  
  { path: '', redirectTo: 'home', pathMatch: 'full' },
];

@NgModule({
  declarations: [
    AppComponent,
    ChangePageComponent,
    LoginComponent,
    PostListComponent,
    PostPreviewComponent,
    HomeComponent,
    CreatePostComponent,
    CommentListComponent,
    CreateCommentComponent,
    PostDetailComponent,
    CommentComponent,
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule,
    RouterModule.forRoot(
      appRoutes
    )
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
