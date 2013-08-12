package ee.proexpert.homework.util;

import ee.proexpert.homework.model.Data;
import ee.proexpert.homework.worker.DataWorker;

public class DataUtil {

  public static Data getData() {
    return DataWorker.getLastDate();
  }
}
