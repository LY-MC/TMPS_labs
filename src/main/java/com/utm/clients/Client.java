package com.utm.clients;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public abstract class Client {
    private int age;
    private int happiness;

    public abstract void buyTicket();

    public abstract void enterZoo(boolean canEnter);

}
