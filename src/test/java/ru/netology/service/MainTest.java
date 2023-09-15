package ru.netology.service;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.*;

class MainTest {
    @Test
    public void MobileBankApiTestV7() {
        // Given - When - Then
        // Предусловия
        given()
                .log().all()
                .baseUri("https://postman-echo.com")
                .body("some data") // отправляемые данные (заголовки и query можно выставлять аналогично)
        // Выполняемые действия
                .when()
                .post("/post")
                .prettyPeek()
        // Проверки
                .then()
                .statusCode(200)
                .body("data", equalTo("some data"))
        ;
    }
}