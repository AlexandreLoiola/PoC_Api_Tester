package com.AlexandreLoiola.ApiTester.ApiTestSuite.domain.enumeration;

import lombok.Getter;

@Getter
public enum ParameterTypeEnum {
    INTEGER("Integer"),
    STRING("String"),
    BOOLEAN("Boolean"),
    FLOAT("Float"),
    DATE("Date");

    private final String type;

    ParameterTypeEnum(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public static ParameterTypeEnum fromString(String type) {
        for (ParameterTypeEnum parameterType : ParameterTypeEnum.values()) {
            if (parameterType.getType().equalsIgnoreCase(type)) {
                return parameterType;
            }
        }
        throw new IllegalArgumentException("Unknown type: " + type);
    }
}
