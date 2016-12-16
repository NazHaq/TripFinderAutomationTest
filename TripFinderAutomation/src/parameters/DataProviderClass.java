/**
 * 
 */
/**
 * @author nazmul.haque
 *
 */
package parameters;
import org.testng.annotations.DataProvider;

public class DataProviderClass {

        @DataProvider(name="SearchProvider")

        public static Object[][] getDataFromDataprovider(){

            return new Object[][] {

                    { "North Sydney Station", "Town Hall Station" }


                };
        	}
        
        }