package Animals;

import java.util.Random;

//Parrot class that will inherit from Animal
class Parrot extends Animal {
    Parrot() {
        getAnimalName("Parrot");
        getSound("SQWACK!");
        giveName();
        randomAge(95);
        setFood(20);
        randomFoodConsumption(12, 7);
        setFoodType("seeds");
        randomHeight(2, 0.5);
        randomWeight(4, 0.5);
        printValue();
        moreSeeds();
    }

    void fly() {
        flying = true;
        System.out.println(name + " will get to fly today!");
    }

    void land() {
        flying = false;
        System.out.println(name + " won't get to fly today");
    }
    private void moreSeeds(){
        Random rand = new Random();
        int food = rand.nextInt(30);
        food += 1;
    }
}
