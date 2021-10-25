package br.com.restassuredapitesting.tests.booking.requests.payloads;

import org.json.JSONObject;

public class BookingPayloads {
    public JSONObject payloadValidBooking(){
        JSONObject payload = new JSONObject();
        JSONObject bookingDates = new JSONObject();

        bookingDates.put("checkin","2018-01-01");
        bookingDates.put("checkout","2019-01-01");
        payload.put("firstname","Jonas");
        payload.put("lastname","Brito");
        payload.put("totalprice",789);
        payload.put("depositpaid",true);
        payload.put("bookingdates",bookingDates);
        payload.put("additionalneeds","Breakfast");

        return payload;
    }

}
