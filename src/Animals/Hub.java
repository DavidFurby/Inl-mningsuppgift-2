package Animals;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Hub {

    private Scanner sc = new Scanner(System.in);

    //Created three ArrayList to hold an unlimited amount of different animals
    private List<Dog> dogs = new ArrayList<>();
    private List<Elephant> elephants = new ArrayList<>();
    private List<Parrot> parrots = new ArrayList<>();
    private int years;
    public int currentDay;
    public  int currentDogAgeInDays;
    public  int currentDogAgeInYears;

    Hub() {
        System.out.println("Start");
        menu();
    }

    private void menu() {
        Scanner sc = new Scanner(System.in);
        String menu;
        System.out.println("For new animal, press: 1. \nTo start first day, press: 2. \nTo show all animals, press 3. \nTo exit, press: 4.");
        while (true) {
            menu = sc.next();
            switch (menu) {
                case "1":
                    selectAnimal();
                    break;
                case "2":
                    someDayInLife();
                    break;
                case "3":
                    printAllAnimals(1);
                    break;
                case "4":
                    exit();
            }
        }
    }

    private void selectAnimal() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Choose your Animal. \nFor Dog, press: 1. For Parrot, press: 2. For Elephant, press: 3");
        String animalSelect;
        while (true) {
            animalSelect = sc.next();
            switch (animalSelect) {
                case "1":
                    aDogsLife();
                    break;
                case "2":
                    aParrotsLife();
                    break;
                case "3":
                    anElephantsLife();
                    break;
            }
        }
    }

    //print out all the animals in the animal arrays on command
    private void printAllAnimals(int returnToMenu) {
        for (Dog dog : dogs) {
            System.out.println("Animal type: " + dog.animal);
            System.out.println("Name: " + dog.getName());
            System.out.println("Age:" + dog.getAge());
            System.out.println("Age in Days: " + dog.getAgeInDays());
            System.out.println("Animal sound " + dog.sound);
            System.out.println("current units of " + dog.getFoodType() + ": " + dog.food + "\n");
        }

        for (Elephant elephant : elephants) {
            System.out.println("Animal type: " + elephant.animal);
            System.out.println("Name: " + elephant.getName());
            System.out.println("Age: " + elephant.getAge());
            System.out.println("Animal sound " + elephant.sound + "\n");
        }

        for (Parrot parrot : parrots) {
            System.out.println("Animal type: " + parrot.animal);
            System.out.println("Name: " + parrot.getName());
            System.out.println("Age: " + parrot.getAge());
            System.out.println("Animal sound: " + parrot.sound + "\n");
        }
        if (returnToMenu == 1)
        {
            menu();
        }
    }

    private void exit() {
        System.out.println("Okay. Bye then");
        System.exit(0);
    }

/*tried to get the day-system to work, but we don´t know how to specify specific days during the arrays loop where the
* functions will activate on repeat*/

    private void someDayInLife() {
        while (true) {
            printAllAnimals(0);
            System.out.println("Would you like to continue? Type 1 if yes. 2 if no");
            int toContinue = sc.nextInt();
            if (toContinue == 1) {
                System.out.println("How many days would you like to advance?");
                for (Dog dog : dogs) {
                    dog.newDay();
                    dog.hasEaten();
                    if (dog.needRefill == 1) {
                        dog.moreDogFood();
                    }
                    if (dog.getAgeInDays() % 5 == 0) {
                        dog.brokenChewToy();
                        System.out.println(dog.name + " chew-toy broke");

                    }
                    if (dog.getAgeInDays() % 6 == 0){
                        System.out.println(dog.name +  " was given a new chew-toy");
                        dog.newChewToy();
                    }
                    if (dog.hasDiedOfAge()) {
                        dogs.remove(dog);
                    }
                    for (Elephant elephant : elephants) {
                        if (elephant.hasDiedOfAge()) {
                            elephants.remove(elephant);
                        }
                        for (Parrot parrot : parrots) {
                            if (parrot.hasDiedOfAge()) {
                                parrots.remove(parrot);
                            }
                        }
                    }
                    someDayInLife();
                }
            }
            if (toContinue == 2) {
                menu();
                break;
            }
        }
    }
    private void aDogsLife() {
        System.out.println("What name do you want to give the dog");
        Dog myDog = new Dog();
        System.out.println("Your " + myDog.animal + "'s name is: " + myDog.name);
        System.out.println(myDog.AnimalVariables);
        addAnimals(myDog);
        menu();
    }
    private void aParrotsLife() {
        System.out.println("What name do you want to give to the parrot?");
        Parrot myParrot = new Parrot();
        System.out.println("Your " + myParrot.animal + "'s name is: " + myParrot.name);
        System.out.println(myParrot.AnimalVariables);
        addAnimals(myParrot);
        menu();
    }

    //Create the animal-object and insert it into the specified ArrayList
    private void anElephantsLife() {
        System.out.println("What name do you want to give to the elephant?");
        Elephant myElephant = new Elephant();
        System.out.println("Your " + myElephant.animal + "'s name is: " + myElephant.name);
        System.out.println(myElephant.AnimalVariables);
        addAnimals(myElephant);
        menu();
    }


    private void addAnimals(Animal animal) { //expects input in form of an animal
        switch (animal.animal) {
            case "Dog":
                dogs.add((Dog) animal);
                break;
            case "Elephant":
                elephants.add((Elephant) animal);
                break;
            case "Parrot":
                parrots.add((Parrot) animal);
                break;
        }
    }

    private void comparison() {
        //biggest: height
        //best: age
        //most beautiful: weight
    }
}