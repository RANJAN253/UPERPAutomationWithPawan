package com.erp.testcases;
import java.io.IOException;
import org.testng.annotations.Test;
import com.erp.baseclass.BaseClass;
import com.erp.pages.ENoteSheetPage;
import com.erp.pages.LoginPage;

public class TC6_E_NoteSheetTestCase extends BaseClass {

	@Test(priority=1,enabled = true)
		public void createENoteSheet() throws InterruptedException, IOException {
			LoginPage lp = new LoginPage(driver);
			lp.setUserName("dsmluc");
			lp.setPassword("123456");
			lp.clickOnLoginBtn();

			ENoteSheetPage notesheet = new ENoteSheetPage(driver);
			notesheet.clickOnModule();
			notesheet.Action();
			notesheet.clickOnEnoteSheetNew();
			notesheet.selectNoteSheetCategory("Sales");
			Thread.sleep(1000);
			notesheet.selectNoteSheetSubCatagory("GST1");
			Thread.sleep(1000);
			notesheet.enterDocNumber("Doc-17062025");
			Thread.sleep(1000);
			notesheet.enterSubject("Subject ");
			Thread.sleep(1000);
			notesheet.enterDetails("The quick brown fox jumps right over the lazy dog.");
			Thread.sleep(1000);
			notesheet.enterComment("Initiated By DSM");
			Thread.sleep(1000);
			notesheet.clickOnSubmit();
			Thread.sleep(3000);
			notesheet.ActionDsm();
			lp.clickOnddlLogoutBtn();
		}
		@Test(priority=2)
		public void statusENoteSheet2() throws InterruptedException, IOException {
			LoginPage lp = new LoginPage(driver);
			lp.setUserName("ag3.2dsmlko");
			Thread.sleep(1000);
			lp.setPassword("123456");
			lp.clickOnLoginBtn();
			ENoteSheetPage notesheet = new ENoteSheetPage(driver);
			notesheet.clickOnModule();
			notesheet.Action();
			notesheet.clickOnENoteSheetStatus();
			Thread.sleep(1000);
			notesheet.clickonViewNoteSheet();
			Thread.sleep(1000);
			notesheet.clickOnRecOption();
			notesheet.enterComment("Rec By Arun Kumar");
			Thread.sleep(1000);
			notesheet.clickOnSubmit();
			Thread.sleep(3000);
			notesheet.ActionAcc();
			lp.clickOnddlLogoutBtn();
		}
		
		@Test(priority=3)
		public void statusENoteSheet3() throws InterruptedException, IOException {
			LoginPage lp = new LoginPage(driver);
			lp.setUserName("cao");
			Thread.sleep(1000);
			lp.setPassword("123456");
			lp.clickOnLoginBtn();

			ENoteSheetPage notesheet = new ENoteSheetPage(driver);
			
			notesheet.clickOnModule();
			notesheet.Action();
			notesheet.clickOnENoteSheetStatus();
			Thread.sleep(1000);
			notesheet.clickonViewNoteSheet();
			Thread.sleep(1000);
			notesheet.clickOnRecOption();
			
			notesheet.enterComment("Rec By CAO");
			Thread.sleep(1000);
			notesheet.clickOnSubmit();
			Thread.sleep(3000);
			notesheet.ActionAcc();
			lp.clickOnddlLogoutBtn();
		}
		
		@Test(priority=4)
		public void statusENoteSheet4() throws InterruptedException, IOException {
			LoginPage lp = new LoginPage(driver);
			lp.setUserName("rmlko");
			Thread.sleep(1000);
			lp.setPassword("123456");
			lp.clickOnLoginBtn();

			ENoteSheetPage notesheet = new ENoteSheetPage(driver);
			
			notesheet.clickOnModule();
			notesheet.Action();
			notesheet.clickOnENoteSheetStatus();
			Thread.sleep(1000);
			notesheet.clickonViewNoteSheet();
			Thread.sleep(1000);
			notesheet.clickOnRecOption();
			
			notesheet.enterComment("Rec By RM lucknow");
			Thread.sleep(1000);
			notesheet.clickOnSubmit();
			Thread.sleep(3000);
			notesheet.ActionAcc();
			lp.clickOnddlLogoutBtn();
		}
		
		@Test(priority=5)
		public void statusENoteSheet5() throws InterruptedException, IOException {
			LoginPage lp = new LoginPage(driver);
			lp.setUserName("gmsale");
			Thread.sleep(1000);
			lp.setPassword("123456");
			lp.clickOnLoginBtn();

			ENoteSheetPage notesheet = new ENoteSheetPage(driver);
			
			notesheet.clickOnModule();
			notesheet.Action();
			notesheet.clickOnENoteSheetStatus();
			Thread.sleep(1000);
			notesheet.clickonViewNoteSheet();
			Thread.sleep(1000);
			notesheet.clickOnRecOption();
			
			notesheet.enterComment("Rec By Accountant Kamlesh");
			Thread.sleep(1000);
			notesheet.clickOnSubmit();
			Thread.sleep(3000);
			notesheet.ActionAcc();
			lp.clickOnddlLogoutBtn();
		}
		
		@Test(priority=6)
		public void statusENoteSheet6() throws InterruptedException, IOException {
			LoginPage lp = new LoginPage(driver);
			lp.setUserName("ag3.2dsmlko");
			Thread.sleep(1000);
			lp.setPassword("123456");
			lp.clickOnLoginBtn();

			ENoteSheetPage notesheet = new ENoteSheetPage(driver);
			
			notesheet.clickOnModule();
			notesheet.Action();
			notesheet.clickOnENoteSheetStatus();
			Thread.sleep(1000);
			notesheet.clickonViewNoteSheet();
			Thread.sleep(1000);
			notesheet.clickOnRecOption();
			
			notesheet.enterComment("Rec By Accountant Kamlesh");
			Thread.sleep(1000);
			notesheet.clickOnSubmit();
			Thread.sleep(3000);
			notesheet.ActionAcc();
			lp.clickOnddlLogoutBtn();
		}
		
		
}
//span[@id='ctl00_ContentPlaceHolder1_dgPending_ctl01_lblgrdView']
//a[@id='ctl00_ContentPlaceHolder1_dgPending_ctl02_lnkView']//img
//a[@id='ctl00_ContentPlaceHolder1_dgPending_ctl03_lnkView']//img
