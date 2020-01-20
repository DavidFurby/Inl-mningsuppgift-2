package Animals;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

//Animal class as parent
public abstract class Animal {
    //Create reusable variables that then can be used with all the animals
    String animal;
    String sound;
    String name;
    double weight;
    double height;
    int eat;
    int age;
    boolean flying;
    int seeds;
    int bananas;
    boolean bathed;
    String foodName;
    int day;
    ArrayList AnimalVariables;
    //Created an ArrayList with all the variables needed to describe the animals
    public void printValue() {
        AnimalVariables = new ArrayList<>();
        /*called a method that controls the amount of decimals that are show when the variable is presented. In this
        case only two decimals will be shown */
        DecimalFormat df = new DecimalFormat("0.00");
        AnimalVariables.add("Animal: " + animal);
        AnimalVariables.add("Animal sound " + makeSound());
        AnimalVariables.add("Weight " + df.format(weight) + " kilo");
        AnimalVariables.add("Height " + df.format(height) + " meters");
        AnimalVariables.add("total food consumption per day: " + eat + " " + foodName);
        AnimalVariables.add("Age: " + age);
    }

    //method to create sound
    public String makeSound() {
        return sound;
    }
    //method to give name
    void giveName() {
        Scanner sc = new Scanner(System.in);
        name = sc.next();
    }
    //returns the already assigned name on command
    public String getName() {
        return name;
    }

    //return the already assigned age on command
    public int getAge() {
        return age;
    }



}