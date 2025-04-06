package com.AlexandreLoiola.ApiTester.ApiTestSuite.presentation.Controller;

import com.AlexandreLoiola.ApiTester.ApiTestSuite.application.dto.request.RequestRequest;
import com.AlexandreLoiola.ApiTester.ApiTestSuite.application.dto.response.RequestResponse;
import com.AlexandreLoiola.ApiTester.ApiTestSuite.application.service.RequestApplicationService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/requests")
public class RequestController {
    private final RequestApplicationService requestApplicationService;

    public RequestController(RequestApplicationService requestApplicationService) {
        this.requestApplicationService = requestApplicationService;
    }

    @GetMapping
    public ResponseEntity<Page<RequestResponse>> findAll(Pageable pageable) {
        Page<RequestResponse> responses = requestApplicationService.findAll(pageable);
        return ResponseEntity.status(HttpStatus.OK).body(responses);
    }

    @PostMapping
    public ResponseEntity<RequestResponse> registerRequest(
            @Valid @RequestBody RequestRequest request
    ) {
        RequestResponse response = requestApplicationService.registerRequest(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
