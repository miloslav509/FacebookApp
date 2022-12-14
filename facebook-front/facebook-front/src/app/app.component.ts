import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'facebook';
  username = window.localStorage["username"];

  logout() {
    window.localStorage.removeItem('username');
    window.location.reload();
  }
}
