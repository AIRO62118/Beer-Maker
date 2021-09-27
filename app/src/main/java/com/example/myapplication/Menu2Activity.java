package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.DeadObjectException;
import android.text.Editable;
import android.text.Layout;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Menu2Activity extends AppCompatActivity {

    //Attributs
    Recette recette;

    EditText input1;
    EditText input2;
    EditText input3;

    Button boutonCalculer;

    LinearLayout layoutReponse;

    TextView reponse1;
    TextView reponse2;
    TextView reponse3;
    TextView reponse4;
    TextView reponse5;
    TextView reponse6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu2);

        init();
        calculerIngredients();

    }


    public void init(){
        input1 = findViewById(R.id.input1);
        input2 = findViewById(R.id.input2);
        input3 = findViewById(R.id.input3);

        boutonCalculer = findViewById(R.id.boutonCalculer);

        layoutReponse = findViewById(R.id.layoutReponse);

        reponse1 = findViewById(R.id.textReponse1);
        reponse2 = findViewById(R.id.textReponse2);
        reponse3 = findViewById(R.id.textReponse3);
        reponse4 = findViewById(R.id.textReponse4);
        reponse5 = findViewById(R.id.textReponse5);
        reponse6 = findViewById(R.id.textReponse6);


    }

    private void calculer(){


        Double volume = Double.parseDouble(input1.getText().toString());
        Double degre = Double.parseDouble(input2.getText().toString());
        Double moyenneEBC = Double.parseDouble(input3.getText().toString());

        recette = new Recette(volume, degre, moyenneEBC);

        input1.setText(recette.getVolumeBiere().toString());
        input2.setText(recette.getAlcoolDegre().toString());
        input3.setText(recette.getMoyenneEBC().toString());

        afficherIngredient();
    }

    private void afficherIngredient(){
        reponse1.setText("Quantité de Malt: "+recette.calcMalt());
        reponse2.setText("Quantité Eau Brassage:" +recette.calcEauB());
        reponse3.setText("Quantité Eau rinçage:" +recette.calcEauR());
        reponse4.setText("Quantité Houblon Amerisant: "+recette.calcHouAm());
        reponse5.setText("Quantité Houblon Aromatique: "+recette.calchouAr());
        reponse6.setText("Quantité levure: "+recette.calcLevure());
        layoutReponse.setVisibility(View.VISIBLE);
    }


    private void calculerIngredients(){
        boutonCalculer.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculer();
            }
        });


    }

}