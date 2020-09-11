import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from "@angular/forms";
import { HttpClientModule } from "@angular/common/http";

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { PokemonCrudComponent } from './pokemon-crud/pokemon-crud.component';
import { InMemoryWebApiModule} from 'angular-in-memory-web-api';
import { PokemonDataService} from "./data/PokemonDataService";
import { PokemonListComponent } from './pokeapi/pokemon-list/pokemon-list.component';
import { PokemonDetailComponent } from './pokeapi/pokemon-detail/pokemon-detail.component';
@NgModule({
  declarations: [
    AppComponent,
    PokemonCrudComponent,
    PokemonListComponent,
    PokemonDetailComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    ReactiveFormsModule,
    InMemoryWebApiModule.forRoot(PokemonDataService, {
      passThruUnknownUrl: true
    })
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
