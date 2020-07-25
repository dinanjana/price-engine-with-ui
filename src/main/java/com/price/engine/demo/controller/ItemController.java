package com.price.engine.demo.controller;

import com.price.engine.demo.bean.Item;
import com.price.engine.demo.service.ItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/v1/items")
public class ItemController {

    @Autowired
    private ItemsService itemsService;

    @GetMapping
    public @ResponseBody List<Item> getItems() {
        return itemsService.getItems();
    }

    @GetMapping("{name}/price")
    public List<Double> getPriceForUnitsRange(@PathVariable("name") String name, @RequestParam("start") int start, @RequestParam("end") int end) {
        return itemsService.getPricesForARangeOfUnits(name, start, end);
    }

    @GetMapping("{name}/price/{units}")
    public double getPriceForGivenNumberOfUnits(@PathVariable("name") String name, @PathVariable("units") int units) {
        return itemsService.getPriceForNumberOfUnits(name, units);
    }
}
