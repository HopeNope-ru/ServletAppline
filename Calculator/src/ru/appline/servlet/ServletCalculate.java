package ru.appline.servlet;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import ru.appline.Calculator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/calculate")
public class ServletCalculate extends HttpServlet {
  private Gson  gson = new GsonBuilder().setPrettyPrinting().create();

  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    request.setCharacterEncoding("UTF-8");

    StringBuffer  buff = new StringBuffer();
    String        line;

    try {
      BufferedReader br = request.getReader();
      while((line = br.readLine()) != null) {
        buff.append(line);
      }
    }
    catch (Exception e) {
      System.out.println("error");
    }

    System.out.println(buff);

    JsonObject jobject = gson.fromJson(String.valueOf(buff), JsonObject.class);

    double x  = jobject.get("x").getAsDouble();
    double y  = jobject.get("y").getAsDouble();
    String op = jobject.get("math").getAsString();

    Calculator calculator = new Calculator(x, y, op);

    PrintWriter pw = response.getWriter();
    response.setContentType("application/json");

    pw.print(gson.toJson(calculator.calculate()));
  }
}
