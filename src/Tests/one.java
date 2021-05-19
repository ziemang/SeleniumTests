package Tests;

import PageObjects.main;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.security.PublicKey;

public class one {

   @Test
   public void simpleGoogleTest() {
      WebDriver driver = chromeDriver();
      driver.get("https://google.com");
      System.out.println("yay");
      driver.close();
   }

   @Test
   public void searchYoutubeDogs(){
      //Initialize chromedriver
      WebDriver driver = chromeDriver();

      //Go to Youtube
      openURL(driver, "https://www.youtube.com");

      //Search for Dog videos
      main Youtube = new main(driver);
      Youtube.youtubeSearchFor("Dogs");

      //Click search button
      Youtube.youtubeClickSearch();

      //Sleep
      sleepPageTwoSeconds();

      //Assert title is what was searched for
      String title = Youtube.getTitle();
      Assert.assertTrue(title.equals("Dogs - YouTube"));

      //Close webpage
      Youtube.closePage();
   }

   @Test
   public void searchAmazonHDD(){
      //Initialize chromedriver
      WebDriver driver = chromeDriver();

      //Go to Amazon
      openURL(driver, "https://www.amazon.com");

      //Search for HDDs
      main Amazon = new main(driver);
      Amazon.amazonSearchFor("Hard Drive");

      //Click search button
      Amazon.amazonClickSearch();

      //Assert title is what was searched for
      String title = Amazon.getTitle();
      Assert.assertTrue(title.equals("Amazon.com : Hard Drive"));

      //Sleep
      sleepPageTwoSeconds();

      //Click on HDD link
      Amazon.amazonSelection();

      //Sleep
      sleepPageTwoSeconds();

      //Make sure link opens correctly
      String all = Amazon.getAllTextOnPage();
      Assert.assertTrue(all.contains("Seagate BarraCuda 2TB Internal Hard Drive HDD – 3.5 Inch SATA 6Gb/s 7200 RPM 256MB Cache 3.5-Inch – Frustration Free Packaging (ST2000DM008)"));

      //Close webpage
      Amazon.closePage();
   }

   @Test
   public void twitchStreaming(){
      //Initialize chromedriver
      WebDriver driver = chromeDriver();

      //Go to Twitch
      openURL(driver, "https://www.twitch.tv");

      //Click browse
      main Twitch = new main(driver);
      Twitch.twitchBrowseSelect();

      sleepPageTwoSeconds();

      //Click Just Chatting
      Twitch.twitchJC();

      sleepPageTwoSeconds();

      //Click Hasan Channel
      Twitch.twitchStream();

      sleepPageTwoSeconds();

      //Verify live stream opens
      Boolean isDisplayed = Twitch.isVideoPresent();
      Assert.assertTrue(isDisplayed.equals(true));

      //Close webpage
      Twitch.closePage();
   }


   /********************
    ** helper methods **
    ********************/

   //Initialize WebDriver
   public WebDriver chromeDriver(){
      System.setProperty("webdriver.chrome.driver", "C:\\Users\\Durkle\\Desktop\\Selenium Edu\\chromedriver.exe");
      ChromeDriver driver = new ChromeDriver();
      return driver;
   }

   //Sleeps the page for 2 seconds
   public void sleepPageTwoSeconds(){
      try {
         Thread.sleep(2000);
      } catch (InterruptedException e) {
         e.printStackTrace();
      }
   }

   //Opens any URL
   public void openURL(WebDriver driver, String url){
      driver.get(url);
   }
}
