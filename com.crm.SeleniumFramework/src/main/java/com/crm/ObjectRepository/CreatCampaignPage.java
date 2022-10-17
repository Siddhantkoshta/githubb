package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreatCampaignPage {
			
	public void CreatCampaignPage(WebDriver driver)
{
	PageFactory.initElements(driver, this);
}	
	
	
	
	
	@FindBy(name="productname")
	private WebElement productname;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement savebutton;
	 
	
	@FindBy(linkText="More")
	private WebElement morelink;
	
	@FindBy(linkText="Campaigns")
	private WebElement createcampaigns;
	
	@FindBy(xpath="//img[@alt='Create Campaign...']")
	private WebElement newcampaigns;
	
	
	@FindBy(name="campaignname")
	private WebElement entercampaigns;
	
	@FindBy(xpath="//img[@title='Select']")
	private WebElement button;
	
	@FindBy(id="search_txt")
	private WebElement window;
	

	@FindBy(name="search")
	private WebElement searchbutton;
	
	

	@FindBy(xpath="//a[text()='\"+data+\"']")
	private WebElement searchelement;
	
	

	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement selected;



	public WebElement getProductname() {
		return productname;
	}



	public WebElement getSavebutton() {
		return savebutton;
	}



	public WebElement getMorelink() {
		return morelink;
	}



	public WebElement getCreatecampaigns() {
		return createcampaigns;
	}



	public WebElement getNewcampaigns() {
		return newcampaigns;
	}



	public WebElement getEntercampaigns() {
		return entercampaigns;
	}



	public WebElement getButton() {
		return button;
	}



	public WebElement getWindow() {
		return window;
	}



	public WebElement getSearchbutton() {
		return searchbutton;
	}



	public WebElement getSearchelement() {
		return searchelement;
	}



	public WebElement getSelected() {
		return selected;
	}
	
	public void camapign(String data)
	{
		productname.sendKeys(data);
		savebutton.click();
		
	}



	public void campaign() {
		// TODO Auto-generated method stub
		
	}
	
	
	
	
	

}
