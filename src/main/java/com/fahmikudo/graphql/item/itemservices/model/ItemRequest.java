package com.fahmikudo.graphql.item.itemservices.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ItemRequest {

    private Long id;
    private String itemName;
    private Integer price;
    private Long itemCategoryId;


}
