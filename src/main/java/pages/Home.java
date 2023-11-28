package pages;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Home {
    ExtentTest test;
    WebDriver dv = null;

    public Home (WebDriver dv, ExtentTest test) {
        this.dv = dv;
        this.test = test;
    }

    public void gotoHome()  throws InterruptedException {
        dv.get("https://opencart.abstracta.us/index.php?route=common/home");
        Thread.sleep(1000);
        test.log(LogStatus.INFO, "Ir a Home page");
    }

    public void clickFirstProduct()  throws InterruptedException {
        dv.findElement(By.xpath("(//span[@class='hidden-xs hidden-sm hidden-md'][normalize-space()='Add to Cart'])[1]")).click();
        Thread.sleep(1000);
        test.log(LogStatus.INFO, "Click en primer producto ");
    }

    public void clickSecondProduct()  throws InterruptedException {
        dv.findElement(By.xpath("(//span[@class='hidden-xs hidden-sm hidden-md'][normalize-space()='Add to Cart'])[2]")).click();
        Thread.sleep(1000);
        test.log(LogStatus.INFO, "Click en primer producto ");
    }

}
