package com.assignment.dataservice.api;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.assignment.dataservice.persistence.entities.ServiceRequest;
import com.assignment.dataservice.services.ServiceRequestsService;
import com.google.gson.Gson;

/**
 * @author HALAALI
 *
 */
@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/history")
public class ApiHistoryController {
  @Autowired
  private ServiceRequestsService serviceRequestsService;

  @GetMapping(path = "/{apiName}",
      produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<String> getApiHistory(@PathVariable String apiName,
      HttpServletRequest servletRequest) {
    List<ServiceRequest> requests = serviceRequestsService.getApiHistory(apiName);
    Gson gson = new Gson();
    System.out.println("apiName::::::::::::::::::::" + apiName);
    return ResponseEntity.ok(gson.toJson(requests));

  }

}
