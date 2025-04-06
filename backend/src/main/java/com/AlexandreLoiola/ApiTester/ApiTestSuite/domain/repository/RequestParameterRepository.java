package com.AlexandreLoiola.ApiTester.ApiTestSuite.domain.repository;

import com.AlexandreLoiola.ApiTester.ApiTestSuite.domain.model.RequestParameterModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface RequestParameterRepository extends JpaRepository<RequestParameterModel, UUID> {
}
