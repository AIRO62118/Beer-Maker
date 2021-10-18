package com.example.myapplication.RecyclerView;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.AccesLocal;
import com.example.myapplication.Menu3Activity;
import com.example.myapplication.R;
import com.example.myapplication.RecetteBDD;

public class MyViewHolder extends RecyclerView.ViewHolder {
    private TextView idRecette;
    private TextView ingredient1;
    private TextView ingredient2;
    private TextView ingredient3;
    private Button charger;
    private Button supprimer;
    private AccesLocal accesLocal;


    //itemView est la vue correspondante à 1 cellule
    public MyViewHolder(View itemView) {
        super(itemView);
        //c'est ici que l'on fait nos findView

        idRecette = (TextView) itemView.findViewById(R.id.idRecette);
        ingredient1 = (TextView) itemView.findViewById(R.id.recette1);
        ingredient2 = (TextView) itemView.findViewById(R.id.recette2);
        ingredient3 = (TextView) itemView.findViewById(R.id.recette3);

        charger = (Button) itemView.findViewById(R.id.boutonCharg);
        supprimer = (Button) itemView.findViewById(R.id.boutonSuppr);
    }

    //puis ajouter une fonction pour remplir la cellule en fonction d'un MyObject
    //callback// 2 - add callback reference to the signature
    public void bind(RecetteBDD myObject) {

        idRecette.setText(myObject.getId().toString());
        ingredient1.setText(myObject.getVolumeBiere().toString());
        ingredient2.setText(myObject.getAlcoolDegre().toString());
        ingredient3.setText(myObject.getMoyenneEBC().toString());

        charger();
        supprimer();
    }

    public void charger() {
        charger.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                accesLocal.recupEtoile();
            }
        });
    }

    public void supprimer(){
        supprimer.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick (View view){
                accesLocal.vider();
            }
        });
    }
}
