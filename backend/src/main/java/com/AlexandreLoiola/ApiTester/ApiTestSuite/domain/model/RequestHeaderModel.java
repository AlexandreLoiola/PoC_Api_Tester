package com.AlexandreLoiola.ApiTester.ApiTestSuite.domain.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;


@Entity
@Table(name = "tb_request_header")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RequestHeaderModel {
    @Id
    @GeneratedValue
    private UUID id;

    @Column(name = "name", nullable = false, length = 255)
    private String name;

    @Column(name = "parameter_value", length = 1000)
    private String value;

    @ManyToOne
    @JoinColumn(name = "request_id", nullable = false)
    private RequestModel request;
}
