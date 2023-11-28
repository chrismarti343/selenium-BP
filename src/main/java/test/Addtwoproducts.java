package test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.ExtentFactory;
import pages.*;

public class Addtwoproducts {

    WebDriver dv;
    ExtentReports report;
    ExtentTest test;

    String nameTest;
    Home homepage;
    Checkout checkoutpage;

    ViewCart viewCart;
    String firstName = "Guest";
    String lastName = "Checkout";
    String email = "testing@gmail.com";
    String phone = "0923456783";
    String address = "Simon Bolivar #4";
    String city = "Quito";
    String postCode = "189503";


    @BeforeMethod
    public void beforeMethod() throws InterruptedException {

        report = ExtentFactory.getInstance();
        nameTest = "Reto practico Banco de Pinchincha 1";
        test = report.startTest(nameTest,"Descripcion: 1. Agregar dos productos al carrito 2. Visualizar el carrito 3. Completar el “Checkout” como invitado: “Guest Checkout” 4. Finalizar la compra hasta la confirmación: “Your order has been placed!” ");
        ChromeOptions options = new ChromeOptions();
//		options.addArguments("--headless=new");
        options.addArguments("ignore-certificate-errors");
        options.addArguments("--remote-allow-origins=*");
        dv = new ChromeDriver(options);
        homepage = new Home(dv, test);
        viewCart = new ViewCart(dv, test);
        checkoutpage = new Checkout(dv, test);
        dv.manage().window().maximize();
    }

    @Test
    public void testCreatePerfil() throws Exception {
        homepage.gotoHome();
        homepage.clickFirstProduct();
        homepage.clickSecondProduct();
        viewCart.clickonItems();
        viewCart.clickonViewCart();
        checkoutpage.clickonCheckout();
        checkoutpage.clickonGuest();
        checkoutpage.clickonContinuar();
        checkoutpage.setName(firstName);
        checkoutpage.setLastName(lastName);
        checkoutpage.setEmail(email);
        checkoutpage.setPhone(phone);
        checkoutpage.setAddress(address);
        checkoutpage.setCity(city);
        checkoutpage.setPost(postCode);
        checkoutpage.setCountry();
        checkoutpage.setState();
        checkoutpage.clickonContinuarCheckout();
        checkoutpage.clickonNextStepShipping();
        checkoutpage.acceptConditions();
        checkoutpage.clickonNextStepPayment();
        checkoutpage.confirmOrder();
        String verifyOrderText= "Your order has been placed!";
        checkoutpage.verify(verifyOrderText, 10);
        test.log(LogStatus.PASS, nameTest);

    }

    @AfterMethod
    public void tearDown(ITestResult result) throws Exception {

        if(ITestResult.FAILURE==result.getStatus())
        {
            test.log(LogStatus.FAIL, nameTest);

        } else {
            System.out.println("Successful: " + result.getMethod().getMethodName());
        }

        dv.quit();
        report.endTest(test);
        report.flush();


    }

}
