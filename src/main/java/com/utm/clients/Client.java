package com.utm.clients;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
abstract public class Client {
    private int age;
    private int happiness;

    public abstract void buyTicket();

    public abstract void enterZoo(boolean canEnter);

}
