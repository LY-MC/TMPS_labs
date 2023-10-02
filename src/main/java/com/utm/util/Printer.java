package com.utm.util;

import com.utm.miscellaneous.Cage;

import java.util.List;

public class Printer {
    public static void printSimulationHour(int simulationHour) {
        System.out.println("Time " + simulationHour + ":00");
    }

    public static void printClientSneaks() {
        System.out.println("Client sneaks into the zoo");
    }

    public static void printTicketsWithDiscount(boolean isDiscountAvailable) {
        if (isDiscountAvailable) {
            System.out.println("DISCOUNT FOR TICKETS!");
        }
    }

    public static void printInCages(Cage elephantCage, Cage horseCage, Cage lionCage, Cage monkeyCage) throws InterruptedException {
        System.out.println("In cages we have:");
        elephantCage.printAnimalsInCage();
        horseCage.printAnimalsInCage();
        lionCage.printAnimalsInCage();
        monkeyCage.printAnimalsInCage();
        Thread.sleep(5000);
        System.out.println();
    }

    public static void printCashierRude() {
        System.out.println("Cashier was rude");
    }

    public static void printVeterinarianIsTreating() {
        System.out.println("Veterinarian is treating animals because of wrong food.");
    }

    public static void printAnimalSounds(List<Cage> listOfCages) {
        System.out.println("Animals:");
        for (Cage cage : listOfCages) {
            cage.getAnimalList().get(0).makeSound();
        }
    }

    public static void printClientBehavior(boolean clientCanEnter) {
        if (clientCanEnter) {
            System.out.println("Client enters the zoo.");
        } else {
            System.out.println("Client wants to enter but can't.");
        }
    }

    public static void printSecurityGuardBehavior(boolean isSleeping) {
        if (isSleeping) {
            System.out.println("Security guard is sleeping.");
        } else {
            System.out.println("Security guard is not sleeping.");
        }
    }

    public static void printZookeeperBehavior(boolean isCleaning) {
        if (isCleaning) {
            System.out.println("Zookeeper is cleaning cages.");
        }
    }

    public static void printAnimalFeeding(int counterHungryMonkeys, int counterHungryElephants, int counterHungryHorses, int counterHungryLions) {
        System.out.println("Zookeeper needs to feed " + counterHungryMonkeys + " monkeys, " + counterHungryElephants + " elephants, " + counterHungryHorses + " horses, " + counterHungryLions + " lions");
    }

    public static void printTreatingAnimal(String animalType) {
        System.out.println("Veterinarian is treating " + animalType);
    }

    public static void printHorseRiding(boolean childWantsToRideHorse, boolean canRideHorse) {
        if (childWantsToRideHorse && canRideHorse) {
            System.out.println("Child rides a horse.");
        }
    }

    public static void printTipping(int tips) {
        System.out.println("Cashier gets " + tips + " dollars tips because client was happy.");
    }

    public static void printUnhappyClientRefund(double refundAmount) {
        System.out.println("Client gets " + refundAmount + " dollars back because they were unhappy.");
    }

    public static void printAnimalsInCage(List animalList) {
        for (Object animal : animalList) {
            System.out.println(animal.toString());
        }
    }
}
