package com.erp.testcases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.erp.baseclass.BaseClass;
import com.erp.pages.ENoteSheetPage;
import com.erp.pages.LoginPage;
import com.erp.utilities.B_ReadExcelNew;


public class TC7_E_NoteSheetWithDataDriven extends BaseClass {
	ENoteSheetPage sheet ;
	
	
	@Test(dataProvider ="LoginData")	
	   //@Test(priority=1,dataProvider ="getTestData")
	   //public void saleDatePages(String saleTypes, String saleStatus, String[] arrDepotName) throws InterruptedException
	public void serviceMethod(String username, String password, String notesheetcat, String notesheetsubcat,String doc, String subject, String details,String comment) throws InterruptedException
	{
		LoginPage login = new LoginPage(driver);
		login.setUserName(username);
		login.setPassword(password);
		login.clickOnLoginBtn();
		
		sheet  = new ENoteSheetPage(driver);
		sheet.clickOnModule();
		sheet.Action();
		sheet.clickOnEnoteSheetNew();
		
		sheet.selectNoteSheetCategory(notesheetcat);
		sheet.selectNoteSheetSubCatagory(notesheetsubcat);
		sheet.enterDocNumber(doc);
		sheet.enterSubject(subject);
		sheet.enterDetails(details);
		sheet.enterComment(comment);
		sheet.clickOnSubmit();
		
	}

	@DataProvider(name="LoginData")
	String[][] getData() throws IOException
	{
		String path= "C:/Users/ranjantiplin/AutomationFramework/UPERPAutomationWithPawan/ReadFromExcel/ForestDetails.xlsx";
		int rownum=B_ReadExcelNew.getRowCount(path, "notesheet");
		int colcount=B_ReadExcelNew.getCellCount(path, "notesheet", 1);
		
		String logindata[][]= new String[rownum][colcount];
		for(int i=1; i<=rownum; i++)
		{
			for(int j=0;j<colcount; j++)
			{
				logindata[i-1][j]= B_ReadExcelNew.getCellData(path, "notesheet", i, j);
			}
		}
		return logindata;
	}
	
	
	
	
	
	
	

}
