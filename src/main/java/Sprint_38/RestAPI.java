package Sprint_38;

import io.restassured.RestAssured;
import io.restassured.response.Response;

/**
 * REST API Validation Class
 * Uses httpbin.org (Cloudflare-free) for API testing
 * NOTE: reqres.in requires JavaScript via browser - use RestAPIWithSelenium.java for that
 */
public class RestAPI {

	/**
	 * Login API endpoint validation
	 * Uses httpbin.org for testing (no Cloudflare protection)
	 */
	public static void loginValidation() {
		System.out.println("====== REST API Post Request Testing (httpbin.org) ======");
		testValidPostRequest();
		testInvalidPostRequest();
	}

	/**
	 * Test valid POST request
	 */
	private static void testValidPostRequest() {
		RestAssured.baseURI = "https://httpbin.org";
		
		String requestBody = "{\n" +
			"  \"email\": \"eve.holt@reqres.in\",\n" +
			"  \"password\": \"cityslicka\"\n" +
			"}";

		Response response = RestAssured.given()
			.header("Content-Type", "application/json")
			.body(requestBody)
			.post("/post");

		int statusCode = response.getStatusCode();
		System.out.println("\n[Test 1] Valid POST Request");
		System.out.println("Status Code: " + statusCode);
		System.out.println("\nJSON Response Body (Pretty Print):");
		System.out.println(response.getBody().prettyPrint());

		if (statusCode == 200) {
			String json = response.jsonPath().getString("json");
			System.out.println("✅ PASS - Request successful with data: " + json);
		} else {
			System.out.println("❌ FAIL - Expected 200, got " + statusCode);
		}
	}

	/**
	 * Test POST request with empty body
	 */
	private static void testInvalidPostRequest() {
		RestAssured.baseURI = "https://httpbin.org";
		
		String requestBody = "{}";

		Response response = RestAssured.given()
			.header("Content-Type", "application/json")
			.body(requestBody)
			.post("/post");
		
		int statusCode = response.getStatusCode();
		System.out.println("\n[Test 2] POST Request with Empty Data");
		System.out.println("Status Code: " + statusCode);
		System.out.println("\nJSON Response Body (As String):");
		System.out.println(response.getBody().asString());

		if (statusCode == 200) {
			System.out.println("✅ PASS - Empty POST request handled correctly");
		} else {
			System.out.println("❌ FAIL - Expected 200, got " + statusCode);
		}
	}

	/**
	 * Get JSON response body as string
	 */
	public static String getPostResponseBody(String email, String password) {
		RestAssured.baseURI = "https://httpbin.org";
		
		String requestBody = String.format("{\n  \"email\": \"%s\",\n  \"password\": \"%s\"\n}", email, password);
		
		Response response = RestAssured.given()
			.header("Content-Type", "application/json")
			.body(requestBody)
			.post("/post");
		
		return response.getBody().prettyPrint();
	}

	/**
	 * Get raw JSON response as string
	 */
	public static String getRawJsonResponse(String email, String password) {
		RestAssured.baseURI = "https://httpbin.org";
		
		String requestBody = String.format("{\n  \"email\": \"%s\",\n  \"password\": \"%s\"\n}", email, password);
		
		Response response = RestAssured.given()
			.header("Content-Type", "application/json")
			.body(requestBody)
			.post("/post");

		return response.getBody().asString();
	}

	/**
	 * Validate POST response
	 */
	public static boolean isPostSuccessful(Response response) {
		return response.getStatusCode() == 200;
	}

	/**
	 * Main method for direct execution
	 */
	public static void main(String[] args) {
		loginValidation();
		
		// Additional: Get and display JSON response body
		System.out.println("\n====== Getting JSON Response Body (Pretty Print) ======");
		System.out.println("\nPOST Response (Pretty):");
		System.out.println(getPostResponseBody("eve.holt@reqres.in", "cityslicka"));
		
		System.out.println("\n\n====== Getting Raw JSON Response (As String) ======");
		System.out.println("\nPOST Response (Raw String):");
		System.out.println(getRawJsonResponse("eve.holt@reqres.in", "cityslicka"));
	}
}
