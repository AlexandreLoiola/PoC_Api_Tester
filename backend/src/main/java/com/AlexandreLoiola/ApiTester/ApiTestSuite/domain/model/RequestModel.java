package com.AlexandreLoiola.ApiTester.ApiTestSuite.domain.model;

import com.AlexandreLoiola.ApiTester.ApiTestSuite.domain.enumeration.HttpMethodEnum;
import com.AlexandreLoiola.ApiTester.ApiTestSuite.infrastructure.ZonedDateTimeAttributeConverter;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "tb_request")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RequestModel {
    @Id
    @GeneratedValue
    private UUID id;

    @Column(name = "endpoint", nullable = false, length = 500)
    private String endpoint;

    @Enumerated(EnumType.STRING)
    @Column(name = "http_method", nullable = false)
    private HttpMethodEnum httpMethod;

    @OneToMany(mappedBy = "request", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<RequestHeaderModel> headers;

    @OneToMany(mappedBy = "request", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<RequestParameterModel> parameters;

    @Lob
    @Column(name = "body", columnDefinition = "TEXT")
    private String body;

    @Column(name = "description", length = 1000)
    private String description;

    @Convert(converter = ZonedDateTimeAttributeConverter.class)
    @Column(name = "created_at", nullable = false)
    private ZonedDateTime createdAt;

    @Convert(converter = ZonedDateTimeAttributeConverter.class)
    @Column(name = "updated_at")
    private ZonedDateTime updatedAt;

    @Column(name = "is_active", nullable = false)
    private boolean isActive;

    @Version
    @Column(name = "version", nullable = false)
    private long version;

    @PrePersist
    public void prePersist() {
        this.isActive = true;
        ZonedDateTime now = ZonedDateTime.now();
        this.createdAt = now;
        this.updatedAt = now;
    }
}