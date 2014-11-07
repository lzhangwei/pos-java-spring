package com.thoughtworks.pos.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-config.xml")
public class ItemServiceTests {

    @Autowired
    private ItemService itemService;

    @Test
    public void get_all_items_test() {

    }

    @Test
    public void get_item_by_barcode_test() {

    }
}
