package com.example.caesar.opellaapp;

public class OpeleModel {

    private String name;
    private int imageResourceId;

    public static final OpeleModel[] pizzas = {new OpeleModel("Domino's", R.drawable.smallseeds),
            new OpeleModel("Funghi", R.drawable.mediumseeds), new OpeleModel("Funghi", R.drawable.largeseeds),
            new OpeleModel("Funghi", R.drawable.extralargeseeds)};

    public OpeleModel(String name, int imageResourceId){
        this.name = name;
        this.imageResourceId = imageResourceId;
    }

    public String getName(){
        return name;
    }
    public int getImageResourceId(){
        return imageResourceId;
    }

}
