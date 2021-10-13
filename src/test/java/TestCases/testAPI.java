package TestCases;

import Objects.API;
import Setting.DataProviderTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class testAPI {


    @Test(dataProviderClass = DataProviderTest.class, dataProvider = "getData")
    public void testCreatesBooking(String firstname, String lastname, String totalprice, String additionalneeds) {
        API form = new API();
        int price = Integer.parseInt(totalprice);
        String response = form.sendRequest(firstname, lastname, price, additionalneeds);
        Assert.assertFalse(response.isEmpty());

        String booking = form.getBooking(response);
        Assert.assertTrue(booking.contains(firstname) /*Expected value*/, "Response body contains the value");


    }
}
