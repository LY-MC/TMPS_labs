package com.utm;

import com.utm.animals.facade.ZooFacade;

public class Main {
    public static void main(String[] args) {
        ZooFacade zooFacade = new ZooFacade();
        zooFacade.runSimulationWithUserInput();
    }
}
