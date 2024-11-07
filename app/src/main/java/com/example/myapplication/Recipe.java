package com.example.myapplication;






public class Recipe {
    private String name;
    private String preparation;
    private String ingredients;
    private int imageResId;

    public Recipe(String name, String preparation, String ingredients, int imageResId) {
        this.name = name;
        this.preparation = preparation;
        this.ingredients = ingredients;
        this.imageResId = imageResId;
    }

    public String getName() {
        return name;
    }

    public String getPreparation() {
        return preparation;
    }

    public String getIngredients() {
        return ingredients;
    }

    public int getImageResId() {
        return imageResId;
    }
}
