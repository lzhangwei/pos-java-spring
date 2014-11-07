package com.thoughtworks.pos.service;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.fest.assertions.api.Assertions.assertThat;

public class ItemServiceTests {


    private ItemService itemService;

    @Before
    public void before() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
        itemService = (ItemService)context.getBean("itemService");
    }



    @Test
    public void get_all_items_test() {

        assertThat(itemService.getItems().size()).isEqualTo(6);
        assertThat(itemService.getItems().get(1).getName()).isEqualTo("雪碧");
        assertThat(itemService.getItems().get(1).getCategoryId()).isEqualTo(1);
        assertThat(itemService.getItems().get(1).getDiscount()).isEqualTo(75);
        assertThat(itemService.getItems().get(1).getPromotionList().size()).isEqualTo(3);

    }

    @Test
    public void get_item_by_barcode_test() {

        assertThat(itemService.getItemByBarcode("ITEM000001").getName()).isEqualTo("雪碧");
        assertThat(itemService.getItemByBarcode("ITEM000001").getCategoryId()).isEqualTo(1);
        assertThat(itemService.getItemByBarcode("ITEM000001").getDiscount()).isEqualTo(75);
        assertThat(itemService.getItemByBarcode("ITEM000001").getPromotionList().size()).isEqualTo(3);

    }
}
