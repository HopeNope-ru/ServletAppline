package ru.appline;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.sun.deploy.net.HttpRequest;
import com.sun.deploy.net.HttpResponse;
import logic.Model;
import logic.User;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.atomic.AtomicInteger;

// При помощи addUser.html будет вызывать этот сервлет.
// Его вызов находится в форме и указан в action="add".
@WebServlet(urlPatterns = "/add")
public class ServletAdd extends HttpServlet {

  private AtomicInteger counter = new AtomicInteger(4);

  Model model = Model.getInstance();
  Gson  gson  = new GsonBuilder().setPrettyPrinting().create();

  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
    StringBuffer jb = new StringBuffer();
    String line;

    try {
      BufferedReader reader = request.getReader();
      while((line = reader.readLine()) != null) {
        jb.append(line);
      }
    }
    catch(Exception e) {
      System.out.println("Error");
    }

    System.out.println(jb);

    JsonObject jobject = gson.fromJson(String.valueOf(jb), JsonObject.class);
    request.setCharacterEncoding("UTF-8");

    String name     = jobject.get("name").getAsString();
    String surname  = jobject.get("surname").getAsString();
    double salary   = jobject.get("salary").getAsDouble();

    User user = new User(name, surname, salary);
    model.add(user, counter.getAndIncrement());

    response.setContentType("application/json;charset=utf-8");
    PrintWriter pw = response.getWriter();

    pw.print(gson.toJson(model.getUserFromList()));
  }

    // 2 версия
//  // Создает нового пользователя
//  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
//    // На запрос мы отвечаем html страницей с кодировкой utf-8
//    response.setContentType("text/html;charset=utf-8");
//
//    // Чтобы запросы адекватно обробатывали русские буквы
//    request.setCharacterEncoding("UTF-8");
//
//    PrintWriter pw = response.getWriter();
//
//    // Поиск введенных параметров из addUser.html
//    String name     = request.getParameter("name");
//    String surname  = request.getParameter("surname");
//    double salary   = Double.parseDouble(request.getParameter("salary"));
//
//    // Добавление пользователя в map
//    User user = new User(name, surname, salary);
//    model.add(user, counter.getAndIncrement());
//
//    // В новой html странице будет выведено следующее
//    pw.print(
//              "<html>" +
//              "<h3>Пользователь " + name + " " + surname + " с зарплатой: " + salary + " успешно добавлен</h3>" +
//              "<a href=\"addUser.html\">Создать нового пользователя</a><br/>" +
//              "<a href=\"index.jsp\">Домой</a>" +
//              "</html>"
//            );
//  }
}
