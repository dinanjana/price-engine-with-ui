package com.price.engine.demo.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "item")
@Data public class Item implements Serializable {

    private static final long serialVersionUID = -2343243243242432341L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "itemsPerCarton")
    private int itemsPerCarton;

    @Column(name = "priceOfACarton")
    private double priceOfACarton;

    public double getUnitPrice() {
        if (itemsPerCarton == 0 || priceOfACarton == 0) {
            return 0;
        }
        return priceOfACarton/itemsPerCarton*1.3;
    }

    public double getPriceForGivenNumberOfCartons(int numberOfCartons) {
        if (itemsPerCarton == 0 || priceOfACarton == 0) {
            return 0;
        }

        if(numberOfCartons >= 3) {
            return priceOfACarton * numberOfCartons *0.9;
        }
        return priceOfACarton * numberOfCartons;
    }

    public double getPriceForAGivenNumberOfUnits(int numberOfUnits) {
        if (itemsPerCarton == 0 || priceOfACarton == 0) {
            return 0;
        }
        return getPriceForGivenNumberOfCartons(numberOfUnits/itemsPerCarton) + (getUnitPrice() * (numberOfUnits%itemsPerCarton));
    }
}
