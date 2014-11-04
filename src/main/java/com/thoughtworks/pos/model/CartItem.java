package com.thoughtworks.pos.model;

public class CartItem {
    private Item item;
    private double num;
    private double sumPrice;
    private double promotionPrice;

    public CartItem(Item item, double num) {
        this.item = item;
        this.num = num;
    }

    public String getBarcode() {
        return item.getBarcode();
    }

    public double getNum() {
        return num;
    }

    public void setNum(double num) {
        this.num = num;
    }
}
