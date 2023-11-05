package com.fahmikudo.graphql.item.itemservices.controller;

import com.fahmikudo.graphql.item.itemservices.entity.Item;
import com.fahmikudo.graphql.item.itemservices.entity.ItemCategory;
import com.fahmikudo.graphql.item.itemservices.model.ItemRequest;
import com.fahmikudo.graphql.item.itemservices.repository.ItemCategoryRepository;
import com.fahmikudo.graphql.item.itemservices.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
@RequiredArgsConstructor
@Log4j2
public class ItemController {

    private final ItemRepository itemRepository;
    private final ItemCategoryRepository itemCategoryRepository;

    @MutationMapping(name = "createItem")
    public Item createItem(@Argument (name = "itemRequest") ItemRequest itemRequest) {
        log.info("Item Request {} ", itemRequest);

        ItemCategory itemCategory = itemCategoryRepository.findById(itemRequest.getItemCategoryId())
                .orElseThrow(() -> new IllegalArgumentException("Item category not found"));

        Item item = Item.builder()
                .itemName(itemRequest.getItemName())
                .price(itemRequest.getPrice())
                .itemCategory(itemCategory)
                .build();
        return itemRepository.save(item);
    }

    @QueryMapping
    public List<ItemCategory> itemCategories() {
        log.info("Get All Item Categories");
        return itemCategoryRepository.findAll();
    }

    @QueryMapping
    public ItemCategory itemCategoryById(@Argument Long id) {
        log.info("Get Item Category By Id {}", id);
        return itemCategoryRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Item category not found"));
    }

}
