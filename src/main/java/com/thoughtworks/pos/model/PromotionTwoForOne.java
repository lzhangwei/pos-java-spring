package com.thoughtworks.pos.model;

public class PromotionTwoForOne extends Promotion{
    @Override
    public double caculatePromotionPrice(CartItem cartItem) {
        return 0;
    }
}
