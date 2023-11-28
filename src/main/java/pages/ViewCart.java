package pages;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ViewCart {
    ExtentTest test;
    WebDriver dv = null;

    public ViewCart (WebDriver dv, ExtentTest test) {
        this.dv = dv;
        this.test = test;
    }

    public void clickonItems() throws InterruptedException {
        dv.findElement(By.xpath("//span[@id='cart-total'][1]")).click();
        Thread.sleep(1000);
        test.log(LogStatus.INFO, "Click en Items ");
    }

    public void clickonViewCart() throws InterruptedException {
        dv.findElement(By.xpath("//strong[normalize-space()='View Cart']")).click();
        Thread.sleep(1000);
        test.log(LogStatus.INFO, "Click en View Cart ");
    }


}
