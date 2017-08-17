package java8.tp;

import java.util.List;

import org.junit.Test;

public class BasketTest {

	List<Article> filteredList;

	public static Basket getBasket() {
		Basket basket = new Basket();

		basket.getArticles().add(new Article("Coca-Cola", "Boisson", 2.5, false));
		basket.getArticles().add(new Article("Orangina", "Boisson", 2.5, false));
		basket.getArticles().add(new Article("Bière sans alcool", "Boisson", 4.2, true));
		basket.getArticles().add(new Article("Spaghetti", "Pates", 1.8, false));
		basket.getArticles().add(new Article("Lasagnes", "Pates", 3.1, true));
		basket.getArticles().add(new Article("Ramen", "Pates", 3.5, false));
		basket.getArticles().add(new Article("Beurre salé", "Produits laitiers", 1.8, true));
		basket.getArticles().add(new Article("Camembert", "Produits laitiers", 2.8, false));
		basket.getArticles().add(new Article("Yaourth", "Produits laitiers", 3.1, false));

		return basket;
	}
	
	// Modifier la méthode de la classe Basket précédente afin qu'elle prenne
	// en paramètre un filtre. Exemple ci-dessous :
	// articles = basket.filter(new FilterStock());
	// // Appeler cette même méthode panier.filtrer avec une classe anonyme qui
	// fait la même chose qu’une des 2 classes précédemment créées.
	// articles = ...;
	// // Appeler la méthode filtrer avec une expression lambda
	// articles = ...;

	// En méthode impérative:
	// a- méthode dans la classe Basket, qui filtre les articles et retourne uniquement les articles du basket qui sont en stock (outOfStock=false)
	@Test
	public void test_filter_inStock() throws Exception {
		filteredList = getBasket().filterArticlesByStock();
		assert filteredList.size() == 6;
	}

	// b- Méthode dans la classe Basket un peu plus générique, 
	// qui prend en paramètre stock=O/N et un prix maximum 
	// et qui retourne la liste des articles du panier qui correspondent aux critères (cf. exemple 1)

	// c- vérifier que la méthode fonctionne en testant divers cas de figures.
	// Exemple (1) de ce qu’il faut obtenir
	@Test
	public void test_filter_outOfStockAndPrice() throws Exception {
		System.out.println("\n Articles out of stock, less then maxPrice : ");
		
		filteredList = getBasket().filterArticlesByStockAndPrice(false, 3.0);
		assert filteredList.size() == 1;
	}

	@Test
	public void test_filter_inStockAndPrice() throws Exception {
		System.out.println("\n Articles in stock, less then maxPrice : ");
		
		filteredList = getBasket().filterArticlesByStockAndPrice(true, 2.6);
		assert filteredList.size() == 3;
	}

}
