package com.rest.test.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@Service
@RequiredArgsConstructor
public class RestApiService {
    private final RestTemplate restTemplate;

    public HashMap<String, Object> getOembedData(final String baseUrl, final String url) {
        HashMap<String, Object> result = new HashMap<>();
        UriComponents uri = UriComponentsBuilder.fromHttpUrl(baseUrl + "?url=" + url).build();


        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE);

        ResponseEntity<Map> resultMap = restTemplate.exchange(uri.toString(), HttpMethod.GET, new HttpEntity<>(headers), Map.class);
        result.put("statusCode", resultMap.getStatusCode());
        result.put("header", resultMap.getHeaders());
        result.put("body", resultMap.getBody());

        return result;
    }
}
