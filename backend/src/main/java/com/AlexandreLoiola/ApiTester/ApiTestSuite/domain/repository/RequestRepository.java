package com.AlexandreLoiola.ApiTester.ApiTestSuite.domain.repository;

import com.AlexandreLoiola.ApiTester.ApiTestSuite.domain.model.RequestModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface RequestRepository extends JpaRepository<RequestModel, UUID> {

    Page<RequestModel> findAllByIsActiveTrue(Pageable pageable);
}
