package org.fit5042.pokemon.controller;
import org.fit5042.pokemon.entity.Pokemon;
import org.fit5042.pokemon.repository.PokemonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/api")
public class PokemonController {
    @Autowired
    private PokemonRepository pokemonRepository;

    @PostMapping("/pokemons")
    public Pokemon create(@RequestBody Pokemon pokemon) {
        return pokemonRepository.save(pokemon);
    }
    @RequestMapping(value = "/pokemons", method = RequestMethod.GET)
    // @GetMapping("/pokemons")
    public List<Pokemon> findAll() {
        return pokemonRepository.findAll();
    }
    @PutMapping("/pokemons/{pokemon_id}")
    public Pokemon update(@PathVariable("pokemon_id") Long pokemonId, @RequestBody Pokemon pokemonObject)
    {
        Pokemon pokemon = pokemonRepository.getOne(pokemonId);
        pokemon.setName(pokemonObject.getName());
        pokemon.setPower(pokemonObject.getPower());
        return pokemonRepository.save(pokemon);
    }
    @RequestMapping(value = "/pokemons/{pokemon_id}", method = RequestMethod.DELETE)
    // @DeleteMapping("/pokemons/{pokemon_id}")
    public List<Pokemon> delete(@PathVariable("pokemon_id") Long pokemonId)
    {
        pokemonRepository.deleteById(pokemonId);
        return pokemonRepository.findAll();
    }

    @GetMapping("/pokemons/{pokemon_id}")
    public Pokemon findByPokemonId(@PathVariable("pokemon_id") Long pokemonId)
    {
        return pokemonRepository.getOne(pokemonId);
    }
}