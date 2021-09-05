package com.example.rickandmorty.screens.personage;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import com.example.rickandmorty.R;
import com.example.rickandmorty.adapters.PersonageAdapter;


import java.util.ArrayList;


public class PersonageListActivity extends AppCompatActivity {

    private PersonageAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView recyclerViewPersonage = findViewById(R.id.recyclerViewPersonage);
        adapter = new PersonageAdapter();
        adapter.setPersonages(new ArrayList<>());
        recyclerViewPersonage.setLayoutManager(new LinearLayoutManager(this));

        recyclerViewPersonage.setAdapter(adapter);
        PersonageViewModel viewModel = ViewModelProviders.of(this).get(PersonageViewModel.class);
        viewModel.getPersonages().observe(this, personages -> adapter.setPersonages(personages));
        viewModel.loadData();

    }
}