package ru.appline;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.internal.GsonBuildConfig;
import com.sun.xml.internal.ws.resources.HttpserverMessages;
import logic.Model;
import logic.User;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.Buffer;
import java.util.Map;

// При помощи index.jsp будет вызывать этот сервлет.
// Его вызов находится в форме и указан в action="get".
@WebServlet(urlPatterns = "/get")
public class ServletList extends HttpServlet {
  private Model model = Model.getInstance();
  private Gson  gson  = new GsonBuilder().setPrettyPrinting().create();

  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
    PrintWriter pw = response.getWriter();
    response.setContentType("application/json; charset=utf-8");

    pw.print(gson.toJson(model.getUserFromList()));
  }

//  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
//    response.setContentType("text/html;charset=utf-8");
//
//    PrintWriter pw = response.getWriter();
//
//    int id = Integer.parseInt(request.getParameter("ID"));
//
//    if(id == 0) {
//      pw.print(
//                "<html>" +
//                "<h3>Доступные пользователи</h3><br/>" +
//                "ID пользователя: " +
//                "<ul>"
//              );
//      for(Map.Entry<Integer, User> entry : model.getUserFromList().entrySet()) {
//        pw.print(
//                  "<li>"            + entry.getKey() + "</li>" +
//                  "<ul>"            +
//                  "<li>Имя: "       + entry.getValue().getName()    + "</li>" +
//                  "<li>Фамилия: "   + entry.getValue().getSurname() + "</li>" +
//                  "<li>Зарплата: "  + entry.getValue().getSalary()  + "</li>" +
//                  "</ul>"
//                );
//      }
//      pw.print(
//                "</ul>" +
//                "<a href=\"index.jsp\">Домой</a>" +
//                "</html>"
//              );
//    }
//    else if(id > 0) {
//      if(id > model.getUserFromList().size()) {
//        pw.print(
//                  "<html>" +
//                  "<h3>Выход за пределы количества пользавателей<h3><br/>" +
//                  "<a href=\"index.jsp\">Домой</a>" +
//                  "</html>"
//                );
//      }
//      else {
//        pw.print(
//                  "<html>"           +
//                  "<br/>Имя: "       + model.getUserFromList().get(id).getName()     +
//                  "<br/>Фамилия: "   + model.getUserFromList().get(id).getSurname()  +
//                  "<br/>Зарплата: "  + model.getUserFromList().get(id).getSalary()   +
//                  "<br/><a href=\"index.jsp\">Домой</a>" +
//                  "/html"
//                );
//      }
//    }
//    else {
//      pw.print(
//              "<html>" +
//              "<h3>ID должен быть не отрицательным<h3><br/>" +
//              "<a href=\"index.jsp\">Домой</a>" +
//              "</html>"
//      );
//    }
//  }
}
