package com.thoughtworks.pos;

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
}
