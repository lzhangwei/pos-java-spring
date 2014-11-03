package com.thoughtworks.pos.service;

import com.thoughtworks.pos.model.Item;

import java.util.List;

public interface ItemService {
    List<Item> getItems();

    Item getItemByBarcode(String barcode);
}
