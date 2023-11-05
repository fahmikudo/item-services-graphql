package com.fahmikudo.graphql.item.itemservices.repository;

import com.fahmikudo.graphql.item.itemservices.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {
}
