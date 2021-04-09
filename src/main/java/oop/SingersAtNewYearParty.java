package oop;

import java.util.Random;

public class SingersAtNewYearParty {

    public static void main(String[] args) {
        Random random = new Random();
        Array randomBase = new Array();

//Создать массив из 5 сотрудников.
        Employee[] singers = new Employee[5];

        for (int i = 0; i < 5; i++) {
            singers[i] = new Employee(randomBase.fio[random.nextInt(10)]
                    , randomBase.position[random.nextInt(10)], randomBase.eMail[random.nextInt(10)]
                    , randomBase.phoneNumber[random.nextInt(10)], randomBase.salary[random.nextInt(10)]
                    , randomBase.age[random.nextInt(10)]);
        }

//С помощью цикла вывести информацию только о сотрудниках старше 40 лет.
        for (Employee i : singers) {
            if (i.getAge() > 40) {
                System.out.println("---");
                i.employeeInfoPrint();
                System.out.println("---");
            }
        }


    }

}
