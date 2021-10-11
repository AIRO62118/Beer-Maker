package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.text.Editable;
import android.text.Layout;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Serializable;
import java.text.ParseException;

public class Menu2Activity extends AppCompatActivity {

    //Attributs
    private Recette recette;
    private AccesLocal accesLocal;
    private RecyclerView listeBdd;

    EditText input1;
    EditText input2;
    EditText input3;

    Button boutonCalculer;
    Button boutonEnregistrer;

    LinearLayout layoutReponse;

    TextView reponse1;
    TextView reponse2;
    TextView reponse3;
    TextView reponse4;
    TextView reponse5;
    TextView reponse6;
    TextView reponse7;
    TextView reponse8;
    TextView reponse9;
    TextView textColor;

    String serializable = "serializable";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu2);

        init();
        calculerIngredients();
        checkSerialize();
        enregistrer();

    }


    public void init(){
        input1 = findViewById(R.id.input1);
        input2 = findViewById(R.id.input2);
        input3 = findViewById(R.id.input3);

        boutonCalculer = findViewById(R.id.boutonCalculer);
        boutonEnregistrer = findViewById(R.id.boutonEnregistrer);

        layoutReponse = findViewById(R.id.layoutReponse);

        reponse1 = findViewById(R.id.textReponse1);
        reponse2 = findViewById(R.id.textReponse2);
        reponse3 = findViewById(R.id.textReponse3);
        reponse4 = findViewById(R.id.textReponse4);
        reponse5 = findViewById(R.id.textReponse5);
        reponse6 = findViewById(R.id.textReponse6);
        reponse7 = findViewById(R.id.textReponse7);
        reponse8 = findViewById(R.id.textReponse8);
        reponse9 = findViewById(R.id.textReponse9);

        textColor = findViewById(R.id.textColor);

        layoutReponse.setVisibility(View.INVISIBLE);

        accesLocal = new AccesLocal(this);
        listeBdd = findViewById(R.id.listeRecette);

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

        Serializer.serialize(serializable, recette, Menu2Activity.this);

    }
    private void afficherIngredient(){
        reponse1.setText("Quantité de Malt: "+recette.calcMalt()+" kg");
        reponse2.setText("Quantité Eau Brassage:" +recette.calcEauB()+" L");
        reponse3.setText("Quantité Eau rinçage:" +recette.calcEauR()+" L");
        reponse4.setText("Quantité Houblon Amerisant: "+recette.calcHouAm()+" g");
        reponse5.setText("Quantité Houblon Aromatique: "+recette.calchouAr()+" g");
        reponse6.setText("Quantité levure: "+recette.calcLevure()+" kg");
        reponse7.setText("MCU = "+recette.calcMcu());
        reponse8.setText("EBC = "+recette.calcEbcFromSrm());
        reponse9.setText("SRM = "+recette.calcSrm());

        textColor.setBackgroundColor(Color.parseColor(srmToRGB(recette.calcSrm())));
        textColor.setText(srmToRGB(recette.calcSrm()));
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

    private void enregistrer(){
        boutonEnregistrer.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View view){
                accesLocal.ajout(recette.getVolumeBiere(), recette.getAlcoolDegre(), recette.getMoyenneEBC());
                Toast.makeText(Menu2Activity.this, "Saisie Enregistrée", Toast.LENGTH_LONG).show();

            }
        });
    }


    private String srmToRGB(double srm) {
        // Returns an RGB value based on SRM
        Double r, g, b;
        r= g= b= (double) 0;
        if (srm>=0 && srm<=1) {
            r = (double) 240;
            g = (double) 239;
            b = (double) 181;
        } else if (srm>1 && srm<=2) {
            r = (double) 233;
            g = (double) 215;
            b = (double) 108;
        } else if (srm>2) {
            // Set red decimal
            if (srm<70.6843) {
                r = 243.8327-(6.4040*srm)+(0.0453*srm*srm);
            } else {
                r = 17.5014;
            }
            // Set green decimal
            if (srm<35.0674) {
                g = 230.929-12.484*srm+0.178*srm*srm;
            } else {
                g = 12.0382;
            }
            // Set blue decimal
            if (srm<4) {
                b = (double) -54*srm+216;
            } else if (srm>=4 && srm<7) {
                b = (double) 0;
            } else if (srm>=7 && srm<9) {
                b = (double) 13*srm-91;
            } else if (srm>=9 && srm<13) {
                b = (double) 2*srm+8;
            } else if (srm>=13 && srm<17) {
                b = -1.5*srm+53.5;
            } else if (srm>=17 && srm<22) {
                b = 0.6*srm+17.8;
            } else if (srm>=22 && srm<27) {
                b = -2.2*srm+79.4;
            } else if (srm>=27 && srm<34) {
                b = -0.4285*srm + 31.5714;
            } else {
                b = (double) 17;
            }
        }
        Integer red = r.intValue();
        Integer green = g.intValue();
        Integer blue = b.intValue();
        //String rgb  = "#"+red.toHexString(red)+green.toHexString(green)+blue.toHexString(blue);
        String rr = red.toHexString(red);
        String gg = green.toHexString(green);
        String bb = blue.toHexString(blue);

        String rgb = "#";
        if (rr.length()<2){
            rr="0"+rr;
        }else if (gg.length()<2){
            gg="0"+gg;
        }else if (bb.length()<2){
            bb="0"+bb;
        }
        rgb = rgb+rr+gg+bb;
        return rgb;
    }


    private void recupSerialize(Context contexte){
        recette = (Recette) Serializer.deserialize(serializable, contexte);
    }
    private void checkSerialize(){
        try{
            recupSerialize(this);
            ((TextView) findViewById(R.id.input1)).setText("" + recette.getVolumeBiere());
            ((TextView) findViewById(R.id.input2)).setText("" + recette.getAlcoolDegre());
            ((TextView) findViewById(R.id.input3)).setText("" + recette.getMoyenneEBC());
            // findViewById(R.id.btn_save).performClick();
        }catch (Exception e){};
    }


}