package com.thoughtworks.pos.model;

public class PromotionDiscount extends Promotion{
    @Override
    public double caculatePromotionPrice(CartItem cartItem) {
        return 0;
    }
}
