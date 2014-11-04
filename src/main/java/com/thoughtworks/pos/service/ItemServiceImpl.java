package com.thoughtworks.pos.service;

import com.thoughtworks.pos.dao.CategoryDao;
import com.thoughtworks.pos.dao.ItemDao;
import com.thoughtworks.pos.dao.PromotionDao;
import com.thoughtworks.pos.model.Item;

import java.util.List;

public class ItemServiceImpl implements ItemService{

    private ItemDao itemDao;
    private CategoryDao categoryDao;
    private PromotionDao promotionDao;

    public ItemServiceImpl(ItemDao itemDao, CategoryDao categoryDao, PromotionDao promotionDao) {
        this.itemDao = itemDao;
        this.categoryDao = categoryDao;
        this.promotionDao = promotionDao;
    }

    @Override
    public List<Item> getItems() {
        return null;
    }

    @Override
    public Item getItemByBarcode(String barcode) {
        return null;
    }
}
