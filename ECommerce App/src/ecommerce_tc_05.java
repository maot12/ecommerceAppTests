
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
						
			driver.findElements(By.xpath("//*[@text='ADD TO CART']")).get(0).click();
			driver.findElements(By.xpath("//*[@text='ADD TO CART']")).get(0).click();
			
			driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
			
			Thread.sleep(4000);
			
			/*
			 *  Siguiente pantalla
			 *   */
			
			String amount1 = driver.findElements(By.id("com.androidsample.generalstore:id/productPrice")).get(0).getText();
			amount1 = amount1.substring(1);
			Double amount1value = Double.parseDouble(amount1);
			
			String amount2 = driver.findElements(By.id("com.androidsample.generalstore:id/productPrice")).get(1).getText();
			amount2 = amount2.substring(1);
			Double amount2value = Double.parseDouble(amount2);
			
			Double sumOfProduct = amount1value + amount2value;
			
			System.out.println(sumOfProduct);
			
			String total = driver.findElements(By.id("com.androidsample.generalstore:id/totalAmountLbl")).get(0).getText();
			total = total.substring(1);
			Double totalValue = Double.parseDouble(total);
			System.out.println(totalValue);
			
			Assert.assertEquals(sumOfProduct, totalValue);
			
			
			
			 
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}

	}

}
