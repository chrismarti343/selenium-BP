package pages;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Checkout {


    ExtentTest test;
    WebDriver dv = null;

    public Checkout (WebDriver dv, ExtentTest test) {
        this.dv = dv;
        this.test = test;
    }

    public void clickonCheckout() throws InterruptedException {
        dv.findElement(By.xpath("//a[@class='btn btn-primary']")).click();
        Thread.sleep(1000);
        test.log(LogStatus.INFO, "Click en Chechout ");
    }

    public void clickonGuest() throws InterruptedException {
        dv.findElement(By.xpath("//input[@value='guest']")).click();
        Thread.sleep(1000);
        test.log(LogStatus.INFO, "Click en Guest ");
    }

    public void clickonContinuar() throws InterruptedException {
        dv.findElement(By.xpath("//input[@id='button-account']")).click();
        Thread.sleep(1000);
        test.log(LogStatus.INFO, "Click en Continuar ");

    }

    public void setName(String name) throws InterruptedException {
        dv.findElement(By.id("input-payment-firstname")).sendKeys(name);
        Thread.sleep(1000);
        test.log(LogStatus.INFO, "Agregar Nombre ");
    }

    public void setLastName(String lastName) throws InterruptedException {
        dv.findElement(By.id("input-payment-lastname")).sendKeys(lastName);
        Thread.sleep(1000);
        test.log(LogStatus.INFO, "Agregar Nombre ");
    }

    public void setEmail(String email) throws InterruptedException {
        dv.findElement(By.id("input-payment-email")).sendKeys(email);
        Thread.sleep(1000);
        test.log(LogStatus.INFO, "Agregar email ");
    }
    public void setPhone(String phone) throws InterruptedException {
        dv.findElement(By.id("input-payment-telephone")).sendKeys(phone);
        Thread.sleep(1000);
        test.log(LogStatus.INFO, "Agregar telefono ");
    }

    public void setAddress(String address) throws InterruptedException {
        dv.findElement(By.id("input-payment-address-1")).sendKeys(address);
        Thread.sleep(1000);
        test.log(LogStatus.INFO, "Agregar direccion ");
    }

    public void setCity(String city) throws InterruptedException {
        dv.findElement(By.id("input-payment-city")).sendKeys(city);
        Thread.sleep(1000);
        test.log(LogStatus.INFO, "Agregar ciudad ");
    }

    public void setPost(String postCode) throws InterruptedException {
        dv.findElement(By.id("input-payment-postcode")).sendKeys(postCode);
        Thread.sleep(1000);
        test.log(LogStatus.INFO, "Agregar codigo postal");
    }

    public void setCountry() throws InterruptedException {
        dv.findElement(By.id("input-payment-country")).click();
        Thread.sleep(1000);
        dv.findElement(By.xpath("//option[@value='62']")).click();
        Thread.sleep(1000);
        test.log(LogStatus.INFO, "Agregar pais");
    }

    public void setState() throws InterruptedException {
        dv.findElement(By.id("input-payment-zone")).click();
        Thread.sleep(1000);
        dv.findElement(By.xpath("//option[@value='997']")).click();
        Thread.sleep(1000);
        test.log(LogStatus.INFO, "Agregar estado");
    }

    public void clickonContinuarCheckout() throws InterruptedException {
        dv.findElement(By.id("button-guest")).click();
        Thread.sleep(1000);
        test.log(LogStatus.INFO, "Click en Continuar");
    }

    public void clickonNextStepShipping() throws InterruptedException {
        dv.findElement(By.id("button-shipping-method")).click();
        Thread.sleep(1000);
        test.log(LogStatus.INFO, "Click en Continuar siguiente");

    }

    public void acceptConditions() throws InterruptedException{
        dv.findElement(By.xpath("//input[@name='agree']")).click();
        Thread.sleep(1000);
        test.log(LogStatus.INFO, "Click en Aceptar Condiciones");
    }

    public void clickonNextStepPayment() throws InterruptedException{
        dv.findElement(By.id("button-payment-method")).click();
        Thread.sleep(1000);
        test.log(LogStatus.INFO, "Click en Continuar siguiente");
    }

    public void confirmOrder() throws InterruptedException{
        dv.findElement(By.id("button-confirm")).click();
        Thread.sleep(1000);
        test.log(LogStatus.INFO, "Click en confirmar orden");
    }
    public void verify(String text, int time) throws InterruptedException {

        WebDriverWait wait = new WebDriverWait(dv, Duration.ofSeconds(time));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h1[normalize-space()='"+text+"']")));
        Thread.sleep(1000);
        WebElement errorElement1 = dv.findElement(By.xpath("//h1[normalize-space()='"+text+"']"));
        String textValue = errorElement1.getText();
        Assert.assertEquals(text,textValue);
        test.log(LogStatus.INFO, "Verificar texto: "+text);
    }




}
