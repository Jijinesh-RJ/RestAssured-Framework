package api.endpoints;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import api.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

@SuppressWarnings("unused")
public class UserEndpoints {
public static Response createUser(User payload) {
	Response repsonse = given()
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.body(payload)
			.when()
			.post(Routes.post_url);
	return repsonse;
}
public static Response readUser(String userName) {
	Response repsonse = given()
			.pathParam("username", userName)
			.when()
			.get(Routes.get_url);
	return repsonse;
}
public static Response updateUser(String userName, User payload) {
	Response repsonse = given()
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.pathParam("username", userName)
			.body(payload)
			.when()
			.put(Routes.update_url);
	return repsonse;
}
public static Response deleteUser(String userName) {
	Response repsonse = given()
			.pathParam("username", userName)
			.when()
			.delete(Routes.delete_url);
	return repsonse;
}
}
