package ee.proexpert.homework.servlet;

import ee.proexpert.homework.mock.MockData;
import ee.proexpert.homework.model.Data;
import ee.proexpert.homework.util.DataUtil;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

public class ServiceServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;
  private static final Gson gson = new GsonBuilder().create();

  public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
    response.setContentType("application/json; charset=utf-8");
    System.out.println("Service was called: " + new Date());
    String parameter = (String) request.getParameter("q");
    Data data = null;
    PrintWriter out = response.getWriter();
    if (parameter != null && !parameter.isEmpty()) {
      data = MockData.getMockData();
    } else {
      data = DataUtil.getData();
    }
    String outText = gson.toJson(data);
    System.out.println(outText);
    out.println(outText);
  }
}
