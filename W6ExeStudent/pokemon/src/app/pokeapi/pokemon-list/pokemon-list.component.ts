import { Component, OnInit } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
@Component({
  selector: 'app-pokemon-list',
  templateUrl: './pokemon-list.component.html', styleUrls: ['./pokemon-list.component.scss']
})
export class PokemonListComponent implements OnInit {
  pokemons: any;
  constructor(private http: HttpClient) { }
  ngOnInit() { this.http.get('https://pokeapi.co/api/v2/pokemon').subscribe(data => { this.pokemons = data['results'];
  });
  } }
