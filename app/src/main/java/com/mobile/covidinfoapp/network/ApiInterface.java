package com.mobile.covidinfoapp.network;

import com.mobile.covidinfoapp.config.Constant;
import com.mobile.covidinfoapp.model.CovidData;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {

    @GET(Constant.HOME+Constant.LAST_DATA+Constant.LOCATION)
    Call<CovidData> getLast ();

    @GET(Constant.HOME+Constant.ALL_DATA+Constant.LOCATION)
    Call<List<CovidData>> getAllData ();
}
