import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Frame2 {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://the-internet.herokuapp.com/nested_frames");
		System.out.println("navigated the nested frame page");
		Thread.sleep(2000);
		
		driver.switchTo().frame(driver.findElement(By.name("frame-top")));
		System.out.println("switched out to top frame");
		
		
		 List<WebElement> topFrames = driver.findElements(By.tagName("frame"));
		 if (topFrames.size() == 3) {
             System.out.println("Verified: There are three frames in the top frame.");
         } else {
             System.out.println("Verification failed: Expected 3 frames but found " + topFrames.size());
         }
		 
		 driver.switchTo().frame(driver.findElement(By.name("frame-left")));
         String leftText = driver.findElement(By.xpath("//body")).getText();
         if (leftText.equals("LEFT")) {
             System.out.println("Verified: Left frame contains text 'LEFT'.");
         } else {
             System.out.println("Verification failed: Left frame text is '" + leftText + "'.");
         }
         driver.switchTo().parentFrame();
         System.out.println("Switched back to the top frame.");

         // Step 7: Switch to the middle frame and verify its text
         driver.switchTo().frame(driver.findElement(By.name("frame-middle")));
         String middleText = driver.findElement(By.cssSelector("div")).getText();
         if (middleText.equals("MIDDLE")) {
             System.out.println("Verified: Middle frame contains text 'MIDDLE'.");
         } else {
             System.out.println("Verification failed: Middle frame text is '" + middleText + "'.");
         }
         
         driver.switchTo().parentFrame();
         System.out.println("Switched back to the top frame.");

         // Step 9: Switch to the right frame and verify its text
         driver.switchTo().frame(driver.findElement(By.name("frame-right")));
         String rightText = driver.findElement(By.xpath("//body")).getText();
         if (rightText.equals("RIGHT")) {
             System.out.println("Verified: Right frame contains text 'RIGHT'.");
         } else {
             System.out.println("Verification failed: Right frame text is '" + rightText + "'.");
         }
         
         driver.switchTo().parentFrame();
         System.out.println("Switched back to the top frame.");

         driver.quit();
         System.out.println("Browser closed.");
	}
}
