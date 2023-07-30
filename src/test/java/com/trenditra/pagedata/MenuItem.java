package com.trenditra.pagedata;

public enum MenuItem {

    //comment4

    LOCATION("Адреса"),
    LOGIN("Войти"),
    BASKET("Корзина");

    private String desc;

    MenuItem(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }
}
