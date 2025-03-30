package com.AlexandreLoiola.ApiTester.ApiTestSuite.domain.Repository;

import com.AlexandreLoiola.ApiTester.ApiTestSuite.domain.model.RequestHeaderModel;
import com.AlexandreLoiola.ApiTester.ApiTestSuite.domain.model.RequestModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface RequestHeaderRepository extends JpaRepository<RequestHeaderModel, UUID> {
}
