package com.example.myapplication;

public class RecetteBDD extends Recette {

    //Attributs
    Integer id;

    public RecetteBDD(Integer id, Double volumeBiere, Double alcoolDegre, Double moyenneEBC) {
        super(volumeBiere, alcoolDegre, moyenneEBC);
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}

