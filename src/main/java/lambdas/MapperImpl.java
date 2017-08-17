package lambdas;

public class MapperImpl implements Mapper {

	@Override
	public Person map(Account account) {
		return new Person(account.getSolde());
	}

}
