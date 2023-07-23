package com.trenditra.tests;

import com.codeborne.selenide.Configuration;
import com.trenditra.pagedata.MenuItem;
import com.trenditra.pageparametres.WildberriesMainPage;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.List;
import java.util.stream.Stream;

import static com.codeborne.selenide.Selenide.open;
import static com.trenditra.pageparametres.WildberriesMainPage.URL;

@Tag("Wildberries")
public class ParallelTest {

    private WildberriesMainPage wb = new WildberriesMainPage();
    private static String clothe = "Носок";

    @ValueSource(strings = {
            "Джинсы",
            "Поло",
            "Носки",
            "Ремень"
    })
    @ParameterizedTest(name = "Check search results for input string: {0}")
    void wildberriesSearchTest(String searchQuery) {
        Configuration.startMaximized = true;
        Configuration.pageLoadStrategy = "eager";
        open(URL);
        wb.doSearch(searchQuery)
                .checkResults(searchQuery);
    }

    @CsvSource(value = {
            "adidas; джинсы",
            "lego; футболка"
    },
            delimiter = ';')
    @ParameterizedTest(name = "{1}")
    void testWithComplexName(String searchQuery) {
        Configuration.startMaximized = true;
        Configuration.pageLoadStrategy = "eager";
        open(URL);
        wb.doSearch(searchQuery)
                .checkResults(searchQuery);
    }

    @EnumSource(value = MenuItem.class)
    @ParameterizedTest(name = "{1}")
    void checkSearchResultForSeveralMenuItems(MenuItem menuItem) {
        Configuration.startMaximized = true;
        Configuration.pageLoadStrategy = "eager";
        open(URL);
        wb.doSearch("Джинсы")
                .switchToMenuItem(menuItem);
        System.out.println();
    }

    static Stream<Arguments> testWithMethodSource() {
        return Stream.of(
                Arguments.of(
                        13270, clothe, List.of("Джинсы", "Поло")
                ),
                Arguments.of(
                        123456, clothe, List.of("Джинсы", "Кофта")
                )
        );
    }

    @Disabled
    @MethodSource("testWithMethodSource")
    @ParameterizedTest
    void testWithMethodSource(int i, String str, List list) {
        Configuration.startMaximized = true;
        Configuration.pageLoadStrategy = "eager";
        doSmth(list);
        doSmth(str);
        doSmth(i);
    }

    private void doSmth(List names) {
        System.out.println(names);
    }
    private void doSmth(String str) {
        System.out.println(str);
    }
    private void doSmth(int i) {
        System.out.println(i);
    }
}