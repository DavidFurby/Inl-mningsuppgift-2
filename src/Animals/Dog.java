package Animals;

import java.util.Random;

//Dog class that will inherit from Animal
class Dog extends Animal {
    public boolean chewToy;

    Dog() {
        getAnimalName("Dog");
        getSound("BARK!");
        chewToy = true;
        giveName();
        randomAge(15);
        setFood(50);
        randomFoodConsumption(42, 23);
        setFoodType("Dog Food");
        randomHeight(1, 0.3);
        randomWeight(35, 1);
        moreDogFood();
        printValue();
        brokenChewToy();
        newChewToy();
    }
    void brokenChewToy() {
        chewToy = false;
    }
    void newChewToy() {
      chewToy = true;
    }
    private void moreDogFood(){
    moreFood();
    }
}