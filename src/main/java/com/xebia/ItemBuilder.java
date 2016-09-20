package com.xebia;

/**
 * Created by mthakur on 20/09/16.
 */
public class ItemBuilder {
    public static Item withBarCode(String s) {
        Item item = new Item();
        item.setBarCode(s);
        return item;
    }
}
