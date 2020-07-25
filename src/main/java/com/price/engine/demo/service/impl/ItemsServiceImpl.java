package com.price.engine.demo.service.impl;

import com.price.engine.demo.bean.Item;
import com.price.engine.demo.repository.ItemsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

@Service
public class ItemsServiceImpl implements com.price.engine.demo.service.ItemsService {

    @Autowired
    private ItemsRepository repository;

    @Override
    public List<Item> getItems() {
        List<com.price.engine.demo.entity.Item> items = repository.findAll();
        return Item.getItems(items);
    }

    @Override
    public double getPriceForNumberOfUnits(String itemName, int units) {
        com.price.engine.demo.entity.Item item = repository.getItemByName(itemName);
        return item.getPriceForAGivenNumberOfUnits(units);
    }

    @Override
    public List<Double> getPricesForARangeOfUnits(String itemName, int start, int end) {
        com.price.engine.demo.entity.Item item = repository.getItemByName(itemName);
        List<CompletableFuture<Double>> prices = new ArrayList<>();
        for(int i = start; i <= end; i++) {
            final int j = i;
            prices.add(CompletableFuture.supplyAsync(() -> item.getPriceForAGivenNumberOfUnits(j)));
        }
        return prices.stream().map(CompletableFuture::join)
                .collect(Collectors.toList());
    }
}
