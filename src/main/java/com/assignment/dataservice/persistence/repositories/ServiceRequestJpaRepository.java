package com.assignment.dataservice.persistence.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.assignment.dataservice.persistence.entities.ServiceRequest;

/**
 * JPA Repository to handle ServiceRequest entity operations.
 *
 * @author HALAALI
 *
 */
@Repository
public interface ServiceRequestJpaRepository extends JpaRepository<ServiceRequest, Long> {
  List<ServiceRequest> findByApiName(String apiName);
}
