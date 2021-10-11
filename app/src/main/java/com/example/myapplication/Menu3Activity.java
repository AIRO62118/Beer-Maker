package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.example.myapplication.RecyclerView.MyAdapter;

import java.util.ArrayList;

public class Menu3Activity extends AppCompatActivity {

    //Attributs
    private RecyclerView listeBdd;
    private AccesLocal accesLocal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu3);

    init();
    }

    public void init(){
        listeBdd = findViewById(R.id.listeRecette);
        accesLocal = new AccesLocal(this);
    }



    @Override
    public void onResume(){
        Log.d("MonLog", "OnResume Start");
        super.onResume();

        ArrayList<Recette> listeRecette = accesLocal.recupEtoile();
        listeBdd.setLayoutManager(new LinearLayoutManager(this));
        listeBdd.setAdapter(new MyAdapter(listeRecette));
    }
}