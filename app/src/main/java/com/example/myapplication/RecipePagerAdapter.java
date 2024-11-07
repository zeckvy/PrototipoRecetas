package com.example.myapplication;




import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;
import java.util.List;

public class RecipePagerAdapter extends PagerAdapter {

    private Context context;
    private List<Recipe> recipes;

    public RecipePagerAdapter(Context context, List<Recipe> recipes) {
        this.context = context;
        this.recipes = recipes;
    }

    @Override
    public int getCount() {
        return recipes.size();
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View view = LayoutInflater.from(context).inflate(R.layout.recipe_item, container, false);

        ImageView recipeImageView = view.findViewById(R.id.recipeImage);
        TextView nameTextView = view.findViewById(R.id.recipeName);
        TextView preparationTextView = view.findViewById(R.id.recipePreparation);
        TextView ingredientsTextView = view.findViewById(R.id.recipeIngredients);

        Recipe recipe = recipes.get(position);

        recipeImageView.setImageResource(recipe.getImageResId());
        nameTextView.setText(recipe.getName());
        preparationTextView.setText(recipe.getPreparation());
        ingredientsTextView.setText(recipe.getIngredients());

        // Configura un clic para abrir los detalles de la receta
        view.setOnClickListener(v -> {
            Intent intent = new Intent(context, RecipeDetailActivity.class);
            intent.putExtra("recipeName", recipe.getName());
            intent.putExtra("recipePreparation", recipe.getPreparation());
            intent.putExtra("recipeIngredients", recipe.getIngredients());
            intent.putExtra("recipeImageResId", recipe.getImageResId());
            context.startActivity(intent);
        });

        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }
}
