/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autotest;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 *
 * @author user
 */
public class PortalLogin {
    
    public static void main(String[] args) throws FileNotFoundException, InterruptedException{
        System.setProperty("webdriver.chrome.driver", "C:\\Chrome\\chromedriver.exe");
        
        WebDriver driver = new ChromeDriver();
        
        driver.get("http://portal.aait.edu.et/");
       driver.findElement(By.xpath(".//*[@id=\"UserName\"]")).sendKeys("ATR/7952/09");
       driver.findElement(By.xpath(".//*[@id=\"Password\"]")).sendKeys("1910");
       driver.findElement(By.xpath("//*[@id=\"home\"]/div[2]/div[2]/form/div[4]/div/button")).click();
        
       // grade & results
       
       driver.navigate().to("https://portal.aait.edu.et/Grade/GradeReport");
       
       
       String grade = driver.findElement(By.xpath("./html/body/div[2]/div/div[2]/div[1]/div/div/table")).getText();

        //System.out.println(grade);
        
        try{
            PrintWriter writer = new PrintWriter("C:\\gradeReportFile\\grade.txt", "UTF-8");
            writer.write(grade);
            writer.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        Thread.sleep(100000);
        driver.close();
        driver.quit();
    }
    
}
