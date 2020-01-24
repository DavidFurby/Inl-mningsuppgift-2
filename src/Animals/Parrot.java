package Animals;

import java.util.Random;


/**
 * Parrot class that will inherit from Animal
 */
class Parrot extends Animal {
    private boolean flying;

    /**
     * Parrot constructor
     */
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

    /**
     * a method for how often the flying variable should be checked within the user assigned howManyDays-variable
     */
    void toFly(){
        currentDay = getAgeInDays() - howManyDays;
        for (int i = 1; i <= howManyDays; i++) {
            currentDay++;
            fly();
            land();
        }
    }

    /**
     * Sets the value of flying as true if chewToy = false and currentDay can be divided by two or three without decimals
     */
    void fly() {
        for (int i = 1; i <= howManyDays; i++) {
            if (!flying) {
                if (currentDay % 2 == 0 || currentDay % 3 == 0) {
                    System.out.println("on day: " + currentDay + " " + name + " got to fly today!");
                    flying = true;
                }
            }
        }
    }

    /**
     * Sets the value of flying as false if chewToy = true  and currentDay can't be divided by two or 3 without decimals
     */
    void land() {
        for (int i = 1; i <= howManyDays; i++) {
            if (flying) {
                if (currentDay % 2 != 0 || currentDay % 3 != 0) {
                    flying = false;
                }
            }
        }
    }

    /**
     *if the elephant doesn't have enough food this method will be called to add more
     */
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
