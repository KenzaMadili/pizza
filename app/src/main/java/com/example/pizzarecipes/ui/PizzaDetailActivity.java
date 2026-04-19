package com.example.pizzarecipes.ui;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.pizzarecipes.R;
import androidx.appcompat.app.AppCompatActivity;

import com.example.pizzarecipes.classes.Produit;
import com.example.pizzarecipes.service.ProduitService;

public class PizzaDetailActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.activity_pizza_detail);

        long id = getIntent().getLongExtra("pizza_id", -1);
        Produit p = ProduitService.getInstance().findById(id);

        ImageView img = findViewById(R.id.img);
        TextView title = findViewById(R.id.title);
        TextView desc = findViewById(R.id.desc);
        TextView ingredients = findViewById(R.id.ingredients);
        TextView steps = findViewById(R.id.steps);

        // Boutons
        ImageView btnBack = findViewById(R.id.btnBack);
        ImageView btnShare = findViewById(R.id.btnShare);

        // Action retour
        btnBack.setOnClickListener(v -> finish());

        // Action partager
        btnShare.setOnClickListener(v -> {
            Intent shareIntent = new Intent(Intent.ACTION_SEND);
            shareIntent.setType("text/plain");
            shareIntent.putExtra(Intent.EXTRA_TEXT,
                    "Découvrez " + p.getNom() + "\n\n" +
                            "Ingrédients : " + p.getIngredients() + "\n\n" +
                            "Étapes : " + p.getEtapes());
            startActivity(Intent.createChooser(shareIntent, "Partager la recette"));
        });

        if (p != null) {
            img.setImageResource(p.getImageRes());
            title.setText(p.getNom());
            desc.setText(p.getDescription());
            ingredients.setText(p.getIngredients());
            steps.setText(p.getEtapes());
        } else {
            title.setText("Pizza introuvable !");
        }
    }
}
