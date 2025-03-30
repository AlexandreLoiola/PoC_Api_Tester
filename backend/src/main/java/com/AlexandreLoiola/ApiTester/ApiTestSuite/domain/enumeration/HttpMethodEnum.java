package com.AlexandreLoiola.ApiTester.ApiTestSuite.domain.enumeration;

import lombok.Getter;

import java.util.Arrays;

@Getter
public enum HttpMethodEnum {
    GET, POST, PUT, DELETE, PATCH, HEAD, OPTIONS;

    public static HttpMethodEnum fromString(String method) {
        return Arrays.stream(HttpMethodEnum.values())
                .filter(m -> m.name().equalsIgnoreCase(method))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Invalid HTTP method: " + method));
    }
}
