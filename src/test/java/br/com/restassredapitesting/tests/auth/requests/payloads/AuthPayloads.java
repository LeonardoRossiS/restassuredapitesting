package br.com.restassredapitesting.tests.auth.requests.payloads;

import org.json.JSONObject;

public class AuthPayloads {
    public JSONObject jsonAuthLogin(){
        JSONObject authLogin = new JSONObject();

        authLogin.put("username", "admin");
        authLogin.put("password", "password123");

        return authLogin;
    }

}
