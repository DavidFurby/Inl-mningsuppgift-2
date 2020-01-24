package Animals;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;


/**
 * Animal class as parent with necessary variables
 */
abstract class Animal {
    String animal;
    String sound;
    String name;
    private double weight;
    private double height;
    int eat;
    private int age;
    private int ageInDays;
    private String foodType;
    private int maxAge;
    int food;
    int needRefill;
    int howManyDays;
    int currentDay;
    int refillFood;
    private DecimalFormat df = new DecimalFormat("0.00");


    /**
     *  An ArrayList with all the variables needed to identify the animals
     */
    ArrayList<Object> AnimalVariables;

    /**
     * prints the values within the AnimalVariable-ArrayList
     */
    void printValue() {
        AnimalVariables = new ArrayList<>();
        AnimalVariables.add("Animal: " + animal + "\n");
        AnimalVariables.add("Animal sound " + sound + "\n");
        AnimalVariables.add("Weight " + df.format(weight) + " kilo\n");
        AnimalVariables.add("Height " + df.format(height) + " meters\n");
        AnimalVariables.add("total food consumption per day: " + eat + " units of " + foodType + "\n");
        AnimalVariables.add("Age in Days: " + ageInDays + "\n");
    }

    /**
     * get the animal-name
     * @param animal the animal-species name
     */
    void getAnimalName(String animal) {
        this.animal = animal;
    }

    /**
     * Get the animals sound
      * @param sound the animal-species sound
     */
    void getSound(String sound) {
        this.sound = sound;
    }


    /**
     * Get the already assigned name on command
     * @return the animals name
     */
    String getName() {
        return name;
    }

    /**
     * Get the animals randomized age
     * @return the animals age
     */
    int getAgeInDays() {
        return ageInDays;
    }

    /**
     * Get the animals randomized height
     * @return the animals height
     */
    double getHeight() {
        return height;
    }

    /**
     * Get the animals random weight
     * @return the animals weight
     */
    double getWeight() {
        return weight;
    }

    /**
     * Assign the the type of food the animal-species eats
     * @param foodType is then assigned in the different animals classes
     */
    void setFoodType(String foodType) {
        this.foodType = foodType;
    }

    /**
     * Get the animals preferred food
     * @return the animals preferred food
     */
    String getFoodType() {
        return foodType;
    }

    /**
     * A scanner for the user to give the animal a name
     */
    void giveName() {
        Scanner sc = new Scanner(System.in);
        name = sc.next();
    }


    /**
     * A randomization-method to get a random number between the animals maxAge and 1
     * @param maxAge is then assigned in the different animal classes
     */
    void randomAge(int maxAge) {
        this.maxAge = maxAge;
        int rangeAge = maxAge - 1;
        age = (int) (Math.random() * rangeAge) + 1;
        ageInDays = age * 365;
    }

    /**
     * A method used to add the animals age in days with the users choice
     */
    void newDay() {
        System.out.println("How many days would you like to advance for " + name + "");
        Scanner scanner = new Scanner(System.in);
        howManyDays = scanner.nextInt();
        System.out.println("advancing by " + howManyDays + " day(s) for " + name);
        ageInDays += howManyDays;
        setCurrentDay();
    }

    /**
     * Used to identify if the animal has died
     * @return true if the value of AgeInDays is more than the animals maxAge. This will remove that animal from their ArrayList
     */
    boolean hasDiedOfAge() {
        for (int i = 1; i <= howManyDays; i++) {
            currentDay++;
            if (ageInDays >= maxAge * 365) {
                System.out.println("on day:" + currentDay + " " + name + " has died due to age\n");
                return true;
            }
        }
        return false;
    }

    /**
     * a randomize-method for how much an animal may eat in a day
     * @param maxFood the max amount of food the specified animal can eat
     * @param minFood the minimum amount of food the specified animal can eat
     */
    void randomFoodConsumption(int maxFood, int minFood) {
        int rangeFood = maxFood - minFood;
        eat = (int) (Math.random() * rangeFood) + minFood;
    }

    /**
     * Sets a current day-variable to get the days in between the previous days and current
     */
    private void setCurrentDay() {
        currentDay = ageInDays - howManyDays;
    }

    /**
     * A loop based on how many days the user selected. adds to currentDay by one until the value of howManyDays has been reached
     * @return true of food needs to be refilled
     */
         boolean loopDays() {
            for (int i = 1; i <= howManyDays; i++) {
                currentDay++;
                System.out.println("Day : " + currentDay);
                hasEaten();
                if (refillFood == 1) {
                    return true;
                }
            }
             return false;
         }

    /**
     * Method to first check if the animal has enough food. If they do: subtract food by eat. If they don't: return value of refillFood to every animals respective moreFood-method
     * @return value of refilledFood if the animal needs more food
     */
    int hasEaten() {
            if (food < eat) {
                System.out.println(name + " needs to eat " + eat + " units of " + foodType + " but only has " + food + " units of " + foodType + " left");
                System.out.println("press 1 if you want to fill their bowl.");
                Scanner scanner = new Scanner(System.in);
                 refillFood = scanner.nextInt();
                 if (refillFood == 1) {
                     return refillFood;
                 }
            }
            if (food >= eat) {
                int remainingFood = food - eat;
                System.out.println(name + " has eaten " + eat + " units of " + foodType + ", and has " + remainingFood + " units of " + foodType + " left");
                food = remainingFood;
            }
                if (currentDay < ageInDays) {
                    loopDays();
                    if (refillFood == 1) {
                        return refillFood;
                    }
                }
                if (currentDay >= ageInDays){
                    return refillFood = 0;
                }
                return refillFood = 0;
            }

    /**
     * randomize-method to assign the max and min-height of each animal
     * @param maxHeight assigned in the animals to specify their max height
     * @param minHeight assigned in the animals to specify their min height
     */
    void randomHeight(double maxHeight, double minHeight) {
        double rangeHeight = (maxHeight - minHeight + 1);
        height = ((Math.random() * rangeHeight) + minHeight);
    }

    /**
     * randomize-method to assign the max and min-weight of each animal
     * @param maxWeight assigned in the animals to specify their max weight
     * @param minWeight assigned in the animals to specify their min weight
     */
    void randomWeight(double maxWeight, double minWeight) {
        double rangeWeight = maxWeight - minWeight + 1;
        weight = ((Math.random() * rangeWeight) + minWeight);
    }
}