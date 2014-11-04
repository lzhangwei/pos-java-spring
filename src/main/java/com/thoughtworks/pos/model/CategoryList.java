package com.thoughtworks.pos.model;

import java.util.List;

public class CategoryList {
    private Category category;
    private List<CartItem> cartItemList;

    public void setCartItemList(List<CartItem> cartItemList) {
        this.cartItemList = cartItemList;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Category getCategory() {
        return category;
    }

    public void addCartItem(CartItem cartItem) {
        cartItemList.add(cartItem);
    }
    
    public String getCategoryName() {
        return category.getName();
    }

    public List<CartItem> getCartItemList() {
        return cartItemList;
    }
}
