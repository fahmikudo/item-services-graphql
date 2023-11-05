package com.fahmikudo.graphql.item.itemservices.controller;

import com.fahmikudo.graphql.item.itemservices.entity.Item;
import com.fahmikudo.graphql.item.itemservices.entity.ItemCategory;
import com.fahmikudo.graphql.item.itemservices.model.ItemRequest;
import com.fahmikudo.graphql.item.itemservices.repository.ItemCategoryRepository;
import com.fahmikudo.graphql.item.itemservices.repository.ItemRepository;
import com.fahmikudo.graphql.item.itemservices.service.ItemService;
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

    private final ItemCategoryRepository itemCategoryRepository;

    private final ItemService itemService;

    @MutationMapping(name = "createItem")
    public Item createItem(@Argument (name = "itemRequest") ItemRequest itemRequest) {
        log.info("Item Request {} ", itemRequest);
        return itemService.createItem(itemRequest);
    }

    @MutationMapping(name = "updateItem")
    public Item updateItem(@Argument (name = "id") Long id, @Argument (name = "itemRequest") ItemRequest itemRequest) {
        log.info("Item Request {} ", itemRequest);
        return itemService.updateItem(id, itemRequest);
    }

    @MutationMapping(name = "deleteItem")
    public Boolean deleteItem(@Argument(name = "id") Long id) {
        log.info("Item Id {} ", id);
        return itemService.deleteItem(id);
    }

    @QueryMapping
    public List<Item> items() {
        log.info("Get All Items");
        return itemService.getAllItems();
    }

    @QueryMapping
    public Item itemById(@Argument Long id) {
        log.info("Get Item By Id {}", id);
        return itemService.getItemById(id);
    }

}
