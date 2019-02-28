import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Main {

    static WebDriver driver;
    By dropdown = By.id("Lot");
    By calculate = By.xpath("/html/body/form/input[2]");
    By entryTime = By.id("EntryTime");
    By entryDate = By.id("EntryDate");
    By exitTime = By.id("ExitTime");
    By exitDate = By.id("ExitDate");
    By entryRadio = By.xpath("/html/body/form/table/tbody/tr[2]/td[2]/font/input[3]");
    By exitRadio = By.xpath("/html/body/form/table/tbody/tr[3]/td[2]/font/input[3]");


    public Main(WebDriver driver) {
        this.driver = driver;
    }

    public void populateEntryTime(String time) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(entryTime));
        driver.findElement(entryTime).click();
        driver.findElement(entryTime).clear();
        driver.findElement(entryTime).sendKeys(time);
    }

    public void populateEntryDate(String date) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(entryDate));
        driver.findElement(entryDate).click();
        driver.findElement(entryDate).clear();
        driver.findElement(entryDate).sendKeys(date);
    }

    public void populateExitTime(String exittime) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(exitTime));
        driver.findElement(exitTime).click();
        driver.findElement(exitTime).clear();
        driver.findElement(exitTime).sendKeys(exittime);
    }

    public void populateExitDate(String exitdate) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(exitDate));
        driver.findElement(exitDate).click();
        driver.findElement(exitDate).clear();
        driver.findElement(exitDate).sendKeys(exitdate);
    }

    public void selectParking() {
        Select select = new Select(driver.findElement(dropdown));
        select.selectByValue("LTS");
    }

    public void selectEntryPM() {
        driver.findElement(entryRadio).click();
    }

    public void selectExitPM() {
        driver.findElement(exitRadio).click();
    }

    public void clickCalculate() {
        driver.findElement(calculate).click();
    }

    public void populateAll_WhilePMHours(String time, String date, String exittime, String exitdate) {
        populateEntryDate(date);
        populateEntryTime(time);
        populateExitDate(exitdate);
        populateExitTime(exittime);
        selectParking();
        selectEntryPM();
        selectExitPM();
        clickCalculate();
    }

    public void populateAll_WhileAMHours(String time, String date, String exittime, String exitdate) {
        populateEntryDate(date);
        populateEntryTime(time);
        populateExitDate(exitdate);
        populateExitTime(exittime);
        selectParking();
        clickCalculate();
    }
}
