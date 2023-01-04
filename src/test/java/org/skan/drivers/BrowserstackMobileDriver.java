package org.skan.drivers;

import com.codeborne.selenide.WebDriverProvider;
import lombok.SneakyThrows;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;

public class BrowserstackMobileDriver implements WebDriverProvider {

    @SneakyThrows
    @Override
    public WebDriver createDriver(Capabilities capabilities) {
        MutableCapabilities mutableCapabilities = new MutableCapabilities();
        mutableCapabilities.merge(capabilities);

        // Set your access credentials
        mutableCapabilities.setCapability("browserstack.user", "serhii_DarJRT");
        mutableCapabilities.setCapability("browserstack.key", "vj2zyqmysYxh4Yktt9PM");

        // Set URL of the application under test
        mutableCapabilities.setCapability("app", "bs://4689349df34cbfe8500dae1cfbae9a0d4e3e3b9f");

        // Specify device and os_version for testing
        mutableCapabilities.setCapability("device", "Google Pixel 3 XL");
        mutableCapabilities.setCapability("os_version", "9.0");

        // Set other BrowserStack capabilities
        mutableCapabilities.setCapability("project", "First Java Project");
        mutableCapabilities.setCapability("build", "browserstack-build-2");
        mutableCapabilities.setCapability("name", "first_test");

        // Initialise the remote Webdriver using BrowserStack remote URL
        // and desired capabilities defined above
        return new RemoteWebDriver(new URL("http://hub.browserstack.com/wd/hub"), mutableCapabilities);
    }
}