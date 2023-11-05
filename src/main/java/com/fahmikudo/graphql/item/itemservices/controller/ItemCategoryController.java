package com.fahmikudo.graphql.item.itemservices.controller;

import com.fahmikudo.graphql.item.itemservices.entity.ItemCategory;
import com.fahmikudo.graphql.item.itemservices.service.ItemCategoryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@RequiredArgsConstructor
@Log4j2
public class ItemCategoryController {

    private final ItemCategoryService itemCategoryService;

    @QueryMapping
    public List<ItemCategory> itemCategories() {
        log.info("Get All Item Categories");
        return itemCategoryService.getAllItemCategories();
    }

    @QueryMapping
    public ItemCategory itemCategoryById(@Argument Long id) {
        log.info("Get Item Category By Id {}", id);
        return itemCategoryService.getItemCategoryById(id);
    }

}
