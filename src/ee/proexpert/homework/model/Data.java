package ee.proexpert.homework.model;

import java.util.List;

public class Data implements Cloneable {
  private int number;
  private boolean enabled;
  private String active;
  private String phoneNumber;
  private String additionalService;
  private String language;
  private String additionalServiceLanguage;
  private String serviceEndDate;
  private String serviceEndTime;
  private String serviceActivationStartTime;
  private String serviceActivationEndTime;
  private String list;
  private List<String> phoneNumbers;
  private List<String> names;

  public int getNumber() {
    return number;
  }

  public void setNumber(int number) {
    this.number = number;
  }

  public boolean isEnabled() {
    return enabled;
  }

  public void setEnabled(boolean enabled) {
    this.enabled = enabled;
  }

  public String getActive() {
    return active;
  }

  public void setActive(String active) {
    this.active = active;
  }

  public String getPhoneNumber() {
    return phoneNumber;
  }

  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  public String getAdditionalService() {
    return additionalService;
  }

  public void setAdditionalService(String additionalService) {
    this.additionalService = additionalService;
  }

  public String getLanguage() {
    return language;
  }

  public void setLanguage(String language) {
    this.language = language;
  }

  public String getAdditionalServiceLanguage() {
    return additionalServiceLanguage;
  }

  public void setAdditionalServiceLanguage(String additionalServiceLanguage) {
    this.additionalServiceLanguage = additionalServiceLanguage;
  }

  public String getServiceEndDate() {
    return serviceEndDate;
  }

  public void setServiceEndDate(String serviceEndDate) {
    this.serviceEndDate = serviceEndDate;
  }

  public String getServiceEndTime() {
    return serviceEndTime;
  }

  public void setServiceEndTime(String serviceEndTime) {
    this.serviceEndTime = serviceEndTime;
  }

  public String getServiceActivationStartTime() {
    return serviceActivationStartTime;
  }

  public void setServiceActivationStartTime(String serviceActivationStartTime) {
    this.serviceActivationStartTime = serviceActivationStartTime;
  }

  public String getServiceActivationEndTime() {
    return serviceActivationEndTime;
  }

  public void setServiceActivationEndTime(String serviceActivationEndTime) {
    this.serviceActivationEndTime = serviceActivationEndTime;
  }

  public String getList() {
    return list;
  }

  public void setList(String list) {
    this.list = list;
  }

  public List<String> getPhoneNumbers() {
    return phoneNumbers;
  }

  public void setPhoneNumbers(List<String> phoneNumbers) {
    this.phoneNumbers = phoneNumbers;
  }

  public List<String> getNames() {
    return names;
  }

  public void setNames(List<String> names) {
    this.names = names;
  }

  @Override
  public String toString() {
    return "Data [number=" + number + ", enabled=" + enabled + ", active=" + active + ", phoneNumber=" + phoneNumber + ", additionalService=" + additionalService
           + ", language=" + language + ", additionalServiceLanguage=" + additionalServiceLanguage + ", serviceEndDate=" + serviceEndDate + ", serviceEndTime="
           + serviceEndTime + ", serviceActivationStartTime=" + serviceActivationStartTime + ", serviceActivationEndTime=" + serviceActivationEndTime + ", list=" + list
           + ", phoneNumbers=" + phoneNumbers + ", names=" + names + "]";
  }
}
