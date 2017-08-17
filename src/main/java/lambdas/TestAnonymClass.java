package lambdas;

public class TestAnonymClass {

	public static void main(String[] args) {
//		Mapper mapper = new Mapper () { 
//			public Double map(Account account) {
//				return account.getSolde();
//			}			
//		};
//		
//		Account acc = new Account();
//		acc.setSolde(150.0);
//		
//		Double solde = mapper.map(acc);

		Mapper mapper = (Account account) -> {
				return new Person(account.getSolde());
			} 			
		;
		
		Account acc = new Account();
		acc.setSolde(150.0);
		
		Person person = mapper.map(acc);
		System.out.println("Person's solde = " + person.getSolde());
		
	}
}
