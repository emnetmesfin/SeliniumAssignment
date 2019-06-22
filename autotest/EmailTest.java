/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autotest;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 *
 * @author user
 */
public class EmailTest {
    
   public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException{
        System.setProperty("webdriver.chrome.driver", "C:\\Chrome\\chromedriver.exe");
        
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, 30);
        
        driver.get("https://gmail.com");
        driver.findElement(By.xpath(".//*[@id=\"identifierId\"]") ).sendKeys("emnetmes2@gmail.com");
        driver.manage().timeouts().implicitlyWait(11, TimeUnit.SECONDS);
        driver.findElement(By.xpath(".//*[@id=\"identifierNext\"]/span") ).click();
        driver.manage().timeouts().implicitlyWait(11, TimeUnit.SECONDS);


        
       WebElement Password = driver.findElement(By.xpath(".//*[@id=\"password\"]/div[1]/div/div[1]/input"));
        wait.until(ExpectedConditions.elementToBeClickable(Password));
        Password.sendKeys("0112841831eee");
        driver.findElement(By.xpath(".//*[@id=\"passwordNext\"]/span/span")).click();
        

System.out.println("-------------------");
        PrintWriter writer = new PrintWriter("c://Email/Unread.txt", "UTF-8");
     List<WebElement> mailsObj = driver.findElements(By.xpath("//*[@class='zF']"));
      for(int i=0; i<mailsObj.size();i++){
          String unread = mailsObj.get(i).getText();
          System.out.print(unread);
          writer.append(unread + '\n');
      }
   }
   
}
      
          


    

