package com.trenditra.pageparametres;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class WildberriesMainPage {

    //comment3

    public static final String URL = "https://www.wildberries.ru";

    private SelenideElement searchInput = $("#searchInput");

    public WildberriesResultsPage doSearch(String searchQuery) {
        searchInput.setValue(searchQuery).pressEnter();
        return new WildberriesResultsPage();
    }
}
