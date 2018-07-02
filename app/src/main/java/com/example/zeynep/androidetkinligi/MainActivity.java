package com.example.zeynep.androidetkinligi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.zeynep.androidetkinligi.Model.City;
import com.example.zeynep.androidetkinligi.service.CityService;
import com.example.zeynep.androidetkinligi.service.ServiceGenerator;
import com.jaredrummler.materialspinner.MaterialSpinner;
import com.jaredrummler.materialspinner.MaterialSpinnerAdapter;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    CityService cityService;
    List<City> cityList ;
    MaterialSpinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinner = findViewById(R.id.spinner_city);


        cityService = ServiceGenerator.createService(CityService.class); //servisi ayağa kaldırdın.
        Call<List<City>> callUserList = cityService.getCityList();  //call edilebilir durumda. , enqueue servisi calıstıran metod.
       callUserList.enqueue(new Callback<List<City>>() {
           @Override
           public void onResponse(Call<List<City>> call, Response<List<City>> response) {
               cityList = response.body();
               LoadSpinner();
               Log.d("Test", "onResponse: " + cityList.get(0).getAdi());
           }

           @Override
           public void onFailure(Call<List<City>> call, Throwable t) {
               Toast.makeText(MainActivity.this, "hata aldı"+ t.getMessage(), Toast.LENGTH_SHORT).show();
           }
       });



    }
    public void LoadSpinner(){
        spinner.setItems(cityList);
        spinner.setOnItemSelectedListener(new MaterialSpinner.OnItemSelectedListener<City>() {

            @Override public void onItemSelected(MaterialSpinner view, int position, long id, City item) {

                Toast.makeText(getApplicationContext(),"secilen "+item.getAdi(),Toast.LENGTH_LONG).show();
            }
        });
    }
}
