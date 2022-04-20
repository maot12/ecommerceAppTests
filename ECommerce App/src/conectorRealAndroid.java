
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;

public class conectorRealAndroid {

	public static AndroidDriver capabilities(String device) throws MalformedURLException {
		// TODO Auto-generated method stub
		
		String rootDir = "src";
		String nameApk = "General-Store.apk";
		String nameDevice = "";
		String automationName = "uiautomator2";
		String url = "http://127.0.0.1:4723/wd/hub";
		
		/*-------------------------------------------------------------------------------*/
					
		File app = new File(new File(rootDir), nameApk);
		
		DesiredCapabilities cap = new DesiredCapabilities();
		
			if(device.equals("emulator")) {
				//Cambiar el siguiente string por el nombre del emulador
				nameDevice = "PruebaAppium";
				cap.setCapability(MobileCapabilityType.DEVICE_NAME,nameDevice);	
				
			} else if(device.equals("real")) {
				//Cambiar el siguiente string por el nombre del dispositivo
				nameDevice = "R58R44BP8NZ";
				cap.setCapability(MobileCapabilityType.DEVICE_NAME,nameDevice);	
			}
		
			cap.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
			cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 14);
			cap.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());		
			cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, automationName);
		
		AndroidDriver driver = new AndroidDriver(new URL(url),cap);
		
		return driver;
	
	}

}
