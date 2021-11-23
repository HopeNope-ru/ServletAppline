package ru.appline;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import logic.Model;
import logic.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/change")
public class ServletPut extends HttpServlet {
  private Model model = Model.getInstance();
  private Gson  gson  = new GsonBuilder().setPrettyPrinting().create();

  protected void doPut(HttpServletRequest request, HttpServletResponse response) throws IOException {
    StringBuffer  jb = new StringBuffer();
    String        line;

    try {
      BufferedReader br = request.getReader();
      while ((line = br.readLine()) != null) {
        jb.append(line);
      }
    }
    catch(Exception e) {
      System.out.println("error");
    }

    System.out.println(jb);

    JsonObject jobject = gson.fromJson(String.valueOf(jb), JsonObject.class);
    request.setCharacterEncoding("UTF-8");

    int    id       = jobject.get("id").getAsInt();
    String name     = jobject.get("name").getAsString();
    String surname  = jobject.get("surname").getAsString();
    double salary   = jobject.get("salary").getAsDouble();

    User user = new User(name, surname, salary);
    model.put(user, id);

    response.setContentType("application/json;charset=utf-8");
    PrintWriter pw = response.getWriter();

    pw.print(gson.toJson(model.getUserFromList()));
  }
}
