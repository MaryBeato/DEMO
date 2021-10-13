package Objects;


import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class API {

    String urlAPI = "https://restful-booker.herokuapp.com/booking";
    private String firstName;
    private String lastName;
    private int totalPrice;
    private String additionalNeeds;

    public String sendRequest(String firstName, String lastName, int totalPrice, String additionalNeeds) {
        String response =
                given().log().all().
                        contentType("application/json").
                        body("{ \"firstname\": \"" + firstName + "\", " +
                                "\"lastname\" :\"" + lastName + "\"," +
                                "\"totalprice\" : " + totalPrice + "," +
                                "\"depositpaid\" : true,\n" +
                                "    \"bookingdates\" : {\n" +
                                "        \"checkin\" : \"2018-01-01\",\n" +
                                "        \"checkout\" : \"2019-01-01\"\n" +
                                "    },\n" +
                                "    \"additionalneeds\" : \"" + additionalNeeds + "\"}"
                        ).
                        when().
                        post(urlAPI).
                        then().
                        log().all().
                        assertThat().statusCode(200).
                        extract().response().body().path("bookingid").toString();
        System.out.println(response);
        return response;

    }

    public String getBooking(String bookingid) {
        //  String body=null;
       /* String body =
                given().log().all().
                        contentType("application/json").
                        pathParam("id",bookingid).
                        when().
                        get(urlAPI+"/{id}").
                        then().
                        log().all().
                        assertThat().statusCode(200).
                        extract().response().body().prettyPrint();*/

        RestAssured.baseURI = urlAPI;
        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.get("/" + bookingid);

        // Retrieve the body of the Response
        ResponseBody body = response.getBody();

        // By using the ResponseBody.asString() method, we can convert the  body
        // into the string representation.
        System.out.println("Response Body is: " + body.asString());


        return body.asString();

    }
}
