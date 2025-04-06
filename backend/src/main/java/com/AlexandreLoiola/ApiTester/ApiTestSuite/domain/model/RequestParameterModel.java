package com.AlexandreLoiola.ApiTester.ApiTestSuite.domain.model;

import com.AlexandreLoiola.ApiTester.ApiTestSuite.domain.enumeration.ParameterTypeEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "tb_request_parameter")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RequestParameterModel {
    @Id
    @GeneratedValue
    private UUID id;

    @Column(name = "name", nullable = false, length = 255)
    private String name;

    @Column(name = "header_value", length = 1000)
    private String value;

    @Column(name = "type", nullable = false, length = 50)
    private ParameterTypeEnum type;

    @ManyToOne
    @JoinColumn(name = "request_id", nullable = false)
    private RequestModel request;
}