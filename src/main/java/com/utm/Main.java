package com.utm;

import com.utm.animals.facade.ZooFacade;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        ZooFacade zooFacade = new ZooFacade();
        zooFacade.startSimulation();
    }
}
