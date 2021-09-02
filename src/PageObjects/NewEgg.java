package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewEgg {

    WebDriver driver;

    public NewEgg(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@id=\"app\"]/header/div[1]/div[3]/div[1]/form/div/div[1]/input")
    WebElement tbSearchField;

    @FindBy(css = "#app > header > div.header2020-inner > div.header2020-search > div.header2020-search-bar > form > div > div.header2020-search-button > button")
    WebElement btnSearch;

    /*******************************************************************************************************************
     *************************************************** Methods *******************************************************
     *******************************************************************************************************************/

    public void enterSearchText(String text){
        tbSearchField.sendKeys(text);
    }

    public void clickSearch(){
        btnSearch.click();
    }

    public String getAllTextOnPage(){
        String all = driver.getPageSource();
        return all;
    }

}
