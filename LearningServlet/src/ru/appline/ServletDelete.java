package ru.appline;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import logic.Model;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

@WebServlet(urlPatterns = "/del")
public class ServletDelete extends HttpServlet {
  private Model model = Model.getInstance();
  private Gson  gson  = new GsonBuilder().setPrettyPrinting().create();

  protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws IOException {
    request.setCharacterEncoding("UTF-8");

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

    int id = jobject.get("id").getAsInt();
    model.delete(id);

    PrintWriter pw = response.getWriter();
    response.setContentType("application/json;charset=utf-8");

    pw.print(gson.toJson(model.getUserFromList()));
  }
}
