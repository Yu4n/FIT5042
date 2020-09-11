import { Component, OnInit } from '@angular/core';
import {PokemonDataService} from '../data/PokemonDataService';
import {FormControl, FormGroup} from '@angular/forms';
import {Pokemon} from '../model/pokemon';
import {DataService} from '../service/dataService';

@Component({
  selector: 'app-pokemon-crud',
  templateUrl: './pokemon-crud.component.html',
  styleUrls: ['./pokemon-crud.component.scss']
})
export class PokemonCrudComponent implements OnInit {

  title = 'My pokemon app';
  pokemons: PokemonDataService[] = [];
  pokemonFormGroup: FormGroup;
  poke: Pokemon;
  isUpdate: boolean;
  constructor(private pokemonDataService: DataService){
    this.poke = new Pokemon();
  }
  ngOnInit(): void {
    this.pokemonFormGroup = new FormGroup(
      {
        name : new FormControl(''),
        power : new FormControl('')
      },
    );
    this.getPokemons();
  }
  getPokemons() {
    this.pokemonDataService.getPokemons().subscribe(data => {
      this.pokemons = data;
    });
  }
  getPokemon(id) {
    this.pokemonDataService.getPokemon(id).subscribe(data => {
      this.poke = data;
      this.isUpdate = true;
      this.pokemonFormGroup.setValue({
        name: this.poke.name,
        power: this.poke.power
      });
    });
  }
  addPokemon() {
    if (this.isUpdate) {
      this.pokemonDataService.updatePokemon(this.poke.id, this.pokemonFormGroup.value).subscribe(data => {
        this.poke = data;
        console.log(this.poke);
        this.isUpdate = false;
      });
    } else {
      this.pokemonDataService.addPokemon(this.pokemonFormGroup.value).subscribe(data => {
        this.poke = data;
        console.log(this.poke);
      });
    }
    this.getPokemons();
    this.clearForm();
  }

  deletePokemon(id) {
    this.pokemonDataService.deletePokemon(id).subscribe(data => {
      this.getPokemons();
    });
  }
  updatePokemon(id) {
    this.isUpdate = true;
    this.getPokemon(id);
  }
  clearForm() {
    this.pokemonFormGroup.reset({});
  }
}
