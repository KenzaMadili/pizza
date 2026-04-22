

https://github.com/user-attachments/assets/db21c5e0-3d29-460a-bcd1-5cb0282da295



# 🍕 Pizza Recipes App

## 📱 Description du projet

**Pizza Recipes App** est une application Android permettant d’afficher une liste de recettes de pizzas avec leurs détails (image, ingrédients, description et étapes de préparation).

L’objectif de ce projet est de mettre en pratique :

* la programmation Android en Java
* l’utilisation des composants UI (ListView, Adapter, Activity)
* la gestion des données en mémoire (pattern DAO + Singleton)

---

## 🧩 Fonctionnalités

✅ Affichage d’une liste de pizzas
✅ Interface utilisateur moderne (CardView)
✅ Navigation entre écrans (Intent)
✅ Page détail avec :

* image
* nom
* durée
* prix
* ingrédients
* description
* étapes de préparation

---

## 🏗️ Architecture du projet

Le projet est organisé selon une structure simple :

### 📦 `classes`

Contient la classe principale :

* `Produit.java` : modèle représentant une pizza

---

### 📦 `service`

* `ProduitService.java`
  👉 Gère les données des pizzas (CRUD)

✔️ utilise le **pattern Singleton**
✔️ stocke les données dans une liste
✔️ méthode `seed()` pour pré-remplir les pizzas

---

### 📦 `dao`

* `IDao.java`
  👉 Interface définissant les opérations :
* create
* update
* delete
* findById
* findAll

---

### 📦 `adapter`

* `PizzaAdapter.java`
  👉 Permet de relier les données à la ListView

✔️ utilise le **ViewHolder pattern**
✔️ améliore les performances

---

### 📦 `ui`

Contient les écrans de l’application :

* `SplashActivity.java`
  👉 écran de démarrage (2 secondes)

* `ListPizzaActivity.java`
  👉 affiche la liste des pizzas

* `PizzaDetailActivity.java`
  👉 affiche les détails d’une pizza

---

## 🔄 Fonctionnement de l’application

1. L’application démarre avec **SplashActivity**
2. Redirection vers **ListPizzaActivity**
3. Les pizzas sont chargées depuis `ProduitService`
4. L’utilisateur clique sur une pizza
5. Ouverture de **PizzaDetailActivity**
6. Affichage des informations détaillées

---

## 🧠 Concepts utilisés

* ✔️ **ListView + Adapter**
* ✔️ **Intents (navigation entre activités)**
* ✔️ **Singleton Pattern**
* ✔️ **DAO Pattern**
* ✔️ **ViewHolder Pattern**
* ✔️ **Gestion des ressources (images, layouts)**

---

## 🎨 Interface utilisateur

* Utilisation de **CardView** pour un design moderne
* Layouts XML structurés et responsives
* Mise en forme avec marges, paddings et styles

---

## ⚙️ Technologies utilisées

* Java
* Android SDK
* XML (UI)
* Android Studio



---
## 🚀 Améliorations possibles

🔧 Ajouter une recherche de pizzas
🔧 Ajouter un système de favoris ❤️
🔧 Ajouter une base de données (SQLite / Room)
🔧 Ajouter une API externe

---

## 🎥 Démonstration de l'application

Une vidéo de démonstration de l'application est disponible ci-dessous.
Elle présente les principales fonctionnalités :

* Affichage de la liste des pizzas 🍕
* Navigation entre les écrans
* Consultation des détails d’une pizza
* Interface utilisateur

### 📹 Vidéo

👉 [Voir la vidéo de démonstration](/demo_pizza.mp4)

---

## 📁 Fichier vidéo

Le fichier vidéo compressé est inclus dans le projet :

```
/demo_pizza.mp4
```

---





