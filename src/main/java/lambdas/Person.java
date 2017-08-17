package lambdas;

public class Person {
	
	private String name;	
	private double solde;
	
	/**
	 * @param name
	 * @param solde
	 */
	public Person(double solde) {
		this.solde = solde;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getSolde() {
		return solde;
	}

	public void setSolde(double solde) {
		this.solde = solde;
	}	
}
