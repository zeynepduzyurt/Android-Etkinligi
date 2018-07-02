package com.example.zeynep.androidetkinligi.service;

import com.example.zeynep.androidetkinligi.Model.City;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by Zeynep on 25.06.2018.
 */

public interface CityService {

    @GET("sehirler")
    Call<List<City>> getCityList();


    @GET("cities/{id}")
    Call<City> getUserDetail(@Path("id") int userid);
}
