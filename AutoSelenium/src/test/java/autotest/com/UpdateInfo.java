package autotest.com;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.Select;
import java.util.concurrent.TimeUnit;

public class UpdateInfo {
    WebDriver driver;

    @BeforeMethod
    public void Setup()throws InterruptedException{
        WebDriverManager.chromedriver().setup();
        driver =new ChromeDriver();
        driver.get("https://hasaki.vn/");

        // dong alert
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.id("onesignal-slidedown-allow-button")).click();

        // chuan bi login
        driver.findElement(By.xpath("/html/body/div[3]/div[2]/div[3]/div[1]")).click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.findElement(By.id("hskLoginButton")).click();

        //login
        WebDriverWait wait = new WebDriverWait(driver, 20); //20 seconds
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("form-head-login")));
        driver.findElement(By.id("username")).sendKeys("nthanh170420@gmail.com");
        driver.findElement(By.id("password")).sendKeys("hanh123456");
        Boolean checkbox = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[2]/div/div/div/div[2]/form/div[5]/label/input")).isSelected();
        if(checkbox == false){ // kiểm tra checkbox
            driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[2]/div/div/div/div[2]/form/div[5]/label/input")).click();
        }
        //Bo checkbox
        driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[2]/div/div/div/div[2]/form/div[5]/label/input")).click();
        driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[2]/div/div/div/div[2]/form/button")).click();

        //Đi đến trang acc
        driver.findElement(By.xpath("/html/body/div[3]/div[2]/div[3]/div[1]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/div[3]/div[2]/div[3]/div[1]/div[3]/div/div[1]")).click();
        Thread.sleep(2000);
        // đi đến chỉnh sửa thông tin

        driver.findElement(By.xpath("/html/body/div[6]/div[1]/div/div/div/div[2]/div[1]/div[2]/div/div[1]/div/a")).click();
    }
    @Test
    public void TestSetInfo() throws InterruptedException{
        // cập nhật tên mới
        WebElement fullname = driver.findElement(By.id("fullName"));
        fullname.clear();
        fullname.sendKeys("hanh nt");

        //gender
         driver.findElement(By.xpath("/html/body/div[6]/div[1]/div/div/div/div[2]/div/div/div[1]/div/form/div[2]/div/div[2]/div[3]/div/label[2]")).click();

        // chon ngay
        Select select1 = new Select(driver.findElement(By.id("popup-date")));
        select1.selectByVisibleText("1");
        //chon thang
        Select select2 = new Select(driver.findElement(By.id("popup-month")));
        select2.selectByIndex(10);
        // chon nam
        Select select3 = new Select(driver.findElement(By.id("popup-year")));
        select3.selectByValue("2000");
        //Update
        //driver.findElement(By.xpath("//*[@id=\"form-account\"]/div[2]/div/div[2]/div[9]/button")).click();
        Thread.sleep(2000);

    }

@AfterMethod
    public void Teardown(){
    driver.quit();
}
}


