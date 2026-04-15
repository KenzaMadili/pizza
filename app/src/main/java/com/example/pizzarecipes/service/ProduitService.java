package com.example.pizzarecipes.service;

import com.example.pizzarecipes.R;
import com.example.pizzarecipes.classes.Produit;
import com.example.pizzarecipes.dao.IDao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ProduitService implements IDao<Produit> {

    private static ProduitService INSTANCE;
    private final List<Produit> data = new ArrayList<>();

    private ProduitService() {
        seed();
    }

    public static ProduitService getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new ProduitService();
        }
        return INSTANCE;
    }

    private void seed() {

        create(new Produit("BARBECUED CHICKEN PIZZA", 3, R.mipmap.pizza1, "35 min",
                "- 2 boneless skinless chicken breast halves (6 ounces each)\n- 1/4 teaspoon pepper\n- 1 cup barbecue sauce, divided\n- 1 tube refrigerated pizza crust\n- 2 teaspoons olive oil\n- 2 cups shredded Gouda cheese\n- 1 small red onion\n- 1/4 cup cilantro",
                "So fast and so easy with refrigerated pizza crust, these saucy, smoky pizzas make quick fans with their rustic flavor.",
                "STEP 1:\nGrill chicken.\nSTEP 2:\nPrepare dough and grill.\nSTEP 3:\nAdd toppings and cook."));

        create(new Produit("BRUSCHETTA PIZZA", 5, R.mipmap.pizza2, "35 min",
                "- Pork sausage\n- Pepperoni\n- Mozzarella\n- Tomatoes\n- Basil\n- Garlic\n- Vinegar",
                "Loaded with Italian flavor and fresh tomatoes, it's a family favorite.",
                "STEP 1:\nCook sausage.\nSTEP 2:\nPrepare tomato mix.\nSTEP 3:\nBake and garnish."));

        create(new Produit("SPINACH PIZZA", 2, R.mipmap.pizza3, "25 min",
                "- Pizza crust\n- Alfredo sauce\n- Tomatoes\n- Spinach\n- Cheese",
                "This tasty pizza is easy and veggie-filled.",
                "STEP 1:\nPrepare dough.\nSTEP 2:\nAdd toppings.\nSTEP 3:\nBake."));

        create(new Produit("DEEP-DISH SAUSAGE PIZZA", 8, R.mipmap.pizza4, "45 min",
                "- Yeast\n- Flour\n- Oil\n- Sausage\n- Cheese\n- Tomato",
                "Traditional deep-dish pizza with rich flavors and thick crust.",
                "STEP 1:\nPrepare dough.\nSTEP 2:\nLayer ingredients.\nSTEP 3:\nBake."));

        create(new Produit("HOMEMADE PIZZA", 4, R.mipmap.pizza5, "50 min",
                "- Yeast\n- Flour\n- Beef\n- Tomato sauce\n- Cheese",
                "Classic homemade pizza with crispy crust.",
                "STEP 1:\nPrepare dough.\nSTEP 2:\nCook beef.\nSTEP 3:\nBake."));

        create(new Produit("PESTO CHICKEN PIZZA", 3, R.mipmap.pizza6, "50 min",
                "- Chicken\n- Pesto\n- Peppers\n- Cheese\n- Mushrooms",
                "Healthy and flavorful pizza with pesto and chicken.",
                "STEP 1:\nPrepare dough.\nSTEP 2:\nCook chicken.\nSTEP 3:\nBake."));

        create(new Produit("LOADED MEXICAN PIZZA", 3, R.mipmap.pizza7, "30 min",
                "- Beans\n- Onion\n- Tomato\n- Jalapeno\n- Cheese",
                "Spicy and flavorful Mexican-style pizza.",
                "STEP 1:\nPrepare mixture.\nSTEP 2:\nAdd toppings.\nSTEP 3:\nBake."));

        create(new Produit("BACON CHEESEBURGER PIZZA", 2, R.mipmap.pizza8, "20 min",
                "- Beef\n- Bacon\n- Cheese\n- Pickles",
                "Combination of pizza and cheeseburger loved by kids.",
                "STEP 1:\nCook beef.\nSTEP 2:\nAssemble pizza.\nSTEP 3:\nBake."));

        create(new Produit("PIZZA MARGHERITA", 1, R.mipmap.pizza9, "30 min",
                "- Yeast\n- Flour\n- Tomato\n- Basil\n- Mozzarella",
                "Classic Italian pizza with simple ingredients.",
                "STEP 1:\nPrepare dough.\nSTEP 2:\nAdd toppings.\nSTEP 3:\nBake."));

        create(new Produit("PEPPERONI-SAUSAGE STUFFED PIZZA", 5, R.mipmap.pizza10, "45 min",
                "- Pepperoni\n- Sausage\n- Cheese\n- Dough",
                "Stuffed pizza rich and delicious.",
                "STEP 1:\nPrepare dough.\nSTEP 2:\nAdd filling.\nSTEP 3:\nBake."));
    }

    @Override
    public Produit create(Produit p) {
        data.add(p);
        return p;
    }

    @Override
    public Produit update(Produit p) {
        for (int i = 0; i < data.size(); i++) {
            if (data.get(i).getId() == p.getId()) {
                data.set(i, p);
                return p;
            }
        }
        return null;
    }

    @Override
    public boolean delete(long id) {
        return data.removeIf(p -> p.getId() == id);
    }

    @Override
    public Produit findById(long id) {
        for (Produit p : data) {
            if (p.getId() == id) return p;
        }
        return null;
    }

    @Override
    public List<Produit> findAll() {
        return Collections.unmodifiableList(data);
    }
}