package oop;

//Создать класс "Сотрудник" с полями: ФИО, должность, email, телефон, зарплата, возраст
public class Employee {

    private final String FIO;
    private final String position;
    private final String eMail;
    private final long phoneNumber;
    private final double salary;
    private final int age;

//Конструктор класса должен заполнять эти поля при создании объекта

    //Из задания не понятно должен ли конструктор заполнять поля атоматически или требовать заполнения
    //На всякий случай создам 2 конструктора
    public Employee() {
        FIO = "Ivanov Ivan Ivanovich";
        position = "HR";
        eMail = "ivanov.hr@company.com";
        phoneNumber = 88001234512L;
        salary = 50000;
        age = 30;
    }

    public Employee(String FIO, String position, String eMail, long phoneNumber, double salary, int age) {
        this.FIO = FIO;
        this.position = position;
        this.eMail = eMail;
        this.phoneNumber = phoneNumber;
        this.salary = salary;
        this.age = age;
    }

//Внутри класса «Сотрудник» написать метод, который выводит информацию об объекте в консоль.
    public void employeeInfoPrint() {
        System.out.println("FIO = " + FIO);
        System.out.println("position = " + position);
        System.out.println("eMail = " + eMail);
        System.out.println("phoneNumber = " + phoneNumber);
        System.out.println("salary = " + 50000);
        System.out.println("age = " + age);
    }



    //Добавил герер для последнего задания
    public int getAge() {
        return age;
    }



}
