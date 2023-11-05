package com.fahmikudo.graphql.item.itemservices.service.impl;

import com.fahmikudo.graphql.item.itemservices.entity.ItemCategory;
import com.fahmikudo.graphql.item.itemservices.repository.ItemCategoryRepository;
import com.fahmikudo.graphql.item.itemservices.service.ItemCategoryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Log4j2
public class ItemCategoryServiceImpl implements ItemCategoryService {

    private final ItemCategoryRepository itemCategoryRepository;
    @Override
    public List<ItemCategory> getAllItemCategories() {
        log.info("Get All Item Categories");
        return itemCategoryRepository.findAll();
    }

    @Override
    public ItemCategory getItemCategoryById(Long id) {
        log.info("Get Item Category By Id {}", id);
        return itemCategoryRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Item category not found"));
    }
}
