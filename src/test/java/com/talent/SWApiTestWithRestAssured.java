package com.talent;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.*;

public class SWApiTestWithRestAssured {

    @Test
    public void requestAresourcesThenLinkToReturn(){

        ValidatableResponse body = RestAssured
                .given()
                .baseUri("https://swapi.dev/api")
                .and()
                .queryParam("format", "json")
                .when()
                .get("/")
                .then()
                .log().all()
                .and().assertThat().statusCode(is(equalTo(200)));
    }
}
