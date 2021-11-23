package logic;

public class User {
  private String name;
  private String surname;
  private double salary;

  // Для быстрого создания конструкторов, сеттеров и т.д
  // используется комбинация клавишь ALT+Insert
  public User(String name, String surname, double salary) {
    this.name     = name;
    this.surname  = surname;
    this.salary   = salary;
  }

  // Setters
  public void setName(String name) {
    this.name = name;
  }

  public void setSurname(String surname) {
    this.surname = surname;
  }

  public void setSalary(double salary) {
    this.salary = salary;
  }

  // Getters
  public String getName() {
    return name;
  }

  public String getSurname() {
    return surname;
  }

  public double getSalary() {
    return salary;
  }
}
