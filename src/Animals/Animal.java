package Animals;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

//Animal class as parent
abstract class Animal {
    //Create reusable variables for the animals
    String animal;
    String sound;
    String name;
    private double weight;
    double height;
    private int eat;
    int age;
    boolean flying;
    boolean bathed;
    private String foodType;
    //Created an ArrayList with all the variables needed to describe the animals
    ArrayList<Object> AnimalVariables;
    void printValue() {
        AnimalVariables = new ArrayList<>();
        /*called a method that controls the amount of decimals that are show when the variable is presented. In this
        case only two decimals will be shown */

        DecimalFormat df = new DecimalFormat("0.00");
        AnimalVariables.add("Animal: " + animal);
        AnimalVariables.add("Animal sound " + sound);
        AnimalVariables.add("Weight " + df.format(weight) + " kilo");
        AnimalVariables.add("Height " + df.format(height) + " meters");
        AnimalVariables.add("total food consumption per day: " + eat + " " + foodType);
        AnimalVariables.add("Age: " + age);
    }

    public void getAnimalName(String animal) {
        this.animal = animal; 
    }
    //method to create sound
    public void getSound(String sound) {
        this.sound = sound;
    }

    //method to give name
    void giveName() {
        Scanner sc = new Scanner(System.in);
        name = sc.next();
    }
    //returns the already assigned name on command
    String getName() {
        return name;
    }

    //return the already assigned age on command
    int getAge() {
        return age;
    }

    //give the animal-age
    public void randomAge (int maxAge, int minAge) {
        int rangeAge = maxAge - minAge;
        for (int i = 0; true; i++) {
            age = (int) (Math.random() * rangeAge) + minAge;
            break;
        }
    }

    public void randomFoodConsumption(int maxFood, int minFood) {
        int rangeFood = maxFood - minFood;
        for (int i = 0; true; i++) {
            eat = (int) (Math.random() * rangeFood) + minFood;
            break;
        }
    }

    public void getFoodType(String foodType) {
        this.foodType = foodType;
    }
    public void randomHeight(double maxHeight, double minHeight) {
        double rangeHeight = (maxHeight - minHeight + 1);
        for (double i = 0; true; i++) {
            height = ((Math.random() * rangeHeight) + minHeight);
            break;
        }
    }
    public void randomWeight (double maxWeight,double minWeight) {
        double rangeWeight = maxWeight - minWeight + 1;
        for (int i = 0; true; i++) {
            weight = ((Math.random() * rangeWeight) + minWeight);
            break;
        }
    }
   public void moreFood(int bound){
        Random rand = new Random();
         int food = rand.nextInt(bound);
        food += 1;
    }
}