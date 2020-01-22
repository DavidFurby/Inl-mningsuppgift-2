package Animals;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Random;
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
    private int ageInDays;
    boolean flying;
    boolean bathed;
    private String foodType;
    private int maxAge;
    private int food;
    private boolean death;
    private int refillFood;
    private int remainingFood;
    private DecimalFormat df = new DecimalFormat("0.00");


    //Created an ArrayList with all the variables needed to describe the animals
    ArrayList<Object> AnimalVariables;


    void printValue() {
        AnimalVariables = new ArrayList<>();
        AnimalVariables.add("Animal: " + animal);
        AnimalVariables.add("Animal sound " + sound);
        AnimalVariables.add("Weight " + df.format(weight) + " kilo");
        AnimalVariables.add("Height " + df.format(height) + " meters");
        AnimalVariables.add("total food consumption per day: " + eat + " units of " + foodType);
        AnimalVariables.add("Age: " + age);
        AnimalVariables.add("Age in Days: " + ageInDays + "\n");
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
    int getAgeInDays() {
        return ageInDays;
    }

    void setFoodType(String foodType) {
        this.foodType = foodType;
    }
    String getFoodType() {
        return foodType;
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
        ageInDays = age * 365;
    }

    void hasAged() {
        age++;
        System.out.println(name + " Has turned " + age + " years old");
    }
    boolean hasDiedOfAge() {
        if (age == maxAge) {
            System.out.println(name + " has died from natural causes ");
            return true;
        }
        return false;
    }
    void setFood(int food) {
        this.food = food;
    }

    int getFood() {
        return food;
    }

    void randomFoodConsumption(int maxFood, int minFood) {
        int rangeFood = maxFood - minFood;
        eat = (int) (Math.random() * rangeFood) + minFood;
    }
    void hasEaten() {
           if (food > eat) {
             remainingFood = food - eat;
            System.out.println(name + " has eaten " + eat + " units of " + foodType + ", and has " + remainingFood + " units of " + foodType + " left");
        }
           if (food < eat) {
               System.out.println(name + " is out of " + foodType);
            System.out.println("press 1 if you want to fill their bowl. press 2 if you want them to starve");
            Scanner scanner = new Scanner(System.in);
            refillFood = scanner.nextInt();
            if (refillFood == 1) {
                moreFood();
            }
        }
           food = remainingFood;
    }
    void moreFood() {
        Random rand = new Random();
         food = rand.nextInt(50);
        food += 1;
        System.out.println(name +" now has " + food + " units of" + foodType);
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