package Animals;

import java.util.Random;


/**
 * Elephant class that will inherent from Animal
 */
class Elephant extends Animal {
    private boolean bathed;

    /**
     * Constructor for elephant
     */
    Elephant() {
        getAnimalName("Elephant");
        getSound("PFFFPPFFF!");
        randomAge(70);
        food = 100;
        randomFoodConsumption(50, 30);
        setFoodType("Bananas");
        randomHeight(4, 2);
        randomWeight(7000, 3000);
        printValue();
    }

    /**
     * method to set value of bathed to true if bathed is previously set to false and the current day can be divided by two
     * set the value of bathed to false if value was true previously and the current day can't be divided by 2
     */
     void bath() {
         currentDay = getAgeInDays() - howManyDays;
         for (int i = 1; i <= howManyDays; i++) {
             currentDay++;
             if (!bathed) {
                 if (currentDay % 2 == 0) {
                     System.out.println("on day: " + currentDay + " " + name + " got to bathe");
                     bathed = true;
                 }
             }
             if (bathed) {
                 if (currentDay % 2 != 0) {

                     bathed = false;
                 }
             }
         }
     }

    /**
     * if the elephant doesn't have enough food this method will be called to add more
     */
    void moreBananas(){
        Random rand = new Random();
        food += rand.nextInt(100);
        if (eat > food) {
            moreBananas();
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