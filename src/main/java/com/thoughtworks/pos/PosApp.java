package com.thoughtworks.pos;

import com.thoughtworks.pos.model.CartItem;
import com.thoughtworks.pos.model.CategoryList;
import com.thoughtworks.pos.util.Scanner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class PosApp {

    public static final String CART_FILE = "src/main/resources/cart.txt";

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");

        Scanner scanner = (Scanner)context.getBean("scanner");
        List<String> cartItemBarcodes = scanner.readFile(CART_FILE);

        Pos pos = (Pos)context.getBean("pos");
        pos.parseBarcode(cartItemBarcodes);

        pos.caculatePrice();

        print(pos);
    }

    private static void print(Pos pos) {
        DecimalFormat df = new DecimalFormat("0.00");

        System.out.println("**********************Let's Go**********************");

        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("日期：" + format.format(date));

        System.out.print(creatItemPrint(pos));

        System.out.println("总计：");
        System.out.print("优惠前：" + df.format(pos.getSumPrice()) + "    ");
        System.out.print("优惠后：" + df.format(pos.getSumPrice() - pos.getPromotionPrice()) + "    ");
        System.out.print("优惠差价：" + df.format(pos.getPromotionPrice()));
    }

    private static String creatItemPrint(Pos pos) {
        String result = "";

        return result;
    }
}
