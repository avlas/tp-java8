package java8.ex01;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.codec.digest.DigestUtils;
import org.junit.Test;

import java8.data.Data;
import java8.data.Person;

/**
 * Exercice 01 - Filter
 */
public class Lambda_01_Test {
	List<Person> filteredList = new ArrayList<>();

	interface PersonPredicate {
		boolean test(Person p);
	}

	private List<Person> filter(List<Person> persons, PersonPredicate predicate) {
		// Imperative 
		// newListe base sur "persons", qui contient que les pesonnes qui passe le test suivant :
		// predicate.test(person) == true;

		for (Person person : persons) {
			if (predicate.test(person) == true) {
				filteredList.add(person);
				System.out.println(person.toString());
			}
		}
		return filteredList;
	}

	@Test
	public void test_filter_by_age() throws Exception {
		List<Person> personList = Data.buildPersonList(100);

		// result = personnes adultes (age >= 18)
		List<Person> result = filter(personList, person -> (person.getAge() >= 18 ? true : false));

		assert result.size() == 83;
		for (Person person : result) {
			assert person.getAge() > 17;
		}
	}

	@Test
	public void test_filter_by_firstname() throws Exception {
		List<Person> personList = Data.buildPersonList(100);

		// result = personnes dont le prénom est "first_10"
		List<Person> result = filter(personList, person -> (person.getFirstname().equals("first_10") ? true : false));

		assert result.size() == 1;
		assert result.get(0).getFirstname().equals("first_10");

	}

	@Test
	public void test_filter_by_password() throws Exception {
		List<Person> personList = Data.buildPersonList(100);

		String passwordSha512Hex = "ee26b0dd4af7e749aa1a8ee3c10ae9923f618980772e473f8819a5d4940e0db27ac185f8a0e1d5f84f88bc887fd67b143732c304cc5fa9ad8e6f57f50028a8ff";

		// result = personnes dont l'age est > 49 && hash du mot de passe correspond à la valeur de la variable passwordSha512Hex
		// Pour obtenir le hash d'un mot, utiliser la méthode DigestUtils.sha512Hex(mot)
		List<Person> result = filter(personList,
				person -> (person.getAge() > 49 && DigestUtils.sha512Hex(person.getPassword()).equals(passwordSha512Hex) ? true : false));

		assert result.size() == 6;
		for (Person person : result) {
			assert person.getPassword().equals("test");
		}
	}
}
