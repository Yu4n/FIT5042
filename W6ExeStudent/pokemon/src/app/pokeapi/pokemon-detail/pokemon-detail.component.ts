import { Component, OnInit } from '@angular/core'; import {ActivatedRoute, Router} from '@angular/router'; import {HttpClient} from '@angular/common/http';
@Component({
  selector: 'app-pokemon-detail',
  templateUrl: './pokemon-detail.component.html', styleUrls: ['./pokemon-detail.component.scss']
})
export class PokemonDetailComponent implements OnInit {
  id: string;
  pokemon: any
  abilities: any
  getUrl: string
  constructor( private route: ActivatedRoute,
               private router: Router, private http: HttpClient) { }
  ngOnInit() {
    this.id = this.route.snapshot.paramMap.get('id'); this.getUrl = 'https://pokeapi.co/api/v2/pokemon/' + this.id; this.http.get(this.getUrl).subscribe(data => {
      this.pokemon = data; });
  } }
