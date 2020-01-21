package Animals;

//Dog class that will inherit from Animal
public class Dog extends Animal {
    boolean chewToy;
    private int chewToyDays;

    Dog() {
        /*List of variables and methods specific for the animals. Either a method to assign with input,
        predetermined var or the list printer. Same with all the other animals*/
        getAnimalName("Dog");
        getSound("BARK!");
        chewToy = true;
        chewToyDays = 0;
        giveName();
        randomAge(15, 1);
        randomFoodConsumption(42, 23);
        getFoodType("units");
        randomHeight(1, 0.3);
        randomWeight(35, 1);
        moreFood(50);
        printValue();
    }

//A randomization method that gives a random number for the animals Age. Same on all Animals

    //Boolean method to assign if the dog has a toy or not. Couldn't figure out how repeat the function on the specific days
void checkChewToy() {
        if (chewToyDays == 5) {
            chewToy = false;
            System.out.println(name + " does not have a toy." );
        } else {
            chewToyDays++;
        }
    }

    void newChewToy() {
        chewToyDays = 0;
        chewToy = true;
        System.out.println(name + " has a toy.");
    }
}