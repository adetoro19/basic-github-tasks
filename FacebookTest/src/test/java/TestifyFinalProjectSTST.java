import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

    public class TestifyFinalProjectSTST {

        private WebDriver driver;

        @BeforeClass
        public void setUp() {
            // Set the path to your ChromeDriver executable
            System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
            driver = new ChromeDriver();
            driver.manage().window().maximize();
        }

        @Test
        public void orderProcessFlow() throws InterruptedException {
            // Step 1: Visit the Konga URL
            driver.get("https://www.konga.com");

            // Step 2: Sign in to Konga
            // Replace "your_username" and "your_password" with actual login credentials
            signIn("your_username", "your_password");

            // Step 3: Navigate through the categories
            selectCategory("Computers and Accessories");
            selectSubCategory("Laptop");
            selectProduct("Apple MacBooks");

            // Step 4: Add item to the cart
            addItemToCart();

            // Step 5: Select address
            selectAddress();

            // Step 6: Make payment
            continueToPayment();

            // Step 7: Select card payment method
            selectCardPayment();

            // Step 8: Input invalid card details
            inputInvalidCardDetails();

            // Step 9: Print out the error message
            printErrorMessage();

            // Step 10: Close the iFrame displaying the input card modal
            closeIFrame();

            // Step 11: Quit the browser
            quitBrowser();
        }

        // Implement the methods for each step

        private void signIn(String username, String password) {
            // Your implementation for signing in
        }

        private void selectCategory(String category) {
            // Your implementation for selecting a category
        }

        private void selectSubCategory(String subCategory) {
            // Your implementation for selecting a sub-category
        }

        private void selectProduct(String product) {
            // Your implementation for selecting a product
        }

        private void addItemToCart() {
            // Your implementation for adding an item to the cart
        }

        private void selectAddress() {
            // Your implementation for selecting an address
        }

        private void continueToPayment() {
            // Your implementation for continuing to payment
        }

        private void selectCardPayment() {
            // Your implementation for selecting card payment
        }

        private void inputInvalidCardDetails() {
            // Your implementation for inputting invalid card details
        }

        private void printErrorMessage() {
            // Your implementation for printing the error message
        }

        private void closeIFrame() {
            // Your implementation for closing the iFrame
        }

        private void quitBrowser() {
            // Close the browser
            driver.quit();
        }

        @AfterClass
        public void tearDown() {
            // Close the browser in case the test fails and browser is not closed
            if (driver != null) {
                driver.quit();
            }
        }
    }

