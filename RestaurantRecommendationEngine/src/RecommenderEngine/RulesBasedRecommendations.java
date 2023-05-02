package RecommenderEngine;
import java.util.ArrayList;

import Model.Restaurant;
import Model.User;

/*
 * Here we are using chain of responsibility pattern to get recommendations.
 * */

public abstract class RulesBasedRecommendations {
	
	static ArrayList<String> recommendations;
	
	RulesBasedRecommendations nextRuleBasedRecommendation;
	
	RulesBasedRecommendations(RulesBasedRecommendations nextRuleBasedRecommendation) {
		this.nextRuleBasedRecommendation = nextRuleBasedRecommendation;
	}
	
	public void getRestaurantRecommendations(User user, Restaurant[] availableRestaurants) {

		
		if(nextRuleBasedRecommendation!=null) {
			nextRuleBasedRecommendation.getRestaurantRecommendations(user,availableRestaurants);
		}
		
	}

	public void addRecommendations(String recommendation) {
		if(recommendations==null)
			recommendations=new ArrayList<String>();
		
		recommendations.add(recommendation);
	}
	
	public String[] getRecommendations() {
		String[] out = (String[]) recommendations.toArray(new String[recommendations.size()]);
		if(recommendations.size()>100)
		out = (String[]) (recommendations.subList(0, 100)).toArray();
		return out;
	}
}
