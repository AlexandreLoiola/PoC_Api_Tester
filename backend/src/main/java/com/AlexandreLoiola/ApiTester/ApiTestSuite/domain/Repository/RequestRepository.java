package com.AlexandreLoiola.ApiTester.ApiTestSuite.domain.Repository;

import com.AlexandreLoiola.ApiTester.ApiTestSuite.domain.model.RequestModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface RequestRepository extends JpaRepository<RequestModel, UUID> {
}
