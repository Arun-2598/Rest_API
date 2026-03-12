package Sprint_38;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

/**
 * API Validation Script using RestAssured
 * Tests the login endpoint at reqres.in
 */
public class ApiValidationScript {

	public static void main(String[] args) {
		// Test 1: Valid login credentials
		System.out.println("====== Test 1: Valid Login Credentials ======");
		testValidLogin();

		// Test 2: Invalid login credentials (missing password)
		System.out.println("\n====== Test 2: Invalid Login (Missing Password) ======");
		testInvalidLoginMissingPassword();

		// Test 3: Invalid login credentials (missing email)
		System.out.println("\n====== Test 3: Invalid Login (Missing Email) ======");
		testInvalidLoginMissingEmail();
	}

	/**
	 * Test valid login with email and password
	 */
	public static void testValidLogin() {
		RestAssured.baseURI = "https://reqres.in";
		
		RequestSpecification request = RestAssured.given()
			.header("Content-Type", "application/json")
			.body("{\n" +
				"  \"email\": \"eve.holt@reqres.in\",\n" +
				"  \"password\": \"cityslicka\"\n" +
				"}");

		Response response = request.post("/api/login");

		System.out.println("Status Code: " + response.getStatusCode());
		System.out.println("Response Body:\n" + response.getBody().prettyPrint());

		// Assertions
		if (response.getStatusCode() == 200) {
			String token = response.jsonPath().getString("token");
			if (token != null && !token.isEmpty()) {
				System.out.println("✅ PASS: Valid login successful. Token: " + token);
			} else {
				System.out.println("❌ FAIL: Token not found in response");
			}
		} else {
			System.out.println("❌ FAIL: Expected status code 200, got " + response.getStatusCode());
		}
	}

	/**
	 * Test login with missing password (should fail)
	 */
	public static void testInvalidLoginMissingPassword() {
		RestAssured.baseURI = "https://reqres.in";
		
		RequestSpecification request = RestAssured.given()
			.header("Content-Type", "application/json")
			.body("{\n" +
				"  \"email\": \"eve.holt@reqres.in\"\n" +
				"}");

		Response response = request.post("/api/login");

		System.out.println("Status Code: " + response.getStatusCode());
		System.out.println("Response Body:\n" + response.getBody().prettyPrint());

		// Assertions
		if (response.getStatusCode() == 400) {
			String error = response.jsonPath().getString("error");
			if (error != null && error.contains("password")) {
				System.out.println("✅ PASS: Correctly rejected login. Error: " + error);
			} else {
				System.out.println("⚠️  Status 400 but error message unexpected: " + error);
			}
		} else {
			System.out.println("❌ FAIL: Expected status code 400, got " + response.getStatusCode());
		}
	}

	/**
	 * Test login with missing email (should fail)
	 */
	public static void testInvalidLoginMissingEmail() {
		RestAssured.baseURI = "https://reqres.in";
		
		RequestSpecification request = RestAssured.given()
			.header("Content-Type", "application/json")
			.body("{\n" +
				"  \"password\": \"cityslicka\"\n" +
				"}");

		Response response = request.post("/api/login");

		System.out.println("Status Code: " + response.getStatusCode());
		System.out.println("Response Body:\n" + response.getBody().prettyPrint());

		// Assertions
		if (response.getStatusCode() == 400) {
			String error = response.jsonPath().getString("error");
			if (error != null && error.contains("email")) {
				System.out.println("✅ PASS: Correctly rejected login. Error: " + error);
			} else {
				System.out.println("⚠️  Status 400 but error message unexpected: " + error);
			}
		} else {
			System.out.println("❌ FAIL: Expected status code 400, got " + response.getStatusCode());
		}
	}

	/**
	 * Generalized method to validate login with custom credentials
	 */
	public static Response validateLogin(String email, String password) {
		RestAssured.baseURI = "https://reqres.in";
		
		String requestBody = String.format("{\n  \"email\": \"%s\",\n  \"password\": \"%s\"\n}", email, password);
		
		Response response = RestAssured.given()
			.header("Content-Type", "application/json")
			.body(requestBody)
			.post("/api/login");

		return response;
	}

	/**
	 * Validate response contains expected fields
	 */
	public static boolean isValidLoginResponse(Response response) {
		if (response.getStatusCode() != 200) {
			System.out.println("Invalid status code: " + response.getStatusCode());
			return false;
		}

		String token = response.jsonPath().getString("token");
		if (token == null || token.isEmpty()) {
			System.out.println("Token field missing or empty");
			return false;
		}

		System.out.println("✅ Valid login response with token: " + token);
		return true;
	}

	/**
	 * Validate error response
	 */
	public static boolean isErrorResponse(Response response, int expectedStatusCode) {
		if (response.getStatusCode() != expectedStatusCode) {
			System.out.println("Expected status " + expectedStatusCode + " but got " + response.getStatusCode());
			return false;
		}

		String error = response.jsonPath().getString("error");
		if (error == null || error.isEmpty()) {
			System.out.println("Error field missing or empty");
			return false;
		}

		System.out.println("✅ Error response: " + error);
		return true;
	}
}
