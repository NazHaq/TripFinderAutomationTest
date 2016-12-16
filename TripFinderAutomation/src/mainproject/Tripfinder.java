

/*
 * This an initial trip finding automation Selenium Webdriver-TestNG test framework.
 * This test use Selenium Webdriver-TestNG frame work to run test module and create html reports
 * This test also uses @Dataprovider parameterize methods to pass parameters and can be run tests for multiple iterations
 */
package mainproject;
import org.testng.annotations.Test;
import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.*;
import utilities.BrowserType;
import utilities.Constant;
import parameters.DataProviderClass;


public class Tripfinder {
	
	public WebDriver driver;
	public String expected =null;	
	public String actual =null;
	WebElement element=null;
//Launch the test URL    
@BeforeTest	
public void setUp(){
	   driver = BrowserType.Execute();
}
//Verify the Home page details
@Test(priority=0)
  public void verifyHomepageTitle() {
    System.out.println("Starting test " + new Object(){}.getClass().getEnclosingMethod().getName());
    expected = Constant.pageTitle;
    actual = driver.getTitle();
    Assert.assertEquals(expected, actual);
  }
//Search and verify the trip results table
@Test(dataProvider="SearchProvider",dataProviderClass=DataProviderClass.class, priority=1)
public void searchTrip(String From,String To) throws InterruptedException
{
    System.out.println("Starting test " + new Object(){}.getClass().getEnclosingMethod().getName());
    driver.findElement(By.id(Constant.searchFrom)).sendKeys(From);
    Thread.sleep(2000);
    // Select item from live suggestion
    driver.findElement(By.xpath(Constant.selectFromLiveSuggestion)).click();
    Thread.sleep(2000);
    driver.findElement(By.id(Constant.searchTo)).sendKeys(To);
    Thread.sleep(2000);
    // Select item from live suggestion
    driver.findElement(By.xpath(Constant.selectToLiveSuggestion)).click();
    Thread.sleep(2000);
    driver.findElement(By.id(Constant.goButton)).click();

    System.out.println("Welcome, you are travelling ->"+From+" to->"+To);
    // Verify whether the results table apear after search. Other elements of the search result table can be verified too.	
    WebElement result= driver.findElement(By.id(Constant.resultSection));
    if(result!=null)
    {
    	Assert.assertTrue(true, "Results Found");
    }
    else
    {
    	Assert.assertTrue(false, "No trip found");
    }
}
// Close the browser once all the tests being covered.
@AfterTest
public void closeBrowser()
{
	 driver.quit();
}

}
