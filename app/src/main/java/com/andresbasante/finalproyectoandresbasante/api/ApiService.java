package com.andresbasante.finalproyectoandresbasante.api;

import com.andresbasante.finalproyectoandresbasante.models.Cine;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Acer on 05/06/2017.
 */

public interface ApiService
{
    @GET("2azi-vnwj.json")
    Call<ArrayList<Cine>> obtenerListaCine();
}
