package com.AlexandreLoiola.ApiTester.ApiTestSuite.domain.model;

import com.AlexandreLoiola.ApiTester.ApiTestSuite.infrastructure.ZonedDateTimeAttributeConverter;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.ZonedDateTime;
import java.util.UUID;

@Entity
@Table(name = "tb_request_history")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RequestHistoryModel {
    @Id
    @GeneratedValue
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "request_id", nullable = false)
    private RequestModel request;

    @Convert(converter = ZonedDateTimeAttributeConverter.class)
    @Column(name = "executed_at", nullable = false, updatable = false)
    private ZonedDateTime executedAt;

    @Column(name = "status_code", nullable = false)
    private int statusCode;

    @Column(name = "response_time_ms", nullable = false)
    private long responseTimeMs;

    @Lob
    @Column(name = "response_body")
    private String responseBody;

    @Column(name = "error_message")
    private String errorMessage;
}

