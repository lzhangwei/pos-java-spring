package com.thoughtworks.pos.model;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.fest.assertions.api.Assertions.assertThat;

public class PromotionTests {

    @Test
    public void should_return_PromotionDiscount_object() {
        assertThat(PromotionFactory.getPromotionByType(1) instanceof PromotionDiscount).isTrue();
    }

    @Test
    public void should_return_PromotionSecondHalf_object() {
        assertThat(PromotionFactory.getPromotionByType(2) instanceof PromotionSecondHalf).isTrue();
    }

    @Test
    public void should_return_PromotionTwoForOne_object() {
        assertThat(PromotionFactory.getPromotionByType(3) instanceof PromotionTwoForOne).isTrue();
    }

    @Test
    public void promotion_caculate_test() {
        List<Promotion> promotions = new ArrayList<>();
        promotions.add(new PromotionDiscount());
        promotions.add(new PromotionSecondHalf());
        promotions.add(new PromotionTwoForOne());
        Item item = new Item(1, "ITEM000001", "雪碧", "瓶", 3.0, new Category(1, "饮料"), 75, promotions);
        CartItem cartItem = new CartItem(item, 5);

        assertThat(promotions.get(0).caculatePromotionPrice(cartItem)).isEqualTo(3.75);
        assertThat(promotions.get(1).caculatePromotionPrice(cartItem)).isEqualTo(3);
        assertThat(promotions.get(2).caculatePromotionPrice(cartItem)).isEqualTo(3);
    }
}
