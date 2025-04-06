package com.AlexandreLoiola.ApiTester.ApiTestSuite.domain.service;

import com.AlexandreLoiola.ApiTester.ApiTestSuite.domain.enumeration.HttpMethodEnum;
import com.AlexandreLoiola.ApiTester.ApiTestSuite.domain.model.RequestHeaderModel;
import com.AlexandreLoiola.ApiTester.ApiTestSuite.domain.model.RequestModel;
import com.AlexandreLoiola.ApiTester.ApiTestSuite.domain.model.RequestParameterModel;
import com.AlexandreLoiola.ApiTester.ApiTestSuite.domain.repository.RequestRepository;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class RequestService {

    private final RequestRepository requestRepository;

    public RequestService(RequestRepository requestRepository) {
        this.requestRepository = requestRepository;
    }

    public Page<RequestModel> findAll(Pageable pageable) {
        return requestRepository.findAllByIsActiveTrue(pageable);
    }

    public RequestModel save(RequestModel model) {
        validate(model);
        for (RequestHeaderModel header : model.getHeaders()) {
            header.setRequest(model);
        }
        for (RequestParameterModel parameter : model.getParameters()) {
            parameter.setRequest(model);
        }
        try {
            return requestRepository.save(model);
        } catch (DataIntegrityViolationException exception) {
            throw new RuntimeException("Cannot save the model", exception);
        }
    }

    public void validate(RequestModel model) {
        validateEndpoint(model.getEndpoint());
        validateUniqueParameters(model.getParameters());
        validateUniqueHeaders(model.getHeaders());
        validateBodyIfRequired(model.getHttpMethod(), model.getBody());
    }

    public void validateUniqueHeaders(List<RequestHeaderModel> headers) {
        Set<String> headerNames = new HashSet<>();
        for (RequestHeaderModel header : headers) {
            if (!headerNames.add(header.getName())) {
                throw new IllegalArgumentException("Duplicate header name: " + header.getName());
            }
        }
    }

    public void validateUniqueParameters(List<RequestParameterModel> parameters) {
        Set<String> parameterNames = new HashSet<>();
        for (RequestParameterModel parameter : parameters) {
            if (!parameterNames.add(parameter.getName())) {
                throw new IllegalArgumentException("Duplicate parameter name: " + parameter.getName());
            }
        }
    }

    public void validateEndpoint(String endpoint) {
        try {
            new java.net.URL(endpoint).toURI();
        } catch (Exception e) {
            throw new IllegalArgumentException("Invalid endpoint URL.");
        }
    }

    public void validateBodyIfRequired(HttpMethodEnum httpMethod, String body) {
        if ((httpMethod == HttpMethodEnum.POST || httpMethod == HttpMethodEnum.PUT || httpMethod == HttpMethodEnum.PATCH)
                && (body == null || body.isEmpty())) {
            throw new IllegalArgumentException("Body is required for " + httpMethod + " method.");
        }
    }

    void execute() {}
}
