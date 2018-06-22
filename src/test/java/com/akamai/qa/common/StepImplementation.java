package com.akamai.qa.common;

import com.thoughtworks.gauge.Gauge;
import com.thoughtworks.gauge.Step;
import driver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import static org.assertj.core.api.Assertions.assertThat;

public class StepImplementation {

    @Step("Go to Gauge Get Started Page")
    public void gotoGetStartedPage() throws InterruptedException {
        WebElement getStartedButton = Driver.webDriver.findElement(By.xpath("//li[@class='link_getstarted']"));
        getStartedButton.click();
        Gauge.writeMessage("Page title is %s", Driver.webDriver.getTitle());
    }

    @Step("Ensure installation instructions are available")
    public void ensureInstallationInstructionsAreAvailable() throws InterruptedException {
        WebElement instructions = Driver.webDriver.findElement(By.xpath("//p[@class='instruction']"));
        assertThat(instructions).isNotNull();
    }

    @Step("Open the Gauge homepage")
    public void implementation1() {
        String app_url = System.getenv("APP_URL");
        Driver.webDriver.get(app_url + "/");
        assertThat(Driver.webDriver.getTitle()).contains("Gauge");
    }

    @Step("Open Site Requirements Page")
    public void implementation2() {
        Driver.webDriver.get("http://localhost:3001/apps/provision/#/create?gid=19717");
        assertThat(Driver.webDriver.getTitle()).contains("Luna Control Center");
    }

    @Step("Select product <IoT Edge Connect>")
    public void selectProduct(String product) {
        WebElement element = Driver.webDriver.findElement(By.cssSelector("akam-dropdown[text-property='productName']"));
        element.click();
        element.findElement(By.linkText(product)).click();
    }

    @Step("Ensure that <2> sections are displayed")
    public void ensureExpectedNumberOfSectionsIsDisplayed(Integer expectedSections) {
        assertThat(Driver.webDriver.findElements(By.cssSelector("section.settings-input")).size()).isEqualTo(expectedSections);
    }
}
