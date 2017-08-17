package java8.tp.filters;

import java8.tp.Article;

/**
 * Classe qui implémente l’interface Filter. La méthode de cette classe retourne
 * true uniquement si l’article est en stock.
 */
public class FilterByStockImpl implements Filter {
	@Override
	public boolean accept(Article article) {
		return !article.isOutOfStock();
	}

}
