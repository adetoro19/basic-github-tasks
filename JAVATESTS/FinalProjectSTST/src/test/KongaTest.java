package test;


//Visit the URL Konga
// Sign in to KongaSuccessfully
// From the Categories, click on the “Computers and Accessories”
// Click on the Laptop SubCategory
// Click on the Apple MacBooks-Add an item to the cart
// Select Address-Continue to make payment
// Select a Card Payment Method
// Input invalid card details
// Print Out the error message: Invalid card number
// Close the iFrame that displays the input card Modal
// Quit the browser.

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class KongaTest {
    //import the selenium WebDriver
    private WebDriver driver;
    @BeforeTest
    public void start() throws InterruptedException{
        //locate where the chromedriver is
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        //1. Open your chrome browser
        driver = new ChromeDriver();
        //2. Input your Konga Page URL (https://https://www.konga.com)
        driver.get("https://www.konga.com");
        //3. Maximize the browser
        driver.manage().window().maximize();
    }
    @Test(priority = 0)
    public void positiveSignIn() throws InterruptedException {
        //4. Click on Signup button to open the Signup page
        driver.findElement(By.xpath("//*[@id=\"nav-bar-fix\"]/div[1]/div/div/div[4]/a")).click();
        Thread.sleep(2000);
        //5. Enter Username
        driver.findElement(By.id("username")).sendKeys("afeezadenekan@gmail.com");
        //6. Enter Password
        driver.findElement(By.id("password")).sendKeys("adenekan12");
        //7. Click on the Login
        driver.findElement(By.xpath("//*[@id=\"app-content-wrapper\"]/div[4]/section/section/aside/div[2]/div/form/div[3]")).click();
        Thread.sleep(10000);
        System.out.println("Successful Logim");
        // Get the title of the page
        String pageTitle = driver.getTitle();
        System.out.println("Page Title: " + pageTitle);

    }
    @Test(priority = 1)

    public void selectItem() throws InterruptedException {
        //8. Select Computer and Accessories Category
        driver.findElement(By.xpath("//*[@id=\"nav-bar-fix\"]/div[2]/div/a[2]")).click();
        Thread.sleep(10000);
        //9.Select Laptop Subcategory
        driver.findElement(By.xpath("//*[@id=\"mainContent\"]/section[3]/section/div/section/div[2]/div[2]/ul/li[2]/a/label/span")).click();
        //driver.findElement(By.xpath("//*[@id=\"mainContent\"]/section[3]/section/div/section/div[2]/div[2]/ul/li[2]/a/label/span")).click();
        Thread.sleep(10000);
        //10. Select the Apple Macbook option
        driver.findElement(By.xpath("//*[@id=\"mainContent\"]/section[3]/section/div/section/div[2]/div[2]/ul/li[4]/a/ul/li[1]/a/label/span")).click();
        Thread.sleep(30000);
        //11. Choose the Item to buy
        driver.findElement(By.xpath("//*[@id=\"mainContent\"]/section[3]/section/section/section/section/ul/li[1]/div/div/div[1]/a[1]/picture/img")).click();
        Thread.sleep(20000);
        //12. Buy item now
        driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div[4]/div[3]/div[1]/div[2]/div[2]/form/div[5]/div[1]/button")).click();
        Thread.sleep(20000);
        System.out.println("Item selected");
    }

    @Test(priority = 2)
    public void checkOutAndSelectAddAddress() throws InterruptedException {
        //13. Checkout to payment
        driver.findElement(By.linkText("Continue to Checkout")).click();
        Thread.sleep(5000);
        System.out.println("Check out to payment");
        // 7, select an address
        // click on change
        driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div/form/div/div[1]/section[1]/div/div/div[1]/div[2]/div/button")).click();
        //7b, click on "add delivery address"
        Thread.sleep(15000);
        driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div/form/div/div[1]/section[1]/div/div/div[2]/div[1]/div[2]/div[1]/div/button")).click();
        Thread.sleep(5000);
        //7c select address
        driver.findElement(By.xpath("//*[@id=\"app-content-wrapper\"]/div[2]/section/section/aside/div[2]/div/div/div[2]/div[1]/form/button")).click();
        Thread.sleep(8000);
        //7d click on use this address
        driver.findElement(By.xpath("//*[@id=\"app-content-wrapper\"]/div[2]/section/section/aside/div[3]/div/div/div/a")).click();
        Thread.sleep(10000);
        System.out.println("Address selected");


    }

    @Test (priority = 3)
    public void makePayment() throws InterruptedException {
        //8 continue to make payment
        // 8a click on pay now
        driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div/form/div/div[1]/section[2]/div/div[2]/div[1]/div[1]/span/input")).click();
        Thread.sleep(15000);
        //8b click on continue to make payment
        driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div/form/div/div[1]/section[2]/div/div[2]/div[3]/div[2]/div/button")).click();
        System.out.println("Continue to payment");
        Thread.sleep(15000);

    }
    @Test (priority = 4)
    public void selectCardMethod() throws InterruptedException {
        //9 select a card payment method
        //9a change from default to iframe
        WebElement paymethod = driver.findElement(By.tagName("iframe"));

        driver.switchTo().frame("kpg-frame-component");
        Thread.sleep(7000);
        System.out.println("Payment Method");
        //9b select card payment method
        WebElement cardpayment = driver.findElement(By.className("Card"));
        cardpayment.click();
        System.out.println("Select card method");
        Thread.sleep(5000);
    }

    @Test (priority = 5)
    public void inputCardDetails() throws InterruptedException {
        //10. input individual card details
        //10a input card number in its field
        WebElement carddigit = driver.findElement(By.id("card-number"));
        carddigit.sendKeys("123456789000");
        Thread.sleep(3000);

        //10b input date in its field
        WebElement datedigit = driver.findElement(By.id("expiry"));
        datedigit.sendKeys("1124");
        Thread.sleep(3000);

        //10c input CVV in its field
        WebElement cvvdigit = driver.findElement(By.id("cvv"));
        cvvdigit.sendKeys("456");
        Thread.sleep(5000);
        System.out.println("input card details");
    }

    @Test (priority = 6)
    public void errorMessage() throws InterruptedException {

        //11 print out the error message
        WebElement error = driver.findElement(By.id("card-number_unhappy"));
        System.out.println(error.getText());
        Thread.sleep(5000);
    }
    @Test (priority = 7)
    public void closeFrame() throws InterruptedException {
        //12 close the Iframe that displays input card details
        WebElement exitframe = driver.findElement(By.className("data-card__close"));
        exitframe.click();
        System.out.println("Exit payment method iframe");
        Thread.sleep(5000);

    }
    @Test (priority = 8)
    public void exitIFrame() throws InterruptedException {
        // Exit iFrame web
        driver.switchTo().defaultContent();
        Thread.sleep(5000);
        System.out.println("Restore default page");
    }
    @AfterTest
    public void quitBrowser() throws InterruptedException {
        //13. Quit your browser
        driver.quit();
        System.out.println("Quit browser");
    }

}
