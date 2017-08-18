package java8.ex03;

import static java.util.stream.Collectors.partitioningBy;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.junit.Test;

import java8.data.Data;
import java8.data.domain.Customer;
import java8.data.domain.Gender;
import java8.data.domain.Order;
import java8.data.domain.Pizza;

/**
 * Exercice 03 - Collectors
 */
public class Stream_03_Test {

    @Test
    public void test_joining() throws Exception {

        List<Customer> customers = new Data().getCustomers();

        // Construire une chaîne contenant les prénoms des clients triés et séparé par le caractère "|"
        String result = customers.stream().map(Customer :: getFirstname).sorted().collect(Collectors.joining("|"));  

        assertThat(result, is("Alexandra|Cyril|Johnny|Marion|Sophie"));
    }

    @Test
    public void test_grouping() throws Exception {

        List<Order> orders = new Data().getOrders();

        // Construire une Map <Customer, Order> effectuées par le client
        Map<Customer, List<Order>> result = orders.stream().collect(Collectors.groupingBy(Order::getCustomer, Collectors.toList()));			

        assertThat(result.size(), is(2));
        assertThat(result.get(new Customer(1)), hasSize(4));
        assertThat(result.get(new Customer(2)), hasSize(4));
    }

    @Test
    public void test_partitionning() throws Exception {
        List<Pizza> pizzas = new Data().getPizzas();

        // Séparer la liste des pizzas en 2 ensembles : 
        // true -> les pizzas dont le nom commence par "L"
        // false -> les autres
        Map<Boolean, List<Pizza>> result = pizzas.stream().collect(partitioningBy(pizza -> pizza.getName().startsWith("L")));

        assertThat(result.get(true), hasSize(6));
        assertThat(result.get(false), hasSize(2));
    }

    @Test
    public void test_mapping() throws Exception {

        List<Customer> customers = new Data().getCustomers();

        // Construire la map Sexe -> Chaîne représentant les prénoms des clients
  //      Map<Gender, String> result = customers.stream().collect(Collectors.toMap(Customer::getGender, Customer::getFirstname, ));

        Map<Gender, String> result = null;
        
        assertThat(result.get(Gender.F), is("Alexandra|Marion|Sophie"));
        assertThat(result.get(Gender.M), is("Cyril|Johnny"));
    }
}
