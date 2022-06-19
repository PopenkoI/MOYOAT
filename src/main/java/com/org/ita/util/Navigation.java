package com.org.ita.util;

import com.org.ita.driver.DriverRepository;
import org.openqa.selenium.WebDriver;

public class Navigation {
    private WebDriver driver;

    public Navigation() {
        driver = DriverRepository.DRIVERS.get();
    }

    public void navigateToUrl(String url) {
        driver.get(url);
        driver.manage().window().maximize();
    }
}
