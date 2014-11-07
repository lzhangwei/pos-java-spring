package com.thoughtworks.pos.util;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.fest.assertions.api.Assertions.assertThat;

public class ScannerTests {
    @Test
    public void scanner_test() {
        List<String> barcodes = new ArrayList<String>();
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
        String path = "src/main/resources/cart.txt";
        Scanner scanner = new Scanner();
        List<String> result = scanner.readFile(path);
        assertThat(result.size()).isEqualTo(12);
        assertThat(result.get(1)).isEqualTo("ITEM000001");
    }
}
