import {Pokemon} from '../model/pokemon';
import {InMemoryDbService} from 'angular-in-memory-web-api';
export class PokemonDataService implements InMemoryDbService { createDb() {
  const pokemons: Pokemon[] = [
    { id: 1, name: 'Bulbasaur', power: 'Grass, Poison' }, { id: 2, name: 'Ivysaur' , power: 'Grass, Poison'},
    { id: 3, name: 'Venusaur' , power: 'Grass, Poison'}, { id: 4, name: 'Charmander' , power: 'Fire' },
    { id: 5, name: 'Charmeleon' , power: 'Fire'},
    { id: 6, name: 'Charizard' , power: 'Fire, Flying'},
    { id: 7, name: 'Squirtle' , power: 'Water'},
    { id: 8, name: 'Wartortle' , power: 'Water'},
    { id: 9, name: 'Blastoise' , power: 'Water'},
    { id: 10, name: 'Rattata' , power: 'Normal'}
  ];
  return {pokemons}; }
}
