package com.test.pages;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.test.controller.ActionMethods;
import com.test.controller.FlowMethods;
import com.test.controller.Report;
import com.test.excelAPI.ExcelOperation;
import com.test.testData.OverviewTestData;
import com.test.testData.TestDataObjectLogin;
import com.test.utils.Constant;


public class LoginPage extends FlowMethods {

	//public WebDriver driver;

	Logger log = LogManager.getLogger(ActionMethods.class);	
	ActionMethods actionMethods = new ActionMethods();
	ExcelOperation excelOperation = new ExcelOperation();

	/*public void launchURL() throws Exception {
		try {
			ActionMethods actionMethods = new ActionMethods();
			actionMethods.launchURL();
			Report.getInstance().generateReport(Thread.currentThread().getStackTrace()[1].getMethodName(),Constant.statusFlag+" Execution started on :"+Constant.browser, driver);
		} catch (Exception e) {
			Constant.statusFlag = "Failed";
			Report.getInstance().generateReport(Thread.currentThread().getStackTrace()[1].getMethodName(),Constant.statusFlag, driver);
			throw e;
		}
	}*/

   public void loginGmailAccount(String userNmae, String password)
   {
	   String locator;
	   try
	   {
	//	   locator = objectRepo.getProperty("Gmail.SignIn");
	//	   actionMethods.click(locator);
		   actionMethods.waitFor();
		   
	//	   actionMethods.switchToTab();
		   locator = objectRepo.getProperty("Gmail.EnterEmail");
		   actionMethods.enterInputMandatoryFiled(locator, userNmae);
		   locator = objectRepo.getProperty("Gmail.Next");
		   actionMethods.click(locator);
		   locator = objectRepo.getProperty("Gmail.EnterPassword");
		   actionMethods.waitFor();
		   actionMethods.enterInputMandatoryFiled(locator, password);
		   locator = objectRepo.getProperty("Gmail.Next");
		   actionMethods.click(locator);
		   Report.getInstance().generateReport(Thread.currentThread().getStackTrace()[1].getMethodName(),Constant.statusFlag+"Login details : "+userNmae+"/"+password, driver);
	   } catch (Exception e) 
	   {
		   log.error("Exception Occured at loginGmailAccount : "+e.getMessage());
		   Constant.statusFlag = "Failed";
		   Report.getInstance().generateReport(Thread.currentThread().getStackTrace()[1].getMethodName(),Constant.statusFlag, driver);
		   throw e;
	   }
	   
   }
   
   public String getOtP()
   {
	   String locator, getOTP = "";
	   try
	   {
		   actionMethods.waitFor();
		   locator = objectRepo.getProperty("Gmail.selectMail");
		   actionMethods.click(locator);
		   actionMethods.waitFor();
		   locator = objectRepo.getProperty("Gmail.GetOtp");
		   getOTP = actionMethods.getText(locator);
		   System.out.println("Login OTP : "+getOTP.split(" ")[1]);
		   Report.getInstance().generateReport(Thread.currentThread().getStackTrace()[1].getMethodName(),Constant.statusFlag+getOTP, driver);
	   } catch (Exception e) {
		   log.error("Exception Occured at getOtP : "+e.getMessage());
		   Constant.statusFlag = "Failed";
		   Report.getInstance().generateReport(Thread.currentThread().getStackTrace()[1].getMethodName(),Constant.statusFlag, driver);
		   throw e;
	}
	return getOTP.split(" ")[1];
   }
   
