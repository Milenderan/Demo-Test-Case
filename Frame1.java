import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Frame1 {

	public static void main(String[] args) throws Exception {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://the-internet.herokuapp.com/windows");
		System.out.println("navigated to the website");
		Thread.sleep(2000);
		
		WebElement clicka = driver.findElement(By.xpath("//a[@href='/windows/new']"));
		clicka.click();
		System.out.println("clicked on clicka to open the new window");
		Thread.sleep(2000);
		
		String originalWindow = driver.getWindowHandle();
		
		 Set<String> allWindows = driver.getWindowHandles();
         for (String window : allWindows) {
             if (!window.equals(originalWindow)) {
                 driver.switchTo().window(window);
                 System.out.println("Switched to the new window.");
                 break;
             }
         }
         
         WebElement newWindowText = driver.findElement(By.tagName("h3"));
         if (newWindowText.getText().equals("New Window")) {
             System.out.println("Text verification passed! Found text: " + newWindowText.getText());
         } else {
             System.out.println("Text verification failed.");
         }

		driver.close();
		System.out.println("closed the new window");
		 driver.switchTo().window(originalWindow);
		 System.out.println("Switched back to the original window.");
		 
		  if (driver.getTitle().contains("The Internet")) {
              System.out.println("Successfully verified that the original window is active.");
          } else {
              System.out.println("Failed to verify the original window.");
          }
		  Thread.sleep(2000);
		  driver.quit();
          System.out.println("Browser closed.");
	}
}
