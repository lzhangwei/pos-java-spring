package com.thoughtworks.pos.dao;

import com.thoughtworks.pos.model.Item;

import java.util.List;

public interface ItemDao {

    List<Item> getItems();

    Item getItemByBarcode(String barcode);

}
