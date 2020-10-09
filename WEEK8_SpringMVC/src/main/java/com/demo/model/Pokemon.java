package com.demo.model;

import javax.persistence.*;

@Entity
public class Pokemon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String pokename;
    private String poketype;
    private String pokespeed;

    public Pokemon() {
    }

    public Pokemon(String pokename, String poketype, String pokespeed) {
        this.pokename = pokename;
        this.poketype = poketype;
        this.pokespeed = pokespeed;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPokename() {
        return pokename;
    }

    public void setPokename(String pokename) {
        this.pokename = pokename;
    }

    public String getPoketype() {
        return poketype;
    }

    public void setPoketype(String poketype) {
        this.poketype = poketype;
    }

    public String getPokespeed() {
        return pokespeed;
    }

    public void setPokespeed(String pokespeed) {
        this.pokespeed = pokespeed;
    }
}
