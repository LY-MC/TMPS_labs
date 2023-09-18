package com.utm.zooworkers;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Cashier {
    private int ticketPrice;
    private int tips;

    public void sellTicket(boolean asked, int age) {
        if (asked && age < 18) {
            System.out.println("Cashier sells a ticket for " + ticketPrice / 2 + " dollars.");
        } else if (asked) {
            System.out.println("Cashier sells a ticket for " + ticketPrice + " dollars.");
        } else {
            System.out.println("Cashier: Sorry, I don't have tickets :( ");
        }
    }
}
