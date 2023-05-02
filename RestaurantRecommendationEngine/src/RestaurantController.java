import java.util.ArrayList;

import Model.Restaurant;
import Model.User;
import RecommenderEngine.RestaurantRecommendations;
import View.ConsoleView;


public class RestaurantController {
	
	ConsoleView view;
	ArrayList<Restaurant> restaurants;
	ArrayList<User> users;
	RestaurantRecommendations recommendations;
	
	public RestaurantController(ConsoleView view, ArrayList<Restaurant> restaurants, ArrayList<User> users) {
		super();
		this.view = view;
		this.restaurants = restaurants;
		this.users = users;
	} 
	
	
	public void printRecommendedRestaurantsOnScreen(int userIndex) {
		recommendations = new RestaurantRecommendations();
		Restaurant[] restaurantsInArray = new Restaurant[restaurants.size()];
		restaurantsInArray = (Restaurant[]) restaurants.toArray(restaurantsInArray);
		view.printRecommendations(recommendations.getRestaurantRecommendations(users.get(userIndex), restaurantsInArray));
	}
	
	

}
