package Animals;

import java.util.Random;

//Dog class that will inherit from Animal
class Dog extends Animal {
    private boolean chewToy;

    Dog() {
        getAnimalName("Dog");
        getSound("BARK!");
        chewToy = true;
        giveName();
        randomAge(15);
        getFood(50);
        doesHasFood();
        randomFoodConsumption(42, 23);
        getFoodType("DogFood");
        randomHeight(1, 0.3);
        randomWeight(35, 1);
        moreDogFood();
        printValue();
    }

    void newChewToy() {
        if (chewToy = false) {
            chewToy = true;
        }
    }
    private void moreDogFood(){
        Random rand = new Random();
        int food = rand.nextInt(50);
        food += 1;
    }
}