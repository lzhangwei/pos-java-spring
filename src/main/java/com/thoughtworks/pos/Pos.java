package com.thoughtworks.pos;

import com.thoughtworks.pos.model.CartItem;
import com.thoughtworks.pos.model.CategoryList;
import com.thoughtworks.pos.model.Item;
import com.thoughtworks.pos.service.ItemService;

import java.util.ArrayList;
import java.util.List;

public class Pos {
    private List<Item> items;
    private List<CartItem> cartItems;
    private double sumPrice;
    private double promotionPrice;
    private ItemService itemService;

    public void setItemService(ItemService itemService) {
        this.itemService = itemService;
    }

    public void parseBarcode(List<String> cartItemBarcodes) {
        for (String barcode : cartItemBarcodes) {
            String[] splitBarcode = barcode.split("-");
            Item item = itemService.getItemByBarcode(splitBarcode[0]);
            items.add(item);
            double num = splitBarcode.length == 1 ? 1 : Double.parseDouble(splitBarcode[1]);
            cartItems.add(new CartItem(item, num));
        }

        cartItems = mergeCartItems(cartItems);
    }

    private List<CartItem> mergeCartItems(List<CartItem> cartItems) {
        for (int i = 0; i < cartItems.size() - 1; i++) {
            for (int j = i + 1; j < cartItems.size(); j++) {
                if (cartItems.get(i).getBarcode().equals(cartItems.get(j).getBarcode())) {
                    double newNum = cartItems.get(i).getNum() + cartItems.get(j).getNum();
                    cartItems.get(i).setNum(newNum);
                    cartItems.remove(j);
                    i--;
                    break;
                }
            }
        }
        return cartItems;
    }

    public void caculatePrice() {
    }

    public double getSumPrice() {
        return sumPrice;
    }

    public double getPromotionPrice() {
        return promotionPrice;
    }

    public List<CategoryList> createCategoryLists() {
        return null;
    }
}
