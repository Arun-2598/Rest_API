package Sprint_38;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Listeners;

import com.aventstack.extentreports.Status;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class EPIC_1889 extends UtilClass {

	public static String sendkeys = "";
	public static String BOL_Order = "";
	public static String DateTime = "";
	public static String GetLocationCity_State = "";
	public static String GetLocationCity_State_2 = "";
	public static String Arrived_POD = "";
	public static String Depart_POD = "";
	public static String PYGUID_Shipment_Ref2 = "";
	public static String PYGUID_Shipment_Ref1 = "";

	public EPIC_1889(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "loginText2")
	public static WebElement ssoLogin;

	@FindBy(className = "table-row")
	public static WebElement code;

	@FindBy(id = "idTxtBx_SAOTCC_OTC")
	public static WebElement send;

	@FindBy(id = "idSubmit_SAOTCC_Continue")
	public static WebElement click;

	@FindBy(xpath = "//input[@placeholder='Search']")
	public static WebElement SearchInput;

	@FindBy(xpath = "//button//i[@class='pi pi-search-2']")
	public static WebElement SearchClick;

	@FindBy(xpath = "//span//a[contains(text(), 'OrderServicePackage Services ProcessData')]")
	public static WebElement ClickonProcessData;

	@FindBy(xpath = "//div[contains(@class,'launch-portals')]/descendant::a")
	public static WebElement LaunchPortal;

	@FindBy(xpath = "//span[contains(text(),'WareHouse UserPortal')]")
	public static WebElement warehouse;

	@FindBy(xpath = "//li[@title='Orders PAR']")
	public static WebElement OrdersPAR;

	@FindBy(xpath = "//iframe[@name='PegaGadget0Ifr']")
	public static WebElement frameName1;

	@FindBy(xpath = "//iframe[@name='PegaGadget1Ifr']")
	public static WebElement frameName2;
	
	@FindBy(xpath = "//iframe[@name='PegaGadget2Ifr']")
	public static WebElement frameName3;

	@FindBy(xpath = "//h3[contains(text(),'OS&D')]")
	public static WebElement OSD;

	@FindBy(xpath = "//h3[contains(text(),'Inbound Trailer')]")
	public static WebElement InboundTrailer;

	@FindBy(xpath = "//h3[contains(text(),'POD Review')]")
	public static WebElement POD_Review;

	@FindBy(xpath = "//th[@aria-label='Order ID']//a[@class='filter highlight-ele']")
	public static WebElement OrderFilter;

	@FindBy(xpath = "//div[@class='content-inner ']/div/span/input[@type='text']")
	public static WebElement OrderSearch_Filter;

	@FindBy(xpath = "(//input[@type='checkbox' and contains(@name,'Inbound')])[21]")
	public static WebElement FilterCheckBox;

	@FindBy(xpath = "(//button[@class='pzhc pzbutton'])[1]")
	public static WebElement OrderFilterApply;

	@FindBy(xpath = "//a[@name='PODRequiredPAR_pyDisplayHarness_25']")
	public static WebElement POD_Review_refresh;

	@FindBy(xpath = "//a[contains(text(), 'PAR')]")
	public static WebElement ClickPARCaseID;

	@FindBy(xpath = "//button[contains(text(),'Go')]")
	public static WebElement OutboundLoads_Go;

	@FindBy(xpath = "//iframe[contains(@name, 'PegaGadget')]")
	public static WebElement oneframe;

	@FindBy(xpath = "//*[contains(@name, '$PpyWorkPage$pStatusEvent')]")
	public static WebElement Inbound_trailer_outboundLoads_Status;

	@FindBy(xpath = "//select[@name='$PpyWorkPage$pAssignedTradingPartnerName']")
	public static WebElement Release__Carrier;

	@FindBy(xpath = "//*[contains(@alt, 'Choose from calendar')]")
	public static WebElement ClickonCalendar;

	@FindBy(xpath = "//a[@id='applyLink']")
	public static WebElement ClickOnApply;

	@FindBy(xpath = "//input[@name='$PpyWorkPage$pEventDate']")
	public static WebElement GetDateandTime;

	@FindBy(xpath = "//button[contains(text(), 'Submit')]")
	public static WebElement Submit;

	@FindBy(xpath = "(//h3[@class='layout-group-item-title'])[3]")
	public static WebElement CLickonDataType;

	@FindBy(xpath = "//a[@aria-label='menu Order']")
	public static WebElement ClickonOrderDatatype;

	@FindBy(xpath = "//table[@id='gridLayoutTable']//tbody//tr//td[@data-attribute-name='ArrivedAtPickup']//div")
	public static WebElement Arrived_At_PickUp_Date_Order_Datetype;

	@FindBy(xpath = "//table[@id='gridLayoutTable']//tbody//tr//td[@data-attribute-name='OutForDelivery']//div")
	public static WebElement Out_For_Delivery_Date_Order_Datetype;

	@FindBy(xpath = "//a[@aria-label='menu Status']")
	public static WebElement ClickonStatusDatatype;

	@FindBy(xpath = "//div[@data-lg-child-id='4']/div[@aria-label='Records']/h3[@class='layout-group-item-title']")
	public static WebElement Clickon_Record_Status_and_OrderDatatype;

	@FindBy(xpath = "(//input[@placeholder='Search...'])[2]")
	public static WebElement Searchon_Order_Status_Datatype;

	@FindBy(xpath = "//i[@class='pi pi-search']")
	public static WebElement SelectSearchon_Order_Status_Datatype;

	@FindBy(xpath = "//td[@data-attribute-name='Status Event']//div[contains(text(), ' Received')]")
	public static WebElement Received_Status_in_Status_Datatype;

	@FindBy(xpath = "//td[@data-attribute-name='Status Event']//div[contains(text(), ' Released')]")
	public static WebElement Released_Status_in_Status_Datatype;

	@FindBy(xpath = "//td[@data-attribute-name='Status Event']//div[contains(text(), ' Arrived at Pickup')]")
	public static WebElement Arrived_At_pickup_Status_in_Status_Datatype;

	@FindBy(xpath = "//td[@data-attribute-name='Status Event']//div[contains(text(), ' Out For Delivery')]")
	public static WebElement Out_For_Delivery_Status_in_Status_Datatype;

	// **** Status Data type

	@FindBy(xpath = "//div[contains(text(), ' Received')]/ancestor::tr[contains(@id, 'PpyVirtualRecord')]//td[contains(@data-ui-meta, 'EventLocationAddress')]//div")
	public static WebElement EventLocationAddress_Received_Status_Datatype;

	@FindBy(xpath = "//div[contains(text(), ' Released')]/ancestor::tr[contains(@id, 'PpyVirtualRecord')]//td[contains(@data-ui-meta, 'EventLocationAddress')]//div")
	public static WebElement EventLocationAddress_Released_Status_Datatype;

	@FindBy(xpath = "//div[contains(text(), ' Arrived at Pickup')]/ancestor::tr[contains(@id, 'PpyVirtualRecord')]//td[contains(@data-ui-meta, 'EventLocationAddress')]//div")
	public static WebElement EventLocationAddress_ArrivedAtPickUp_Status_Datatype;

	@FindBy(xpath = "//div[contains(text(), ' Out For Delivery')]/ancestor::tr[contains(@id, 'PpyVirtualRecord')]//td[contains(@data-ui-meta, 'EventLocationAddress')]//div")
	public static WebElement EventLocationAddress_OutForDelivery_Status_Datatype;

	@FindBy(xpath = "//div[contains(text(), ' Received')]/ancestor::tr[contains(@id, 'PpyVirtualRecord')]//td[contains(@data-ui-meta, 'ShipmentRef')]//div")
	public static WebElement ShipmentRef_Received_Status_Datatype;

	@FindBy(xpath = "//div[contains(text(), ' Released')]/ancestor::tr[contains(@id, 'PpyVirtualRecord')]//td[contains(@data-ui-meta, 'ShipmentRef')]//div")
	public static WebElement ShipmentRef_Released_Status_Datatype;

	@FindBy(xpath = "//div[contains(text(), ' Arrived at Pickup')]/ancestor::tr[contains(@id, 'PpyVirtualRecord')]//td[contains(@data-ui-meta, 'ShipmentRef')]//div")
	public static WebElement ShipmentRef_ArrivedAtPickup_Status_Datatype;

	@FindBy(xpath = "//div[contains(text(), ' Out For Delivery')]/ancestor::tr[contains(@id, 'PpyVirtualRecord')]//td[contains(@data-ui-meta, 'ShipmentRef')]//div")
	public static WebElement ShipmentRef_OutForDelivery_Status_Datatype;

	// **** POD Exception Date****
	@FindBy(xpath = "//div[@id='pyFlowActionHTML']//div[contains(@data-ui-meta, 'ArrivedAtPickup')]//div[@class='field-item dataValueRead']//span")
	public static WebElement Arrived_At_Pickup_Date_POD_Exception;

	@FindBy(xpath = "//div[@id='pyFlowActionHTML']//div[contains(@data-ui-meta, 'OutForDelivery')]//div[@class='field-item dataValueRead']//span")
	public static WebElement Depart_At_Pickup_Date_POD_Exception;

	// ****Click on Go****

	@FindBy(xpath = "(//button[contains(text(), 'Go')])")
	public static WebElement ClickonGo;

	// ****POD Review Calendar****

	@FindBy(xpath = "(//*[contains(@alt, 'Choose from calendar')])[1]")
	public static WebElement ClickonCalendar_POD_review;

	@FindBy(xpath = "(//*[contains(@alt, 'Choose from calendar')])[2]")
	public static WebElement ClickonCalendar_POD_review2;

	// ********

	@FindBy(xpath = "//span[contains(text(), 'POD Received')]")
	public static WebElement POD_Received_Validation;

	@FindBy(xpath = "(//span[contains(text(), 'Orders PAR')])[2]")
	public static WebElement ClickonOrdersPAR;

	@FindBy(xpath = "(//h3[@class='layout-group-item-title'])[4]")
	public static WebElement ClickonPOD_Review;

	@FindBy(xpath = "//th[@aria-label='Order ID']//span//a[@id='pui_filter']")
	public static WebElement Clickon_OrderID_Filter_POD_Review;

	@FindBy(xpath = "//span[contains(text(),'Refresh')]")
	public static WebElement ClickReport_Refresh;

	@FindBy(xpath = "//div[@class='oflowDivM ']/span[contains(text(),'Released')]   ")
	public static WebElement status_Released;

	@FindBy(xpath = "//div[@class='oflowDivM ']/span[contains(text(),'POD Received')]   ")
	public static WebElement status_PODReceived;

	@FindBy(xpath = "//td[@data-attribute-name='Attached?']/div/span[contains(text(),'N')]")
	public static WebElement Attachment_No;

	@FindBy(xpath = "//td[@data-attribute-name='Attached?']/div/span[contains(text(),'Y')]")
	public static WebElement Attachment_Yes;

	@FindBy(xpath = "//h3[@class='layout-group-item-title' and contains(text(),'Add existing')]")
	public static WebElement Add_Existing_Attachment;

	@FindBy(xpath = "//td[@data-attribute-name='Count']/div/span[contains(text(),'0')]")
	public static WebElement Count_Nil;

	@FindBy(xpath = "//input[@name='$PAddRecentContent$ppyLabel']")
	public static WebElement RichText_Name;

	@FindBy(xpath = "//div[@title='Add URL']")
	public static WebElement AddURL;

	@FindBy(xpath = "//input[@name='$PpyAttachmentPage$ppyNote']")
	public static WebElement AddURL_Name;

	@FindBy(xpath = "//input[@name='$PpyAttachmentPage$ppyURL']")
	public static WebElement AddURL_tag;

	@FindBy(xpath = "//div[@class='oflowDivM ']/span/a/i[@class='pi pi-paper-clip']")
	public static WebElement Attachment_Clip;

	@FindBy(xpath = "//button[@title='Submit']")
	public static WebElement Attachment_Submit;

	@FindBy(xpath = "//button[contains(text(),'Refresh ')]")
	public static WebElement PAR_Refresh;

	@FindBy(xpath = "(//button[@name='CaseActionHeader_pyWorkPage_4'])[2]")
	public static WebElement Actions_Button;

	@FindBy(xpath = "//span[contains(text(), 'Refresh')]")
	public static WebElement Actions_Refresh;

	@FindBy(xpath = "//span[contains(text(),'Resolved-Completed')]")
	public static WebElement Resolved_Completed;

	// **** Clip Board****

	@FindBy(xpath = "//button[@title='Toggle runtime toolbar']//i[contains(@class,'gear')]")
	public static WebElement Toggle_toolbar;

	@FindBy(xpath = "//button[@title='Clipboard']")
	public static WebElement CLickOnClipBoard;

//	@FindBy(xpath = "//span[contains(text(),'pyWorkPage')]/ancestor::ul[@class='rowContent']/descendant::div[contains(@id,'icon')]")
//	public static WebElement pyWorkPage;

	@FindBy(xpath = "((//span[contains(@title, 'pyWorkPage')])[1]/ancestor::li)[2]//ul//li//div//a")
	public static WebElement ClickonpyworkPage;

	@FindBy(xpath = "(//span[contains(text(), 'pyWorkPage')])[1]/ancestor::li[2]/ul/li/div/div[1]")
	public static WebElement ExpandpyworkPage;

	@FindBy(xpath = "//span[contains(text(), 'OrderPage')]")
	public static WebElement ClickonOrderpageinCipboard;

	@FindBy(xpath = "((//span[contains(text(), 'OrderPage')])[1]/ancestor::li)[3]/ul/li/div/div/a")
	public static WebElement ExpandOrderPageinClipboard;

	@FindBy(xpath = "((//span[contains(text(), 'ShipmentList')]/ancestor::li)[4]//ul//li//div//div)[1]")
	public static WebElement ExpandShipmentinCLipboard;

	@FindBy(xpath = "//span[contains(text(), 'ShipmentList(1)(ESTES-Data-Shipment)')]")
	public static WebElement Click_Shipment_1_inCLipboard;

	@FindBy(xpath = "//span[contains(text(), 'ShipmentList(2)(ESTES-Data-Shipment)')]")
	public static WebElement Click_Shipment_2_inCLipboard;

//	@FindBy(xpath = "//span[contains(text(), 'ShipmentList(2)')]")
//	public static WebElement ClickonShipment2inCLipboard;

	@FindBy(xpath = "(//table[@class='gridTable '])[2]//tr[41]//td[2]//div//span")
	public static WebElement PYGUID_Shipment1_Clipboard;

	@FindBy(xpath = "(//table[@class='gridTable '])[2]//tr[35]//td[2]//div//span")
	public static WebElement PYGUID_Shipment2_Clipboard;

	public void PAR_Order_Creation() throws Exception {

		String dirpath = System.getProperty("user.dir");
		File file = new File(dirpath + "//PAR.json");
		ObjectMapper mapper = new ObjectMapper();
		JsonNode node = mapper.readTree(file);
		String actual = node.toPrettyString();
		JSONObject jsonObject = new JSONObject(actual);
		JSONObject orderRefs = jsonObject.getJSONObject("OrderRefs");

		// ObjectNode orderRefs = (ObjectNode) objectNode.get("OrderRefs");
		double ceil = Math.ceil(Math.random() * 100000000);
		BOL_Order = Double.toString(ceil);
		orderRefs.put("BOL", BOL_Order);
		orderRefs.put("TrackingNumber", Math.ceil(Math.random() * 100000000));
		orderRefs.put("InvoiceNumber", Math.ceil(Math.random() * 100000000));

		RestAssured.baseURI = "https://epicuatlb.estes-express.com";
		Response response = RestAssured.given().auth().basic("EpicSevicesTest1", "Rules@1234")
				.contentType("application/json").body(jsonObject.toString())
				.post("/prweb/api/OrderServicePackage/V1/CreateOrUpdateOrder");
		String responseBody = response.getBody().asString();
		String[] split = responseBody.split("Reference is ");

		sendkeys = split[1];
		System.out.println(sendkeys);
		System.out.println("<------Result of PAR Json------>");
		System.out.println("Response Body: " + responseBody);
		int statusCode = response.getStatusCode();
		System.out.println("Status Code: " + statusCode);
		extentTest.log(Status.PASS, "Order Created");

	}

	public void Status_Update() throws JsonProcessingException, IOException, JSONException {
		String dirpath = System.getProperty("user.dir");
		File file = new File(dirpath + "//PAR.json");
		ObjectMapper mapper = new ObjectMapper();
		JsonNode node = mapper.readTree(file);
		String actual = node.toPrettyString();
		// System.out.println("actual json----------------"+actual);

		// String[] Status_Events = { "Received", "Loaded", "Released", "Cancelled",
		// "Shortage", "Overage" };

		JSONObject jsonObject = new JSONObject(actual);
		JSONObject Origin_object = jsonObject.getJSONObject("OrderOrigin");

		Object GetCity = Origin_object.get("City");
		Object GetState = Origin_object.get("State");

		String Get_State = GetState.toString();
		GetLocationCity_State = GetCity.toString().concat(" " + Get_State);

		System.out.println("Location 1:" + GetLocationCity_State);
		JSONObject Origin_object2 = jsonObject.getJSONObject("OrderAgent");

		Object GetCity2 = Origin_object2.get("City");
		Object GetState2 = Origin_object2.get("State");

		String Get_State2 = GetState2.toString();
		GetLocationCity_State_2 = GetCity2.toString().concat(" " + Get_State2);

//		String branch ="Branch";
//		GetLocationCity_State_2.concat(" " + branch);

		System.out.println("Location 1:" + GetLocationCity_State_2);

		RestAssured.baseURI = "https://epicuatlb.estes-express.com";
		Response response = RestAssured.given().auth().basic("EpicSevicesTest1", "Rules@1234")
				.contentType("application/json").body(jsonObject.toString())
				.get("/prweb/api/OrderServicePackage/V1/CreateOrUpdateOrder");
		String responseBody = response.getBody().asString();

		System.out.println("<------Result of Updated PAR Json------>");
		System.out.println("Response Body: " + responseBody);
		int statusCode = response.getStatusCode();
		System.out.println("Status Code: " + statusCode);
		System.out.println("JSON value updated successfully.");

	}

	public static void Main_frame() {
		driver.switchTo().frame(oneframe);
	}

	public void PEGALogin() throws InterruptedException {
		ssoLogin.click();
		waits(code);
		code.click();

		// ****Scanner class to handle OTP****
		String scanner = scanner();
		send.sendKeys(scanner);
		waits(click);
		click.click();
	}

	public void LaunchWarehousePortal() throws InterruptedException {
		waits(LaunchPortal);
		LaunchPortal.click();
		waits(warehouse);
		warehouse.click();
		Await();
		Windows();
		extentTest.log(Status.PASS, "Enetered into Warehouse Portal");

	}

	public void OrdersPAR() throws Exception {
		Await();
		OrdersPAR.click();
		Await();
		Main_frame();
		waits(OSD);
		OSD.click();
		waits(InboundTrailer);

	}

	public void InboundTrailer_WorkQueue() throws InterruptedException {
		InboundTrailer.click();
		Await();
		OrderFilter.click();
		waits(OrderSearch_Filter);
		OrderSearch_Filter.sendKeys(sendkeys);
//		waits(FilterCheckBox);
//		FilterCheckBox.click();
		waits(OrderFilterApply);
		OrderFilterApply.click();
		Await();

		ClickPARCaseID.click();
		Await();
		driver.switchTo().defaultContent();
		driver.switchTo().frame(frameName2);

//		Main_frame();

		Await();
		// Inbound_trailer_outboundLoads_Status.click();
		// driver.switchTo().defaultContent();
	}

	public void Received_Status() {
		SelectClass(Inbound_trailer_outboundLoads_Status, "Received");
		extentTest.log(Status.PASS, "Order is Moved into Received Status");

	}

	public static void frameswitch1() {
		driver.switchTo().frame(frameName1);
	}

	public static void frameswitch2() {
		driver.switchTo().frame(frameName2);
	}
	
	public static void frameswitch3() {
		driver.switchTo().frame(frameName3);
	}

	public static void getAttribute() {
		DateTime = GetDateandTime.getAttribute("data-value");
	}

	public void Released_Status() {
		SelectClass(Inbound_trailer_outboundLoads_Status, "Released");
		extentTest.log(Status.PASS, "Order is Moved into Released Status");

	}

	public void Release_Carrier() {
		SelectClass(Release__Carrier, "Radiant");
		extentTest.log(Status.PASS, "Release Carrier selected as Radiant");

	}

	public void POD_Exception() throws InterruptedException {
		ClickonCalendar_POD_review.click();
		Calendarss();
		Await();
		ClickonCalendar_POD_review2.click();
		Calendarss();
		Await();
		Release_Carrier();
		Submit.click();
		Await();
		ClickonGo.click();
		driver.switchTo().defaultContent();
		Await();
		frameswitch2();
		Await();
	}

	public void POD_Exception_2() throws InterruptedException {
		getIgnoringStaleElementException(Arrived_At_Pickup_Date_POD_Exception);
		Arrived_POD = Arrived_At_Pickup_Date_POD_Exception.getText();
		System.out.println(Arrived_POD);
		Await();
		Depart_POD = Depart_At_Pickup_Date_POD_Exception.getText();
		System.out.println(Depart_POD);
	}

	public void Clip_board() throws InterruptedException {
		driver.switchTo().defaultContent();
		Await();
		Toggle_toolbar.click();
		Await();
		CLickOnClipBoard.click();
		Await();
		Windows();
		Await();
		ScrollDown();
//		Await();
//		ClickonpyworkPage.click();
		Await();
		ExpandpyworkPage.click();
	    Await();
		ExpandOrderPageinClipboard.click();
		Thread.sleep(9000);
		ExpandShipmentinCLipboard.click();
		Await();
		Click_Shipment_1_inCLipboard.click();
		Await();
		PYGUID_Shipment_Ref2 = PYGUID_Shipment1_Clipboard.getText();
		System.out.println("Shipment Ref2:" + PYGUID_Shipment_Ref2);
		Await();
		Click_Shipment_2_inCLipboard.click();
		Await();
		PYGUID_Shipment_Ref1 = PYGUID_Shipment2_Clipboard.getText();
		System.out.println("Shipment Ref1:" + PYGUID_Shipment_Ref1);

		driver.close();

	}

	public void BackToPega() throws InterruptedException, ParseException {

		Await();
		ArrayList<String> tab = new ArrayList<>(driver.getWindowHandles());
		driver.switchTo().window(tab.get(0));
		// Windows();
		List<WebElement> Close_Tabs = driver
				.findElements(By.xpath("//span[contains(text(), 'Home')]/following::td/span[@title='Close this tab']"));
 
		for (int i = 0; i < Close_Tabs.size(); i++) {
			Close_Tabs.get(i).click();
			System.out.println("Successfully closed all tabs");
 
		}

		CLickonDataType.click();
		Await();
		ClickonOrderDatatype.click();

		driver.switchTo().defaultContent();
		// FrameSwtich4();
		frameswitch2();
		Await();
		waits(Clickon_Record_Status_and_OrderDatatype);
		// Await();
		Thread.sleep(9000);
		Clickon_Record_Status_and_OrderDatatype.click();
		waits(Searchon_Order_Status_Datatype);
		Searchon_Order_Status_Datatype.click();
		Searchon_Order_Status_Datatype.sendKeys(sendkeys);
		waits(SelectSearchon_Order_Status_Datatype);
		SelectSearchon_Order_Status_Datatype.click();
		Await();

		String Date_Arrived_Order_Datatype = Arrived_At_PickUp_Date_Order_Datetype.getText();

		SimpleDateFormat formats1 = new SimpleDateFormat("M/d/yy h:mm a");
		Date dates1 = formats1.parse(Arrived_POD);

		SimpleDateFormat formats2 = new SimpleDateFormat("M/d/yyyy h:mm a");
		Date dates2 = formats2.parse(Date_Arrived_Order_Datatype);

		SimpleDateFormat forms = new SimpleDateFormat("MM/dd/yyyy");
		String dateExpected1 = forms.format(dates2);
		String dateActual1 = forms.format(dates1);

		System.out.println(dateActual1 + "----------------------" + dateExpected1);
		assertEquals(dateActual1, dateExpected1);

		System.out.println("Successfully Validated Arrived At Pickup Date:" + Date_Arrived_Order_Datatype);

		extentTest.log(Status.PASS, "Successfully Validated Arrived At Pickup Date");

		String Date_Depart_Order_Datatype = Out_For_Delivery_Date_Order_Datetype.getText();

		SimpleDateFormat Date_format1 = new SimpleDateFormat("M/d/yy h:mm a");
		Date Date1 = Date_format1.parse(Arrived_POD);

		SimpleDateFormat Date_format2 = new SimpleDateFormat("M/d/yyyy h:mm a");
		Date Date2 = Date_format2.parse(Date_Arrived_Order_Datatype);

		SimpleDateFormat form = new SimpleDateFormat("MM/dd/yyyy");
		String dateExpected01 = form.format(Date2);
		String dateActual01 = form.format(Date1);

		System.out.println(dateActual01 + "----------------------" + dateExpected01);
		assertEquals(dateActual1, dateExpected1);

		System.out.println("Successfully Validated Out for Delivery Date:" + Date_Depart_Order_Datatype);
		extentTest.log(Status.PASS, "Successfully Validated Out for Delivery Date");

		Await();
		driver.switchTo().defaultContent();
		ClickonStatusDatatype.click();
		Await();

		// FrameSwtich3();
		Await();

		Actions PEGA = new Actions(driver);
		PEGA.keyDown(Keys.ARROW_DOWN);
		PEGA.keyUp(Keys.ARROW_DOWN);

		PEGA.keyDown(Keys.ARROW_DOWN);
		PEGA.keyUp(Keys.ARROW_DOWN);

		PEGA.keyDown(Keys.ARROW_DOWN);
		PEGA.keyUp(Keys.ARROW_DOWN);

		PEGA.keyDown(Keys.ARROW_DOWN);
		PEGA.keyUp(Keys.ARROW_DOWN);

		Await();
		driver.switchTo().defaultContent();
		frameswitch3();
//		Main_frame();
		Thread.sleep(9000);
		waits(Clickon_Record_Status_and_OrderDatatype);
		Clickon_Record_Status_and_OrderDatatype.click();
		waits(Searchon_Order_Status_Datatype);
		Searchon_Order_Status_Datatype.click();
		Searchon_Order_Status_Datatype.sendKeys(sendkeys);
		waits(SelectSearchon_Order_Status_Datatype);
		SelectSearchon_Order_Status_Datatype.click();
		Await();

		String Received_Status = Received_Status_in_Status_Datatype.getText();
		assertTrue(Received_Status.contains("Received"));
		System.out.println("Successfully Validated Received_Status:" + Received_Status);
		extentTest.log(Status.PASS, "Successfully Validated Received Status");

		Await();
		String Released_Status = Released_Status_in_Status_Datatype.getText();
		assertTrue(Released_Status.contains("Released"));
		System.out.println("Successfully Validated Released_Status:" + Released_Status);
		extentTest.log(Status.PASS, "Successfully Validated Released Status");

		Await();
		String Arrived_At_Pickup_Status = Arrived_At_pickup_Status_in_Status_Datatype.getText();
		assertTrue(Arrived_At_Pickup_Status.contains("Arrived at Pickup"));
		System.out.println("Successfully Validated status :" + Arrived_At_Pickup_Status);
		extentTest.log(Status.PASS, "Successfully Validated Arrived At Pickup Status");

		Await();
		String Out_For_Delivery_Status = Out_For_Delivery_Status_in_Status_Datatype.getText();
		assertTrue(Out_For_Delivery_Status.contains("Out For Delivery"));
		System.out.println("Successfully Validated Received_Status:" + Out_For_Delivery_Status);
		extentTest.log(Status.PASS, "Successfully Validated Out for Delivery Status");

		Await();
		String Event_location1 = EventLocationAddress_Received_Status_Datatype.getText();
		System.out.println(Event_location1);
		Await();
		assertTrue(Event_location1.contains(GetLocationCity_State_2));
		System.out.println("Successfuly validated EventLocationAddress: " + Event_location1);
		extentTest.log(Status.PASS, "Successfuly validated EventLocationAddress for Received");


		Await();
		String Event_location2 = EventLocationAddress_Released_Status_Datatype.getText();
		System.out.println(Event_location2);
		Await();
		assertTrue(Event_location2.contains(GetLocationCity_State_2));
		System.out.println("Successfuly validated EventLocationAddress: " + Event_location2);
		extentTest.log(Status.PASS, "Successfuly validated EventLocationAddress for Released");


		Await();
		String Event_location3 = EventLocationAddress_ArrivedAtPickUp_Status_Datatype.getText();
		System.out.println(Event_location3);
		Await();
		assertTrue(Event_location3.contains(GetLocationCity_State));
		System.out.println("Successfuly validated EventLocationAddress: " + Event_location3);
		extentTest.log(Status.PASS, "Successfuly validated EventLocationAddress for ArrivedAtPickUp");


		Await();
		String Event_location4 = EventLocationAddress_OutForDelivery_Status_Datatype.getText();
		System.out.println(Event_location4);
		Await();
		assertTrue(Event_location4.contains(GetLocationCity_State));
		System.out.println("Successfuly validated EventLocationAddress: " + Event_location4);
		extentTest.log(Status.PASS, "Successfuly validated EventLocationAddress for OutForDelivery");


		Await();
		String Received_Shipement_Ref = ShipmentRef_Received_Status_Datatype.getText();
		System.out.println();
		assertTrue(Received_Shipement_Ref.contains(PYGUID_Shipment_Ref1));
		System.out.println("Succesfully validated Shipemnt Ref 2 in Received: " + Received_Shipement_Ref);
		extentTest.log(Status.PASS, "Succesfully validated Shipemnt Ref 2 in Received");


		Await();
		String Released_Shipement_Ref = ShipmentRef_Released_Status_Datatype.getText();
		assertTrue(Released_Shipement_Ref.contains(PYGUID_Shipment_Ref1));
		System.out.println("Succesfully validated Shipemnt Ref 2 in Released: " + Released_Shipement_Ref);
		extentTest.log(Status.PASS, "Succesfully validated Shipemnt Ref 2 in Released");


		
		Await();
		String ArrivedAtPickup_Shipement_Ref = ShipmentRef_ArrivedAtPickup_Status_Datatype.getText();
		assertTrue(ArrivedAtPickup_Shipement_Ref.contains(PYGUID_Shipment_Ref2));
		System.out.println("Succesfully validated Shipemnt Ref 1 in Arrived_At_Pickup: " + ArrivedAtPickup_Shipement_Ref);
		extentTest.log(Status.PASS, "Succesfully validated Shipemnt Ref 1 in Arrived_At_Pickup");

		
		
		Await();
		String OutForDelivery_Shipement_Ref = ShipmentRef_OutForDelivery_Status_Datatype.getText();
		assertTrue(OutForDelivery_Shipement_Ref.contains(PYGUID_Shipment_Ref2));
		System.out.println("Succesfully validated Shipemnt Ref 1 in Out_For_Delivery: " + OutForDelivery_Shipement_Ref);
		extentTest.log(Status.PASS, "Succesfully validated Shipemnt Ref 1 in Out_For_Delivery");

	}
}