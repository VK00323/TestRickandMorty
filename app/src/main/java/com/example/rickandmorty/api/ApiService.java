package com.example.rickandmorty.api;

import com.example.rickandmorty.pojo.Example;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface ApiService {
    @GET("character")
    Observable<Example>  getExample();

}
