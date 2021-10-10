package PageObjects;

import net.bytebuddy.asm.Advice;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class main {

    WebDriver driver;

    public main(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    /*******************************************************************************************************************
     ********************************************** Page Objects *******************************************************
     *******************************************************************************************************************/

    //YouTube Search//

    @FindBy(css = "#search")
    WebElement tbYoutubeSearchField;

    @FindBy(id = "search-icon-legacy")
    WebElement YoutubeSearchButton;

    //Amazon Search For HDD//

    @FindBy(id = "twotabsearchtextbox")
    WebElement amazonSearchField;

    @FindBy(id = "nav-search-submit-button")
    WebElement amazonSearchButton;

    @FindBy(linkText = "Seagate BarraCuda 2TB Internal Hard Drive HDD – 3.5 Inch SATA 6Gb/s 7200 RPM 256MB Cache 3.5-Inch – Frustration Free Packaging (ST2000DM008)")
    WebElement amazonHddSelected;

    //Twitch Navigation//

    @FindBy(xpath = "//*[@id=\"root\"]/div/div[2]/nav/div/div[1]/div[1]/div/div[1]/div[1]/a/div/div[1]/div[2]/p")
    WebElement twitchBrowseClick;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div[2]/div/main/div[2]/div[3]/div/div/div/div/div[4]/div/div[1]/div[2]/div/div/div/div/div[1]/div/a/div/div[5]/div/div/div")
    WebElement twitchJCClick;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div[2]/div/main/div[2]/div[3]/div/div/div/div/div/div[4]/div[2]/div[1]/div[1]/div[3]/div/div/div/article/div[2]/div/div[5]/a/div/div")
    WebElement clickStream;

    @FindBy(css = "#root > div > div.sc-AxjAm.tlQbp > div > main > div.root-scrollable.scrollable-area.scrollable-area--suppress-scroll-x > div.simplebar-scroll-content > div > div > div.InjectLayout-sc-588ddc-0.iTtXFV.persistent-player > div > div.sc-AxjAm.StDqN.video-player > div > video")
    WebElement videoPlayer;

    //Google Calculator//

    @FindBy(xpath = "/html/body/div[1]/div[3]/form/div[1]/div[1]/div[1]/div/div[2]/input")
    WebElement googleSearchField;

    @FindBy(xpath = "/html/body/div[1]/div[3]/form/div[1]/div[1]/div[3]/center/input[1]")
    WebElement googleClickButton;

    @FindBy(xpath = "//*[@id=\"rso\"]/div[1]/div/div/div[1]/div/div/div[3]/div/table[2]/tbody/tr[2]/td[1]/div/div")
    WebElement numberSeven;

    @FindBy(xpath = "//*[@id=\"rso\"]/div[1]/div/div/div[1]/div/div/div[3]/div/table[2]/tbody/tr[3]/td[4]/div/div")
    WebElement multiplySign;

    @FindBy(xpath = "//*[@id=\"rso\"]/div[1]/div/div/div[1]/div/div/div[3]/div/table[2]/tbody/tr[4]/td[3]/div/div")
    WebElement numberThree;

    @FindBy(xpath = "//*[@id=\"rso\"]/div[1]/div/div/div[1]/div/div/div[3]/div/table[2]/tbody/tr[5]/td[3]/div/div")
    WebElement equalsSign;


    /*******************************************************************************************************************
     *************************************************** Methods *******************************************************
     *******************************************************************************************************************/


    public void youtubeSearchFor(String text) {tbYoutubeSearchField.sendKeys(text);}

    public void amazonSearchFor(String text) {amazonSearchField.sendKeys(text);}

    public void youtubeClickSearch() {YoutubeSearchButton.click();}

    public void amazonClickSearch() {amazonSearchButton.click();}

    public void amazonSelection() {amazonHddSelected.click();}

    public String getTitle(){
        String title = driver.getTitle();
        return title;
    }

    public String getAllTextOnPage(){
        String all = driver.getPageSource();
        return all;
    }

    public void twitchBrowseSelect() {twitchBrowseClick.click();}

    public void twitchJC() {twitchJCClick.click();}

    public void twitchStream() {clickStream.click();}

    public Boolean isVideoPresent(){
        Boolean presentVideo = videoPlayer.isDisplayed();
        return presentVideo;
    }

    public void googleSearchFor(String text) {googleSearchField.sendKeys(text);}

    public void googleSearchClick() {googleClickButton.click();}

    public void googleClickSeven() {numberSeven.click();}

    public void googleClickMultiply() {multiplySign.click();}

    public void googleClickThree() {numberThree.click();}

    public void googleClickEquals() {equalsSign.click();}


    public void closePage() {driver.quit();}

}
