import {Component} from '@angular/core'; import {Router} from '@angular/router'; @Component({
  selector: 'app-root',
  templateUrl: './app.component.html', styleUrls: ['./app.component.scss']
})
export class AppComponent {
  title = 'Pokemon APP';
  constructor( private router: Router) {
  }
  onClick() {
    console.log('varnav')
    this.router.navigate(['/']); }
}
