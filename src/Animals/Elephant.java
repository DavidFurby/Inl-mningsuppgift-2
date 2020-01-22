package Animals;

import java.util.Random;

//Elephant class that will inherent from Animal
class Elephant extends Animal {
    Elephant() {
        getAnimalName("Elephant");
        getSound("PFFFPPFFF!");
        giveName();
        randomAge(70);
        setFood(100);
        randomFoodConsumption(70, 1);
        setFoodType("Bananas");
        randomHeight(4, 2);
        randomWeight(7000, 3000);
        moreBananas();
        printValue();
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
        int food = rand.nextInt(100);
        food += 1;
    }
}