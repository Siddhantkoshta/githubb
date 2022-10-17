package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	//Initialization
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//Declaration
	@FindBy(linkText="Organizations")
	private WebElement organizationLink;
	
	@FindBy(linkText="Products")
	private WebElement productLink;
	
	@FindBy(linkText="More")
	private WebElement moreLink;
	
	@FindBy(linkText="Campaigns")
	private WebElement campaignLink;

	
	//Getter Method
	public WebElement getOrganizationLink() {
		return organizationLink;
	}

	public WebElement getProductLink() {
		return productLink;
	}

	public WebElement getMoreLink() {
		return moreLink;
	}

	public WebElement getCampaignLink() {
		return campaignLink;
	}

	
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement signoutImage;
	
	@FindBy(linkText="Sign Out")
	private WebElement signoutLink;
	
	
	
	
	public WebElement getSignoutImage() {
		return signoutImage;
	}

	public WebElement getSignoutLink() {
		return signoutLink;
	}

	public void clickOrganizationLink()
	{
		organizationLink.click();
	}
	
	public void clickCampaignLink()
	{
		campaignLink.click();
	}
	
	public void clickMoreLink()
	{
		moreLink.click();
		
	}
	
	public void clickproductLink()
	{
		productLink.click();
		
	}
	
	public void clicksignoutImage()
	{
		signoutImage.click();
		
	}
	
	
	
	
	
				
	
	
	}


