package Runner_Sprint_38;

import org.testng.annotations.Test;

import Sprint_38.EPIC_1735;
import Sprint_38.EPIC_1741;
import Sprint_38.EPIC_1889;
import Sprint_38.EPIC_1896;
import Sprint_38.UtilClass;

public class Runner extends UtilClass {

	@Test
	public void EPICPLTFRM_1735() throws Exception {

		EPIC_1735 login = new EPIC_1735(driver);
		login.api();
		Await();
		login.PEGALogin();
		login.LaunchWarehousePortal();
		login.OrdersPAR();
		login.InboundTrailer_WorkQueue();
		Thread.sleep(7000);

		login.Received_Status();
		Await();
		EPIC_1735.ClickonCalendar.click();
		EPIC_1735.Calendarss();
		Await();
//		login.ClickOnApply.click();
//		Await();
		EPIC_1735.getAttribute();
		EPIC_1735.Submit.click();
		Await();
		EPIC_1735.ClickonGo.click();
		EPIC_1735.driver.switchTo().defaultContent();
		Await();
		EPIC_1735.frameswitch2();
		Await();
		login.Released_Status();
		Await();
		EPIC_1735.ClickonCalendar.click();
		EPIC_1735.Calendarss();
		Await();
//		login.ClickOnApply.click();
//		Await();
//		Pom.getAttribute();
		EPIC_1735.Submit.click();
		Await();
		EPIC_1735.ClickonGo.click();
		EPIC_1735.driver.switchTo().defaultContent();
		Await();
		EPIC_1735.frameswitch2();
		Await();
		login.POD_Exception();
		Await();
		EPIC_1735.ClickonGo.click();
		EPIC_1735.driver.switchTo().defaultContent();
		Await();
		EPIC_1735.frameswitch2();
		Await();

		login.POD_Received_Validation();
		Await();
		EPIC_1735.driver.switchTo().defaultContent();
		EPIC_1735.ClickonOrdersPAR.click();
		EPIC_1735.frameSwitch();
		EPIC_1735.ClickonPOD_Review.click();
		driver.switchTo().defaultContent();
		EPIC_1735.frameSwitch();
		// Await();
		Thread.sleep(9000);

		// ---------------

		login.OrderSearchandFilter();
		Await();
		EPIC_1735.Validate_Status_Released();
		EPIC_1735.Validate_Attachment_No();
		Await();
		EPIC_1735.Attachment_Clip();
		login.Rich_Text();
		login.Attachment_Submit();
		Await();
		login.OrderSearchandFilter();
		Await();
		EPIC_1735.Validate_Status_PODReceived();
		Await();
		EPIC_1735.Validate_Attachment_Yes();
//				Await();
//				pom.OrderSearchandFilter();
		Await();
//		EPIC_1735.Attachment_Clip();
//		login.AddURL();
//		login.Attachment_Submit();
		EPIC_1735.driver.switchTo().defaultContent();
		login.SwitchtoOrderPage();
		EPIC_1735.frameswitch2();
		Await();
		login.ActionsButton();
		Await();
		EPIC_1735.driver.switchTo().defaultContent();
		EPIC_1735.frameswitch2();
		Await();
		EPIC_1735.ClickonGo.click();
		Await();
		EPIC_1735.Submit.click();
		Await();

		Await();
		EPIC_1735.driver.switchTo().defaultContent();
		EPIC_1735.ClickonOrdersPAR.click();
		EPIC_1735.frameSwitch();
		EPIC_1735.ClickonPOD_Review.click();
		driver.switchTo().defaultContent();
		EPIC_1735.frameSwitch();

		// Await();
		Thread.sleep(9000);

		// ---------------

		login.OrderSearchandFilter();
		Await();
		EPIC_1735.Validate_Attachment_Yes();
		Await();
		EPIC_1735.Validate_Req_Status_Yes();
		Await();
		login.Approve_POD();

		EPIC_1735.driver.switchTo().defaultContent();
		login.SwitchtoOrderPage();
		EPIC_1735.frameswitch2();
		Await();
		login.ActionsButton();
		Await();
		EPIC_1735.driver.switchTo().defaultContent();
		EPIC_1735.frameswitch2();

		EPIC_1735.Resolved_Completed();
		

	}

