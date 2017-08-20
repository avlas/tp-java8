package java8.ex02;

import java.util.List;

import org.junit.Test;

import java8.data.Data;
import java8.data.Person;

/**
 * Exercice 02 - Redéfinition
 */
public class Method_02_Test {

    interface IDao {
        List<Person> findAll();

        // Methode qui retourne une chaîne de la forme [<nb_personnes> persons]
        // Exemple : "[14 persons]", "[30 persons]"
		default String format() {			
			return "[" + findAll().size() + " persons]";        
		}
    }

    class DaoA implements IDao {

        List<Person> people = Data.buildPersonList(20);

        @Override
        public List<Person> findAll() {
            return people;
        }

        // Redefinir pour que la methode retourne une chaîne de la forme DaoA[<nb_personnes> persons]
        // Exemple : "DaoA[14 persons]", "DaoA[30 persons]"
        // L'implementation reutilise la méthode format() de l'interface
		public String format() {
			return "DaoA" + IDao.super.format();      
		}
    }

    @Test
    public void test_daoA_format() throws Exception {
        DaoA daoA = new DaoA();

        String result = daoA.format();

        assert "DaoA[20 persons]".equals(result);
    }
}
