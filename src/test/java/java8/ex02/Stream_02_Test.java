package java8.ex02;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Test;

import java8.data.Data;
import java8.data.domain.Customer;
import java8.data.domain.Order;

/**
 * Exercice 02 - Transformation
 */
public class Stream_02_Test {

    @Test
    public void test_map() throws Exception {

        List<Order> orders = new Data().getOrders();
        
        // Liste des clients ayant déjà passés une commande
        List<Customer> result = orders.stream().map(order -> order.getCustomer()).distinct().collect(Collectors.toList());

        assertThat(result, hasSize(2));
    }

    @Test
    public void test_flatmap() throws Exception {

        List<Order> orders = new Data().getOrders();

        // Calculer les statistiques sur les prix des pizzas vendues, en utilisant l'opération summaryStatistics
        IntSummaryStatistics result =  orders.stream().flatMap(order -> order.getPizzas().stream()).mapToInt(pizza -> pizza.getPrice()).summaryStatistics();


        assertThat(result.getSum(), is(10900L));
        assertThat(result.getMin(), is(1000));
        assertThat(result.getMax(), is(1375));
        assertThat(result.getCount(), is(9L));
    }
}