	@Test
	public void EPICPLTFRM_1741() throws Exception {

		EPIC_1741 login = new EPIC_1741(driver);
		login.api();
		Await();
		login.PEGALogin();
		login.LaunchWarehousePortal();
		login.OrdersPAR();
		login.InboundTrailer_WorkQueue();
		Thread.sleep(7000);

		login.Received_Status();
		Await();
		EPIC_1741.ClickonCalendar.click();
		EPIC_1741.Calendarss();
		Await();
//		login.ClickOnApply.click();
//		Await();
		EPIC_1741.getAttribute();
		EPIC_1741.Submit.click();
		Await();
		EPIC_1741.ClickonGo.click();
		EPIC_1741.driver.switchTo().defaultContent();
		Await();
		EPIC_1741.frameswitch2();
		Await();
		login.Released_Status();
		Await();
		EPIC_1741.ClickonCalendar.click();
		EPIC_1741.Calendarss();
		Await();
//		login.ClickOnApply.click();
//		Await();
//		Pom.getAttribute();
		EPIC_1741.Submit.click();
		Await();
		EPIC_1741.ClickonGo.click();
		EPIC_1741.driver.switchTo().defaultContent();
		Await();
		EPIC_1741.frameswitch2();
		Await();
		login.POD_Exception();
		login.POD_Exception_2();

		Await();
		login.BackToPega();
		

	}

	@Test
	public static void EPICPLTFRM_1896() throws Exception {
		EPIC_1896 login = new EPIC_1896(driver);
		login.PAR_Order_Creation();
		login.Status_Update();
		login.PEGALogin();
		login.LaunchWarehousePortal();
		login.OrdersPAR();
		login.InboundTrailer_WorkQueue();
		login.Received_Status();
		Await();
		EPIC_1896.ClickonCalendar.click();
		Await();
		EPIC_1896.Calendarss();
		Await();
//		login.ClickOnApply.click();
//		Await();
		EPIC_1896.getAttribute();
		EPIC_1896.Submit.click();
		Await();
		EPIC_1896.ClickonGo.click();
		EPIC_1896.driver.switchTo().defaultContent();
		Await();
		EPIC_1896.frameswitch2();
		Await();
		login.Released_Status();
		Await();
		EPIC_1896.ClickonCalendar.click();
		EPIC_1896.Calendarss();
		Await();
//		login.ClickOnApply.click();
//		Await();
//		Pom.getAttribute();
		EPIC_1896.Submit.click();
		Await();
		EPIC_1896.ClickonGo.click();
		EPIC_1896.driver.switchTo().defaultContent();
		Await();
		EPIC_1896.frameswitch2();
		Await();
		login.POD_Exception();
		login.POD_Exception_2();
		Await();
		login.Clip_board();
		login.BackToPega();
		

	}

	@Test
	public static void EPICPLTFRM_1889() throws Exception {
		EPIC_1889 login = new EPIC_1889(driver);
		login.PAR_Order_Creation();
		login.Status_Update();
		login.PEGALogin();
		login.LaunchWarehousePortal();
		login.OrdersPAR();
		login.InboundTrailer_WorkQueue();
		login.Received_Status();
		Await();
		EPIC_1889.ClickonCalendar.click();
		Await();
		EPIC_1889.Calendarss();
		Await();
//		login.ClickOnApply.click();
//		Await();
		EPIC_1889.getAttribute();
		EPIC_1889.Submit.click();
		Await();
		EPIC_1889.ClickonGo.click();
		EPIC_1889.driver.switchTo().defaultContent();
		Await();
		EPIC_1889.frameswitch2();
		Await();
		login.Released_Status();
		Await();
		EPIC_1889.ClickonCalendar.click();
		EPIC_1896.Calendarss();
		Await();
//		login.ClickOnApply.click();
//		Await();
//		Pom.getAttribute();
		EPIC_1889.Submit.click();
		Await();
		EPIC_1889.ClickonGo.click();
		EPIC_1889.driver.switchTo().defaultContent();
		Await();
		EPIC_1889.frameswitch2();
		Await();
		login.POD_Exception();
		Await();
		login.POD_Exception_2();
		Await();
		login.Clip_board();
		login.BackToPega();
		

	}
}
