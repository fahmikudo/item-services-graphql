package com.fahmikudo.graphql.item.itemservices.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "item_category")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ItemCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "category_name")
    private String categoryName;

    @Column(name = "description")
    private String description;

    @OneToMany(mappedBy = "itemCategory", cascade = CascadeType.ALL)
    private List<Item> items = new ArrayList<>();

}
