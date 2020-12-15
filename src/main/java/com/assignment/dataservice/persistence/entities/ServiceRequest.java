package com.assignment.dataservice.persistence.entities;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;

/**
 * Represents a request made to an api. The object has all details about the request including the
 * request body, response body, and api name.
 *
 * @author HALAALI
 *
 */
@Entity
public class ServiceRequest {
  @Id
  @GeneratedValue
  private Long id;
  private String apiName;
  @Lob
  @Column(length = 100000)
  private String requestBody;
  @Lob
  @Column(length = 100000)
  private String responseBody;
  private String user;
  private Date requestDate;
  private String fileName;

  /**
   * @return the fileName
   */
  public String getFileName() {
    return fileName;
  }

  /**
   * @param fileName the fileName to set
   */
  public void setFileName(String fileName) {
    this.fileName = fileName;
  }

  /**
   *
   * @param id
   * @param apiName
   * @param requestBody
   * @param responseBody
   * @param user
   * @param requestDate
   * @param fileName
   */
  public ServiceRequest(String apiName, String requestBody, String responseBody,
      String user, Date requestDate, String fileName) {
    super();
    this.apiName = apiName;
    this.requestBody = requestBody;
    this.responseBody = responseBody;
    this.user = user;
    this.requestDate = requestDate;
    this.fileName = fileName;
  }

  /**
   * default constructor
   */
  public ServiceRequest() {

  }

  /**
   * @return the id
   */
  public Long getId() {
    return id;
  }

  /**
   * @param id the id to set
   */
  public void setId(Long id) {
    this.id = id;
  }

  /**
   * @return the apiName
   */
  public String getApiName() {
    return apiName;
  }

  /**
   * @param apiName the apiName to set
   */
  public void setApiName(String apiName) {
    this.apiName = apiName;
  }

  /**
   * @return the requestBody
   */
  public String getRequestBody() {
    return requestBody;
  }

  /**
   * @param requestBody the requestBody to set
   */
  public void setRequestBody(String requestBody) {
    this.requestBody = requestBody;
  }

  /**
   * @return the responseBody
   */
  public String getResponseBody() {
    return responseBody;
  }

  /**
   * @param responseBody the responseBody to set
   */
  public void setResponseBody(String responseBody) {
    this.responseBody = responseBody;
  }

  /**
   * @return the user
   */
  public String getUser() {
    return user;
  }

  /**
   * @param user the user to set
   */
  public void setUser(String user) {
    this.user = user;
  }

  /**
   * @return the requestDate
   */
  public Date getRequestDate() {
    return requestDate;
  }

  /**
   * @param requestDate the requestDate to set
   */
  public void setRequestDate(Date requestDate) {
    this.requestDate = requestDate;
  }


}
