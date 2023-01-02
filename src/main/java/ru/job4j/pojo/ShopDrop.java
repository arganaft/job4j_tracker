package ru.job4j.pojo;

public class ShopDrop {
    public static Product[] delete(Product[] products, int index) {
        products[index] = null;
        index++;
        for (; index < products.length; index++) {
            products[index - 1] = products[index];
        }
        products[products.length - 1] = null;
        return products;
    }
}