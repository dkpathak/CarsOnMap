package com.dk.sixt.carzrent.apis;

import com.dk.sixt.carzrent.models.Cars;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by dk on 30/8/17.
 */

public interface ApiInterface {

    @GET("cars.json")
    Call <List<Cars>> getCars();



}
