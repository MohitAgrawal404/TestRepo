import java.util.ArrayList;
/**
 * Write a description of class Day here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class MealTime
{
    private ArrayList<Meal> foodList = new ArrayList<Meal>();
    
    private int calories = 0;
    private String name = "";
    private ArrayList<String> foods = new ArrayList<String>(); 
    
    public MealTime(String mealName)
    {
       name = mealName; 
       
    }
    
    public void addFood(String food, int foodCalories)
    {
        foodList.add(new Meal(food, foodCalories));
        
    }
    
    public ArrayList getFood()
    {
        return foodList;
    }
    
    public String getName()
    {
        return name; 
    }
    
    public int getTotalCals()
    {
        for (int x = 0; x < foodList.size(); x++)
        {
            calories += foodList.get(x).getCalories();
        }
        return calories;
    }
    
    
}
