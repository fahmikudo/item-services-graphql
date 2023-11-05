package com.fahmikudo.graphql.item.itemservices.repository;

import com.fahmikudo.graphql.item.itemservices.entity.ItemCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemCategoryRepository extends JpaRepository<ItemCategory, Long> {
}
