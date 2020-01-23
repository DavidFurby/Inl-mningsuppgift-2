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
                    someDayInLife(1);
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
            System.out.println("current units of " + dog.getFoodType() + ": " + dog.getFood() + "\n");
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

    private void someDayInLife(int currentDay) {
        while (true) {
            System.out.println("Current year: " + years);
            System.out.println("Current day: " + currentDay + "\n");
            printAllAnimals(0);
            System.out.println("Would you like to continue? Type 1 if yes. 2 if no");
            int toContinue = sc.nextInt();
            if (toContinue == 1) {
                System.out.println("How many days would you like to advance?");
                int howManyDays = sc.nextInt();
                currentDay += howManyDays;
                for (Dog dog : dogs) {
                    currentDogAgeInDays = dog.getAgeInDays() + currentDay;
                    currentDogAgeInYears = currentDogAgeInDays / 365;
                    dog.hasEaten();
                    if (currentDogAgeInDays % 5 == 0) {
                        System.out.println(dog.name + " does not have a toy");
                        dog.brokenChewToy();
                    }
                    if (currentDogAgeInDays % 6 == 0){
                        System.out.println(dog.name +  " was given a new toy");
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
                    someDayInLife(currentDay);
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

        //Dog bestDog for(dog)
        //if(i==0) {bestDog = dog.get(i); }
        //if bestDog.age < dog.get(i).age { bestDog = dog.get(i); }

        Dog bestDog = new Dog();
        for (int i = 0; i < dogs.size(); i++) {
            if (i == 0) {
                bestDog = dogs.get(i);
            }
            if (bestDog.getAgeInDays() < dogs.get(i).getAgeInDays()) {
                bestDog = dogs.get(i);
            }
        }
        System.out.println("The best dog is: " + bestDog);

        Dog biggestDog = new Dog();
        for (int j = 0; j < dogs.size(); j++) {
            if (j == 0) {
                biggestDog = dogs.get(j);
            }
            if (biggestDog.getHeight() < dogs.get(j).getHeight()) {
                biggestDog = dogs.get(j);
            }
        }
        System.out.println("The biggest dog is: " + biggestDog);

        Dog mostBeautifulDog = new Dog();
        for (int o = 0; o < dogs.size(); o++) {
            if (o == 0) {
                mostBeautifulDog = dogs.get(o);
            }
            if (mostBeautifulDog.getWeight() < dogs.get(o).getWeight()) {
                mostBeautifulDog = dogs.get(o);
            }
        }
        System.out.println("The most beautiful dog is: " + mostBeautifulDog);

        Elephant bestElephant = new Elephant();
        for (int e = 0; e < elephants.size(); e++) {
            if (e == 0) {
                bestElephant = elephants.get(e);
            }
            if (bestElephant.getAgeInDays() < elephants.get(e).getAgeInDays()) {
                bestElephant = elephants.get(e);
            }
        }
        System.out.println("The best elephant is: " + bestElephant);

        Elephant biggestElephant = new Elephant();
        for (int w = 0; w < elephants.size(); w++) {
            if (w == 0) {
                biggestElephant = elephants.get(w);
            }
            if (biggestElephant.getHeight() < elephants.get(w).getHeight()) {
                biggestElephant = elephants.get(w);
            }
        }
        System.out.println("The biggest elephant is: " + biggestElephant);

        Elephant mostBeautifulElephant = new Elephant();
        for (int q = 0; q < elephants.size(); q++) {
            if (q == 0) {
                mostBeautifulElephant = elephants.get(q);
            }
            if (mostBeautifulElephant.getWeight() < elephants.get(q).getWeight()) {
                mostBeautifulElephant = elephants.get(q);
            }
        }
        System.out.println("The most beautiful elephant is: " + mostBeautifulElephant);


        Parrot bestParrot = new Parrot();
        for (int a = 0; a < parrots.size(); a++) {
            if (a == 0) {
                bestParrot = parrots.get(a);
            }
            if (bestParrot.getAgeInDays() < parrots.get(a).getAgeInDays()) {
                bestParrot = parrots.get(a);
            }
        }
        System.out.println("The best parrot is: " + bestParrot);

        Parrot biggestParrot = new Parrot();
        for (int z = 0; z < parrots.size(); z++) {
            if (z == 0) {
                biggestParrot = parrots.get(z);
            }
            if (biggestParrot.getHeight() < parrots.get(z).getHeight()) {
                biggestParrot = parrots.get(z);
            }
        }
        System.out.println("The biggest parrot is: " + biggestParrot);

        Parrot mostBeautifulParrot = new Parrot();
        for (int s = 0; s < parrots.size(); s++) {
            if (s == 0) {
                mostBeautifulParrot = parrots.get(s);
            }
            if (mostBeautifulParrot.getWeight() < parrots.get(s).getWeight()) {
                mostBeautifulParrot = parrots.get(s);
            }
        }
        System.out.println("The most beautiful parrot is: " + mostBeautifulParrot);
    }
}