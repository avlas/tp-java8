package java8.tp;

import java.util.ArrayList;
import java.util.List;

public class Basket {
	List<Article> filteredList = new ArrayList<>();
	
	private List<Article> articles;

	public Basket() {
		articles = new ArrayList<>();
	}

	public List<Article> filterArticlesByStock() {
		System.out.println("Articles in stock : ");

		for(Article art : articles) {
			if(!art.isOutOfStock()) {
				filteredList.add(art);				
				System.out.println(art.toString());
			}
		}
		
		return filteredList;
	}
	
	public List<Article> filterArticlesByStockAndPrice(boolean isInStock, double maxPrice) {
		for(Article art : articles) {
			if(isInStock != art.isOutOfStock() && art.getPrice() < maxPrice) {
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

	@Override
	public String toString() {
		return "Basket [articles=" + articles + "]";
	}	
}
