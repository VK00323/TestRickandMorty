package com.example.rickandmorty.pojo;

import java.util.List;
import com.google.gson.annotations.Expose;

public class Example {
    @Expose
    private Personage personage;
    @Expose
    private List<Personage> results = null;

    public Personage getPersonage() {
        return personage;
    }

    public void setInfo(Personage personage) {
        this.personage = personage;
    }

    public List<Personage> getResults() {
        return results;
    }

    public void setResults(List<Personage> results) {
        this.results = results;
    }

}
