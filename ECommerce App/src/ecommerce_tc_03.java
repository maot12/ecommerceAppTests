
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;

/**
 * @author mortega2
 *
 */
@SuppressWarnings("deprecation")
public class ecommerce_tc_03 extends conectorRealAndroid{

	/**
	 * Shop the items in the app by scrolling to specific 
	 * Product and add to cart
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
						
			driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector()"
					+ ".resourceId(\"com.androidsample.generalstore:id/rvProductList\"))"
					+ ".scrollIntoView(new UiSelector()"
						+ ".textMatches(\"Jordan 6 Rings\")"
						+ ".instance(0))"));
			
			int count = driver.findElements(By.id("com.androidsample.generalstore:id/productName")).size();
			
			for(int i = 0; i<count; i++) {
				
				String text = driver.findElements(By.id("com.androidsample.generalstore:id/productName")).get(i).getText();
				
				if(text.equals("Jordan 6 Rings")) {
					
					driver.findElements(By.id("com.androidsample.generalstore:id/productAddCart")).get(i).click();
					break;
					
				}
				
			}
			
			driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
			
			 
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}

	}

}
