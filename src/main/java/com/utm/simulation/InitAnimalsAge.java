package com.utm.simulation;

import com.utm.miscellaneous.Cage;
import com.utm.util.StaticUtils;

import java.util.Properties;

public class InitAnimalsAge {
    public void initAgeProps(Cage elephantCage, Cage horseCage, Cage lionCage, Cage monkeyCage, Properties props) {
        int noElephant = StaticUtils.random.nextInt(Integer.parseInt(props.getProperty("numberOfElephants")));
        int noHorse = StaticUtils.random.nextInt(Integer.parseInt(props.getProperty("numberOfHorses")));
        int noLion = StaticUtils.random.nextInt(Integer.parseInt(props.getProperty("numberOfLions")));
        int noMonkey = StaticUtils.random.nextInt(Integer.parseInt(props.getProperty("numberOfMonkeys")));

        if (elephantCage.getAnimalList().get(noElephant).getAge() > Integer.parseInt(props.getProperty("elephantOldAge"))) {
            elephantCage.getAnimalList().get(noElephant).setIll(true);
        }
        if (horseCage.getAnimalList().get(noHorse).getAge() > Integer.parseInt(props.getProperty("horseOldAge"))) {
            horseCage.getAnimalList().get(noHorse).setIll(true);
        }
        if (lionCage.getAnimalList().get(noLion).getAge() > Integer.parseInt(props.getProperty("lionOldAge"))) {
            lionCage.getAnimalList().get(noLion).setIll(true);
        }
        if (monkeyCage.getAnimalList().get(noMonkey).getAge() > Integer.parseInt(props.getProperty("monkeyOldAge"))) {
            monkeyCage.getAnimalList().get(noMonkey).setIll(true);
        }
    }
}

