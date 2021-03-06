package com.talent;



import com.talent.log.LoggerOutputStream;
import static io.restassured.RestAssured.*;

import io.restassured.RestAssured;
import org.junit.Before;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import org.slf4j.Logger;


import java.io.IOException;
import java.io.PrintStream;

import static io.restassured.config.LogConfig.logConfig;
import static io.restassured.config.RestAssuredConfig.config;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;




public class SWApiTestWithRestAssured {

    //private final Logger logger = LoggerFactory.getLogger(getClass());

    @Before
    public void requestBeforeSwapi(){
        baseURI = "https://swapi.dev/api/";
    }

    @Test
    public void getTestSwapi(){
        baseURI = "https://swapi.dev/api/";

                given()
                .log().all()
                .get("/planets/1/")
                .then()
                .log()
                .ifError()
                .statusCode(is(equalTo(200)))
                        .body("population", equalTo("200000"))
                        .log().all();

    }


    /*@Test
    public void whenRequestingAResourceThenLinksToResourcesMustBeReturned() throws IOException {

        try (LoggerOutputStream outputStream = new LoggerOutputStream(logger)) {
            RestAssured.config = config().logConfig(logConfig()
                    .defaultStream(new PrintStream(outputStream))
                    .enableLoggingOfRequestAndResponseIfValidationFails());

            RestAssured
                    .given()
                    .log().method().and().log().uri().and().log().params()
                    .queryParam("format", "json")
                    .when()
                    .get("https://swapi.dev/api/")
                    .then()
                    .assertThat().statusCode(is(equalTo(200)));

            outputStream.flush();

            RestAssured
                    .given()
                    .queryParam("format", "json")
                    .when()
                    .post("https://swapi.dev/api/films/")
                    .then()
                    .assertThat().statusCode(is(equalTo(200)));

            outputStream.flush();
        }

    }
*/

}