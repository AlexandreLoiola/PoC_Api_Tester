package com.AlexandreLoiola.ApiTester.ApiTestSuite.application.dto.response;

import com.AlexandreLoiola.ApiTester.ApiTestSuite.domain.enumeration.ParameterTypeEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RequestParameterResponse {
    private String name;
    private String value;
    private ParameterTypeEnum type;
}
