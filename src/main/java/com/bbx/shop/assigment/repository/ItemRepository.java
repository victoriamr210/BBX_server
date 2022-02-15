package com.bbx.shop.assigment.repository;

import com.bbx.shop.assigment.model.Item;
import com.bbx.shop.assigment.model.Supplier;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ItemRepository extends CrudRepository<Item, Long> {
    Optional<Item> findByItemCode(String itemCode);

//
    @Query("SELECT i from Item i where i.price = (SELECT min(price) from Item)")
    Item cheapestItemBySupplier(@Param("code") String code);
}

