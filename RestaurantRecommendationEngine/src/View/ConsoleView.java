package View;

public class ConsoleView {
	
	public void printRecommendations(String[] recommendations) {
		
		try {
			for(String recommendation: recommendations) {
				System.out.println(recommendation);
			}
		}catch(NullPointerException e) {
			System.out.println("Sorry we don't have any recommendations for you as of now");
			// We should be having some default list in this case to show
		}
		
	}

}
