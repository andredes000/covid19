package com.mobile.covidinfoapp;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.mobile.covidinfoapp.adapters.LastUpdateAdapter;
import com.mobile.covidinfoapp.model.CovidData;
import com.mobile.covidinfoapp.network.ApiInterface;
import com.mobile.covidinfoapp.network.ApiServices;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private LastUpdateAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ApiInterface server = ApiServices.getRetrofit().create(ApiInterface.class);
        Call<List<CovidData>> response = server.getAllData();
        response.enqueue(new Callback<List<CovidData>>() {
            @Override
            public void onResponse(Call<List<CovidData>> call, Response<List<CovidData>> response) {
                if (response.isSuccessful()) {
                    loadData(response.body());
                }else{
                    Toast.makeText(MainActivity.this, "No Response!"+response.errorBody(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<CovidData>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Error"+t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void loadData(List<CovidData>listData) {
        recyclerView = findViewById(R.id.rv_data);
        adapter = new LastUpdateAdapter(getBaseContext(),listData);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView.setAdapter(adapter);
    }
}
