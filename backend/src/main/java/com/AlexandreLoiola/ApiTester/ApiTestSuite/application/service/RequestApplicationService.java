package com.AlexandreLoiola.ApiTester.ApiTestSuite.application.service;

import com.AlexandreLoiola.ApiTester.ApiTestSuite.application.dto.request.RequestRequest;
import com.AlexandreLoiola.ApiTester.ApiTestSuite.application.dto.response.RequestResponse;
import com.AlexandreLoiola.ApiTester.ApiTestSuite.domain.model.RequestModel;
import com.AlexandreLoiola.ApiTester.ApiTestSuite.domain.service.RequestService;
import com.AlexandreLoiola.ApiTester.ApiTestSuite.infrastructure.mapper.RequestMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RequestApplicationService {

   private final RequestMapper requestMapper;
   private final RequestService requestService;

    public RequestApplicationService(RequestMapper requestMapper, RequestService requestService) {
        this.requestMapper = requestMapper;
        this.requestService = requestService;
    }

    public RequestResponse registerRequest(RequestRequest request) {
      RequestModel model = requestMapper.toModel(request);
      RequestModel savedModel = requestService.save(model);
      return requestMapper.toResponse(savedModel);
   }

   public Page<RequestResponse> findAll(Pageable pageable) {
       Page<RequestModel> requestModel = requestService.findAll(pageable);
       return requestMapper.pageModeltoPageResponse(requestModel);
   }
}