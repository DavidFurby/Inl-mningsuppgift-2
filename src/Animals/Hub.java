package Animals;

import java.util.ArrayList;
import java.util.Scanner;

public class Hub {

    boolean advanceDays;
    Scanner sc = new Scanner(System.in);
    int tallestDog, year, daysInYear;
    //Created three ArrayList to hold an unlimited amount of different animals
    private List<Dog> Dogs = new ArrayList<>();
    private List<Elephant> Elephants = new ArrayList<>();
    private List<Parrot> Parrots = new ArrayList<>();


    public Hub() {
        System.out.println("Poopedy");
        menu();
    }
//method called in the menu when selecting the alternative to start counting days.
    private void startDay() {
        System.out.println("What day would you like to start at ");
        int currentDay = sc.nextInt();
        someDayInLife(currentDay);
    }

/*tried to get the day-system to work, but we don´t know how to specify specific days during the arrays loop where the
* functions will activate on repeat*/
    private void someDayInLife(int currentDay) {
        advanceDays = true;
        daysInYear = 365;
        while (advanceDays) {
            System.out.println("Day: " + currentDay);
            if (currentDay >= daysInYear) {
                year++;
            }

            System.out.println("Current year: " + year + "\n");
            printAllAnimals(0);
            System.out.println("How many days would you like to advance?");
            int howManyDays = sc.nextInt();
            currentDay += howManyDays;

            for (Dog dog : Dogs) {
                if (dog.getAge() >= 15) {
                    System.out.println(dog.getName() + " Has died\n");
                    Dogs.remove(dog);
                } else {
                    if (!dog.chewToy) {
                        dog.newChewToy();
                    }
                    dog.checkChewToy();
                }

                for (Elephant elephant : Elephants) {
                    elephant.age++;
                    if (elephant.getAge() >= 70) {
                        System.out.println(elephant.getName() + " Has died\n");
                        Elephants.remove(elephant);
                    }

                    for (Parrot parrot : Parrots) {
                        parrot.age++;
                        if (parrot.getAge() > 70) {
                            Parrots.remove(this);
                        }
                    }
                    someDayInLife(currentDay);
                }
            }
        }
    }
//Create the animal-object and insert it into the specified ArrayList
    private void anElephantsLife() {
        System.out.println("What name do you want to give to the elephant?");
        Elephant myElephant = new Elephant();
        System.out.println("Your " + myElephant.animal + "s name is: " + myElephant.name);
        System.out.println(myElephant.AnimalVariables);
        addAnimals(myElephant);
        menu();
    }

    private void aParrotsLife() {
        System.out.println("What name do you want to give to the parrot?");
        Parrot myParrot = new Parrot();
        System.out.println("Your " + myParrot.animal + "s name is: " + myParrot.name);
        System.out.println(myParrot.AnimalVariables);
        addAnimals(myParrot);
        menu();
    }


    private void aDogsLife() {
        System.out.println("What name do you want to give the dog");
        Dog myDog = new Dog();
        System.out.println("Your " + myDog.animal + "s name is: " + myDog.name);
        System.out.println(myDog.AnimalVariables);
        addAnimals(myDog);
        menu();
    }

    public void addAnimals(Animal animal) { //expects input in form of an animal
        if (animal.animal == "Dog") {
            Dogs.add((Dog) animal);
        } else if (animal.animal == "Elephant") {
            Elephants.add((Elephant) animal);
        } else if (animal.animal == "Parrot") {
            Parrots.add((Parrot) animal);
        }
    }
//print out all the animals in the animal arrays on command
    public void printAllAnimals(int returnToMenu) {
        for(int i = 0; i < Dogs.size(); i++) {
            if(Dogs.size() == 0) {
                System.out.println("There are no dogs here!");
            } else {
                System.out.println("Animal type: " + Dogs.get(i).animal);
                System.out.println("Name: " + Dogs.get(i).getName());
                System.out.println("Age:" + Dogs.get(i).getAge());
                System.out.println("Animal sound " + Dogs.get(i).makeSound() + "\n");
            }
        }

        for(int i = 0; i < Elephants.size(); i++) {
            if(Elephants.size() == 0) {
                System.out.println("There are no elephants here!");
            } else {
                System.out.println("Animal type: " + Elephants.get(i).animal);
                System.out.println("Name: " + Elephants.get(i).getName());
                System.out.println("Age: " + Elephants.get(i).getAge());
                System.out.println("Animal sound " + Elephants.get(i).makeSound() + "\n");
            }
        }

        for(int i = 0; i < Parrots.size(); i++) {
            if(Parrots.size() == 0) {
                System.out.println("There are no elephants here!");
            } else {
                System.out.println("Animal type: " + Parrots.get(i).animal);
                System.out.println("Name: " + Parrots.get(i).getName());
                System.out.println("Age: " + Parrots.get(i).getAge());
                System.out.println("Animal sound: " + Parrots.get(i).makeSound() + "\n");
            }
        }
        if (returnToMenu == 1)
        {
            menu();
        }
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
                    startDay();
                    break;
                case "3":
                    printAllAnimals(1);
                    break;
                case "4":
                    Exit();
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
    /*didn't find time to work this part into the project, since we spent mostly all our time trying to make the
    days-counting system to work */

    private void compareAnimals(){
        for (int dog1 = 0; dog1 < Dogs.size(); dog1++) {
            for (int dog2 = 0; dog2 < Dogs.size(); dog2++) {
                if(Dogs.get(dog1).height > Dogs.get(dog2).height) {
                    tallestDog = dog1;
                }
            }
        }
    }
    private void Exit() {
        System.out.println("Okay. Bye then");
        System.exit(0);
    }
}