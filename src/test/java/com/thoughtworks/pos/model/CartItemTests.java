package com.thoughtworks.pos.model;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.fest.assertions.api.Assertions.assertThat;

public class CartItemTests {

    @Test
    public void caculate_cartItem_promotion_test() {
        List<Promotion> promotions = new ArrayList<>();
        promotions.add(new PromotionDiscount());
        promotions.add(new PromotionSecondHalf());
        promotions.add(new PromotionTwoForOne());
        Item item = new Item(1, "ITEM000001", "雪碧", "瓶", 3.0, new Category(1, "饮料"), 75, promotions);
        CartItem cartItem = new CartItem(item, 5);

        assertThat(cartItem.calculatePromotionPrice()).isEqualTo(3.75);
    }
}
