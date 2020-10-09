package com.demo.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import static org.springframework.data.repository.query.parser.Part.Type.LIKE;

@Repository
public interface PokemonRepository extends JpaRepository<Pokemon, Long> {
    @Query(value = "SELECT p FROM Pokemon p WHERE " +
            "lower(p.pokename) LIKE lower(CONCAT('%', :keyword, '%')) OR " +
            "lower(p.poketype) LIKE lower(CONCAT('%', :keyword, '%')) OR " +
            "lower(p.pokespeed) LIKE lower(CONCAT('%', :keyword, '%'))")
    public List<Pokemon> search(@Param("keyword") String keyword);

}
