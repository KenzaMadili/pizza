package com.example.pizzarecipes.ui;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.pizzarecipes.R;
import com.example.pizzarecipes.adapter.PizzaAdapter;
import com.example.pizzarecipes.classes.Produit;
import com.example.pizzarecipes.service.ProduitService;

import java.util.List;

public class ListPizzaActivity extends AppCompatActivity {

    private ListView lv;
    private List<Produit> pizzas;

    @Override
    protected void onCreate(Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.activity_list_pizza);

        lv = findViewById(R.id.lvPizzas);

        pizzas = ProduitService.getInstance().findAll();

        PizzaAdapter adapter = new PizzaAdapter(this, pizzas);
        lv.setAdapter(adapter);

        lv.setOnItemClickListener((parent, view, pos, id) -> {

            Produit selectedPizza = pizzas.get(pos);

            Intent it = new Intent(ListPizzaActivity.this, PizzaDetailActivity.class);

            // 🔥 plus fiable que id seul
            it.putExtra("pizza_id", selectedPizza.getId());

            startActivity(it);
        });
    }
}