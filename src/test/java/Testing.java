import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class Testing {
    WebDriver driver;
    By price = By.xpath("/html/body/form/table/tbody/tr[4]/td[2]/span[1]/font/b");

    @BeforeSuite
    public void initDriver() {
        String pathToDriver = "D:\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", pathToDriver);
        driver = new ChromeDriver();
    }

    @BeforeTest
    public void initUrl() {
        driver.get("http://adam.goucher.ca/parkcalc/index.php");
    }

    @DataProvider(name = "test1")
    public Object[][] createData1() {
        return new Object[][]{
                {"10:00", "3/29/2019", "11:00", "3/29/2019"},
                {"13:00", "2/28/2019", "14:00", "2/28/2019"},
                {"14:00", "2/28/2019", "15:00", "2/28/2019"},
                {"13:30", "4/12/2019", "14:30", "4/12/2019"},
                {"16:00", "3/29/2019", "17:00", "3/29/2019"},
                {"17:00", "3/29/2019", "18:00", "3/29/2019"},
                {"18:00", "3/29/2019", "19:00", "3/29/2019"},
                {"19:00", "3/29/2019", "20:00", "3/29/2019"},
                {"20:00", "3/29/2019", "21:00", "3/29/2019"},
                {"21:00", "3/29/2019", "22:00", "3/29/2019"},
                {"22:00", "3/29/2019", "23:00", "3/29/2019"}
        };
    }

    @Test(dataProvider = "test1")
    public void validateLongTermParking_AMHours(String entryHour, String entryDate, String exitHour, String exitDate) {
        Main main = new Main(driver);
        main.populateAll_WhileAMHours(entryHour, entryDate, exitHour, exitDate);
        String t = driver.findElement(price).getText();
        Assert.assertEquals(t, "$ 2.00");
    }

    @Test(dataProvider = "test1")
    public void validateLongTermParking_PMHours(String entryHour, String entryDate, String exitHour, String exitDate) {
        Main main = new Main(driver);
        main.populateAll_WhilePMHours(entryHour, entryDate, exitHour, exitDate);
        String j = driver.findElement(price).getText();
        Assert.assertEquals(j, "$ 2.00");
    }

    @AfterSuite
    public void closeDriver() {
        driver.close();
    }
}