   public void loginDISApplication(String userName, String passWord) throws Exception
   {
	   String locator = "";
	   try
	   {
		   locator = objectRepo.getProperty("Dis.Login.Gov");
		   actionMethods.click(locator);
		   locator = objectRepo.getProperty("Dis.GovInSignIN");
		   actionMethods.click(locator);
		   locator = objectRepo.getProperty("Dis.Email");
		   actionMethods.enterInputMandatoryFiled(locator, userName);
		   locator = objectRepo.getProperty("Dis.Password");
		   actionMethods.enterInputMandatoryFiled(locator, passWord);
		   locator = objectRepo.getProperty("Dis.SignIn");
		   actionMethods.click(locator);
		   Thread.sleep(7000);
		   
		//   locator = objectRepo.getProperty("Dis.chooseAnotherWay");
		//   actionMethods.click(locator);
		 //  locator = objectRepo.getProperty("Dis.Textmessage");
		  // actionMethods.click(locator);
		  //locator = objectRepo.getProperty("Dis.Continue");
		 // actionMethods.click(locator);
		   
		  actionMethods.launchChrome();
		//	actionMethods.launchURL("");
			String gmailLoginDetails = TestDataObjectLogin.LOGIN_DETAILS;
			loginGmailAccount(gmailLoginDetails.split("/")[0],gmailLoginDetails.split("/")[1].split("~")[0]);
			String  s = getOtP();
		  actionMethods.closeWindow();
		//  actionMethods.switchToParentWindow();
		  
		  
		   locator = objectRepo.getProperty("Dis.Otp");
		   actionMethods.enterInputMandatoryFiled(locator, s);
		  
		   locator = objectRepo.getProperty("Dis.Submit");
		   actionMethods.click(locator);
		   
		   
		   Report.getInstance().generateReport(Thread.currentThread().getStackTrace()[1].getMethodName(),Constant.statusFlag, driver);
	   } catch (Exception e) {
		   log.error("Exception Occured at getOtP : "+e.getMessage());
		   Constant.statusFlag = "Failed";
		   Report.getInstance().generateReport(Thread.currentThread().getStackTrace()[1].getMethodName(),Constant.statusFlag, driver);
		   throw e;
	}
   }
   
   public void validteAllNavigationLinks()
   {
	   String locator = "";
	   try
	   {
		   locator = objectRepo.getProperty("Overview.OfficeBtn");
		   if(actionMethods.isElementPresent(locator))
		   {
			   System.out.println("Overview Offices button presented succesfully! ");
			   Report.getInstance().generateReport(Thread.currentThread().getStackTrace()[1].getMethodName(),Constant.statusFlag, driver);
		   } else			   
			   Report.getInstance().generateReport(Thread.currentThread().getStackTrace()[1].getMethodName(),Constant.statusFlag, driver);
		   
		   locator = objectRepo.getProperty("Strategies.Link");
		   actionMethods.click(locator);
		   locator = objectRepo.getProperty("Strategies.Header");
		   if(actionMethods.isElementPresent(locator))
		   {
			   System.out.println("Strategis header presented succesfully! ");
			   Report.getInstance().generateReport(Thread.currentThread().getStackTrace()[1].getMethodName(),Constant.statusFlag, driver);
		   } else
			   Report.getInstance().generateReport(Thread.currentThread().getStackTrace()[1].getMethodName(),Constant.statusFlag, driver);
		   
		   locator = objectRepo.getProperty("");
		   actionMethods.click(locator);
		   locator = objectRepo.getProperty("");
		   if(actionMethods.isElementPresent(locator))
		   {
			   System.out.println(" presented succesfully! ");
			   Report.getInstance().generateReport(Thread.currentThread().getStackTrace()[1].getMethodName(),Constant.statusFlag, driver);
			   
		   } else
			   Report.getInstance().generateReport(Thread.currentThread().getStackTrace()[1].getMethodName(),Constant.statusFlag, driver);
		   
		   locator = objectRepo.getProperty("");
		   actionMethods.click(locator);
		   locator = objectRepo.getProperty("");
		   if(actionMethods.isElementPresent(locator))
		   {
			   System.out.println("Overview Offices button presented succesfully! ");
		   } else
			   Report.getInstance().generateReport(Thread.currentThread().getStackTrace()[1].getMethodName(),Constant.statusFlag, driver);
		   
		   
		   locator = objectRepo.getProperty("");
		   actionMethods.click(locator);
		   locator = objectRepo.getProperty("");
		   if(actionMethods.isElementPresent(locator))
		   {
			   System.out.println("Overview Offices button presented succesfully! ");
		   } else
			   Report.getInstance().generateReport(Thread.currentThread().getStackTrace()[1].getMethodName(),Constant.statusFlag, driver);
		   
		   locator = objectRepo.getProperty("");
		   actionMethods.click(locator);
		   locator = objectRepo.getProperty("");
		   if(actionMethods.isElementPresent(locator))
		   {
			   System.out.println("Overview Offices button presented succesfully! ");
		   } else
			   Report.getInstance().generateReport(Thread.currentThread().getStackTrace()[1].getMethodName(),Constant.statusFlag, driver);
		   
		   
	   } catch (Exception e) {
		   log.error("Exception Occured at getOtP : "+e.getMessage());
		   Constant.statusFlag = "Failed";
		   Report.getInstance().generateReport(Thread.currentThread().getStackTrace()[1].getMethodName(),Constant.statusFlag, driver);
		   throw e;
	}
   }

}