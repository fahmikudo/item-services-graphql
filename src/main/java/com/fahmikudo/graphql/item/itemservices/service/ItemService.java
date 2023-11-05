package com.fahmikudo.graphql.item.itemservices.service;

import com.fahmikudo.graphql.item.itemservices.entity.Item;
import com.fahmikudo.graphql.item.itemservices.model.ItemRequest;

import java.util.List;

public interface ItemService {

    Item createItem(ItemRequest itemRequest);
    Item updateItem(Long id, ItemRequest itemRequest);
    Boolean deleteItem(Long id);
    List<Item> getAllItems();
    Item getItemById(Long id);

}
