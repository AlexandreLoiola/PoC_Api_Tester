package com.AlexandreLoiola.ApiTester.ApiTestSuite.infrastructure.mapper;

import com.AlexandreLoiola.ApiTester.ApiTestSuite.application.dto.request.RequestHeaderRequest;
import com.AlexandreLoiola.ApiTester.ApiTestSuite.application.dto.request.RequestParameterRequest;
import com.AlexandreLoiola.ApiTester.ApiTestSuite.application.dto.request.RequestRequest;
import com.AlexandreLoiola.ApiTester.ApiTestSuite.application.dto.response.RequestHeaderResponse;
import com.AlexandreLoiola.ApiTester.ApiTestSuite.application.dto.response.RequestParameterResponse;
import com.AlexandreLoiola.ApiTester.ApiTestSuite.application.dto.response.RequestResponse;
import com.AlexandreLoiola.ApiTester.ApiTestSuite.domain.model.RequestHeaderModel;
import com.AlexandreLoiola.ApiTester.ApiTestSuite.domain.model.RequestModel;
import com.AlexandreLoiola.ApiTester.ApiTestSuite.domain.model.RequestParameterModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class RequestMapper {

    public RequestModel toModel(RequestRequest requestRequest) {
        RequestModel requestModel = new RequestModel();
        requestModel.setEndpoint(requestRequest.getEndpoint());
        requestModel.setHttpMethod(requestRequest.getHttpMethod());
        requestModel.setBody(requestRequest.getBody());
        requestModel.setDescription(requestRequest.getDescription());

        if (requestRequest.getHeaders() != null) {
            List<RequestHeaderModel> headers = new ArrayList<>();
            for (RequestHeaderRequest headerRequest : requestRequest.getHeaders()) {
                RequestHeaderModel headerModel = new RequestHeaderModel();
                headerModel.setName(headerRequest.getName());
                headerModel.setValue(headerRequest.getValue());
                headers.add(headerModel);
            }
            requestModel.setHeaders(headers);
        }

        if (requestRequest.getParameters() != null) {
            List<RequestParameterModel> parameters = new ArrayList<>();
            for (RequestParameterRequest parameterRequest : requestRequest.getParameters()) {
                RequestParameterModel parameterModel = new RequestParameterModel();
                parameterModel.setName(parameterRequest.getName());
                parameterModel.setValue(parameterRequest.getValue());
                parameterModel.setType(parameterRequest.getType());
                parameters.add(parameterModel);
            }
            requestModel.setParameters(parameters);
        }
        return requestModel;
    }

    public RequestResponse toResponse(RequestModel requestModel) {
        RequestResponse requestResponse = new RequestResponse();
        requestResponse.setEndpoint(requestModel.getEndpoint());
        requestResponse.setHttpMethod(requestModel.getHttpMethod());
        requestResponse.setBody(requestModel.getBody());
        requestResponse.setDescription(requestModel.getDescription());

        if (requestModel.getHeaders() != null) {
            List<RequestHeaderResponse> headerResponses = new ArrayList<>();
            for (RequestHeaderModel headerModel : requestModel.getHeaders()) {
                RequestHeaderResponse headerResponse = new RequestHeaderResponse();
                headerResponse.setName(headerModel.getName());
                headerResponse.setValue(headerModel.getValue());
                headerResponses.add(headerResponse);
            }
            requestResponse.setHeaders(headerResponses);
        }

        if (requestModel.getParameters() != null) {
            List<RequestParameterResponse> parameterResponses = new ArrayList<>();
            for (RequestParameterModel parameterModel : requestModel.getParameters()) {
                RequestParameterResponse parameterResponse = new RequestParameterResponse();
                parameterResponse.setName(parameterModel.getName());
                parameterResponse.setValue(parameterModel.getValue());
                parameterResponse.setType(parameterModel.getType());
                parameterResponses.add(parameterResponse);
            }
            requestResponse.setParameters(parameterResponses);
        }
        return requestResponse;
    }

    public Page<RequestResponse> pageModeltoPageResponse(Page<RequestModel> models) {
        return models.map(this::toResponse);
    }
}
