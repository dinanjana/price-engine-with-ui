package com.price.engine.demo.bean;

import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

@Data public class Item {
    private String name;

    private int itemsPerCarton;

    private double priceOfACarton;

    private double priceOfAUnit;

    public Item() {}

    public Item(com.price.engine.demo.entity.Item item) {
        this.name = item.getName();
        this.itemsPerCarton = item.getItemsPerCarton();
        this.priceOfACarton = item.getPriceOfACarton();
        this.priceOfAUnit = item.getUnitPrice();
    }

    public static List<Item> getItems (List<com.price.engine.demo.entity.Item> items) {
        return items.stream().map(Item::new).collect(Collectors.toList());
    }
}
