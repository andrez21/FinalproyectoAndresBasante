package com.andresbasante.finalproyectoandresbasante;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.View;

import com.andresbasante.finalproyectoandresbasante.api.ApiService;
import com.andresbasante.finalproyectoandresbasante.models.Cine;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private Retrofit retrofit;
    private static final String TAG = "Cine";
    private RecyclerView recyclerView;
    private boolean aptoParaCargar;
    private ListaCineAdapter listaCineAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        listaCineAdapter = new ListaCineAdapter(this);
        recyclerView.setAdapter(listaCineAdapter);

        recyclerView.setHasFixedSize(true);
        final GridLayoutManager layoutManager = new GridLayoutManager(this, 1);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                if (dy > 0) {
                    int visibleItemCount = layoutManager.getChildCount();
                    int totalItemCount = layoutManager.getItemCount();
                    int pastVisibleItems = layoutManager.findFirstVisibleItemPosition();

                    if (aptoParaCargar) {
                        if ((visibleItemCount + pastVisibleItems) >= totalItemCount) {
                            Log.i(TAG, " Llegamos al final.");

                            aptoParaCargar = false;
                            obtenerLista();
                        }
                    }
                }
            }
        });
        retrofit = new Retrofit.Builder()
                .baseUrl("https://www.datos.gov.co/resource/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        aptoParaCargar = true;
        obtenerLista();
    }
    private void obtenerLista() {

        ApiService service = retrofit.create(ApiService.class);
        Call<ArrayList<Cine>> autoRespuestaCall = service.obtenerListaCine();

        autoRespuestaCall.enqueue(new Callback<ArrayList<Cine>>() {
            @Override
            public void onResponse(Call<ArrayList<Cine>> call, Response<ArrayList<Cine>> response) {
                if(response.isSuccessful()){
                    ArrayList lista = response.body();
                    listaCineAdapter.adicionarListaCine(lista);
                }
                else
                {
                    Log.e(TAG, "onResponse: "+response.errorBody());
                }
            }
            @Override
            public void onFailure(Call<ArrayList<Cine>> call, Throwable t) {
                Log.e(TAG," onFailure: "+t.getMessage());
            }
        });
    }
    public void acerca(View view) {
        Intent x = new Intent(this, AcercaDe.class);
        startActivity(x);
    }
}
