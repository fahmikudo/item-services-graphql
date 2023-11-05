package com.fahmikudo.graphql.item.itemservices.service.impl;

import com.fahmikudo.graphql.item.itemservices.entity.Item;
import com.fahmikudo.graphql.item.itemservices.entity.ItemCategory;
import com.fahmikudo.graphql.item.itemservices.model.ItemRequest;
import com.fahmikudo.graphql.item.itemservices.repository.ItemCategoryRepository;
import com.fahmikudo.graphql.item.itemservices.repository.ItemRepository;
import com.fahmikudo.graphql.item.itemservices.service.ItemService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Log4j2
public class ItemServiceImpl implements ItemService {

    private final ItemRepository itemRepository;
    private final ItemCategoryRepository itemCategoryRepository;

    @Override
    public Item createItem(ItemRequest itemRequest) {
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

    @Override
    public Item updateItem(Long id, ItemRequest itemRequest) {
        log.info("Item Request {} ", itemRequest);

        ItemCategory itemCategory = itemCategoryRepository.findById(itemRequest.getItemCategoryId())
                .orElseThrow(() -> new IllegalArgumentException("Item category not found"));

        Item item = itemRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Item not found."));

        item.setItemName(itemRequest.getItemName());
        item.setPrice(itemRequest.getPrice());
        item.setItemCategory(itemCategory);

        return itemRepository.save(item);
    }

    @Override
    public Boolean deleteItem(Long id) {
        log.info("Item Id {} ", id);

        Item item = itemRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Item not found."));

        itemRepository.delete(item);
        return Boolean.TRUE;
    }

    @Override
    public List<Item> getAllItems() {
        log.info("Get All Items");
        return itemRepository.findAll();
    }

    @Override
    public Item getItemById(Long id) {
        log.info("Get Item By Id {}", id);
        return itemRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Item not found."));
    }
}
