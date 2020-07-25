package com.price.engine.demo.service;

import com.price.engine.demo.bean.Item;

import java.util.List;

public interface ItemsService {

    List<Item> getItems();

    double getPriceForNumberOfUnits(String item, int units);

    List<Double> getPricesForARangeOfUnits(String item, int start, int end);
}
