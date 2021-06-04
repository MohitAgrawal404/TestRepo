import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.util.ArrayList;

/**
 * Write a description of class Main here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class CalorieTracker implements ActionListener
{
    
    private MealTime Breakfasttime;
    private MealTime Lunchtime;
    private MealTime Dinnertime;
    private int GoalCal;
    private int totalcals;
    private int CalsLeft;
    private JFrame frame;
    private JButton Goal;
    private JLabel total;
    private JLabel Left;
    private JLabel Break;
    private JLabel Lunch;
    private JLabel Dinner;
    private JTextArea B;
    private JTextArea L;
    private JTextArea D;
    private JButton AddB;
    private JButton AddL;
    private JButton AddD;
    private int BreakCals = 0;
    private int LunchCals = 0;
    private int DinnerCals = 0;
    private String BreakList = "";
    private String LunchList = "";
    private String DinnerList = "";
    
    
    public CalorieTracker()
    {
        
        Breakfasttime = new MealTime("Breakfast");
        Lunchtime = new MealTime("Lunch");
        Dinnertime = new MealTime("Dinner");
        GoalCal = 0;
        totalcals = Breakfasttime.getTotalCals() + Lunchtime.getTotalCals() + Dinnertime.getTotalCals();
        CalsLeft = GoalCal - totalcals; 
        
        
        
        frame = new JFrame();
        frame.setTitle("Calorie Tracker");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000,900);
        frame.setVisible(true); 
        // making a popup for the goalcals
        //use Integer.parseInt in the text area
        //
        
        
        
        
        frame.setLayout(new GridLayout(4,3));
        Goal = new JButton("Calorie goal: " + GoalCal);
        Goal.setActionCommand("set goal");
        Goal.addActionListener(this);
        
        frame.add(Goal);
        
        total = new JLabel();
        total.setText("Total Calories: " + totalcals);
        frame.add(total);
        
        Left = new JLabel();
        Left.setText("Calories Left: "+ CalsLeft);
        frame.add(Left);
        
        Break = new JLabel();
        Break.setText("Beakfast Total: ");
        frame.add(Break);
        
        Lunch = new JLabel();
        Lunch.setText("Lunch Total: " + LunchCals);
        frame.add(Lunch);
        
        
        Dinner = new JLabel();
        Dinner.setText("Dinner Total: " + DinnerCals);
        frame.add(Dinner);
        
        //Add B L and D for the list
        
        //use text area and set editable to false
        B = new JTextArea();
        B.setText("Meals: \n" + BreakList);
        frame.add(B);
        B.setEditable(false);
        
        L = new JTextArea();
        L.setText("Meals: \n");
        frame.add(L);
        L.setEditable(false);
        
        D = new JTextArea();
        D.setText("Meals: \n");
        frame.add(D);
        D.setEditable(false);
        
        AddB = new JButton();
        AddB.setText("+ Add New Food: ");
        frame.add(AddB);
        AddB.setActionCommand("Add Break");
        AddB.addActionListener(this);
        
        AddL = new JButton();
        AddL.setText("+ Add New Food: ");
        frame.add(AddL);
        AddL.setActionCommand("Add Lunch");
        AddL.addActionListener(this);
        
        AddD = new JButton();
        AddD.setText("+ Add New Food: ");
        frame.add(AddD);
        AddD.setActionCommand("Add Dinner");
        AddD.addActionListener(this);
        
        
    }
    public void setGoal(int goalcal)
    {
        GoalCal = goalcal;
    }
    public void setBreak(int b)
    {
        BreakCals = BreakCals + b;
    }
    
    public void actionPerformed(ActionEvent myEvent)
    {
        if(myEvent.getActionCommand().equals("set goal"))
        {
            String usergoal = JOptionPane.showInputDialog("Enter a Calorie Goal: ");
            setGoal(Integer. parseInt(usergoal));
            Goal.setText("Calorie goal: " + GoalCal);
            CalsLeft = GoalCal - totalcals;
            Left.setText("Calories Left: "+ CalsLeft);
            
        }
        if(myEvent.getActionCommand().equals("Add Break"))
        {
            int BreakMealCals;
            String BreakMealName;
            BreakMealName = JOptionPane.showInputDialog("Enter a food name: ");
            BreakMealCals = Integer. parseInt(JOptionPane.showInputDialog("Enter Calories for food: "));
            BreakCals += BreakMealCals;
            Break.setText("Breakfast Total: " + BreakCals);
            BreakList += (BreakMealName + ": " + BreakMealCals + " Calories\n");
            B.setText("Meals: \n" + BreakList);
            totalcals += BreakMealCals;
            total.setText("Total Calories: " + totalcals);
            CalsLeft -= BreakMealCals;
            Left.setText("Calories Left: "+ CalsLeft);
        }
        
        if(myEvent.getActionCommand().equals("Add Lunch"))
        {
            int LunchMealCals;
            String LunchMealName;
            LunchMealName = JOptionPane.showInputDialog("Enter a food name: ");
            LunchMealCals = Integer. parseInt(JOptionPane.showInputDialog("Enter Calories for food: "));
            LunchCals += LunchMealCals;
            Lunch.setText("Lunch Total: " + LunchCals);
            LunchList += (LunchMealName + ": " + LunchMealCals + " Calories\n");
            L.setText("Meals: \n" + LunchList);
            totalcals += LunchMealCals;
            total.setText("Total Calories: " + totalcals);
            CalsLeft -= LunchMealCals;
            Left.setText("Calories Left: "+ CalsLeft);
        }
        
        if(myEvent.getActionCommand().equals("Add Dinner"))
        {
            int DinnerMealCals;
            String DinnerMealName;
            DinnerMealName = JOptionPane.showInputDialog("Enter a food name: ");
            DinnerMealCals = Integer. parseInt(JOptionPane.showInputDialog("Enter Calories for food: "));
            DinnerCals += DinnerMealCals;
            Dinner.setText("Dinner Total: " + DinnerCals);
            DinnerList += (DinnerMealName + ": " + DinnerMealCals + " Calories\n");
            D.setText("Meals: \n" + DinnerList);
            totalcals += DinnerMealCals;
            total.setText("Total Calories: " + totalcals);
            CalsLeft -= DinnerMealCals;
            Left.setText("Calories Left: "+ CalsLeft);
        }       
        
        
    }
}
