package com.github.lipesc.springapidev.entity;

public class WithdrawRequest {

  private double amount;
  private Long clientId;
  private Long companyId;
  // getters and setters
  public double getAmount() {
    return amount;
  }

  public void setAmount(double amount) {
    this.amount = amount;
  }

  public Long getClientId() {
    return clientId;
  }

  public void setClientId(Long clientId) {
    this.clientId = clientId;
  }

  public Long getCompanyId() {
    return companyId;
  }

  public void setCompanyId(Long companyId) {
    this.companyId = companyId;
  }


}
