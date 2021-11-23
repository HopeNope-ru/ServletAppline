package logic;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

// Модель работы с данными
public class Model implements Serializable {
  private static final Model instance = new Model();

  private final Map<Integer, User> model;

  public static Model getInstance() {
    return instance;
  }

  public Model() {
    model = new HashMap<>();

    model.put(1, new User("Kirill", "Gasanov", 100000));
    model.put(2, new User("Anton", "Osipov", 80000));
    model.put(3, new User("Sofya", "Andreeva", 100000));
  }

  public void add(User user, Integer id) {
    model.put(id, user);
  }

  public void delete(int id) {
    model.remove(id);
  }

  public void put(User user, int id) {
    add(user, id);
  }

  public Map<Integer, User> getUserFromList() {
    return model;
  }
}
