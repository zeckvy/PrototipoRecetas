package com.example.myapplication;





import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class RecipeDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_detail);

        TextView titleTextView = findViewById(R.id.recipeTitleTextView);
        TextView ingredientsTextView = findViewById(R.id.recipeIngredientsTextView);
        TextView preparationTextView = findViewById(R.id.recipePreparationTextView);
        ImageView recipeImageView = findViewById(R.id.recipeImageView);
        Button backToMainButton = findViewById(R.id.backToMainButton);

        Intent intent = getIntent();
        String title = intent.getStringExtra("recipeTitle");
        String ingredients = intent.getStringExtra("recipeIngredients");
        String preparation = intent.getStringExtra("recipePreparation");
        int imageResId = intent.getIntExtra("recipeImage", R.drawable.ic_launcher_background);

        titleTextView.setText(title);
        ingredientsTextView.setText(ingredients);
        preparationTextView.setText(preparation);
        recipeImageView.setImageResource(imageResId);

        backToMainButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mainIntent = new Intent(RecipeDetailActivity.this, MainActivity.class);
                startActivity(mainIntent);
                finish();
            }
        });
    }
}


