package RecommenderEngine;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import Model.CostTracking;
import Model.Cuisine;
import Model.CuisineTracking;
import Model.Restaurant;
import Model.User;

/*
 * All restaurants of any cuisine, any cost bracket
 * */

public class Rule9BasedRecommendations extends RulesBasedRecommendations{
	public Rule9BasedRecommendations(RulesBasedRecommendations nextRuleBasedRecommendation) {
		super(nextRuleBasedRecommendation);
	}


	public void getRestaurantRecommendations(User user, Restaurant[] availableRestaurants) {
		
		
		List<Restaurant> restaurants = new LinkedList<Restaurant>(Arrays.asList(availableRestaurants));
		
		for(int i=0;i<restaurants.size();i++) {
					Restaurant restaurant = restaurants.get(i);
					addRecommendations(restaurant.getRestaurantId());
					restaurants.remove(i--);
				
			}
			
		

		super.getRestaurantRecommendations(user, (Restaurant[]) restaurants.toArray(new Restaurant[restaurants.size()]));
	}

}
