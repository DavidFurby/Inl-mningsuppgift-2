package Animals;

import java.util.Random;

//Elephant class that will inherent from Animal
class Elephant extends Animal {
    private boolean bathed;

    Elephant() {
        getAnimalName("Elephant");
        getSound("PFFFPPFFF!");
        giveName();
        randomAge(70);
        food = 100;
        randomFoodConsumption(70, 1);
        setFoodType("Bananas");
        randomHeight(4, 2);
        randomWeight(7000, 3000);
        moreBananas();
        printValue();
    }

     void bath() {
         for (int i = 1; i <= howManyDays; i++) {
             if (!bathed) {
                 if (getAgeInDays() % 2 == 0) {
                     System.out.println(name + " gets to bathe today");
                     bathed = true;
                 }
             }
             if (getAgeInDays() % 2 != 0) {
                 System.out.println(name + " does not get to bathe today");

                 bathed = false;
             }
         }
     }
    void moreBananas(){
        Random rand = new Random();
        food += rand.nextInt(50);
        if (eat > food) {
            moreBananas();
        }
        if (eat <= food) {
            System.out.println("Filling up " + name + " bowl with " + food + " units of " + getFoodType());
            hasEaten();
        }
    }
}