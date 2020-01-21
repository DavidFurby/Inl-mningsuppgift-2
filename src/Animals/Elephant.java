package Animals;

import java.util.Random;

//Elephant class that will inherent from Animal
class Elephant extends Animal {
    Elephant() {
        getAnimalName("Elephant");
        getSound("PFFFPPFFF!");
        giveName();
        randomAge(70, 1);
        randomAge(15, 1);
        randomFoodConsumption(70, 1);
        getFoodType("Bananas");
        randomHeight(4, 2);
        randomWeight(7000, 3000);
        moreFood(100);
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
}