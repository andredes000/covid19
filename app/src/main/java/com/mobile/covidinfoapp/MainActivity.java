package com.mobile.covidinfoapp;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.github.ybq.android.spinkit.sprite.Sprite;
import com.github.ybq.android.spinkit.style.Wave;
import com.mobile.covidinfoapp.adapters.LastUpdateAdapter;
import com.mobile.covidinfoapp.model.CovidData;
import com.mobile.covidinfoapp.network.ApiInterface;
import com.mobile.covidinfoapp.network.ApiServices;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private LastUpdateAdapter adapter;
    private ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        progressBar = findViewById(R.id.spin_kit);
        Sprite sprite = new Wave();
        progressBar.setIndeterminateDrawable(sprite);
        showLoading(true);
        ApiInterface server = ApiServices.getRetrofit().create(ApiInterface.class);
        Call<CovidData> response = server.getLast();
        response.enqueue(new Callback<CovidData>() {
            @Override
            public void onResponse(Call<CovidData> call, Response<CovidData> response) {
                if (response.isSuccessful()) {
                    CovidData covidData = new CovidData();
                    covidData.setPositif(response.body().getPositif());
                    covidData.setCovidSembuh(response.body().getCovidSembuh());
                    covidData.setCovidMeninggal(response.body().getCovidMeninggal());
                    covidData.setWaktu(response.body().getWaktu());
                    Log.d("Message","Success"+covidData.getPositif());
                    loadData(covidData);
                    showLoading(false);
                }else{
                    Toast.makeText(MainActivity.this, "No Response!"+response.errorBody(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<CovidData> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Error"+t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void loadData(CovidData covidData) {
        recyclerView = findViewById(R.id.rv_data);
        adapter = new LastUpdateAdapter(this,covidData);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView.setAdapter(adapter);
    }

    private void showLoading(Boolean state) {
        if (state) {
            progressBar.setVisibility(View.VISIBLE);
        } else {
            progressBar.setVisibility(View.GONE);
        }
    }
}
