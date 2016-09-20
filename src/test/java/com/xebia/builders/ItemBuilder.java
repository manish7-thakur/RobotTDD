package com.xebia.builders;

import com.xebia.Item;

public class ItemBuilder {
    Item item = new Item();
    public ItemBuilder withBarCode(String s) {
        item.setBarCode(s);
        return this;
    }

    public Item get(){
        return item;
    }

    public ItemBuilder withName(String s){
        item.setName(s);
        return this;
    }

}
