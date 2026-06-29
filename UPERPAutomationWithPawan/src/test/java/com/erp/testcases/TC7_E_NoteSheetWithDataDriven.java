package com.erp.testcases;
import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.erp.baseclass.BaseClass;
import com.erp.pages.ENoteSheetPage;
import com.erp.pages.LoginPage;
import com.erp.utilities.BReadExcelNew;



public class TC7_E_NoteSheetWithDataDriven extends BaseClass {
	ENoteSheetPage sheet ;
	
	
	@Test(dataProvider ="LoginData", enabled = false)	
	   //@Test(priority=1,dataProvider ="getTestData")
	   //public void saleDatePages(String saleTypes, String saleStatus, String[] arrDepotName) throws InterruptedException
	public void serviceMethod(String username, String password, String notesheetcat, String notesheetsubcat,String doc, String subject, String details,String comment) throws InterruptedException
	{
		LoginPage login = new LoginPage(driver);
		login.enterUsername(username);
		login.enterPassword(password);
		login.clickLoginButton();
		
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
		int rownum=BReadExcelNew.getRowCount(path, "notesheet");
		int colcount=BReadExcelNew.getCellCount(path, "notesheet", 1);
		
		String logindata[][]= new String[rownum][colcount];
		for(int i=1; i<=rownum; i++)
		{
			for(int j=0;j<colcount; j++)
			{
				logindata[i-1][j]= BReadExcelNew.getCellData(path, "notesheet", i, j);
			}
		}
		return logindata;
	}
	
	
	
	
	
	
	

}
