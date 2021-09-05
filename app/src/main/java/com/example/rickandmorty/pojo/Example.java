package com.example.rickandmorty.pojo;

import java.util.List;
import com.google.gson.annotations.Expose;

public class Example {
    @Expose
    private Personage personage;
    @Expose
    private final List<Personage> results = null;

    public Personage getPersonage() {
        return personage;
    }

    public List<Personage> getResults() {
        return results;
    }


    public void setPersonage(Personage personage) {
        this.personage = personage;
    }
}
