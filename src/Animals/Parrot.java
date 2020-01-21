package Animals;

import java.util.Random;

//Parrot class that will inherit from Animal
class Parrot extends Animal {
    Parrot() {
        getAnimalName("Parrot");
        getSound("SQWACK!");
        giveName();
        randomAge(95, 1);
        randomFoodConsumption(7, 12);
        getFoodType("seeds");
        randomHeight(2, 0.5);
        randomWeight(4, 0.5);
        printValue();
        moreFood(30);
    }

    @Override
    public void randomAge(int maxAge, int minAge) {
        super.randomAge(maxAge, minAge);
    }

    @Override
    public void randomFoodConsumption(int maxFood, int minFood) {
        super.randomFoodConsumption(maxFood, minFood);
    }

    @Override
    public void getFoodType(String foodType) {
        super.getFoodType(foodType);
    }

    @Override
    public void randomHeight(double maxHeight, double minHeight) {
        super.randomHeight(maxHeight, minHeight);
    }

    @Override
    public void randomWeight(double maxWeight, double minWeight) {
        super.randomWeight(maxWeight, minWeight);
    }

    void fly() {
        flying = true;
        System.out.println(name + " will get to fly today!");
    }

    void land() {
        flying = false;
        System.out.println(name + " won't get to fly today");
    }

    @Override
    public void moreFood(int bound) {
        super.moreFood(bound);
    }
}
