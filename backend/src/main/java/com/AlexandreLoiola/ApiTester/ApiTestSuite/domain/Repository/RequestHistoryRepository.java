package com.AlexandreLoiola.ApiTester.ApiTestSuite.domain.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface RequestHistoryRepository extends JpaRepository<RequestHistoryRepository, UUID> {
}
