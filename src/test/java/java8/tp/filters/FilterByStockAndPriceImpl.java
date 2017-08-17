package java8.tp.filters;

import java8.tp.Article;

/**
 * Classe qui implémente l’interface Filter. 
 * La méthode de cette classe retourne true uniquement si l’article est en stock et si son prix n’excède pas un montant (en dur pour l’instant).
 */
public class FilterByStockAndPriceImpl implements Filter {
	private double maxPrice = 2.0;

	@Override
	public boolean accept(Article article) {
		return (!article.isOutOfStock() && (article.getPrice() < maxPrice));
	}

}
