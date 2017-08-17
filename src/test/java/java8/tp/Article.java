package java8.tp;

public class Article {
	private String reference;
	private String type;
	private double price;
	private boolean outOfStock;
	
	/**
	 * @param reference
	 * @param type
	 * @param price
	 * @param outOfStock
	 */
	public Article(String reference, String type, double price, boolean outOfStock) {
		super();
		this.reference = reference;
		this.type = type;
		this.price = price;
		this.outOfStock = outOfStock;
	}
	
	public String getReference() {
		return reference;
	}
	
	public void setReference(String reference) {
		this.reference = reference;
	}
	
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	public double getPrice() {
		return price;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
	
	public boolean isOutOfStock() {
		return outOfStock;
	}
	
	public void setOutOfStock(boolean outOfStock) {
		this.outOfStock = outOfStock;
	}

	@Override
	public String toString() {
		return "Article [reference=" + reference + ", type=" + type + ", price=" + price + ", outOfStock=" + outOfStock
				+ "]";
	}	
}
