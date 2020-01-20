package Animals;

import java.util.Random;

//Elephant class that will inherent from Animal
public class Elephant extends Animal {
    public Elephant() {
        animal = "Elephant";
        sound = "FPppfff!";
        foodName = "bananas";
        giveName();
        randomAgeElephant();
        randomWeightElephant();
        randomHeightElephant();
        randomFoodConsumptionElephant();
        printValue();
        moreBananas();
    }

    private void randomFoodConsumptionElephant() {

        int maxFood = 70;
        int minFood = 1;
        int rangeFood = maxFood - minFood;
        for (int i = 0; i < 1; i++) {
            eat = (int) (Math.random() * rangeFood) + minFood;
            break;
        }
    }

    private void randomHeightElephant() {
        double maxHeight = 4;
        double minHeight = 2;
        double rangeHeight = (maxHeight - minHeight);
        for (double i = 0; i < 1; i++) {
            height = ((Math.random() * rangeHeight) + minHeight);
        }
    }

    private void randomWeightElephant() {
        double maxWeight = 7000;
        double minWeight = 3000;
        double rangeWeight = maxWeight - minWeight;
        for (int i = 0; i < 1; i++) {
            weight = (Math.random() * rangeWeight) + minWeight;
            break;
        }
    }

    private void randomAgeElephant() {
        int maxAge = 70;
        int minAge = 1;
        int rangeAge = maxAge - minAge;
        for (int i = 0; i < 1; i++) {
            age = (int) (Math.random() * rangeAge) + minAge;
            break;
        }
    }
    void bath() {
        if (bathed) {
            System.out.println(name + " gets to bathe today");
        }
        else {
            System.out.println(name + " won't bathe today");
        }
    }

    private void moreBananas(){
        Random rand = new Random();
        int banana = rand.nextInt(100);
        banana += 1;

    }
}