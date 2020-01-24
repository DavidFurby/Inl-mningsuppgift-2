package Animals;
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
     * method
     */
    private void selectAnimal() {
        int animalSelect;
            animalSelect = (int) (Math.random() * 3) + 1;
        System.out.println(animalSelect);
            if (animalSelect == 1) {
                aDogsLife();
            }
            if (animalSelect == 2) {
                aParrotsLife();
            }
            if (animalSelect == 3) {
                anElephantsLife();
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
     * Picks out the "Best" dog in the array list. The method goes through the array list and picks out the oldest animal first.
     * If more than one dog has the same age, the program compares their weight instead.
     * If they have the same weight as well, the program compares the heights.
     * The program then picks out the oldest/biggest/tallest animal and prints it out to the user.*/
    private void comparison() {
        Dog bestDog = new Dog();
        for (int i = 0; i < dogs.size(); i++) {
            if (i == 0) {
                bestDog = dogs.get(i);
            }
            if (bestDog.getAgeInDays() < dogs.get(i).getAgeInDays()) {
                bestDog = dogs.get(i);
            } else if (bestDog.getAgeInDays() == dogs.get(i).getAgeInDays()) {
                if (bestDog.getWeight() < dogs.get(i).getWeight()) {
                    bestDog = dogs.get(i);
                } else if (bestDog.getWeight() == dogs.get(i).getWeight()) {
                    if (bestDog.getHeight() < dogs.get(i).getHeight()) {
                        bestDog = dogs.get(i);
                    } else if (bestDog.getHeight() == dogs.get(i).getHeight()) {
                        bestDog = dogs.get(i);
                    }
                }
            }
        }
        System.out.println("The best dog is: " + bestDog.name);



        Elephant bestElephant = new Elephant();
        for (int i = 0; i < elephants.size(); i++) {
            if (i == 0) {
                bestElephant = elephants.get(i);
            }
            if (bestElephant.getAgeInDays() < elephants.get(i).getAgeInDays()) {
                bestElephant = elephants.get(i);
            } else if (bestElephant.getAgeInDays() == elephants.get(i).getAgeInDays()) {
                if (bestElephant.getWeight() < elephants.get(i).getWeight()) {
                    bestElephant = elephants.get(i);
                } else if (bestElephant.getWeight() == elephants.get(i).getWeight()) {
                    if (bestElephant.getHeight() < elephants.get(i).getHeight()) {
                        bestElephant = elephants.get(i);
                    } else if (bestElephant.getHeight() == elephants.get(i).getHeight()) {
                        bestElephant = elephants.get(i);
                    }
                }
            }
        }
        System.out.println("The best elephant is: " + bestElephant.name);


        Parrot bestParrot = new Parrot();
        for (int i = 0; i < parrots.size(); i++) {
            if (i == 0) {
                bestParrot = parrots.get(i);
            }
            if (bestParrot.getAgeInDays() < parrots.get(i).getAgeInDays()) {
                bestParrot = parrots.get(i);
            } else if (bestParrot.getAgeInDays() == parrots.get(i).getAgeInDays()) {
                if (bestParrot.getWeight() < parrots.get(i).getWeight()) {
                    bestParrot = parrots.get(i);
                } else if (bestParrot.getWeight() == parrots.get(i).getWeight()) {
                    if (bestParrot.getHeight() < parrots.get(i).getHeight()) {
                        bestParrot = parrots.get(i);
                    } else if (bestParrot.getHeight() == parrots.get(i).getHeight()) {
                        bestParrot = parrots.get(i);
                    }
                }
            }
        }
        System.out.println("The best parrot is: " + bestParrot.name);
        System.out.println("\n");

        menu();
    }
}