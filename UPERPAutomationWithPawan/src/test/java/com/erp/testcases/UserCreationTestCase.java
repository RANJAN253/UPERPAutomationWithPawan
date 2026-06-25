package com.erp.testcases;
import java.io.IOException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.erp.baseclass.BaseClass;
import com.erp.pages.LoginPage;
import com.erp.pages.UserCreationPage;
import com.erp.utilities.B_ReadExcelNew;

public class UserCreationTestCase extends BaseClass {
	
	//UserCreationPage user;
	LoginPage login;
	UserCreationPage userpage;
	
	@Test(dataProvider="UserCreationData")
	//@Test
	public void userCreationWithDDT(String UserId, String office, String d_location, String Role,String empName, String depart, String Desig, String Pwd) throws InterruptedException, IOException
	{
		login = new LoginPage(driver);
		login.setUserName(username);
		login.setPassword(password);
		login.clickOnLoginBtn();
		
		userpage = new UserCreationPage(driver);
		userpage.clickOnUsermanagement();
		Thread.sleep(1000);
		userpage.Action();
		userpage.clickOnUserMaster();
		
		userpage.setUsername(UserId);
		userpage.selectOfficeType(office);
		Thread.sleep(500);
		userpage.selectDLocation(d_location);
		Thread.sleep(1000);
		userpage.selectroleType(Role);
		userpage.enterEmpName(empName);
		userpage.selectDepartment(depart);
		userpage.selectDesignation(Desig);
		userpage.setPassword(Pwd);
	}
	
	@DataProvider(name="UserCreationData")
	String[][] getData() throws IOException
	{
		String path= "C:/Users/ranjantiplin/AutomationFramework/UPERPAutomationWithPawan/ReadFromExcel/ForestDetails.xlsx";
		int rownum=B_ReadExcelNew.getRowCount(path, "Sheet1");
		int colcount=B_ReadExcelNew.getCellCount(path, "Sheet1", 1);
		
		String logindata[][]= new String[rownum][colcount];
		for(int i=1; i<rownum; i++)
		{
			for(int j=0;j<colcount; j++)
			{
				logindata[i-1][j]= B_ReadExcelNew.getCellData(path, "Sheet1", i, j);
			}
		}
		return logindata;
	}
		

}
