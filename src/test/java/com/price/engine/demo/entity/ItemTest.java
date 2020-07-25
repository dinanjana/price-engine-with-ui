package com.price.engine.demo.entity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ItemTest {

    @Test
    public void testGetUnitPrice() {
        Item item = new Item();
        assertEquals(0, item.getUnitPrice(), "Price per unit should be 0");
        item.setItemsPerCarton(20);
        item.setPriceOfACarton(175);
        assertEquals(11.375, item.getUnitPrice(), "Price per unit should be 11.375 ");
    }

    @Test
    public void testGetPriceForGivenNumberOfCartons() {
        Item item = new Item();
        assertEquals(0, item.getPriceForGivenNumberOfCartons(1), "Price for cartons should be 0");

        item.setItemsPerCarton(20);
        item.setPriceOfACarton(175);
        assertEquals(350, item.getPriceForGivenNumberOfCartons(2), "Price for 2 cartons should be 350");

        assertEquals(472.5, item.getPriceForGivenNumberOfCartons(3), "Price for 3 cartons should be 472.5");
    }

    @Test
    public void testGetPriceForAGivenNumberOfUnits() {
        Item item = new Item();
        assertEquals(0, item.getPriceForAGivenNumberOfUnits(1), "Price for 1 unit should be 0");

        item.setItemsPerCarton(20);
        item.setPriceOfACarton(175);

        assertEquals(11.375, item.getPriceForAGivenNumberOfUnits(1), "Price for 1 unit should be 11.375");
        assertEquals(175, item.getPriceForAGivenNumberOfUnits(20), "Price for 20 units should be 175");
        assertEquals(197.75, item.getPriceForAGivenNumberOfUnits(22), "Price for 22 units should be 197.75");
        assertEquals(472.5, item.getPriceForAGivenNumberOfUnits(60), "Price for 20 units should be 472.50");
        assertEquals(506.625, item.getPriceForAGivenNumberOfUnits(63), "Price for 20 units should be 507.75");

    }
}
