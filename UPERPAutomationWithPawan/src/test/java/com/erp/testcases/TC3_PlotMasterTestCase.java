package com.erp.testcases;
import java.io.IOException;

import org.testng.annotations.Test;
import com.erp.baseclass.BaseClass;
import com.erp.pages.LoginPage;
import com.erp.pages.PlotMasterPage;


import junit.framework.Assert;

public class TC3_PlotMasterTestCase extends BaseClass {
	//@Test(dataProvider="PlotData")
	@Test
	public void addPlotMaster() throws InterruptedException, IOException {
		LoginPage lp = new LoginPage(driver);
		lp.enterUsername(username);
		lp.enterPassword(password);
		lp.clickLoginButton();

		PlotMasterPage addplot = new PlotMasterPage();
		
		addplot.createPlotPage(baseURL, username, password, baseURL);
		
		addplot.createPlotPage("Kursi Road Depot Lucknow [Depot]");
		logger.info("Selected Location");
		
		addplot.clickOnModule();
		logger.info("Click on Menu");
		
		addplot.Action();
		logger.info("Click on Action Class");
		
		addplot.clickOnPlotMaster();
		logger.info("Click to Plot Master");
		
		Thread.sleep(2000);
		addplot.selectSpecies("Aam Dry");
		logger.info("Selected Species name");
		
		//addplot.selectSpecies(species);
		addplot.setPlotNumber("12/24-25");
		logger.info("Enter Plot Number");
		
		//addplot.setPlotNumber(date);
		addplot.clickOnSubmit();
		logger.info("Click on Save button");
		
		Thread.sleep(2000);

		String msg1 = addplot.getSuccessfullMsg();
		System.out.println(msg1);
		 
		String title = driver.getTitle(); 
		System.out.println("Title name is :" +  title);
		
		if(title.equals("Record Saved Successfully !1"))
		{ 
			logger.info("Plot master Entry Successfuly - Test passed");
			Assert.assertTrue(true);
			//Assert.assertEquals("Actual", "Expected");
		} 
		else 
		{ 
			logger.info("Record not saved!");
			captureScreenshot(driver,"addPlotMaster");
			Assert.assertTrue(false);
		}

		//Assert.assertEquals("Record Saved Successfully !", msg1);
		//lp.clickLogout();
	}
	
	
	
	
}