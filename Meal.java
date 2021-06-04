
/**
 * Write a description of class Meal here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Meal
{
    private String foodName;
    private int Calories;
    
    public Meal(String name, int foodCalories)
    {
        foodName = name; 
        Calories = foodCalories; 
    }
    
    public String getFood()
    {
        return foodName;
    }
    
    public int getCalories()
    {
        return Calories; 
    }
}
