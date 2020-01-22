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
    int eat;
    private int age;
    private int ageInDays;
    boolean flying;
    boolean bathed;
    private String foodType;
    private int maxAge;
    int food;
    int needRefill;
    private int remainingFood;
    private DecimalFormat df = new DecimalFormat("0.00");


    //Created an ArrayList with all the variables needed to describe the animals
    ArrayList<Object> AnimalVariables;


    void printValue() {
        AnimalVariables = new ArrayList<>();
        AnimalVariables.add("Animal: " + animal + "\n");
        AnimalVariables.add("Animal sound " + sound + "\n");
        AnimalVariables.add("Weight " + df.format(weight) + " kilo\n");
        AnimalVariables.add("Height " + df.format(height) + " meters\n");
        AnimalVariables.add("total food consumption per day: " + eat + " units of " + foodType + "\n");
        AnimalVariables.add("Age: " + age + "\n");
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
        Scanner scanner = new Scanner(System.in);
        int howManyDays = scanner.nextInt();
            ageInDays += howManyDays;
    }
    }

    void randomFoodConsumption(int maxFood, int minFood) {
        int rangeFood = maxFood - minFood;
        eat = (int) (Math.random() * rangeFood) + minFood;
    }
    int hasEaten() {
           if (food < eat) {
               System.out.println(name + " needs to eat " + eat + " units of " + foodType + " but only has " + food + " units of " + foodType + " left");
               System.out.println("press 1 if you want to fill their bowl.");
               Scanner scanner = new Scanner(System.in);
               int refillFood = scanner.nextInt();
               if (refillFood == 1) {
                   return needRefill = 1;
               }
           }
               else {
                   remainingFood = food - eat;
                   System.out.println(name + " has eaten " + eat + " units of " + foodType + ", and has " + remainingFood + " units of " + foodType + " left");
               food = remainingFood;
           }
        return needRefill = 0;
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