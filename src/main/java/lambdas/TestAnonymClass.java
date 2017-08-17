package lambdas;

public class TestAnonymClass {

	public static void main(String[] args) {
//		 mapper = new Mapper () { 
//			public Double map(Account account) {
//				return account.getSolde();
//			}			
//		};
//		
//		Account acc = new Account();
//		acc.setSolde(150.0);
		
// 		Double solde = mapper.map(acc);		
		
// JAVA 7 version using the implementation from a class
		Mapper mapper = new MapperImpl();
		
// JAVA 7 version using the implementation from an anonyme class
		mapper = new Mapper () { 
			public Person map(Account account) {
				Person p = new Person(account.getSolde());
				return p;
			}			
		};
		
// JAVA 8 version
// Premiere etape : on supprime le code "administratif" de la methode 
// (on garde que la liste des params d'entree), on ajoute la fleche 
		mapper = (Account account) -> {
			return new Person(account.getSolde());
		};
		
// Seconde etape : on supprime les accolades ET le return 
// car le corps de la methode ne contient qu'une seule ligne de code
		mapper = (Account account) -> new Person(account.getSolde());
		
// Troisieme etape : on supprime le type des parametres d'entree car Java les connais deja		
		mapper = account -> new Person(account.getSolde());
		
		Account acc = new Account();
		acc.setSolde(150.0);
		
		Person person = mapper.map(acc);
		System.out.println("Person's solde = " + person.getSolde());
		
	}
}
