package com.example.myapplication;





import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView imgArrozHuevo = findViewById(R.id.imgArrozHuevo);
        ImageView imgPanQueso = findViewById(R.id.imgPanQueso);
        ImageView imgCarneAsada = findViewById(R.id.imgCarneAsada);

        imgArrozHuevo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openRecipeDetail(
                        "Arroz con Huevo",
                        "Cocinar el arroz, freír el huevo y mezclar.",
                        "Arroz, Huevo, Sal",
                        R.drawable.arroz_con_huevo
                );
            }
        });

        imgPanQueso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openRecipeDetail(
                        "Pan con Queso",
                        "Abrir el pan y meter el queso.",
                        "Pan, Queso",
                        R.drawable.pan_con_queso
                );
            }
        });

        imgCarneAsada.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openRecipeDetail(
                        "Carne Asada",
                        "Asar la carne a la parrilla.",
                        "Carne, Sal, Pimienta",
                        R.drawable.carne_asada
                );
            }
        });
    }

    private void openRecipeDetail(String name, String preparation, String ingredients, int imageResId) {
        Intent intent = new Intent(MainActivity.this, RecipeDetailActivity.class);
        intent.putExtra("recipeName", name);
        intent.putExtra("recipePreparation", preparation);
        intent.putExtra("recipeIngredients", ingredients);
        intent.putExtra("recipeImage", imageResId);
        startActivity(intent);
    }
}
