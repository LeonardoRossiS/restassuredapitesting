package br.com.restassuredapitesting.tests.booking.requests.payloads;

import br.com.restassuredapitesting.utils.Utils;
import org.json.JSONObject;

public class BookingPayloads {
    public JSONObject payloadValidBooking(){
        JSONObject payload = new JSONObject();
        JSONObject bookingDates = new JSONObject();

        bookingDates.put("checkin", Utils.checkinteste());
        bookingDates.put("checkout", Utils.checkoutteste());
        payload.put("firstname", Utils.nometeste());
        payload.put("lastname", Utils.sobrenometeste());
        payload.put("totalprice",789);
        payload.put("depositpaid",true);
        payload.put("bookingdates",bookingDates);
        payload.put("additionalneeds","Breakfast");

        return payload;
    }

    public JSONObject payloadInvalidBooking(){
        JSONObject payload = new JSONObject();
        JSONObject bookingDates = new JSONObject();

        bookingDates.put("checkin", Utils.checkinteste());
        bookingDates.put("checkout", Utils.checkoutteste());
        payload.put("firstname", 123);
        payload.put("lastname", true);
        payload.put("totalprice",Utils.nometeste());
        payload.put("depositpaid",Utils.sobrenometeste());
        payload.put("bookingdates",bookingDates);
        payload.put("additionalneeds","Breakfast");

        return payload;
    }

    public JSONObject payloadBiggerBooking(){
        JSONObject payload = new JSONObject();
        JSONObject bookingDates = new JSONObject();

        bookingDates.put("checkin", Utils.checkinteste());
        bookingDates.put("midcheck", Utils.checkoutteste());
        bookingDates.put("checkout", Utils.checkoutteste());
        payload.put("firstname", Utils.nometeste());
        payload.put("middlename", Utils.sobrenometeste());
        payload.put("lastname", Utils.sobrenometeste());
        payload.put("totalprice",789);
        payload.put("depositpaid",true);
        payload.put("bookingdates",bookingDates);
        payload.put("additionalneeds","Breakfast");
        payload.put("additionalneeds2","Pool");
        payload.put("additionalneeds3","Air conditioning");

        return payload;
    }
}
