package com.org.ita;

import com.org.ita.components.Filter;
import com.org.ita.util.TestRunner;
import io.qameta.allure.Description;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class FilterTest extends TestRunner {
    @Description("Verify that the amount of the products in the filter subsection matches the amount of the products")
    @Test(description = "TCM-7")
    public void verifyThatTheAmountOfTheProductsInTheFilterSubsectionMatchesTheAmountOfTheProducts() {
        var searchTerm = "Legrand";
        Filter filter = homePage
                .getHeader()
                .search(searchTerm)
                .getFilter();

        var subsectionName = "Світлодіодні світильники";
        var productsAmountInFilterSubsection = filter
                .getProductsAmountInFilterSubsection(subsectionName);

        var productsAmount = filter
                .filterBySection("Товари для дому", subsectionName)
                .getProducts()
                .size();

        assertThat(productsAmountInFilterSubsection)
                .as("The product amount in the filter subsection should match the product amount")
                .isEqualTo(productsAmount);
    }
}
