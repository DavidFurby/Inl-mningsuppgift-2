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
        food = 50;
        randomAge(15);
        randomFoodConsumption(42, 23);
        setFoodType("Dog Food");
        randomHeight(1, 0.3);
        randomWeight(35, 1);
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

    void moreDogFood(){
        Random rand = new Random();
        food += rand.nextInt(50);
        if (eat > food) {
            moreDogFood();
        }
    }
}