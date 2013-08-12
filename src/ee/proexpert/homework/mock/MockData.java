package ee.proexpert.homework.mock;

import ee.proexpert.homework.model.Data;

import java.util.ArrayList;
import java.util.List;

public class MockData {
  public static Data getMockData() {
    Data data = new Data();
    data.setActive("A");
    data.setPhoneNumber("12345678901234567890");
    data.setAdditionalService("J");
    data.setLanguage("I");
    data.setAdditionalServiceLanguage("I");
    data.setServiceEndDate("20130912");
    data.setServiceEndTime("2315");
    data.setServiceActivationStartTime("1500");
    data.setServiceActivationEndTime("2300");
    data.setList("K");
    String phoneNumber = "12345678901234";
    List<String> phoneNumbers = new ArrayList<String>();
    for (int i = 0; i < 8; i++) {
      phoneNumbers.add(phoneNumber + i);
    }
    data.setPhoneNumbers(phoneNumbers);
    String name = "abcd efgh hijk lmn";
    List<String> names = new ArrayList<String>();
    for (int i = 0; i < 8; i++) {
      names.add(name + i);
    }
    data.setNames(names);
    return data;
  }
}
