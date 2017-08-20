package java8.tp;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;

import java8.tp.filters.Filter;
import java8.tp.filters.FilterByStockAndPriceImpl;
import java8.tp.filters.FilterByStockImpl;

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

//		Stream<Article> stream = basket.getArticles().stream();
//		
//		double result = stream.filter(a-> a.getPrice() > 3.0)
//				  .map(a -> a.getPrice())
//				  .reduce((a,b)-> a+b)
//				  .get();	// optional = conteneur du resultat
//		
//		// Equivalent way
//		// intermediate operations => no treatement
//		stream = basket.getArticles().stream();
//		Stream<Article> articleStream = stream.filter(a-> a.getPrice() > 3.0);		
//		
//		Stream<Double> priceStream = articleStream.map(a -> a.getPrice());
//		
//		// final operation => treatement
//		result = priceStream.reduce((a,b)-> a+b).get();	// optional = conteneur du resultat
//
//		stream = basket.getArticles().stream();
//		List<Article> articlesFilters = stream.filter(a-> a.getPrice() > 3.0)
//															.collect(Collectors.toList());	
//		
//		stream = basket.getArticles().stream(); 	// error Execution si on ne reinitialise pas le stream, car l'ancien a ete deja ferme 
//		List<Article> articlesFilters2 = stream.filter(a-> a.getPrice() < 3.0)
//											 	.collect(Collectors.toList());	
		
		return basket;
	}

	// Imperative implementations
	@Test
	public void test_filter_inStock() throws Exception {
		System.out.println("Impérative way - Articles in stock : ");

		filteredList = getBasket().filterArticlesByStock();
		assert filteredList.size() == 6;
	}

	@Test
	public void test_filter_inStockAndPrice() throws Exception {
		System.out.println("\nImpérative way - Articles in stock, less then maxPrice : ");

		filteredList = getBasket().filterArticlesByStockAndPrice(true, 3.0);
		assert filteredList.size() == 4;
	}

	@Test
	public void test_filter_outOfStockAndPrice() throws Exception {
		System.out.println("\nImpérative way - Articles out of stock, less then maxPrice : ");

		filteredList = getBasket().filterArticlesByStockAndPrice(false, 3.0);
		assert filteredList.size() == 1;
	}

	// Filter implementations
	@Test
	public void test_filter_filterInStock() throws Exception {
		System.out.println("\nFilter way - Articles in stock : ");

		filteredList = getBasket().filter(new FilterByStockImpl());
		assert filteredList.size() == 6;
	}

	@Test
	public void test_filter_filterInStockAndPrice() throws Exception {
		System.out.println("\nFilter way - Articles in stock, less then maxPrice : ");

		filteredList = getBasket().filter(new FilterByStockAndPriceImpl());
		assert filteredList.size() == 1;
	}

	// Anonymous implementations
	@Test
	public void test_filter_anonymeFilterInStock() throws Exception {
		System.out.println("\nAnonymous way - Articles in stock : ");

		filteredList = getBasket().filter(new Filter() {
			@Override
			public boolean accept(Article article) {
				return !article.isOutOfStock();
			}
		});
		assert filteredList.size() == 6;
	}

	@Test
	public void test_filter_anonymeFilterInStockAndPrice() throws Exception {
		System.out.println("\nAnonymous way - Articles in stock, less then maxPrice : ");

		filteredList = getBasket().filter(new Filter() {
			@Override
			public boolean accept(Article article) {
				return (!article.isOutOfStock() && (article.getPrice() < 2.0));
			}
		});
		assert filteredList.size() == 1;
	}

	// Using Lambda expressions
	@Test
	public void test_filter_lambdaFilterInStock() throws Exception {
		System.out.println("\nLambda way - Articles in stock : ");

		filteredList = getBasket().filter(article -> !article.isOutOfStock());
		assert filteredList.size() == 6;
	}

	@Test
	public void test_filter_lambdaFilterInStockAndPrice() throws Exception {
		System.out.println("\nLambda way - Articles in stock, less then maxPrice : ");

		filteredList = getBasket().filter(article -> (!article.isOutOfStock() && (article.getPrice() < 2.0)));
		assert filteredList.size() == 1;
	}
}
