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
        food = 50;
        randomAge(15);
        randomFoodConsumption(42, 23);
        setFoodType("Dog Food");
        randomHeight(1, 0.3);
        randomWeight(35, 1);
        printValue();
    }
    void brokenChewToy() {
        for (int i = 1; i <= howManyDays; i++) {
            if (chewToy) {
                if (getAgeInDays() % 5 == 0) {
                    System.out.println(name + " chew-toy broke");
                    chewToy = false;
                }
            }
        }
    }
    void newChewToy() {
        for (int i = 1; i <= howManyDays; i++) {
            if (!chewToy) {
                if (getAgeInDays() % 5 != 0) {
                    System.out.println(name + " got a new chew-toy");
                    chewToy = true;
                }
            }
        }
    }

    void moreDogFood() {
            Random rand = new Random();
            food += rand.nextInt(50);
        if (eat > food) {
                moreDogFood();
            }
            if (eat <= food) {
                System.out.println("Filling up " + name + " bowl with " + food + " units of " + getFoodType());
                hasEaten();
            }
        }
    }