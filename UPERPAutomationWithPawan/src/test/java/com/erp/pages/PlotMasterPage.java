package com.erp.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.erp.baseclass.BaseClass;

public class PlotMasterPage extends BaseClass
{
	@FindBy(linkText="Depot")
	WebElement depot_Module;
	
	@FindBy(linkText="Masters")
	WebElement masters;
	
	@FindBy(linkText="Plot Master")
	WebElement plot_master;
		
	@FindBy(linkText = "Home")
	WebElement home;
		
	@FindBy(id="ctl00_ContentPlaceHolder1_btnSave")
	WebElement SaveBtn;
	
	@FindBy(xpath="//a[@class='icon1']")
	WebElement homebtn;
		
	
	public PlotMasterPage() { //constructor	
		PageFactory.initElements(driver, this);
	}
	
	public void selectLocation(String location)	{
		Select locations = new Select(driver.findElement(By.xpath("//select[@id='ctl00_ContentPlaceHolder1_ddlloc']")));
		locations.selectByVisibleText(location);
	//	Thread.sleep(1000);
	}
	
	public void clickDepot(String depotNames) throws InterruptedException {
		depot_Module.click();
		Thread.sleep(1000);
	}
	
	public void clickPlotMaster(String plot) {
		Actions action= new Actions(driver);
		action.moveToElement(masters).build().perform();
		//Thread.sleep(1000);
		
		plot_master.click();
		//Thread.sleep(1000);
	}
	
	public void createPlotPage(String location, String depotNames, String Species,String plotNo) throws InterruptedException
	{
		Select depotName = new Select(driver.findElement(By.id("ctl00_ContentPlaceHolder1_D_ddlDepot")));
		depotName.selectByVisibleText(depotNames);
		//Thread.sleep(500);
		
		Select speciesName = new Select(driver.findElement(By.id("ctl00_ContentPlaceHolder1_D_ddlSpecies")));
		speciesName.selectByVisibleText(Species);
		//Thread.sleep(500);
		
		driver.findElement(By.id("ctl00_ContentPlaceHolder1_R_txtPlotNo")).sendKeys(plotNo);
	//	Thread.sleep(1000);
		
				
				
		SaveBtn.click();
		//Thread.sleep(1000);
		
		home.click();
		
				
	
	}
	

}
