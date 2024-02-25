package com.example.productorderservice.product;

import com.example.productorderservice.ApiTest;
import io.restassured.RestAssured;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import io.restassured.specification.ResponseSpecification;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;


public class ProductApiTest extends ApiTest {

//    @Autowired
//    private ProductService productService;


    @Test
    void 상품등록() {
        final AddProductRequest request = 상품등록요청_생성();
//        productService.addProduct(request);
        //API 요청
        final ExtractableResponse<Response> response = RestAssured.given().log().all()
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .body(request)
                .when()
                .post("/products")
                .then()
                .log().all().extract();

        Assertions.assertThat(response.statusCode()).isEqualTo(HttpStatus.CREATED.value());

    }

    private static AddProductRequest 상품등록요청_생성() {
        final String name = "상품명";
        int price = 1000;
        DiscountPolicy discountPolicy = DiscountPolicy.NONE;
        final AddProductRequest request = new AddProductRequest(name, price, discountPolicy);
        return request;
    }


}
