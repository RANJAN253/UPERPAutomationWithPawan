package com.erp.testcases;
import java.io.IOException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.erp.baseclass.BaseClass;
import com.erp.pages.PlotMasterPage;
import com.erp.utilities.B_ReadExcel;

public class PlotMasterTestCase extends BaseClass
{
	@Test(dataProvider ="getTestData")	
	public void PlotTestCase(String location, String depotNames, String Species,String plotNo) throws InterruptedException
	{
		PlotMasterPage obj = new PlotMasterPage();
		obj.createPlotPage(location, depotNames, Species, plotNo);
	}
	
	@DataProvider
	public Object[][]getTestData() throws IOException 
	{
		//ReadDistricMaster obj = new ReadDistricMaster();
		//Object[][] District =obj.DistrictDataSupplier();		//return District;
		Object[][] data = B_ReadExcel.testData("Plot");
		return data;
	}
}
