import org.checkerframework.checker.units.qual.A;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.JavascriptExecutor;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.concurrent.TimeUnit;

public class TestOtomasyonSelenium {


    public WebDriver driver;
    @Test
    public void openWeb() throws InterruptedException {

        // Start Chrome Driver
        System.setProperty(ChromeDriverService.CHROME_DRIVER_EXE_PROPERTY , "C:/webdriver/chromedriver.exe");
        WebDriver driver=new ChromeDriver();

        driver.manage().window().maximize();
        //Open website
        driver.get("https://www.gittigidiyor.com/");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        // Click to login
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(By.cssSelector("#main-header > div:nth-child(3) > div > div > div > div.sc-1nx8ums-0.fQSWwJ > div > div:nth-child(1) > div"))).build().perform();
        Thread.sleep(1000);
        action.moveToElement(driver.findElement(By.cssSelector("#main-header > div:nth-child(3) > div > div > div > div.sc-1nx8ums-0.fQSWwJ > div > div.gekhq4-5.hJhHqb > div.sc-3wdx43-0.bAxXdY > div > div > div"))).click().perform();

        // Login
        WebElement username = driver.findElement(By.name("kullanici"));
        username.sendKeys("Username");
        Thread.sleep(1000);
        WebElement password = driver.findElement(By.id("L-PasswordField"));
        password.sendKeys("Password");
        Thread.sleep(1000);
        WebElement login = driver.findElement(By.id("gg-login-enter"));
        login.click();
        Thread.sleep(3000);

        // Search item from bar
        WebElement searchKey = driver.findElement(By.cssSelector("#main-header > div:nth-child(3) > div > div > div > div.sc-1nx8ums-0.fXQfgp > form > div > div.sc-1yew439-3.bxSoKG > div.sc-4995aq-4.dNPmGY > input"));
        searchKey.sendKeys("bilgisayar",Keys.ENTER);

        // Scroll Down
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,10000)");
        //Go to Next Page
        WebElement nextPage = driver.findElement(By.cssSelector("#best-match-right > div.pager.pt30.hidden-m.gg-d-24 > ul > li.next-link > a"));
        nextPage.click();

        js.executeScript("window.scrollBy(0,200)");

        // Choise item from list
        WebElement random = driver.findElement(By.cssSelector("#product_id_673365073"));
        random.click();

        //Catalog Price
        /* somethings wrong I
        WebElement price = driver.findElement(By.id("sp-price-lowPrice"));
        String priceText = price.getText();
        */

        js.executeScript("window.scrollBy(0,100)");
        //Add item to basket
        WebElement addBox =driver.findElement(By.id("add-to-basket"));
        addBox.click();
        Thread.sleep(3000);
        //Go to basket page
        WebElement goToBasket = driver.findElement(By.cssSelector("#header_wrapper > div.header-icon-container.robot-header-iconContainer.gg-w-5.gg-d-6.gg-t-14.gg-m-11.gg-w-push-14.gg-d-push-12.gg-t-push-0.gg-m-push-0 > div.basket-container.robot-header-iconContainer-cart"));
        goToBasket.click();
        Thread.sleep(1000);

        //Basket Price
        /* Somethings wrong II
        WebElement priceBox = driver.findElement(By.className("total-price"));
        String priceBoxText = priceBox.getText();



        if (priceText.compareTo(priceBoxText)>0)
        {
            WebElement changeAmount = driver.findElement(By.className("amount"));
            changeAmount.click();
            changeAmount.sendKeys("2",Keys.ENTER);
        }
        */
        js.executeScript("window.scrollBy(0,100)");
        // Select Amount of product
        WebElement changeAmount = driver.findElement(By.className("amount"));
        changeAmount.click();
        changeAmount.sendKeys("2",Keys.ENTER);

        Thread.sleep(3000);
        // Clear Product
        WebElement clearBox = driver.findElement(By.className("btn-delete btn-update-item"));
        clearBox.click();
        Thread.sleep(3000);

        driver.quit();

    }

}
