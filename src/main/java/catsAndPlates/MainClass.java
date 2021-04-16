package catsAndPlates;

import java.util.Scanner;

public class MainClass {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Plate plate = new Plate(100);
        String[] names = {"Барсик", "Рыжик", "Пират"};
        Cat[] cats = new Cat[3];

        System.out.println("У нас есть 3 кота, введите для каждого их них размер аппетита");
        for (int i = 0; i < 3; i++) {
            System.out.println("Сколько сможеть съесть " + (i + 1) + "й кот");
            int appetite = Math.abs(scanner.nextInt());
            cats[i] = new Cat(names[i], appetite);
        }

        plate.info();

        //Теперь покормим котов
        for (Cat cat : cats) {
            cat.eat(plate);
            System.out.println(cat.getName() + " насытился? " + cat.isSatiety());
            System.out.println("-----------");
        }

        System.out.print("Остаток еды: ");
        plate.info();


        scanner.close();
    }


}
