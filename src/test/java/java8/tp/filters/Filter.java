package java8.tp.filters;

import java8.tp.Article;

/** Ecrire maintenant une interface Filter qui a une seule méthode : 
 * boolean accept(Article article) 
 * Ajouter une annotation à cette interface de manière à ce qu’elle ne puisse avoir qu’une seule méthode
*/
@FunctionalInterface
public interface Filter {
	
	boolean accept(Article article);
	
}
