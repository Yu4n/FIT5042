import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Observable, throwError} from 'rxjs';
import { tap, catchError } from 'rxjs/operators';
import {Pokemon} from '../model/pokemon';
import {PokemonDataService} from '../data/PokemonDataService';

@Injectable({
  providedIn: 'root'
})
export class DataService {

  apiurl = 'api/pokemons';
  headers = new HttpHeaders().set('Content-Type', 'application/json').set('Accept', 'application/json');
  httpOptions = {
    headers: this.headers
  };

  constructor(private http: HttpClient) { }

  getPokemons(): Observable<PokemonDataService[]> {
    return this.http.get<PokemonDataService[]>(this.apiurl);
  }

  getPokemon(id: number): Observable<Pokemon> {
    const url = `${this.apiurl}/${id}`;
    return this.http.get<Pokemon>(url);
  }

  deletePokemon(id: number): Observable<Pokemon> {
    const url = `${this.apiurl}/${id}`;
    return this.http.delete<Pokemon>(url, this.httpOptions);
  }

  addPokemon(pokemon: Pokemon): Observable<Pokemon> {
    pokemon.id = null;
    return this.http.post<Pokemon>(this.apiurl, pokemon, this.httpOptions);
  }

  updatePokemon(id, pokemon: Pokemon): Observable<Pokemon> {
    pokemon.id = id;
    return this.http.put<Pokemon>(this.apiurl, pokemon, this.httpOptions);
  }

}
