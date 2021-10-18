package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Menu1Activity extends AppCompatActivity {

    //Attributs
    TextView texteEtape;
    Button versGauche;
    Button versDroite;
    int page = 0;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu1);

        init();
        clickVersGauche();
        clickVersDroite();
        afficherTexte();
    }


    public void init(){
        texteEtape = findViewById(R.id.texteEtape);
        versGauche = findViewById(R.id.versGauche);
        versDroite = findViewById(R.id.versDroite);
    }


    public void afficherTexte(){
        if(page == 0){
            versGauche.setVisibility(View.INVISIBLE);
            texteEtape.setText("Au préalable:\n" +
                    "Vous allez avoir besoin du matériel suivant pour réaliser votre bière :\n" +
                    "Une dame-jeanne             -un barboteur\n" +
                    "un thermomètre            -un tuyau d’extraction avec un embout anti-lie\n" +
                    "plusieurs casseroles            -une cuillère percée\n" +
                    "une passoire à mailles fines        - bouteilles en verre à clapet\n" +
                    "Le matériel utile à la fabrication doit être propre et stérilisé. Nous vous conseillons d’utiliser un désinfectant en poudre vendu dans le commerce et de vous fier aux instruction (à diluer dans de l’eau dans laquelle il faut faire tremper le matériel quelques minutes)\n" +
                    "\n");
        }else if (page == 1){
            versGauche.setVisibility(View.VISIBLE);
            texteEtape.setText("1- L'empâtage\n" +
                    "Note: Le malt blond peut s'utiliser seul. Les malts plus foncés ne s’utilisent qu’en petite dose pour moduler le goût de la bière.\n" +
                    "Si vous avez achetez du malt en grain entier, le concasser avec un moulin à céréales, un mixer ou encore un rouleau à pâtisserie. \n" +
                    "Définissez la quantité d’eau de brassage nécessaire, puis versez la dans une grande casserole. \n" +
                    "Porter cette eau à une température de 50 °C en vérifiant avec le thermomètre, puis ajouter le malt concassé.\n" +
                    "\n");
        }else if (page == 2){
            texteEtape.setText("2- Le brassage par paliers\n" +
                    "Brasser la mixture malt+eau, appelée maîshe, pendant 30 min, à 40°C environ. \n" +
                    "Remuer avec une grande cuillère percée durant la chauffe et laisser reposer une fois la température du palier atteinte. \n" +
                    "Monter en température la maîshe à 60-65°C et maintenir cette température environ 30 min. Augmenter la température à 68-70°C et maintenir cette température environ 30 min. Augmenter la température à 78°C et maintenir cette température environ 30 min.\n");
        }else if (page == 3){
            texteEtape.setText("3- Filtrer la maîshe\n" +
                    "Au dessus d’une seconde casserole, verser la maîshe dans une grande passoie (tapisser si besoin d’un linge propre) pour obtenir la drêche (résidu solide du malt). \n" +
                    "Pour récupérer les sucres restants dans la drêche égouttée, verser au-dessus de la drêche l’eau de rinçage préalablement montée à 80°C.\n" +
                    "L’eau de brassage associé à l’eau de rinçage s’appelle le moût. Les résidus de malt sont compostables.\n");
        }else if (page == 4){
            texteEtape.setText("4- Le houblonnage\n" +
                    "Calculer la quantité de houblon à ajouter. Différentes recettes existent, les houblons peuvent être complétés par des épices. Faites bouillir le moût. Dès que l'ébullition commence, écumer et ajouter le houblon amer. Laisser bouillir ce mélange sans couvrir pendant 1h30 pour retirer de l’amertume. 10-15 minutes avant la fin de cette ébullition, ajouter le houblin aromatique. Retirer le houblon en le filtrant. Éviter cette étape en plaçant le houblon dans un filtre à thé en papier. Le choix du houblon doit être fait en fonction de son taux IBU qui est l’unité d’amertume.\n");
        }else if (page == 5){
            texteEtape.setText("5- La fermentation\n" +
                    "Le moût doit être refroidi à une température de 20-25°C pour y incorporer les levures puis transvasé dans la dame-jeanne. \n" +
                    "Il existe différentes levures. Nous vous recommandons d’utiliser des levures sèches qui sont mieux adaptées pour des petits brassins. Se référer à l’emballage pour déterminer au mieux la quantité appropriée. Il est recommandé d’utiliser pour débuter de la levure S33 qui est polyvalente. Incorporer la levure et remuer la bonbonne pour mélanger. Dans une pièce à 20°C, fermer la bonbonne et placer le barboter (qui permet d’évacuer l’oxygène). \n" +
                    "Durant environ une semaine, les levures vont travailler et générer du CO2 dans la bonbonne, qui va s’évacuer par le barboteur. Remuer de temps en temps la bonbonne pour faire évacuer le CO2.\n" +
                    "Lorsqu’il n’y a plus d’activité dans le barboteur, mettre la bouteille de fermentation dans une pièce plus fraîche (autour de 10-15°C, comme une cave par exemple). \n" +
                    "La bière peut ainsi maturer pendant 1 à 3 semaines, cette période de fermentation secondaire se nomme la garde.\n" +
                    "Ajouter selon recette des épices, fruits, ...\n");
        }else if (page == 6){
            versDroite.setVisibility(View.VISIBLE);
            texteEtape.setText("6- Le sucrage\n" +
                    "Pour relancer la fermentation qui se fera en bouteille et qui permet d’obtenir de la mousse, incorporer 4 à 6 g de sucre par litre de bière. \n");
        }
        else if (page == 7){
            versDroite.setVisibility(View.INVISIBLE);
            texteEtape.setText("7- La mise en bouteille\n" +
                    "Mettre en bouteille (stérilisées et séchées) en utilisant un tuyau d'extraction avec embout anti-lie. \n" +
                    "Le but est de récupérer le liquide clair et d’éliminer les précipités et dépots. placer l’embout anti-lie sur le fond de la bonbonne et l’autre bout au fond de la bouteille. La bonbonne doit être placée très en hauteur par rapport à la bouteille.\n" +
                    "Utiliser des bouteilles en verre teinté propres et sèches, qui ferment avec un bouchon à vis ou à clapet. Les bouteilles doivent être conservées verticalement. \n" +
                    "Pendant une semaine conserver ces bouteilles à 20°C. Puis pendant 4 à 8 semaines, les gardes au frais, entre 6 et 10°C.\n" +
                    "La bière se conserve 1 an, idéalement entre 10 et 15°C à l’abri de la lumière ou simplement au réfrigérateur.\n");
        }


    }

    public void clickVersGauche(){
        versGauche.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View view){
                page--;
                afficherTexte();
            }
        });
    }

    private void clickVersDroite() {

        versDroite.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View view){
                page++;
                afficherTexte();
            }
        });
    }



}