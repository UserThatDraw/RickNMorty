package com.example.ricknmorty.repository;

import androidx.lifecycle.MutableLiveData;

import com.example.ricknmorty.App;
import com.example.ricknmorty.models.RnMCharacters;
import com.example.ricknmorty.models.RnMEpisodes;
import com.example.ricknmorty.models.RnMLocations;
import com.example.ricknmorty.models.RnMRespons;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RnMRepository {

    public MutableLiveData<RnMRespons<RnMCharacters>> fetchCharacters() {
        MutableLiveData<RnMRespons<RnMCharacters>> data = new MutableLiveData<>();
        App.rnMServies.fetchCharacters().enqueue(new Callback<RnMRespons<RnMCharacters>>() {
            @Override
            public void onResponse(Call<RnMRespons<RnMCharacters>> call, Response<RnMRespons<RnMCharacters>> response) {
                data.setValue(response.body());
            }

            @Override
            public void onFailure(Call<RnMRespons<RnMCharacters>> call, Throwable t) {

            }
        });
        return data;
    }

    public MutableLiveData<RnMRespons<RnMLocations>> fetchLocation() {
        MutableLiveData<RnMRespons<RnMLocations>> data = new MutableLiveData<>();
        App.rnMServies.fetchLocations().enqueue(new Callback<RnMRespons<RnMLocations>>() {
            @Override
            public void onResponse(Call<RnMRespons<RnMLocations>> call, Response<RnMRespons<RnMLocations>> response) {
                data.setValue(response.body());
            }

            @Override
            public void onFailure(Call<RnMRespons<RnMLocations>> call, Throwable t) {

            }
        });
        return data;
    }

    public MutableLiveData<RnMRespons<RnMEpisodes>> fetchEpisode() {
        MutableLiveData<RnMRespons<RnMEpisodes>> data = new MutableLiveData<>();
        App.rnMServies.fetchEpisode().enqueue(new Callback<RnMRespons<RnMEpisodes>>() {
            @Override
            public void onResponse(Call<RnMRespons<RnMEpisodes>> call, Response<RnMRespons<RnMEpisodes>> response) {
                data.setValue(response.body());
            }

            @Override
            public void onFailure(Call<RnMRespons<RnMEpisodes>> call, Throwable t) {

            }
        });
        return data;
    }

    public MutableLiveData<RnMCharacters> addDescription(int id) {
        MutableLiveData<RnMCharacters> characterDescription = new MutableLiveData<>();
        App.rnMServies.fetchCharacter(id).enqueue(new Callback<RnMCharacters>() {
            @Override
            public void onResponse(Call<RnMCharacters> call, Response<RnMCharacters> response) {
                characterDescription.setValue(response.body());
            }

            @Override
            public void onFailure(Call<RnMCharacters> call, Throwable t) {
                characterDescription.setValue(null);
            }
        });
        return characterDescription;
    }
}
