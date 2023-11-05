package com.fahmikudo.graphql.item.itemservices.service;

import com.fahmikudo.graphql.item.itemservices.entity.ItemCategory;

import java.util.List;

public interface ItemCategoryService {

    List<ItemCategory> getAllItemCategories();
    ItemCategory getItemCategoryById(Long id);

}
