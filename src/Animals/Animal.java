package Animals;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

//Animal class as parent
abstract class Animal {
    String animal;
    String sound;
    String name;
    private double weight;
    private double height;
    private int eat;
    private int age;
    boolean flying;
    boolean bathed;
    private String foodType;
    private boolean hasFood;
    private int maxAge;
    private int food;
    private DecimalFormat df = new DecimalFormat("0.00");


    //Created an ArrayList with all the variables needed to describe the animals
    ArrayList<Object> AnimalVariables;


    void printValue() {
        AnimalVariables = new ArrayList<>();
        AnimalVariables.add("Animal: " + animal);
        AnimalVariables.add("Animal sound " + sound);
        AnimalVariables.add("Weight " + df.format(weight) + " kilo");
        AnimalVariables.add("Height " + df.format(height) + " meters");
        AnimalVariables.add("total food consumption per day: " + eat + " " + foodType);
        AnimalVariables.add("Age: " + age);
    }

    void getAnimalName(String animal) {
        this.animal = animal;
    }

    //method to create sound
    void getSound(String sound) {
        this.sound = sound;
    }

    //returns the already assigned name on command
    String getName() {
        return name;
    }

    //return the already assigned age on command
    int getAge() {
        return age;
    }

    void getFoodType(String foodType) {
        this.foodType = foodType;
    }

    //method to give name
    void giveName() {
        Scanner sc = new Scanner(System.in);
        name = sc.next();
    }

    //give the animal-age
    void randomAge(int maxAge) {
        this.maxAge = maxAge;
        int rangeAge = maxAge - 1;
        age = (int) (Math.random() * rangeAge) + 1;
    }
    void hasAged() {
        age++;
        System.out.println(name + " Has turned " + age + " years old");
    }
    boolean hasDied() {
        if (age == maxAge) {
            System.out.println(name + " has died from natural causes ");
            return true;
        }
        return false;
    }
    void getFood(int food) {
        this.food = food;
    }
    void doesHasFood() {
        if (food <= 0) {
            System.out.println(name + " does not have any food left");
            hasFood = false;
        }
        hasFood = true;
    }
    void randomFoodConsumption(int maxFood, int minFood) {
        int rangeFood = maxFood - minFood;
        eat = (int) (Math.random() * rangeFood) + minFood;
    }
    void hasEaten() {
        if (hasFood = true) {
            int foodLeft = food - eat;
            food = foodLeft;
            System.out.println(name + " has eaten " + eat + " units of " + foodType + ", and has " + foodLeft + " units of " + foodType + " left");
        }
        if (hasFood = false) {
            System.out.println("");
        }
    }
    void randomHeight(double maxHeight, double minHeight) {
        double rangeHeight = (maxHeight - minHeight + 1);
        height = ((Math.random() * rangeHeight) + minHeight);
    }

    void randomWeight(double maxWeight, double minWeight) {
        double rangeWeight = maxWeight - minWeight + 1;
        weight = ((Math.random() * rangeWeight) + minWeight);
    }
}