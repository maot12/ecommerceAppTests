
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
public class ecommerce_tc_05 extends conectorRealAndroid{

	/**
	 * Validate the total Amount displayed in the chekout page matches 
	 * with sum of product amounts selected for shopping
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		
		String pais = "Argentina";
		
		String scrollable = "new UiScrollable(new UiSelector())"
				+ ".scrollIntoView(text(\""+pais+"\"));";
		
		try {
			AndroidDriver driver = capabilities("emulator");
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
			driver.findElement(By.id("com.androidsample.generalstore:id/nameField"))
			.sendKeys("Hello");
			
			driver.hideKeyboard();
			
			driver.findElement(By.id("com.androidsample.generalstore:id/radioFemale"))
			.click();
			
			driver.findElement(By.id("com.androidsample.generalstore:id/spinnerCountry"))
			.click();
			
			driver.findElement(MobileBy.AndroidUIAutomator(scrollable)).click();
			
			driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop"))
			.click();
			
			/*
			 *  Siguiente pantalla
			 *   */
						
			driver.findElements(By.xpath("//*[@text='ADD TO CART']"))
			.get(0)
			.click();
			driver.findElements(By.xpath("//*[@text='ADD TO CART']"))
			.get(0)
			.click();
			
			driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
			
			Thread.sleep(4000);
			
			/*
			 *  Siguiente pantalla
			 *   */
			double productValueClean = 0;
			for(int i=0;i<driver.findElements(By.id("com.androidsample.generalstore:id/productPrice")).size();i++) {
				
				String valueString = driver.findElements(By.id("com.androidsample.generalstore:id/productPrice"))
						.get(i)
						.getText();
				productValueClean += getDoubleClean(valueString);
				
			}
			
			System.out.println(productValueClean);
			
			String total = driver.findElements(By.id("com.androidsample.generalstore:id/totalAmountLbl"))
					.get(0)
					.getText();
			double totalValue = getDoubleClean(total);
			System.out.println(totalValue);
			
			Assert.assertEquals(productValueClean, totalValue);
			
			 
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}

	}
	
	public static double getDoubleClean(String value) {
		
		value = value.substring(1);
		double valueDouble = Double.parseDouble(value);
		
		return valueDouble;
		
	}
}
