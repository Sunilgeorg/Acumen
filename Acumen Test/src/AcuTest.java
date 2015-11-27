

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

 

public class AcuTest {

	 public static WebDriver driver = new FirefoxDriver();
	
	public static void main(String[] args) {
		
		

			

			//Launching the website for acumen

			driver.get("http://www.acumenci.com/");

			driver.manage().window().maximize();

			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

			

			//Clicking the Contact Us Link
		

			driver.findElement(By.xpath("//li[@id='menu-item-497']/a")).click();

			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			
			//Verifying the page title
			
			if (driver.getTitle().contains("Contact Us - Acumenci"))
			{
				System.out.println("Test Passed for Contact Us Page title.");
			}
			else 
			{
				System.out.println("Test failed for Contact Us Page title.");
			}

			

			//Verifying the presence of TW9 1HY post code

			String address = driver.findElement(By.xpath("//div[@class='nine column ']/p")).getText();

			
			if(address.contains("TW9 1HY"))

			{

				System.out.println("Address test passed.");

			}
			else 
			{
				System.out.println("Address test failed.");
			}
			
			//Test Data
			String[] inputString = new String[5];
			inputString[0]= "Sunil@test.com";
			inputString[1] = "Some Description";
			
           
			FieldVal(inputString[0],inputString[1]);
			
	}

	    //Test Method for Submission Test
		  static void FieldVal(String fieldString1,String fieldString2)	{		
           String fieldString3;
           fieldString3 = fieldString1;
           //Adding email and Message
         
			driver.findElement(By.xpath("//form[@class='wpcf7-form']/p[5]/span/input")).sendKeys(fieldString3);
			fieldString3 = fieldString2;
			driver.findElement(By.xpath("//form[@class='wpcf7-form']/p[7]/span/textarea")).sendKeys(fieldString3);
			/* WebElement slist = driver.findElement(By.xpath("//form[@class='wpcf7-form']/p"));
	          List<WebElement> slist2 = slist.findElements(By.tagName("p"));
	          System.out.println(slist2.size());*/
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			
			//Clicking Send

			driver.findElement(By.xpath("//input[@class='wpcf7-form-control wpcf7-submit']")).click();

			
            // Checking the required fields
			List<WebElement> elements= driver.findElements(By.xpath("//form[@class='wpcf7-form invalid']/p"));

             

			int count = 0;

			String[] mandatoryFields=new String[5];	
			

			for(int i=1;i<elements.size();i++)

				{



				String validationMessage = driver.findElement(By.xpath("//form[@class='wpcf7-form invalid']/p["+i+"]")).getText();

				

 

					if(validationMessage.contains("Please fill the required field"))

						{

						count++;

						

						String field=validationMessage.substring(0, validationMessage.indexOf("("));

						mandatoryFields[i-1]=field;
						
						
						

						}

						

				}
			//Check for the number of validation errors
			if (count ==3)
			{
				System.out.println("Submission Test Passed");
			}
			else 
			{
				System.out.println("Submission Test Failed");
			}
			System.out.println("User Need to Fill " +count+ " Mandatory Fields ");
			

			for(int j=0;j<mandatoryFields.length;j++)

			{
				if(mandatoryFields[j] != null)
				{
				System.out.println("Required fields" + mandatoryFields[j]);
				}
				
			}
		

			// Closing the current Firefox Browser session

			

			//driver.quit();

}}

		

