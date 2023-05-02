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
 * All restaurants of secondary cuisine, primary cost bracket with rating < 4.5
 * */

public class Rule8BasedRecommendations extends RulesBasedRecommendations{
	public Rule8BasedRecommendations(RulesBasedRecommendations nextRuleBasedRecommendation) {
		super(nextRuleBasedRecommendation);
	}


	public void getRestaurantRecommendations(User user, Restaurant[] availableRestaurants) {
		
		
		List<Restaurant> restaurants = new LinkedList<Restaurant>(Arrays.asList(availableRestaurants));
		
		for(int i=0;i<restaurants.size();i++) {
			
			//Restaurant data
			Restaurant restaurant = restaurants.get(i);
			Cuisine cuisine = restaurant.getCuisine();
			int costBracket = restaurant.getCostBracket();
			
			//User data
			CuisineTracking[] cuisineTracking = user.getCuisines();
			CostTracking[] costTracking = user.getCostBracket();
			
			if(restaurant.getRating()<4.5) {
				if((cuisine == cuisineTracking[1].getType() && costBracket == costTracking[1].getType()) ) {
					addRecommendations(restaurant.getRestaurantId());
					restaurants.remove(i--);
				}
			}
			
		}
		

		super.getRestaurantRecommendations(user, (Restaurant[]) restaurants.toArray(new Restaurant[restaurants.size()]));
	}

}
