package com.thoughtworks.pos.service;

import com.thoughtworks.pos.dao.CategoryDao;
import com.thoughtworks.pos.dao.ItemDao;
import com.thoughtworks.pos.dao.PromotionDao;
import com.thoughtworks.pos.model.Category;
import com.thoughtworks.pos.model.Item;
import com.thoughtworks.pos.model.Promotion;

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
        List<Item> items = itemDao.getItems();
        for(Item item : items) {
            Category category = categoryDao.getCategoryById(item.getCategoryId());
            item.setCategory(category);

            List<Promotion> promotionList = promotionDao.getPromotionsByItemId(item.getId());
            item.setPromotionList(promotionList);

            item.setDiscount(promotionDao.getPromotionDiscount(item.getId()));
        }
        return items;
    }

    @Override
    public Item getItemByBarcode(String barcode) {
        Item item = itemDao.getItemByBarcode(barcode);
        item.setCategory(categoryDao.getCategoryById(item.getId()));
        item.setPromotionList(promotionDao.getPromotionsByItemId(item.getId()));
        item.setDiscount(promotionDao.getPromotionDiscount(item.getId()));
        return item;
    }
}
