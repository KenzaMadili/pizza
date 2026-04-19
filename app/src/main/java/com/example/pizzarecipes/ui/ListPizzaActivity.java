package com.example.pizzarecipes.ui;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ListView;
import com.example.pizzarecipes.R;
import androidx.appcompat.app.AppCompatActivity;

import com.example.pizzarecipes.adapter.PizzaAdapter;
import com.example.pizzarecipes.classes.Produit;
import com.example.pizzarecipes.service.ProduitService;

import java.util.List;

public class ListPizzaActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.activity_list_pizza);

        ListView lv = findViewById(R.id.liste);
        List<Produit> pizzas = ProduitService.getInstance().findAll();

        PizzaAdapter adapter = new PizzaAdapter(this, pizzas);
        lv.setAdapter(adapter);

        lv.setOnItemClickListener((parent, view, pos, id) -> {
            Intent it = new Intent(ListPizzaActivity.this, PizzaDetailActivity.class);
            it.putExtra("pizza_id", id);
            startActivity(it);
        });

        // Bouton share
        ImageView btnShare = findViewById(R.id.btnShare);
        btnShare.setOnClickListener(v -> {
            StringBuilder message = new StringBuilder("Découvrez nos pizzas :\n\n");
            for (Produit p : pizzas) {
                message.append("- ").append(p.getNom()).append(" (").append(p.getPrix()).append(" €)\n");
            }
            Intent shareIntent = new Intent(Intent.ACTION_SEND);
            shareIntent.setType("text/plain");
            shareIntent.putExtra(Intent.EXTRA_TEXT, message.toString());
            startActivity(Intent.createChooser(shareIntent, "Partager la liste des pizzas"));
        });
    }
}
