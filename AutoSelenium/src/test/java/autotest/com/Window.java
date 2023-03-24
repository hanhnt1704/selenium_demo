package autotest.com;


import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class Window {
    WebDriver driver;
    @BeforeMethod
    public void Setup(){
        WebDriverManager.chromedriver().setup();
        driver =new ChromeDriver();
        driver.get("https://hasaki.vn/");
        // dong alert
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.id("onesignal-slidedown-allow-button")).click();
    }


    @Test
    public void TestSp() throws InterruptedException {

        driver.findElement(By.xpath("/html/body/div[3]/div[2]/div[3]/div[3]")).click();//he thong cua hang
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/div[3]/div[2]/div[3]/div[4]")).click();//lien he ho tro

        String MainWindow = driver.getWindowHandle();//Lưu lai window đầu tiên
        System.out.println("Main: "+MainWindow);

        Set<String> windows = driver.getWindowHandles();// lấy tất cả các cửa sổ đã mở
        for (String window : windows){
            System.out.println(window);
            if (!MainWindow.equalsIgnoreCase(window)){
                driver.switchTo().window(window);
                Thread.sleep(2000);
                System.out.println("Pass");
                Thread.sleep(2000);
                driver.close();
                Thread.sleep(2000);
            }
        }
        driver.quit();
    }
}
