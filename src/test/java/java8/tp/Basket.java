package java8.tp;

import java.util.ArrayList;
import java.util.List;

import java8.tp.filters.Filter;

public class Basket {
	List<Article> filteredList = new ArrayList<>();

	private List<Article> articles;

	public Basket() {
		articles = new ArrayList<>();
	}

	// Impérative implementations

	// Filtre les articles et retourne uniquement les articles du basket qui
	// sont en stock (outOfStock=false)
	public List<Article> filterArticlesByStock() {
		for (Article art : articles) {
			if (!art.isOutOfStock()) {
				filteredList.add(art);
				System.out.println(art.toString());
			}
		}

		return filteredList;
	}

	// Générique
	// Filtre les articles en fonction de paramètre isInStock=O/N et un prix
	// maximum et qui retourne la liste des articles du basket qui correspondent
	// aux critères (cf. exemple 1)
	public List<Article> filterArticlesByStockAndPrice(boolean isInStock, double maxPrice) {
		for (Article art : articles) {
			if (isInStock != art.isOutOfStock() && art.getPrice() < maxPrice) {
				filteredList.add(art);
				System.out.println(art.toString());
			}
		}

		return filteredList;
	}

	// Filter implementations
	public List<Article> filter(Filter filter) {
		for (Article art : articles) {
			if (filter.accept(art)) {
				filteredList.add(art);
				System.out.println(art.toString());
			}
		}
		return filteredList;
	}

	public List<Article> getArticles() {
		return articles;
	}

	public void setArticles(List<Article> articles) {
		this.articles = articles;
	}
}
