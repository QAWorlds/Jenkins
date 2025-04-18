package TestExecute.Hydroflask_loq.regressionTestcase;


import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import TestComponent.Hydroflask.GoldHydroLoq_Helper;
import TestLib.Common;
import TestLib.Login;

public class Test_DGLD_HF_ST_Loq_009_Guest_PaymentPage_UpdateAddress_My_billingand_shippingaddress {
	String datafile = "Hydroflask//GoldHydroTestData.xlsx";
	GoldHydroLoq_Helper Hydro = new GoldHydroLoq_Helper(datafile,"Loqata");
	

	@Test(retryAnalyzer = Utilities.RetryAnalyzer.class)
	public void Validate_Guest_Uesr_PaymentPage_UpdateAddress_Mybilling_andshippingaddress () throws Exception {

		try {
			Hydro.AcceptAll();
			Hydro.verifingHomePage();
			Hydro.search_product("Product");       
			Hydro.addtocart("Product");                    
			Hydro.minicart_Checkout();
			Hydro.addDeliveryAddress("AccountDetails");
			Hydro.BillingAddress("BillingDetails");
	        Hydro.updatePaymentAndSubmitOrder("PaymentDetails");

		} catch (Exception e) {

			Assert.fail(e.getMessage(), e);
		}
	}

	@AfterTest
	public void clearBrowser() {
		Common.closeAll();

	} 

	@BeforeTest
	public void startTest() throws Exception {
		System.setProperty("configFile", "Hydroflask\\config.properties");
        Login.signIn();
        Hydro.close_add();

	}

}