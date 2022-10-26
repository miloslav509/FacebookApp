import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { CommentInterface, LikeDislikeInterface, Post, UserInterface } from './common.models';
import { catchError, Observable, of } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AppService {
  private postsUrl = 'http://localhost:8080/api/posts';
  private usersUrl = 'http://localhost:8080/api/users';
  private likesUrl = 'http://localhost:8080/api/likes';
  private commentsUrl = 'http://localhost:8080/api/comments';

  httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' })
  }



  constructor(private http: HttpClient) { }

  getPosts(): Observable<Post[]> {
    return this.http.get<Post[]>(this.postsUrl);
  }

  getPostsPage(pageNo: number): Observable<any> {
    return this.http
      .get<Post[]>(
        `${this.postsUrl}?pageNo=${pageNo}`
      )
      .pipe(catchError(this.handleError<Post[]>('getPostsPage', [])));
  }

  deletePost(id: number): Observable<Post> {
    const url = `${this.postsUrl}/${id}`;

    return this.http
      .delete<Post>(url, this.httpOptions)
      .pipe(catchError(this.handleError<Post>('deletePost')));
  }

  deleteLike(id: number): Observable<LikeDislikeInterface> {
    const url = `${this.likesUrl}/${id}`;

    return this.http
      .delete<LikeDislikeInterface>(url, this.httpOptions)
      .pipe(catchError(this.handleError<LikeDislikeInterface>('deleteLike')));
  }

  deleteComment(id: number): Observable<CommentInterface> {
    const url = `${this.commentsUrl}/${id}`;

    return this.http
      .delete<CommentInterface>(url, this.httpOptions)
      .pipe(catchError(this.handleError<CommentInterface>('deleteComment')));
  }

  addPost(post: Post): Observable<Post> {
    return this.http
      .post<Post>(this.postsUrl, post, this.httpOptions)
      .pipe(catchError(this.handleError<Post>('addPost')));
  }

  addLike(like: LikeDislikeInterface): Observable<LikeDislikeInterface> {
    return this.http
      .post<LikeDislikeInterface>(this.likesUrl, like, this.httpOptions)
      .pipe(catchError(this.handleError<LikeDislikeInterface>('addLike')));
  }

  addComment(comment: CommentInterface): Observable<CommentInterface> {
    return this.http
      .post<CommentInterface>(this.commentsUrl, comment, this.httpOptions)
      .pipe(catchError(this.handleError<CommentInterface>('addComment')));
  }

  login(user: UserInterface): Observable<UserInterface> {
    console.log(user);
    return this.http
      .post<UserInterface>(this.usersUrl, user, this.httpOptions)
      .pipe(catchError(this.handleError<UserInterface>('login')));
  }
  
  private handleError<T>(operation = 'operation', result?: T) {
   return (error: any): Observable<T> => {
     // TODO: send the error to remote logging infrastructure
     console.error(error); // log to console instead

     // TODO: better job of transforming error for user consumption
     console.log(`${operation} failed: ${error.message}`);

     // Let the app keep running by returning an empty result.
     return of(result as T);
   };
 }
}
