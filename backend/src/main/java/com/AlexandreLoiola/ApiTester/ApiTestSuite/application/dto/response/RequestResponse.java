package com.AlexandreLoiola.ApiTester.ApiTestSuite.application.dto.response;

import com.AlexandreLoiola.ApiTester.ApiTestSuite.domain.enumeration.HttpMethodEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RequestResponse {
    private String endpoint;
    private HttpMethodEnum httpMethod;
    private List<RequestHeaderResponse> headers;
    private List<RequestParameterResponse> parameters;
    private String body;
    private String description;
}
