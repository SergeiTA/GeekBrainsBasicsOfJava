public class HomeWorkApp {

    //Задание 1
    public static void main(String[] args) {

        printThreeWords();
        checkSumSign(3, 5);
        printColor();
        compareNumbers();

    }

    //Задание 2
    private static void printThreeWords(){
        System.out.println("Orange");
        System.out.println("Banana");
        System.out.println("Apple");
    }

    //Задание 3
    //ИМХО: Лучше вводить переменные в аргументы метода и уже иниализировать их при выхове метода, но таково ДЗ
    //Имеем 6 warnings из-за хардкода в значениях переменных
    private static void checkSumSign(int a, int b){
        /*int a, b;
        a = 3;
        b = -5;*/
        if ( a + b >= 0 ) { System.out.println("Сумма положительная"); }
        else { System.out.println("Сумма отрицательная"); }
        //ставлю else без условия, т.к. вариантов выбора больше нет и так мы исключим лишнее сравниение из кода/процедуры
    }

    //Задание 4
    private static void printColor() {
        int value;
        value = 25;
        if ( value <= 0 ) { System.out.println("Красный"); }
        else if ( value > 0 && value <= 100) { System.out.println("Желтый"); }
        else {
            System.out.println("Зеленый");
            //ставлю else без условия, т.к. вариантов выбора больше нет и так мы исключим лишнее сравниение из кода/процедуры
        }
    }

    //Задание 5
    private static void compareNumbers(){
        int a, b;
        a = 30;
        b = 50;
        if ( a >= b ) { System.out.println("a >= b"); }
        else { System.out.println("a < b"); }
    }

}
