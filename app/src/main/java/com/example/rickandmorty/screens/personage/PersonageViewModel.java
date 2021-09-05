package com.example.rickandmorty.screens.personage;

import android.app.Application;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.rickandmorty.api.ApiFactory;
import com.example.rickandmorty.api.ApiService;
import com.example.rickandmorty.data.AppDatabase;
import com.example.rickandmorty.pojo.Example;
import com.example.rickandmorty.pojo.Personage;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;


@SuppressWarnings("ALL")
public class PersonageViewModel extends AndroidViewModel {
    private static AppDatabase db;
    private final LiveData<List<Personage>> personages;
    private Disposable disposable;


    public PersonageViewModel(@NonNull Application application) {
        super(application);
        db = AppDatabase.getInstance(application);
        personages = db.personageDao().getAllPersonages();

    }

    public LiveData<List<Personage>> getPersonages() {
        return personages;
    }

    @SuppressWarnings("unchecked")
    public void insertPersonages(List<Personage> personages) {
        new InsertPersonagesTask().execute(personages);

    }


    private static class InsertPersonagesTask extends AsyncTask<List<Personage>, Void, Void> {

        @SafeVarargs
        @Override
        protected final Void doInBackground(List<Personage>... lists) {
            if (lists != null && lists.length > 0) {
                db.personageDao().insertPersonages(lists[0]);
            }
            return null;
        }
    }

    public void deleteAllPersonage() {
    }

    private static class DeleteAllPersonagesTask extends AsyncTask<Void, Void, Void> {

        @Override
        protected Void doInBackground(Void... voids) {
            db.personageDao().deleteAllPersonages();
            return null;
        }
    }

    public void loadData() {
        ApiFactory apiFactory = ApiFactory.getInstance();
        ApiService apiService = apiFactory.getApiService();
        disposable = apiService.getExample()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Example>() {
                    @Override
                    public void accept(Example example) {
                        deleteAllPersonage();
                        insertPersonages(example.getResults());
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {

                    }
                });

    }

    @Override
    protected void onCleared() {
        disposable.dispose();
        super.onCleared();
    }
}
