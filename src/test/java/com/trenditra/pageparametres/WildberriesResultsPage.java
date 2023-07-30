package com.trenditra.pageparametres;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.trenditra.pagedata.MenuItem;

import static com.codeborne.selenide.Selenide.$$;

public class WildberriesResultsPage {

    //comment2
    private ElementsCollection results = $$("#searching-results__title");

    public void checkResults(String expected) {
        results.shouldBe(CollectionCondition.sizeGreaterThan(0))
                .get(1)
                .shouldHave(Condition.text(expected));
    }

    public WildberriesResultsPage switchToMenuItem(MenuItem menuItem) {
        $$("#basketContent").find(Condition.text(menuItem.getDesc())).click();
        return this;
    }
}
