package RecommenderEngine;
import Model.Restaurant;
import Model.User;
import java.util.ArrayList;

/*
 * This is an adapter class between, controller and RuleBasedRecommendations class.
 * */

public class RestaurantRecommendations {
	

	public String[] getRestaurantRecommendations(User user, Restaurant[] availableRestaurants) {
		
		RulesBasedRecommendations rulesBasedRecommendations = new Rule1BasedRecommendations(new Rule2BasedRecommendations(new Rule3BasedRecommendations(new Rule4BasedRecommendations(new Rule5BasedRecommendations(new Rule6BasedRecommendations(new Rule7BasedRecommendations(new Rule8BasedRecommendations(new Rule9BasedRecommendations(null)))))))));
		rulesBasedRecommendations.getRestaurantRecommendations(user, availableRestaurants);
		String[] recommendations = rulesBasedRecommendations.getRecommendations();
		
		return recommendations;
		
		
	}
	
}
