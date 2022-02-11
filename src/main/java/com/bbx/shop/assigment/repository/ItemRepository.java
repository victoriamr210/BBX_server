package com.bbx.shop.assigment.repository;

import com.bbx.shop.assigment.model.Item;
import org.springframework.data.repository.CrudRepository;

public interface ItemRepository extends CrudRepository<Item, Long> {
}
