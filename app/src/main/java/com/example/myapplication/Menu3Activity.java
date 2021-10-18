package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.myapplication.RecyclerView.MyAdapter;

import java.util.ArrayList;

public class Menu3Activity extends AppCompatActivity {

    //Attributs
    private RecyclerView listeBdd;
    private AccesLocal accesLocal;
    TextView nbrRecette;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu3);

    init();

        ArrayList<Recette> listeRecette = accesLocal.recupEtoile();
        Log.d("Pourquoi ?", String.valueOf(listeRecette.size()));
        listeBdd.setLayoutManager(new LinearLayoutManager(this));
        listeBdd.setAdapter(new MyAdapter(listeRecette));

    }

    public void init(){
        listeBdd = findViewById(R.id.listeRecette);
        accesLocal = new AccesLocal(this);

        nbrRecette = findViewById(R.id.nbrRecette);



    }



    @Override
    public void onResume(){
        Log.d("MonLog", "OnResume Start");
        super.onResume();
    }





}