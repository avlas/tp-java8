package java8.ex04;


import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.junit.Test;

import java8.data.Account;
import java8.data.Data;
import java8.data.Person;

/**
 * Exercice 04 - FuncCollection
 * Exercice synthèse des exercices précédents
 */
public class Lambda_04_Test {

    interface GenericPredicate<T> {
    	boolean test(T t);
    }

    interface GenericMapper<T, E> {
    	E map(T t);
    }

    interface Processor<T> {
    	void process(T t);
    }

    class FuncCollection<T> {

        private Collection<T> list = new ArrayList<>();
        public void add(T a) {
            list.add(a);
        }
        public void addAll(Collection<T> all) {
            for(T el:all) {
                list.add(el);
            }
        }

        private FuncCollection<T> filter(GenericPredicate<T> predicate) {
            FuncCollection<T> result = new FuncCollection<>();            
    		for (T t : this.list) {
    			if (predicate.test(t) == true) {
    				result.list.add(t);
    			}
    		}
            return result;
        }

        private <E> FuncCollection<E> map(GenericMapper<T, E> mapper) {
            FuncCollection<E> result = new FuncCollection<>();            
    		for (T t : this.list) {
    			result.add(mapper.map(t));
    		}    		
            return result;
        }

        private void forEach(Processor<T> processor) {
       		for (T t : this.list) {
       			processor.process(t);
    		}
        }
    }

    @Test
    public void test_filter_map_forEach_with_vars() throws Exception {

        List<Person> personList = Data.buildPersonList(100);
        FuncCollection<Person> personFuncCollection = new FuncCollection<>();
        personFuncCollection.addAll(personList);

        // Liste des personnes ayant un age > 50
        GenericPredicate<Person> filterByAge = new GenericPredicate<Person>() {
			public boolean test(Person person) {
				return (person.getAge() >= 50) ? true : false;
			}
		};

		GenericMapper<Person, Account> mapToAccount = new GenericMapper<Person, Account>() {
			public Account map(Person person) {
				return new Account(person, new Integer(1000));
			}
		};
		
		// Verification ( via une assertion (mot clé assert) ) = chaque compte a un solde à 1000 &&  chaque titulaire de compte a un age > 50
        Processor<Account> verifyAccount = account -> assertTrue(account.getBalance().equals(1000) && account.getOwner().getAge() >= 50);

        personFuncCollection
                .filter(filterByAge)
                .map(mapToAccount)
                .forEach(verifyAccount);
    }
    
    @Test
    public void test_filter_map_forEach() throws Exception {

        List<Person> personList = Data.buildPersonList(100);        
        FuncCollection<Person> personFuncCollection = new FuncCollection<>();
        personFuncCollection.addAll(personList);
		
        personFuncCollection
                // Liste des personnes ayant un age > 50
                .filter(person -> (person.getAge() >= 50) ? true : false)
                // Transforme liste de personnes en liste de accounts 
                // Un account a par défaut un solde à 1000.
                .map(person -> new Account(person, new Integer(1000)))
        		// Verification ( via une assertion (mot clé assert) ) = chaque compte a un solde à 1000 &&  chaque titulaire de compte a un age > 50
                .forEach(account -> assertTrue(account.getBalance().equals(1000) && account.getOwner().getAge() >= 50));
    }
}
