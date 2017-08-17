package java8.ex02;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import java8.data.Account;
import java8.data.Data;
import java8.data.Person;

/**
 * Exercice 02 - Map
 */
public class Lambda_02_Test {
	// tag::PersonToAccountMapper[]
	interface PersonToAccountMapper {
		Account map(Person p);
	}
	// end::PersonToAccountMapper[]

	// tag::map[]
	private List<Account> map(List<Person> personList, PersonToAccountMapper mapper) {
		// TODO implémenter la méthode pour transformer une liste de personnes
		// en liste de comptes
		List<Account> accounts = new ArrayList<>();
		for (Person person : personList) {
			accounts.add(mapper.map(person));
		}

		return accounts;
	}
	// end::map[]

	// tag::test_map_person_to_account[]
	@Test
	public void test_map_person_to_account() throws Exception {

		List<Person> personList = Data.buildPersonList(100);

		// TODO transformer la liste de personnes en liste de comptes
		// TODO tous les objets comptes ont un solde à 100 par défaut
		List<Account> result = map(personList, new PersonToAccountMapper() {
			public Account map(Person person) {
				Account account = null;
				if (person != null) {
					account = new Account();
					account.setOwner(person);
					account.setBalance(new Integer(100));
				}
				return account;
			}
		});

		assert result.size() == personList.size();
		for (Account account : result) {
			assert account.getBalance().equals(100);
			assert account.getOwner() != null;
		}
	}
	// end::test_map_person_to_account[]

	// tag::test_map_person_to_firstname[]
	@Test
	public void test_map_person_to_firstname() throws Exception {

		List<Person> personList = Data.buildPersonList(100);

		// TODO transformer la liste de personnes en liste de prénoms
		List<String> result = new ArrayList<>();
		for (Person person : personList) {
			result.add(person.getFirstname());
		}

		assert result.size() == personList.size();
		for (String firstname : result) {
			assert firstname.startsWith("first");
		}
	}
	// end::test_map_person_to_firstname[]
}
