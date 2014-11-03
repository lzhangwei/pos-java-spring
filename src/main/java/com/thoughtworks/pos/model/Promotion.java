package com.thoughtworks.pos.model;

public abstract class Promotion {
    private int  id;
    private String promotionDesc;
    private int type;

    public abstract double caculatePromotionPrice(Item item, double num);
}
