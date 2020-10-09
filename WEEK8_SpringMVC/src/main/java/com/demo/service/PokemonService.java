package com.demo.service;

import com.demo.model.Pokemon;
import com.demo.model.PokemonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
//@Transactional annotation so all of its methods will be intercepted by Spring Data JPA for transaction management
@Transactional
public class PokemonService {

    @Autowired
    PokemonRepository repo;

    public void save(Pokemon pokemon) {
        repo.save(pokemon);
    }

    public List<Pokemon> listAll() {
        return (List<Pokemon>) repo.findAll();
    }

    public Pokemon get(Long id) {
        return repo.findById(id).get();
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }

    public List<Pokemon> search(String keyword) {
        return repo.search(keyword);
    }
}
