
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.Assert;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;

/**
 * @author mortega2
 *
 */
@SuppressWarnings("deprecation")
public class ecommerce_tc_02 extends conectorRealAndroid{

	/**
	 * Fill the form details and verify Toast error messages
	 * displayed appropriately for wrong inputs
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String pais = "Argentina";
		
		String scrollable = "new UiScrollable(new UiSelector())"
				+ ".scrollIntoView(text(\""+pais+"\"));";
		
		try {
			AndroidDriver driver = capabilities("emulator");
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
			/*
			 * driver.findElement(By.id("com.androidsample.generalstore:id/nameField"))
			 * .sendKeys("Hello");
			 * 
			 * driver.hideKeyboard();
			 */
			
			driver.findElement(By.id("com.androidsample.generalstore:id/radioFemale"))
			.click();
			
			driver.findElement(By.id("com.androidsample.generalstore:id/spinnerCountry"))
			.click();
			
			driver.findElement(MobileBy.AndroidUIAutomator(scrollable)).click();
			
			driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop"))
			.click();
			
			String toastMessage = driver.findElement(By.xpath("//android.widget.Toast[1]")).getAttribute("name");
			
			System.out.println(toastMessage);
			
			//La siguiente línea comprueba que el mensaje deseado corresponde al mostrado			
			Assert.assertEquals("Please enter your name", toastMessage);
			
			 
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}

	}

}
