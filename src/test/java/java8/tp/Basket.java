package java8.tp;

import java.util.ArrayList;
import java.util.List;

import java8.tp.filters.Filter;

public class Basket {
	List<Article> filteredArticles = new ArrayList<>();
	private List<Article> articles;

	public Basket() {
		articles = new ArrayList<>();
	}

	// Impérative implementations
	// Filtre les articles et retourne uniquement les articles du basket qui sont en stock (outOfStock=false)
	public List<Article> filterArticlesByStock() {
		for (Article article : articles) {
			if (!article.isOutOfStock()) {
				filteredArticles.add(article);
				System.out.println(article.toString());
			}
		}
		return filteredArticles;
	}

	// Générique
	// Filtre les articles en fonction de paramètre isInStock=O/N et un prix maximum 
	// et qui retourne la liste des articles du basket qui correspondent aux critères (cf. exemple 1)
	public List<Article> filterArticlesByStockAndPrice(boolean isInStock, double maxPrice) {
		for (Article article : articles) {
			if (isInStock != article.isOutOfStock() && article.getPrice() < maxPrice) {
				filteredArticles.add(article);
				System.out.println(article.toString());
			}
		}
		return filteredArticles;
	}

	// Filter implementations
	public List<Article> filter(Filter filter) {
		for (Article article : articles) {
			if (filter.accept(article)) {
				filteredArticles.add(article);
				System.out.println(article.toString());
			}
		}
		return filteredArticles;
	}

	public List<Article> getArticles() {
		return articles;
	}

	public void setArticles(List<Article> articles) {
		this.articles = articles;
	}
}
