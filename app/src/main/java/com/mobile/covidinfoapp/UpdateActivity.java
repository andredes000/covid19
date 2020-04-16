package com.mobile.covidinfoapp;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.github.ybq.android.spinkit.sprite.Sprite;
import com.github.ybq.android.spinkit.style.Wave;
import com.mobile.covidinfoapp.adapters.AllUpdateAdapter;
import com.mobile.covidinfoapp.model.CovidData;
import com.mobile.covidinfoapp.network.ApiInterface;
import com.mobile.covidinfoapp.network.ApiServices;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UpdateActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private AllUpdateAdapter adapter;
    private ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle("All Data");
        }
        progressBar = findViewById(R.id.spin_kit_all);
        Sprite sprite = new Wave();
        progressBar.setIndeterminateDrawable(sprite);
        showLoading(true);
        ApiInterface server = ApiServices.getRetrofit().create(ApiInterface.class);
        Call<List<CovidData>> response = server.getAllData();
        response.enqueue(new Callback<List<CovidData>>() {
            @Override
            public void onResponse(Call<List<CovidData>> call, Response<List<CovidData>> response) {
                if (response.isSuccessful()) {
                    loadData(response.body());
                }else{
                    Toast.makeText(UpdateActivity.this, "No Response!", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<List<CovidData>> call, Throwable t) {
                Toast.makeText(UpdateActivity.this, "Error : "+t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void loadData(List<CovidData> covidData) {
        recyclerView = findViewById(R.id.rv_all_data);
        adapter = new AllUpdateAdapter(getBaseContext(),covidData);
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
