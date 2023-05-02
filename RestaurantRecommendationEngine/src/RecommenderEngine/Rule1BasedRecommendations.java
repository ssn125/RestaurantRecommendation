package RecommenderEngine;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import Model.CostTracking;
import Model.Cuisine;
import Model.CuisineTracking;
import Model.Restaurant;
import Model.User;

/*
 * Featured restaurants of primary cuisine and primary cost bracket.
 * If none, then all featured restaurants of primary cuisine, secondary cost and secondary cuisine, primary cost
 * */

public class Rule1BasedRecommendations extends RulesBasedRecommendations {
	
public Rule1BasedRecommendations(RulesBasedRecommendations nextRuleBasedRecommendation) {
	super(nextRuleBasedRecommendation);
}


public void getRestaurantRecommendations(User user, Restaurant[] availableRestaurants) {
	
	
	List<Restaurant> restaurants = new LinkedList<Restaurant>(Arrays.asList(availableRestaurants));
	

	//Featured restaurants of primary cuisine and primary cost bracket.
	for(int i=0;i<restaurants.size();i++) {
		
		//Restaurant data
		Restaurant restaurant = restaurants.get(i);
		Cuisine cuisine = restaurant.getCuisine();
		int costBracket = restaurant.getCostBracket();
		
		//User data
		CuisineTracking[] cuisineTracking = user.getCuisines();
		CostTracking[] costTracking = user.getCostBracket();
		
		
		if(restaurant.isRecommended()) {
			if(cuisine == cuisineTracking[0].getType() && costBracket == costTracking[0].getType()) {
				addRecommendations(restaurant.getRestaurantId());
				restaurants.remove(i--);
			}
		}
	}
	
	//If recommendations are empty, then all featured restaurants of primary cuisine, secondary cost and secondary cuisine, primary cost

	
	if(restaurants.size() == availableRestaurants.length) {
		for(int i=0;i<restaurants.size();i++) {
			
			//Restaurant data
			Restaurant restaurant = restaurants.get(i);
			Cuisine cuisine = restaurant.getCuisine();
			int costBracket = restaurant.getCostBracket();
			
			//User data
			CuisineTracking[] cuisineTracking = user.getCuisines();
			CostTracking[] costTracking = user.getCostBracket();
			
			if(restaurant.isRecommended()) {
				if((cuisine == cuisineTracking[0].getType() && costBracket == costTracking[1].getType()) || (cuisine == cuisineTracking[1].getType() && costBracket == costTracking[0].getType()) ) {
					addRecommendations(restaurant.getRestaurantId());
					restaurants.remove(i--);
				}
			}
			
		}
	}
		

	super.getRestaurantRecommendations(user, (Restaurant[]) restaurants.toArray(new Restaurant[restaurants.size()]));
}
	
}