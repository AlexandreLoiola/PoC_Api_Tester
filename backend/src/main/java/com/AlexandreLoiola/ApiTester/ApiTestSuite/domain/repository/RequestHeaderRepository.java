package com.AlexandreLoiola.ApiTester.ApiTestSuite.domain.repository;

import com.AlexandreLoiola.ApiTester.ApiTestSuite.domain.model.RequestHeaderModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface RequestHeaderRepository extends JpaRepository<RequestHeaderModel, UUID> {
}
