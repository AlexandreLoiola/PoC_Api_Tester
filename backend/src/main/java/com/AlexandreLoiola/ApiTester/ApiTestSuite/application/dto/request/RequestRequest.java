package com.AlexandreLoiola.ApiTester.ApiTestSuite.application.dto.request;

import com.AlexandreLoiola.ApiTester.ApiTestSuite.domain.enumeration.HttpMethodEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.validation.constraints.*;


import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RequestRequest {
    @NotNull(message = "The endpoint cannot be null.")
    @Size(max = 500, message = "The endpoint cannot exceed 500 characters.")
    private String endpoint;

    @NotNull(message = "The HTTP method cannot be null.")
    private HttpMethodEnum httpMethod;

    private List<RequestHeaderRequest> headers;

    private List<RequestParameterRequest> parameters;

    @Size(max = 1000, message = "The body cannot exceed 1000 characters.")
    private String body;

    @Size(max = 1000, message = "The description cannot exceed 1000 characters.")
    private String description;
}
