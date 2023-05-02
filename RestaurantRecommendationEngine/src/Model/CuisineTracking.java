package Model;

public class CuisineTracking {

	private Cuisine type;
	private int noOfOrders;
	
	public CuisineTracking(Cuisine type, int noOfOrders) {
		super();
		this.type = type;
		this.noOfOrders = noOfOrders;
	}

	public Cuisine getType() {
		return type;
	}

	public void setType(Cuisine type) {
		this.type = type;
	}

	public int getNoOfOrders() {
		return noOfOrders;
	}

	public void setNoOfOrders(int noOfOrders) {
		this.noOfOrders = noOfOrders;
	}
	
	
	
	
}
