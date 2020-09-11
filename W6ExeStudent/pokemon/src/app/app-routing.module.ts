import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {PokemonCrudComponent} from './pokemon-crud/pokemon-crud.component';
import {PokemonListComponent} from "./pokeapi/pokemon-list/pokemon-list.component";
import { PokemonDetailComponent} from "./pokeapi/pokemon-detail/pokemon-detail.component";

const routes: Routes = [
  { path: 'crud-app', component: PokemonCrudComponent },
  { path: 'pokemons', component: PokemonListComponent},
  { path: 'pokemon/:id', component: PokemonDetailComponent},
];
@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

