package ee.proexpert.homework.worker;

import ee.proexpert.homework.model.Data;
import ee.proexpert.homework.wrapper.DataWrapper;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class DataWorker {
  private static Data data;
  private static int delay = 5;
  private static int count;

  static {
    updateData();
    Executors.newSingleThreadScheduledExecutor().scheduleAtFixedRate(new Runnable() {
      @Override
      public void run() {
        updateData();
      }
    }, 0, delay, TimeUnit.SECONDS);
  }

  public static Data getLastDate() {
    return data;
  }

  private static void updateData() {
    URL url = null;
    String text = null;
    try {
      String requestedUrl = "http://people.proekspert.ee/ak/data_" + increaseAndGetCount() + ".txt";
      url = new URL(requestedUrl);
      URLConnection conn = url.openConnection();
      BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "utf-8"));
      text = in.readLine();
      if (!text.isEmpty()) {
        //System.out.println(text);
      }
    } catch (FileNotFoundException e) {
      System.out.println("File not found: " + url);
    } catch (Exception e) {
      e.printStackTrace();
    }
    data = DataWrapper.getDataFromString(count, text);
    //System.out.println(data);
  }

  private static int increaseAndGetCount() {
    if (count == 9) {
      count = 0;
    }
    return ++count;
    //    return 5;
  }
}
