package com.example.rickandmorty.screens.personage;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.rickandmorty.R;
import com.example.rickandmorty.adapters.PersonageAdapter;
import com.example.rickandmorty.pojo.Personage;

import java.util.ArrayList;
import java.util.List;

public class PersonageListActivity extends AppCompatActivity {

    private RecyclerView recyclerViewPersonage;
    private PersonageAdapter adapter;
    private PersonageViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerViewPersonage = findViewById(R.id.recyclerViewPersonage);
        adapter = new PersonageAdapter();
        adapter.setPersonages(new ArrayList<Personage>());
        recyclerViewPersonage.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewPersonage.setAdapter(adapter);
        viewModel = ViewModelProviders.of(this).get(PersonageViewModel.class);
        viewModel.getPersonages().observe(this, new Observer<List<Personage>>() {
            @Override
            public void onChanged(List<Personage> personages) {
                adapter.setPersonages(personages);
            }
        });
        viewModel.loadData();

    }
}