package com.AlexandreLoiola.ApiTester.ApiTestSuite.domain.Repository;

import com.AlexandreLoiola.ApiTester.ApiTestSuite.domain.model.RequestParameterModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface RequestParameterRepository extends JpaRepository<RequestParameterModel, UUID> {
}
