package com.thoughtworks.pos.model;

public class PromotionSecondHalf extends Promotion{
    @Override
    public double caculatePromotionPrice(Item item, double num) {
        return 0;
    }
}
