package com.AlexandreLoiola.ApiTester.ApiTestSuite.application.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RequestHeaderResponse {
    private String name;
    private String value;
}
