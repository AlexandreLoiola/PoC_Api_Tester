package com.AlexandreLoiola.ApiTester.ApiTestSuite.application.dto.request;

import com.AlexandreLoiola.ApiTester.ApiTestSuite.domain.enumeration.ParameterTypeEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.validation.constraints.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RequestParameterRequest {
    @NotNull(message = "The name of the parameter cannot be null.")
    @Size(max = 255, message = "The name of the parameter cannot exceed 255 characters.")
    private String name;

    @NotNull(message = "The value of the parameter cannot be null.")
    @Size(max = 1000, message = "The value of the parameter cannot exceed 1000 characters.")
    private String value;

    @NotNull(message = "The type of the parameter cannot be null.")
    @Size(max = 50, message = "The type of the parameter cannot exceed 50 characters.")
    private ParameterTypeEnum type;
}
