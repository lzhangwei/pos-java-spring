package com.thoughtworks.pos.model;

import org.junit.Test;

import static org.fest.assertions.api.Assertions.assertThat;

public class PromotionTests {

    @Test
    public void should_return_PromotionDiscount_object(){
        assertThat(PromotionFactory.getPromotionByType(1) instanceof PromotionDiscount).isTrue();
    }

    @Test
    public void should_return_PromotionSecondHalf_object(){
        assertThat(PromotionFactory.getPromotionByType(2) instanceof PromotionSecondHalf).isTrue();
    }

    @Test
    public void should_return_PromotionTwoForOne_object(){
        assertThat(PromotionFactory.getPromotionByType(3) instanceof PromotionTwoForOne).isTrue();
    }

    
}
