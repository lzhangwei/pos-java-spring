package com.thoughtworks.pos;

import com.thoughtworks.pos.model.CategoryList;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

import static org.fest.assertions.api.Assertions.assertThat;

public class PosTests {

    private Pos pos;
    List<String> barcodes;

    @Before
    public void before() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
        pos = (Pos)context.getBean("pos");

        barcodes = new ArrayList<>();
        barcodes.add("ITEM000001");
        barcodes.add("ITEM000001");
        barcodes.add("ITEM000001");
        barcodes.add("ITEM000001");
        barcodes.add("ITEM000001");
        barcodes.add("ITEM000003-2");
        barcodes.add("ITEM000005");
        barcodes.add("ITEM000005");
        barcodes.add("ITEM000005");
        barcodes.add("ITEM000002");
        barcodes.add("ITEM000002");
        barcodes.add("ITEM000002");
    }

    @Test
    public void parse_barcode_to_CartItem_test() {
        pos.parseBarcode(barcodes);
        assertThat(pos.getCartItems().size()).isEqualTo(4);
        assertThat(pos.getCartItems().get(2).getItemName()).isEqualTo("电池");
    }

    @Test
    public void caculate_sum_price_test() {
        pos.parseBarcode(barcodes);
        pos.caculatePrice();
        assertThat(pos.getSumPrice()).isEqualTo(69);
    }

    @Test
    public void should_return_sum_price() {
        pos.parseBarcode(barcodes);
        pos.caculatePrice();
        double result = pos.getSumPrice();
        assertThat(result).isEqualTo(69);
    }

    @Test
    public void should_return_promotion_price() {
        pos.parseBarcode(barcodes);
        pos.caculatePrice();
        double result = pos.getPromotionPrice();
        assertThat(result).isEqualTo(11.75);
    }

    @Test
    public void should_return_category_cartItem_list() {
        pos.parseBarcode(barcodes);
        pos.caculatePrice();
        List<CategoryList> result = pos.createCategoryLists();
        assertThat(result.size()).isEqualTo(3);
        assertThat(result.get(1).getCategoryName()).isEqualTo("水果");
    }
}
