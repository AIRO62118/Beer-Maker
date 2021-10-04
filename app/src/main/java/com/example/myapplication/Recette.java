package com.example.myapplication;

import java.io.Serializable;

public class Recette implements Serializable {

    //Attributs persos
    Double volumeBiere;
    Double alcoolDegre;
    Double moyenneEBC;

    //Constructeur
    public Recette(Double volumeBiere, Double alcoolDegre, Double moyenneEBC) {
        this.volumeBiere = volumeBiere;
        this.alcoolDegre = alcoolDegre;
        this.moyenneEBC = moyenneEBC;
    }


    //Getter/Setter

    public Double getVolumeBiere() {
        return volumeBiere;
    }
    public void setVolumeBiere(Double volumeBiere) {
        this.volumeBiere = volumeBiere;
    }

    public Double getAlcoolDegre() {
        return alcoolDegre;
    }
    public void setAlcoolDegre(Double alcoolDegre) {
        this.alcoolDegre = alcoolDegre;
    }

    public Double getMoyenneEBC() {
        return moyenneEBC;
    }
    public void setMoyenneEBC(Double moyenneEBC) {
        this.moyenneEBC = moyenneEBC;
    }


    //Methodes persos
    public Double calcMalt() {
        //(Volume de bière désiré en L * degré d’alcool recherché ) / 20 = Malt en kg
        return ( volumeBiere * alcoolDegre ) / 20;
    }

    public Double calcEauB() {
        //Quantité de malt en kg * 2,8 = Quantité d’eau de brassage en L
        return calcMalt() * 2.8;
    }

    public Double calcEauR() {
        //(Volume de bière désiré en L *1,25) - (Eau de brassage en L *0,7 ) = Eau de rinçage en L
        return (volumeBiere * 1.25) - ( calcEauB() * 0.7 );
    }

    public Double calcHouAm() {
        //Houblon amérisant = Volume de bière à houblonner en L * 3g
        return volumeBiere * 3;
    }
    public Double calchouAr() {
        //Houblon aromatique = Volume de bière à houblonner en L * 1g
        return volumeBiere;
    }
    public Double calcLevure() {
        //Volume de bière désiré en L / 2 = quantité de levure en g
        return volumeBiere / 2;
    }




    public Double calcMcu() {
        //MCU = (4,23 * (Moyenne EBC des grains * poidsEnKg des grains)) / le volume de bière désiré en L
        return (4.23 * (moyenneEBC * calcMalt())) / volumeBiere;
    }
    public Double calcSrm() {
        //SRM = 0,508 * EBC
        return calcEbcFromMcu() * 0.508;
    }
    public Double calcEbcFromSrm() {
        //EBC = 1,97 * SRM
        return calcSrm() * 1.97;
    }
    public Double calcEbcFromMcu() {
        //EBC = 2,9396 * (MCU^0,6859)
        return 2.9396 * Math.pow(calcMcu(), 0.6859);
    }

}
