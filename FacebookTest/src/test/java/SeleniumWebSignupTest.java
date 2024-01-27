import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SeleniumWebSignupTest {
    //Import Selenium WebDriver
    private WebDriver driver;
    @BeforeTest
    public void start() throws InterruptedException {
        //locate where the chromedriver is
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver-win64/chromedriver.exe");
        //1. Open your chrome browser
        driver = new ChromeDriver();
        //2. Input your Selenium Demo Page URL (https://selenium-blog.herokuapp.com)
        driver.get("https://selenium-blog.herokuapp.com");
    }
    @Test(priority = 0)
    public void verifyCorrectWebpage() throws InterruptedException
    {
       // Test1. Verify the user input the right url and his on the right webpage
        if(driver.getCurrentUrl().contains("https://selenium-blog.herokuapp.com"))
            //Passes
            System.out.println("Correct Webpage");
         else
            //Fails
            System.out.println("Wrong Webpage");
         Thread.sleep(5000);
        //3. Maximize the Homepage
        driver.manage().window().maximize();
        //4. Click on Signup button to open the Signup page
        driver.findElement(By.xpath("/html/body/div[2]/div/a[2]")).click();
        Thread.sleep(5000);
    }
    @Test(priority = 1)

    public void SignUp() throws InterruptedException {

            //Test2.  Verify that user is successfully signed up when valid details are used
            //5. Input your username on the username field
            driver.findElement(By.id("user_username")).sendKeys("ade13");
            //6. Locate the email address field and Input an email address on the email field
            driver.findElement(By.id("user_email")).sendKeys("ade13@mailinator.com");
            //7.  Locate the password field and Input your password on the password field
            driver.findElement(By.id("user_password")).sendKeys("testify");
            //8. Click on the signup button
            driver.findElement(By.id("submit")).click();
            Thread.sleep(5000);
        }
    @Test (priority = 2)
    public void click() throws InterruptedException {
        //9. Click on User1 item on the listpage
        driver.findElement(By.xpath("/html/body/div[2]/div[1]/ul/div/div/li[1]/a")).click();

    }
    @Test (priority = 3)
    public void verifyItem() throws InterruptedException {
        //Test3. Search for an item (Using Python with Selenium) and confirm it is present
        driver.findElement(By.xpath("/html/body/div[2]/div[1]/div/div/div[1]/a")).click();
        String expectedPageUrl = "/users/1";
        String actualPageUrl = driver.getCurrentUrl();
        if(actualPageUrl.contains(expectedPageUrl))
        //Pass
        System.out.println("Correct User1Page");
        else
        //Fail
        System.out.println("Wrong User1Page");
        Thread.sleep(5000);}
    @Test (priority = 4)
    public void logoutSucessfully() throws InterruptedException {
        //11. Click on Logout
        driver.findElement(By.xpath("//*[@id=\"bs-example-navbar-collapse-1\"]/ul/li[3]/a")).click();
        //Test4: Verify that when the user logout, he is directed back to the homepage
            String actualTitle = driver.getTitle();
            String expectedTitle = "AlphaBlog";
            if(actualTitle.contains(expectedTitle))
            //Pass
            System.out.println("Correct Title");
            else
            //Fail
           System.out.println("Wrong Title");
        }
    @Test (priority = 5)
    public void negativeSignup() throws InterruptedException {
        //Click on Signup button to open the Signup page

        driver.findElement(By.xpath("/html/body/div[2]/div/a[2]")).click();
        Thread.sleep(5000);
        //Test5. Verify that user cannot signup with username less than 3 characters
        // Input your username on the username field
        driver.findElement(By.id("user_username")).sendKeys("ad");
        //6. Locate the email address field and Input an email address on the email field
        driver.findElement(By.id("user_email")).sendKeys("ade13@mailinator.com");
        //7.  Locate the password field and Input your password on the username field
        driver.findElement(By.id("user_password")).sendKeys("admin");
        //8. Click on the signup button
        driver.findElement(By.id("submit")).click();
        Thread.sleep(5000);}
    @Test(priority = 6)
    public void navigateToHomePage() {
        // Test6: Navigate back to the homepage
        driver.navigate().to("https://selenium-blog.herokuapp.com");
        String expectedUrl = "https://selenium-blog.herokuapp.com";
        String actualUrl = driver.getCurrentUrl();
        if (actualUrl.equals(expectedUrl))
            System.out.println("Successfully navigated to the homepage");
        else
            System.out.println("Failed to navigate to the homepage");
    }
    @Test(priority = 7)
    public void searchForItem() {
        // Test7: Search for an item on the homepage
        driver.findElement(By.id("search")).sendKeys("Selenium");
        driver.findElement(By.id("search-icon-legacy")).click();
        // Add verification logic as per your application behavior
        System.out.println("Search for item test completed");
    }@Test(priority = 8)
    public void invalidLogin() throws InterruptedException {
        // Test8: Attempt to log in with invalid credentials
        driver.findElement(By.id("login")).click();
        driver.findElement(By.id("username")).sendKeys("invalidUser");
        driver.findElement(By.id("password")).sendKeys("invalidPassword");
        driver.findElement(By.id("login-button")).click();
        Thread.sleep(3000);
        // Add verification logic as per your application behavior
        System.out.println("Invalid login test completed");
    }
    @Test(priority = 9)
    public void navigateToAboutPage() {
        // Test9: Navigate to the About page
        driver.findElement(By.linkText("About")).click();
        String expectedTitle = "About Selenium Blog";
        String actualTitle = driver.getTitle();
        if (actualTitle.contains(expectedTitle))
            System.out.println("Successfully navigated to the About page");
        else
            System.out.println("Failed to navigate to the About page");
    }
    @AfterTest
    public void closeBrowser() throws InterruptedException {
        //Quit the browser
        driver.quit();
    }}
