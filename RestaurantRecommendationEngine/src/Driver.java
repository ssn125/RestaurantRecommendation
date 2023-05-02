import Model.Restaurant;
import Model.User;
import View.ConsoleView;
import Model.CostTracking;
import Model.Cuisine;
import Model.CuisineTracking;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

/*
 * This is a driver class which has the main method. It's responsibility is to get the data from whatever source we want.
 * Here instead of using some data souce like sql, I am manually inserting data using various populate methods. 
 * */

public class Driver {
	
	public static void main(String[] args) {
		
		ArrayList<Restaurant> restaurants = populateRestaurants();
		ArrayList<User> users = populateUsers();
		ConsoleView view = new ConsoleView();
		RestaurantController controller = new RestaurantController(view,restaurants,users);
		controller.printRecommendedRestaurantsOnScreen(2);
		
		
	}
	
	public static ArrayList<Restaurant> populateRestaurants() {
		
		ArrayList<Restaurant> reastaurants  = new ArrayList<Restaurant>();
		
		reastaurants.add(new Restaurant("1",Cuisine.SouthIndian,2,2,true,getDate(1)));
		reastaurants.add(new Restaurant("2",Cuisine.NorthIndian,1,1,false,getDate(5)));
		reastaurants.add(new Restaurant("3",Cuisine.SouthIndian,4,0,true,getDate(1)));
		reastaurants.add(new Restaurant("4",Cuisine.Chinese,5,2,true,getDate(6)));
		reastaurants.add(new Restaurant("5",Cuisine.SouthIndian,1,3,true,getDate(1)));
		reastaurants.add(new Restaurant("6",Cuisine.Chinese,2,4,false,getDate(17)));
		reastaurants.add(new Restaurant("7",Cuisine.NorthIndian,5,1,false,getDate(2)));
		reastaurants.add(new Restaurant("8",Cuisine.Chinese,3,5,true,getDate(18)));
		reastaurants.add(new Restaurant("9",Cuisine.SouthIndian,1,4,true,getDate(3)));
		reastaurants.add(new Restaurant("10",Cuisine.Chinese,2,4,false,getDate(10)));
		
		return reastaurants;
	}
	
	public static ArrayList<User> populateUsers() {
		ArrayList<User> users  = new ArrayList<User>();
		ArrayList<CuisineTracking> cuisines= populateCuisines();
		ArrayList<CostTracking> costBrackets= populateCostTracking();
		
		users.add(new User(new CuisineTracking[] {cuisines.get(1),cuisines.get(0),cuisines.get(2)},
				  new CostTracking[] {costBrackets.get(2),costBrackets.get(1),costBrackets.get(0)}));
		
		users.add(new User(new CuisineTracking[] {cuisines.get(1),cuisines.get(2),cuisines.get(3)},
				  new CostTracking[] {costBrackets.get(9),costBrackets.get(3),costBrackets.get(7)}));
		
		users.add(new User(new CuisineTracking[] {cuisines.get(0),cuisines.get(6),cuisines.get(7)},
				  new CostTracking[] {costBrackets.get(10),costBrackets.get(1),costBrackets.get(0)}));
		
		users.add(new User(new CuisineTracking[] {cuisines.get(5),cuisines.get(1),cuisines.get(0)},
				  new CostTracking[] {costBrackets.get(9),costBrackets.get(7),costBrackets.get(1)}));
		
		users.add(new User(new CuisineTracking[] {cuisines.get(5),cuisines.get(0),cuisines.get(6)},
				  new CostTracking[] {costBrackets.get(8),costBrackets.get(2),costBrackets.get(6)}));
		
		
		return users;
		
	}
	
	public static ArrayList<CuisineTracking> populateCuisines() {
		ArrayList<CuisineTracking> cuisines= new ArrayList<CuisineTracking>();
		
		cuisines.add(new CuisineTracking(Cuisine.SouthIndian, 3));
		cuisines.add(new CuisineTracking(Cuisine.NorthIndian, 6));
		cuisines.add(new CuisineTracking(Cuisine.Chinese, 2));
		cuisines.add(new CuisineTracking(Cuisine.SouthIndian, 1));
		cuisines.add(new CuisineTracking(Cuisine.NorthIndian, 8));
		cuisines.add(new CuisineTracking(Cuisine.Chinese, 12));
		cuisines.add(new CuisineTracking(Cuisine.NorthIndian, 12));
		cuisines.add(new CuisineTracking(Cuisine.Chinese, 1));
		
		return cuisines;
	}
	
	public static ArrayList<CostTracking> populateCostTracking() {
		ArrayList<CostTracking> costBrackets= new ArrayList<CostTracking>();
		
		costBrackets.add(new CostTracking(1, 6));
		costBrackets.add(new CostTracking(2, 12));
		costBrackets.add(new CostTracking(3, 12));
		costBrackets.add(new CostTracking(4, 18));
		costBrackets.add(new CostTracking(5, 2));
		costBrackets.add(new CostTracking(1, 3));
		costBrackets.add(new CostTracking(1, 8));
		costBrackets.add(new CostTracking(3, 16));
		costBrackets.add(new CostTracking(4, 28));
		costBrackets.add(new CostTracking(5, 11));
		costBrackets.add(new CostTracking(3, 16));
	
		
		
		return costBrackets;
	}
	
	public static Date getDate(int howOld) {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");

        Date date = new Date();
        String todate = dateFormat.format(date);

        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, -howOld);
        Date todate1 = cal.getTime();    
        String fromdate = dateFormat.format(todate1);
        
        return date;

	}
	
	

}
