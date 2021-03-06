package com.rest.test.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;

@SpringBootTest
class RestApiServiceTest {
    @Autowired
    private RestApiService restApiService;

    @Autowired
    private ApiService apiService;

    @DisplayName("RestTemplate을 사용한 API 호출 테스트")
    @Test
    void test() {
        final String BASE_URL = "https://www.youtube.com/oembed";
        final String PARAM_URL = "https://www.youtube.com/watch?v=dBD54EZIrZo&format=json";

        HashMap<String, Object> resultMap = restApiService.getOembedData(BASE_URL, PARAM_URL);

        assert (resultMap.get("body") != null);
    }

    @Test
    void apiTest() {
        HashMap<String, Object> data = apiService.getData();

        assert (data.get("body") != null);
    }
}