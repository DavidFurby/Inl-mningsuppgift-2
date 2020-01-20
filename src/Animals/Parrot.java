package Animals;

import java.util.Random;

//Parrot class that will inherit from Animal
public class Parrot extends Animal {
    public Parrot() {
        animal = "Parrot";
        sound = "Squawk!";
        foodName = "units of seeds";
        giveName();
        randomAgeParrot();
        randomWeightParrot();
        randomHeightParrot();
        randomFoodConsumptionParrot();
        printValue();
    }

    private void randomFoodConsumptionParrot() {
        int maxFood = 12;
        int minFood = 7;
        int rangeFood = maxFood - minFood;
        for (int i = 0; i < 1; i++) {
            eat = (int) (Math.random() * rangeFood) + minFood;
            break;
        }
    }

    private void randomHeightParrot () {
        double maxHeight = 2;
        double minHeight = 0.5;
        double rangeHeight = (maxHeight - minHeight + 1);
        for (double i = 0; i < 1; i++) {
            height = ((Math.random() * rangeHeight) + minHeight);
            break;
        }
    }

    private void randomWeightParrot () {
        double maxWeight = 1;
        double minWeight = 0.5;
        double rangeWeight = maxWeight - minWeight + 1;
        for (int i = 0; i < 1; i++) {
            weight = ((Math.random() * rangeWeight) + minWeight);
            break;
        }
    }

    private void randomAgeParrot () {
        int maxAge = 95;
        int minAge = 1;
        int rangeAge = maxAge - minAge;
        for (int i = 0; i < 1; i++) {
            age = (int) (Math.random() * rangeAge) + minAge;
            break;
        }
    }
    void fly() {
        flying = true;
        System.out.println(name + " will get to fly today!");
    }
    void land() {
        flying = false;
        System.out.println(name + " won't get to fly today");
    }

    void moreSeeds(){
        Random rand = new Random();
        int seeds = rand.nextInt(30);
        seeds += 1;
    }
}