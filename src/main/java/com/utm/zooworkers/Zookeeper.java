package com.utm.zooworkers;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Zookeeper {
    private boolean isFeeding;
    private boolean isCleaning;
    private int speed = 2;

}
