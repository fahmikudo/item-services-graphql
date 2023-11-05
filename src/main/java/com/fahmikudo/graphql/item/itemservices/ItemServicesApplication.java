package com.fahmikudo.graphql.item.itemservices;

import com.fahmikudo.graphql.item.itemservices.entity.Item;
import com.fahmikudo.graphql.item.itemservices.entity.ItemCategory;
import com.fahmikudo.graphql.item.itemservices.repository.ItemCategoryRepository;
import com.fahmikudo.graphql.item.itemservices.repository.ItemRepository;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.orm.jpa.support.OpenEntityManagerInViewFilter;

import javax.servlet.Filter;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class ItemServicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(ItemServicesApplication.class, args);
	}


	@Bean
	ApplicationRunner applicationRunner(ItemCategoryRepository itemCategoryRepository, ItemRepository itemRepository) {
		return args -> {

			long countItemCategory = itemCategoryRepository.count();
			if (countItemCategory == 0) {
				ItemCategory itemCategory1 = ItemCategory.builder()
						.categoryName("Drinks")
						.description("Drinks Coffee and Non Coffee")
						.build();
				itemCategoryRepository.save(itemCategory1);

				ItemCategory itemCategory2 = ItemCategory.builder()
						.categoryName("Foods")
						.description("Meals and Snacks")
						.build();
				itemCategoryRepository.save(itemCategory2);

				List<Item> items = Arrays.asList(
						new Item(1L, "Latte", 20000, itemCategory1),
						new Item(2L, "Mesh Potato", 45000, itemCategory2)
				);

				itemRepository.saveAll(items);
			}
		};
	}

	@Bean
	public Filter openFilter() {
		return new OpenEntityManagerInViewFilter();
	}
}
