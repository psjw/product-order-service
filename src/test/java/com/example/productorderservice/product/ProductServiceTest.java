package com.example.productorderservice.product;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ProductServiceTest {

    @Autowired
    private ProductService productService;

    @Test
    void 상품조회() {
        //상품등록
        productService.addProduct(ProductSteps.상품등록요청_생성());
        final long productId = 1L;
        //상품을 조회
//        GetProductResponse response = productService.getProduct(productId);

        //상품의 응답을 검증
//        Assertions.assertThat(response).isNotNull();
    }

}
