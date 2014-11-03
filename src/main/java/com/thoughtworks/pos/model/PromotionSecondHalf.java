package com.thoughtworks.pos.model;

public class PromotionSecondHalf extends Promotion{
    @Override
    public double caculatePromotionPrice(CartItem cartItem) {
        return 0;
    }
}
