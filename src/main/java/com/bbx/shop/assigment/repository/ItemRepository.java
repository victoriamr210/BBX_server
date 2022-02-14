package com.bbx.shop.assigment.repository;

import com.bbx.shop.assigment.model.Item;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ItemRepository extends CrudRepository<Item, Long> {
    Optional<Item> findByItemCode(String itemCode);
}
