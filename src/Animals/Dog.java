package Animals;

import java.util.Random;


/**
 * Dog class that will inherit from Animal
 */
class Dog extends Animal {
    private boolean chewToy;

    /**
     * Constructor for dog
     */
    Dog() {
        getAnimalName("Dog");
        getSound("BARK!");
        food = 50;
        randomAge(15);
        randomFoodConsumption(42, 23);
        setFoodType("Dog Food");
        randomHeight(1, 0.3);
        randomWeight(35, 1);
        printValue();
    }

    /**
     * a method for how often the chewtoy-value should be checked within the user assigned HowManyDays-variable
     */
    void chewToy() {
        currentDay = getAgeInDays() - howManyDays;
        for (int i = 1; i <= howManyDays; i++) {
            currentDay++;
            brokenChewToy();
            newChewToy();
        }
    }

    /**
     * Sets the value of chewToy as false if chewToy = true and currentDay can't be divided by five without decimals
     */
    private void brokenChewToy() {
            if (chewToy) {
                if (currentDay % 5 == 0) {
                    System.out.println("on day: " + currentDay + " " + name + " chew-toy broke");
                    chewToy = false;
                }
            }
        }

    /**
     * Sets the value of chewToy as true if chewToy = false and currentDay can be divided by five without decimals
     */
    private void newChewToy() {
            if (!chewToy) {
                if (currentDay % 5 != 0) {
                    System.out.println("on day: " + currentDay + " " + name + " got a new chew-toy");
                    chewToy = true;
                }
            }
        }

    /**
     * if the dog doesn't have enough food this method will be called to add more
     */
    void moreDogFood() {
            Random rand = new Random();
            food += rand.nextInt(50);
        if (eat > food) {
                moreDogFood();
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