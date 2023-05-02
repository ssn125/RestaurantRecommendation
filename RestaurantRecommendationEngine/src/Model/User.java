package Model;
public class User {

	private CuisineTracking[] cuisines;
	private CostTracking[] costBracket;
	
	public User(CuisineTracking[] cuisines, CostTracking[] costBracket) {
		super();
		this.cuisines = cuisines;
		this.costBracket = costBracket;
	}

	public CuisineTracking[] getCuisines() {
		return cuisines;
	}

	public void setCuisines(CuisineTracking[] cuisines) {
		this.cuisines = cuisines;
	}

	public CostTracking[] getCostBracket() {
		return costBracket;
	}

	public void setCostBracket(CostTracking[] costBracket) {
		this.costBracket = costBracket;
	}
	
	
	
	
}
