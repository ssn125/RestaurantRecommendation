package RecommenderEngine;

import java.util.Arrays;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import Model.Restaurant;
import Model.User;

/*
 * Top 4 newly created restaurants by rating
 * */
public class Rule5BasedRecommendations extends RulesBasedRecommendations{
	public Rule5BasedRecommendations(RulesBasedRecommendations nextRuleBasedRecommendation) {
		super(nextRuleBasedRecommendation);
	}
	
	public static long getDifferenceDays(Date d1) {
		Date d2 = new Date();
	    long diff = d2.getTime() - d1.getTime();
	    return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
	}


	public void getRestaurantRecommendations(User user, Restaurant[] availableRestaurants) {
		
		//System.out.println("Inside rule 5");
		
		List<Restaurant> restaurants = new LinkedList<Restaurant>(Arrays.asList(availableRestaurants));
		

		for(int i=0;i<restaurants.size();i++) {
			
			//Restaurant data
			Restaurant restaurant = restaurants.get(i);
			
			if(getDifferenceDays(restaurant.getOnboardedTime())<=2) {
				addRecommendations(restaurant.getRestaurantId());
				restaurants.remove(i);
			}
			
	
		}
		

		super.getRestaurantRecommendations(user, (Restaurant[]) restaurants.toArray(new Restaurant[restaurants.size()]));
	}

}
