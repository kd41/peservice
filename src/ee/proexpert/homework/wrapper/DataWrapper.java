package ee.proexpert.homework.wrapper;

import ee.proexpert.homework.model.Data;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.List;

public class DataWrapper {
  private static final Gson gson = new GsonBuilder().create();

  public static String getDataAsJson(Data data) {
    return gson.toJson(data);
  }

  public static Data getDataFromString(int number, String text) {
    Data data = new Data();
    data.setNumber(number);
    if ((text == null) || text.isEmpty()) {
      data.setEnabled(false);
      return data;
    }
    data.setEnabled(true);
    int index = 0;
    int shift = 1;
    String active = getValue(text, index, index + shift);
    data.setActive(active);
    index += shift;
    shift = 20;
    String phoneNumber = getValue(text, index, index + shift);
    data.setPhoneNumber(phoneNumber);
    index += shift;
    shift = 1;
    String additionalService = getValue(text, index, index + shift);
    data.setAdditionalService(additionalService);
    index += shift;
    shift = 1;
    String language = getValue(text, index, index + shift);
    data.setLanguage(language);
    index += shift;
    shift = 1;
    String additionalServiceLanguage = getValue(text, index, index + shift);
    data.setAdditionalServiceLanguage(additionalServiceLanguage);
    index += shift;
    shift = 8;
    String serviceEndDate = getValue(text, index, index + shift);
    data.setServiceEndDate(serviceEndDate);
    index += shift;
    shift = 4;
    String serviceEndTime = getValue(text, index, index + shift);
    data.setServiceEndTime(serviceEndTime);
    index += shift;
    shift = 4;
    String serviceActivationStartTime = getValue(text, index, index + shift);
    data.setServiceActivationStartTime(serviceActivationStartTime);
    index += shift;
    shift = 4;
    String serviceActivationEndTime = getValue(text, index, index + shift);
    data.setServiceActivationEndTime(serviceActivationEndTime);
    index += shift;
    shift = 1;
    String list = getValue(text, index, index + shift);
    data.setList(list);
    List<String> phoneNumbers = new ArrayList<String>(8);
    for (int i = 0; i < 8; i++) {
      index += shift;
      shift = 15;
      String phoneNumberInList = getValue(text, index, index + shift);
      if (!phoneNumberInList.isEmpty()) {
        phoneNumbers.add(phoneNumberInList);
      }
    }
    data.setPhoneNumbers(phoneNumbers);
    List<String> names = new ArrayList<String>(8);
    for (int i = 0; i < 8; i++) {
      index += shift;
      shift = 20;
      String name = getValue(text, index, index + shift);
      if (!name.isEmpty()) {
        names.add(name);
      }
    }
    data.setNames(names);
    return data;
  }

  private static String getValue(String text, int startIndex, int endIndex) {
    int len = text.length();
    if ((len < startIndex) || (len < endIndex)) {
      return "";
    }
    return text.substring(startIndex, endIndex);
  }
}
