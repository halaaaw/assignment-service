package com.assignment.dataservice.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.assignment.dataservice.persistence.entities.ServiceRequest;
import com.assignment.dataservice.persistence.repositories.ServiceRequestJpaRepository;

/**
 * provides ServiceRequest entity services
 *
 * @author HALAALI
 *
 */
@Service
public class ServiceRequestsService {

  @Autowired
  private ServiceRequestJpaRepository serviceRequestJpaRepository;

  /**
   * saves the provided request into the DB.
   *
   * @param request
   */
  public void saveServiceRequest(ServiceRequest request) {
    serviceRequestJpaRepository.save(request);
  }

  public List<ServiceRequest> getApiHistory(String apiName) {
    return serviceRequestJpaRepository.findByApiName(apiName);
  }
}
