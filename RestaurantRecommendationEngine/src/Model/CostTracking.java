package Model;

public class CostTracking {
	
	private int type;
	private int noOfOrders;
	
	
	
	public CostTracking(int type, int noOfOrders) {
		super();
		this.type = type;
		this.noOfOrders = noOfOrders;
	}
	
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public int getNoOfOrders() {
		return noOfOrders;
	}
	public void setNoOfOrders(int noOfOrders) {
		this.noOfOrders = noOfOrders;
	}

}
