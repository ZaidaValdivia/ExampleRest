package com.talent;

import com.talent.bind.BaseApiResponse;
import io.restassured.RestAssured;
import io.restassured.config.LogConfig;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.config;
import static io.restassured.config.LogConfig.logConfig;
import static org.hamcrest.Matchers.*;

public class SWApiTestWithRestAssured {

    @Test
    public void whenRequestingAResourceThenLinksToResourcesMustBeReturned() {

        RestAssured
                .given()
                .queryParam("format", "json")
                .config(config().logConfig(logConfig().enableLoggingOfRequestAndResponseIfValidationFails()))
                .when().get("https://swapi.dev/api/planets/?format=json")
                .then().assertThat()
                .statusCode(is(equalTo(200)));

    }
}
