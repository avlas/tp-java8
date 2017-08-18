package java8.ex01;

import static org.hamcrest.Matchers.anyOf;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.everyItem;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.junit.Test;

import java8.data.Data;
import java8.data.domain.Order;
import java8.data.domain.Pizza;

/**
 * Exercice 01 - Recherche
 */
public class Stream_01_Test {

	@Test
	public void test_stream_filter() throws Exception {
		List<Pizza> pizzas = new Data().getPizzas();

		// Liste des pizzas dont le prix est >= 1300
		List<Pizza> result = pizzas.stream().filter(pizza -> pizza.getPrice() >= 1300).collect(Collectors.toList());

		assertThat(result, hasSize(3));
		assertThat(result, everyItem(hasProperty("price", anyOf(equalTo(1300), greaterThan(1300)))));
	}

	@Test
	public void test_stream_anyMatch() throws Exception {
		List<Pizza> pizzas = new Data().getPizzas();

		// Validation - au moins une pizza à un prix >= 1300
		// Predicate<Pizza> predicate = new Predicate<Pizza>() {
		// public boolean test(Pizza pizza) {
		// return (pizza.getPrice() >= 1300) ? true : false;
		// }
		// };
		// Boolean result1 = pizzas.stream().anyMatch(predicate);

		Boolean result1 = pizzas.stream().anyMatch(pizza -> (pizza.getPrice() >= 1300) ? true : false);

		// Validation - au moins une pizza à un prix >= 2000
		Boolean result2 = pizzas.stream().anyMatch(pizza -> (pizza.getPrice() >= 2000) ? true : false);

		assertThat(result1, is(true));
		assertThat(result2, is(false));
	}

	@Test
	public void test_stream_allMatch() throws Exception {

		List<Pizza> pizzas = new Data().getPizzas();

		// Validation - toutes les pizzas ont un prix >= 1300
		Boolean result1 = pizzas.stream().allMatch(pizza -> (pizza.getPrice() >= 1300) ? true : false);

		// Validation - toutes les pizzas ont un prix >= 900
		Boolean result2 = pizzas.stream().allMatch(pizza -> (pizza.getPrice() >= 900) ? true : false);

		assertThat(result1, is(false));
		assertThat(result2, is(true));
	}

	@Test
	public void test_stream_noneMatch() throws Exception {

		List<Pizza> pizzas = new Data().getPizzas();

		// Validation - aucune pizza n'a un prix >= 2000
		Boolean result1 = pizzas.stream().noneMatch(pizza -> (pizza.getPrice() >= 2000) ? true : false);
		;

		assertThat(result1, is(true));
	}

	@Test
	public void test_stream_filter_and_match() throws Exception {

		List<Order> orders = new Data().getOrders();

		// Liste de toutes les commandes dont le prénom du client est "Johnny"
		// dont au moins une pizza a un prix >= 1300
		List<Order> result = orders.stream()
				.filter(order -> order.getCustomer().getFirstname().equalsIgnoreCase("Johnny"))
				.filter(order -> order.getPizzas().stream().filter(pizza -> pizza.getPrice() >= 1300).count() >= 1)
				.collect(Collectors.toList());

		assertThat(result, hasSize(1));
		assertThat(result.get(0), hasProperty("id", is(8)));
	}

	@Test
	public void test_stream_findFirst() throws Exception {
		List<Order> orders = new Data().getOrders();

		// Commande faite par un client dont le prénom est "Sophie"
		Optional<Order> result = orders.stream()
				.filter(order -> order.getCustomer().getFirstname().equalsIgnoreCase("Sophie")).findFirst();

		assertThat(result.isPresent(), is(false));
	}

	@Test
	public void test_stream_max() throws Exception {
		List<Pizza> pizzas = new Data().getPizzas();

		// Pizza la plus chère
		Optional<Pizza> result = pizzas.stream().max((Pizza p1, Pizza p2) -> p1.getPrice().compareTo(p2.getPrice()));

		assertThat(result.isPresent(), is(true));
		assertThat(result.get(), hasProperty("id", is(5)));
		assertThat(result.get(), hasProperty("name", is("La Cannibale")));
		assertThat(result.get(), hasProperty("price", is(1550)));
	}

	@Test
	public void test_stream_min() throws Exception {
		List<Pizza> pizzas = new Data().getPizzas();

		// Pizza la moins chère dont le prix est >= 950
		Optional<Pizza> result = pizzas.stream().filter( pizza -> pizza.getPrice() >= 950 )
				.min( (Pizza p1, Pizza p2) -> p1.getPrice().compareTo(p2.getPrice()) );

		assertThat(result.isPresent(), is(true));
		assertThat(result.get(), hasProperty("id", is(3)));
		assertThat(result.get(), hasProperty("name", is("La Reine")));
		assertThat(result.get(), hasProperty("price", is(1000)));
	}
}
