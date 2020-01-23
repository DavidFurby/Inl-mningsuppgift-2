package Animals;

import java.util.Random;

//Parrot class that will inherit from Animal
class Parrot extends Animal {
    private boolean flying;
    Parrot() {
        getAnimalName("Parrot");
        getSound("SQWACK!");
        randomAge(95);
        flying = false;
        food = 20;
        randomFoodConsumption(12, 7);
        setFoodType("seeds");
        randomHeight(2, 0.5);
        randomWeight(4, 0.5);
        printValue();
    }
    void toFly(){
        for (int i = 1; i <= howManyDays; i++) {
            currentDay++;
            fly();
            land();
        }
    }
    void fly() {
        for (int i = 1; i <= howManyDays; i++) {
            if (!flying) {
                if (getAgeInDays() % 2 == 0 || getAgeInDays() % 3 == 0) {
                    System.out.println(name + " will get to fly today!");
                    flying = true;
                }
            }
        }
    }

    void land() {
        for (int i = 1; i <= howManyDays; i++) {
            if (flying) {
                if (getAgeInDays() % 2 != 0 || getAgeInDays() % 3 != 0) {
                    System.out.println(name + " won't get to fly today");
                    flying = false;
                }
            }
        }
    }
    void moreSeeds(){
        Random rand = new Random();
        food += rand.nextInt(30);
        if (eat > food) {
            moreSeeds();
        }
        if (eat <= food) {
            System.out.println("Filling up " + name + "'s bowl with " + food + " units of " + getFoodType());
            hasEaten();
            if (refillFood == 1) {
                return;
            }
            if (refillFood == 0) {
            }
        }
    }
}
