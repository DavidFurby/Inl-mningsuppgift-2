package Animals;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Hub {
    /**
     *  Created three ArrayList to hold an unlimited amount of different animals
     */
    private List<Dog> dogs = new ArrayList<>();
    private List<Elephant> elephants = new ArrayList<>();
    private List<Parrot> parrots = new ArrayList<>();

    /***
     * The hubClass that the main-class will lead into
     */
    Hub() {
        System.out.println("Start");
        menu();
    }

    /**
     * A menu which is used to give the alternatives for the user
     */
     void menu() {
        Scanner sc = new Scanner(System.in);
        String menu;
        System.out.println("For new animal, press: 1. \nTo start first day, press: 2. \nTo show all animals, press 3. \nTo compare animals, press: 4. \nTo exit, press 5.");
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
                    comparison();
                    break;
                case "5":
                    exit();
                    break;
            }
        }
    }

    /**
     * method to let the user select an animal
     */
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


    /**
     *  print out the values for all the animals
     * @param returnToMenu when this method is called assign 1 within the parameters to return to menu after its done
     */
    private void printAllAnimals(int returnToMenu) {
        for (Dog dog : dogs) {
            System.out.println("\nAnimal type: " + dog.animal);
            System.out.println("Name: " + dog.getName());
            System.out.println("Age in Days: " + dog.getAgeInDays());
            System.out.println("Animal sound " + dog.sound);
            System.out.println("current units of " + dog.getFoodType() + ": " + dog.food + "\n");
        }

        for (Elephant elephant : elephants) {
            System.out.println("\nAnimal type: " + elephant.animal);
            System.out.println("Name: " + elephant.getName());
            System.out.println("Age in Days: " + elephant.getAgeInDays());
            System.out.println("Animal sound " + elephant.sound + "\n");
            System.out.println("current units of " + elephant.getFoodType() + ": " + elephant.food + "\n");

        }

        for (Parrot parrot : parrots) {
            System.out.println("\nAnimal type: " + parrot.animal);
            System.out.println("Name: " + parrot.getName());
            System.out.println("Age in days: " + parrot.getAgeInDays());
            System.out.println("current units of " + parrot.getFoodType() + ": " + parrot.food + "\n");
        }
        if (returnToMenu == 1) {
            menu();
        }
    }

    /**
     * method to exit system
     */
    private void exit() {
        System.out.println("Okay. Bye then");
        System.exit(0);
    }

    /**
     * the core-program. Sets the system in a loop until all animals are dead or if user exits the class
     */
    private void someDayInLife() {
        printAllAnimals(0);
        if (dogs.isEmpty() && elephants.isEmpty() && parrots.isEmpty()) {
            System.out.println("\nAll animals have died. Returning to menu");
            menu();
        }
        System.out.println("Would you like to continue? Type 1 if yes. 2 if no");
        Scanner sc = new Scanner(System.in);
        int toContinue = sc.nextInt();
        if (toContinue == 1) {
            for (Dog dog : dogs) {
                dog.newDay();
                dog.loopDays();
                while (dog.refillFood == 1) {
                    dog.moreDogFood();
                }
                if (dog.refillFood == 0) {
                    dog.chewToy();
                    if (dog.hasDiedOfAge()) {
                        dogs.remove(dog);
                        break;
                    }
                }
            }
            for (Elephant elephant : elephants) {
                elephant.newDay();
                elephant.loopDays();
                while (elephant.refillFood == 1) {
                    elephant.moreBananas();
                }
                if (elephant.refillFood == 0) {
                    elephant.bath();
                    if (elephant.hasDiedOfAge()) {
                        elephants.remove(elephant);
                        break;
                    }
                }
            }
            for (Parrot parrot : parrots) {
                parrot.newDay();
                parrot.loopDays();
                while (parrot.refillFood == 1) {
                    parrot.moreSeeds();
                }
                if (parrot.needRefill == 0) {
                    parrot.toFly();
                    if (parrot.hasDiedOfAge()) {
                        parrots.remove(parrot);
                        break;
                    }
                }
            }
        }
        someDayInLife();
        if (toContinue == 2) {
            menu();
        }
    }

    /**
     * List of methods to create animal-objects
     */
    private void aDogsLife() {
        System.out.println("What name do you want to give the dog");
        Dog myDog = new Dog();
        myDog.giveName();
        System.out.println("Your " + myDog.animal + "'s name is: " + myDog.name);
        System.out.println(myDog.AnimalVariables);
        addAnimals(myDog);
        menu();
    }

    private void aParrotsLife() {
        System.out.println("What name do you want to give to the parrot?");
        Parrot myParrot = new Parrot();
        myParrot.giveName();
        System.out.println("Your " + myParrot.animal + "'s name is: " + myParrot.name);
        System.out.println(myParrot.AnimalVariables);
        addAnimals(myParrot);
        menu();
    }
    private void anElephantsLife() {
        System.out.println("What name do you want to give to the elephant?");
        Elephant myElephant = new Elephant();
        myElephant.giveName();
        System.out.println("Your " + myElephant.animal + "'s name is: " + myElephant.name);
        System.out.println(myElephant.AnimalVariables);
        addAnimals(myElephant);
        menu();
    }

    /**
     * Adds the animal-objects to their respective arrayList
     * @param animal to identify which animal is being added into the method
     */
    private void addAnimals(Animal animal) {
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
/**
 * A method that goes through all the animals in the array lists and prints out the best (oldest), biggest,
 * and most beautiful (heaviest) animals from each category.*/
    private void comparison() {
        Dog bestDog = new Dog();
        //loops through the dog array
        for (int i = 0; i < dogs.size(); i++) {
            if (i == 0) {
                bestDog = dogs.get(i);
            }
            //picks out the oldest ("best") dog in the array list
            if (bestDog.getAgeInDays() < dogs.get(i).getAgeInDays()) {
                bestDog = dogs.get(i);
            }
        }
        System.out.println("The best dog is: " + bestDog.name);

        Dog biggestDog = new Dog();
        for (int j = 0; j < dogs.size(); j++) {
            if (j == 0) {
                biggestDog = dogs.get(j);
            }
            if (biggestDog.getHeight() < dogs.get(j).getHeight()) {
                biggestDog = dogs.get(j);
            }
        }
        System.out.println("The biggest dog is: " + biggestDog.name);

        Dog mostBeautifulDog = new Dog();
        for (int o = 0; o < dogs.size(); o++) {
            if (o == 0) {
                mostBeautifulDog = dogs.get(o);
            }
            if (mostBeautifulDog.getWeight() < dogs.get(o).getWeight()) {
                mostBeautifulDog = dogs.get(o);
            }
        }
        System.out.println("The most beautiful dog is: " + mostBeautifulDog.name);

        Elephant bestElephant = new Elephant();
        for (int e = 0; e < elephants.size(); e++) {
            if (e == 0) {
                bestElephant = elephants.get(e);
            }
            if (bestElephant.getAgeInDays() < elephants.get(e).getAgeInDays()) {
                bestElephant = elephants.get(e);
            }
        }
        System.out.println("The best elephant is: " + bestElephant.name);

        Elephant biggestElephant = new Elephant();
        for (int w = 0; w < elephants.size(); w++) {
            if (w == 0) {
                biggestElephant = elephants.get(w);
            }
            if (biggestElephant.getHeight() < elephants.get(w).getHeight()) {
                biggestElephant = elephants.get(w);
            }
        }
        System.out.println("The biggest elephant is: " + biggestElephant.name);

        Elephant mostBeautifulElephant = new Elephant();
        for (int q = 0; q < elephants.size(); q++) {
            if (q == 0) {
                mostBeautifulElephant = elephants.get(q);
            }
            if (mostBeautifulElephant.getWeight() < elephants.get(q).getWeight()) {
                mostBeautifulElephant = elephants.get(q);
            }
        }
        System.out.println("The most beautiful elephant is: " + mostBeautifulElephant.name);


        Parrot bestParrot = new Parrot();

        for (int a = 0; a < parrots.size(); a++) {
            if (a == 0) {
                bestParrot = parrots.get(a);
            }
            if (bestParrot.getAgeInDays() < parrots.get(a).getAgeInDays()) {
                bestParrot = parrots.get(a);
            }
        }
        System.out.println("The best parrot is: " + bestParrot.name);

        Parrot biggestParrot = new Parrot();
        for (int z = 0; z < parrots.size(); z++) {
            if (z == 0) {
                biggestParrot = parrots.get(z);
            }
            if (biggestParrot.getHeight() < parrots.get(z).getHeight()) {
                biggestParrot = parrots.get(z);
            }
        }
        System.out.println("The biggest parrot is: " + biggestParrot.name);

        Parrot mostBeautifulParrot = new Parrot();
        for (int s = 0; s < parrots.size(); s++) {
            if (s == 0) {
                mostBeautifulParrot = parrots.get(s);
            }
            if (mostBeautifulParrot.getWeight() < parrots.get(s).getWeight()) {
                mostBeautifulParrot = parrots.get(s);
            }
        }
        System.out.println("The most beautiful parrot is: " + mostBeautifulParrot.name);
        System.out.println("\n");

        menu();
    }
}