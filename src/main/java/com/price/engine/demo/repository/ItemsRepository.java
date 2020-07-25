package com.price.engine.demo.repository;

import com.price.engine.demo.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemsRepository extends JpaRepository<Item, Long> {
    Item getItemByName(String name);
}
