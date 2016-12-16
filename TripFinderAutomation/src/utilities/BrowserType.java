
package utilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.Constant;

public class BrowserType {

    public static WebDriver Execute() {

         // Set Browser
         WebDriver driver = null;

        	 System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\ChromeDriver\\chromedriver.exe");
             driver = new ChromeDriver();        
          // Navigate to URL
          driver.get(Constant.URL);
          driver.manage().window().maximize();

          return driver;

    }
    

}