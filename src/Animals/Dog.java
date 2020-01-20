package Animals;

import java.lang.Math;
import java.util.Random;

//Dog class that will inherit from Animal
public class Dog extends Animal {
    boolean chewToy;
    int chewToyDays;
    int dogfood;

    public Dog() {
        /*List of variables and methods specific for the animals. Either a method to assign with input,
        predetermined var or the list printer. Same with all the other animals*/
        animal = "Dog";
        sound = "Bark";
        foodName = "units of dogfood";
        chewToy = true;
        chewToyDays = 0;
        dogfood = 1;
        giveName();
        randomAgeDog();
        randomWeightDog();
        randomHeightDog();
        randomFoodConsumptionDog();
        printValue();
    }
//A randomization method that gives a random number for the animals food-consumption. Same on all Animals
    private void randomFoodConsumptionDog() {
        int maxFood = 42;
        int minFood = 23;
        int rangeFood = maxFood - minFood;
        for (int i = 0; i < 1; i++) {
            eat = (int) (Math.random() * rangeFood) + minFood;
            break;
        }
    }
//A randomization method that gives a random number for the animals Height. Same on all Animals
    private void randomHeightDog() {
        double maxHeight = 1;
        double minHeight = 0.3;
        double rangeHeight = (maxHeight - minHeight + 1);
        for (double i = 0; i < 1; i++) {
            height = ((Math.random() * rangeHeight) + minHeight);
            break;
        }
    }
//A randomization method that gives a random number for the animals Weight. Same on all Animals

    private void randomWeightDog() {
        double maxWeight = 35;
        double minWeight = 1;
        double rangeWeight = maxWeight - minWeight;
        for (int i = 0; i < 1; i++) {
            weight = (Math.random() * rangeWeight) + minWeight;
            break;
        }
    }
//A randomization method that gives a random number for the animals Age. Same on all Animals
    private void randomAgeDog() {
        int maxAge = 15;
        int minAge = 1;
        int rangeAge = maxAge - minAge;
        for (int i = 0; i < 1; i++) {
            age = (int) (Math.random() * rangeAge) + minAge;
            break;
        }
    }
//Boolean method to assign if the dog has a toy or not. Couldn't figure out how repeat the function on the specific days
    public void checkChewToy() {
        if (chewToyDays == 5) {
            chewToy = false;
            System.out.println(name + " does not have a toy." );
        } else {
            chewToyDays++;
        }
    }

    public void newChewToy() {
        chewToyDays = 0;
        chewToy = true;
        System.out.println(name + " has a toy.");
    }
//Method to give the Dog more food. Same on all the animals
    void moreDogFood(){
        Random rand = new Random();
        int dogfood = rand.nextInt(50);
        dogfood += 1;
    }
}