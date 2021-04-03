
import java.util.Scanner;

public class HomeWorkTwo {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String printedString;
        int firstNumber, secondNumber, numberOfTimesForPrint, year;

        System.out.println("Сумма целых чисел лежит в промежутке [10;20]");
        System.out.println("Введите первое целочисленное слагаемое");
        //Можно добавиь обработку исключений, но это вне ДЗ
        firstNumber = scanner.nextInt();
        System.out.println("Введите второе целочисленное слагаемое");
        //Можно добавиь обработку исключений, но это вне ДЗ
        secondNumber = scanner.nextInt();
        System.out.println("Утверждение, что сумма целых чисел лежит в промежутке [10;20] является "
                + isSumBetweenTenAndTwenty(firstNumber, secondNumber));

        System.out.println("-------");
        System.out.println("Проверка целого числа на положительное/отрицательное");
        System.out.println("Введите целочисленное значение");
        checkingPositiveOrNegative(scanner.nextInt());

        System.out.println("-------");
        System.out.println("Проверка целого числа на принадлежность к отрицательным");
        System.out.println("Введите целочисленное значение");
        System.out.println("Утверждение, что введенное целое число отрицательное является "
                + isNumberPositiveOrNegative(scanner.nextInt()));

        System.out.println("-------");
        System.out.println("Введите строку для повторения печати");
        printedString = scanner.next();
        System.out.println("Введите положительное целочисленное значение количества повторений печати строки");
        numberOfTimesForPrint = scanner.nextInt();
        printStringNumberOfTimes(printedString, numberOfTimesForPrint);

        System.out.println("-------");
        System.out.println("Введите номер года для проверки является ли год високосным");
        year = scanner.nextInt();
        System.out.println("Утверждение, что " + year + " високосный является " + isYearLeap(year));

        scanner.close();
    }

//Написать метод, принимающий на вход два целых числа и проверяющий,
//что их сумма лежит в пределах от 10 до 20 (включительно), если да – вернуть true, в противном случае – false.
    private static boolean isSumBetweenTenAndTwenty(int firstNumber, int secondNumber) {
        return firstNumber + secondNumber >= 10 && firstNumber + secondNumber <= 20;
    }

//Написать метод, которому в качестве параметра передается целое число, метод должен напечатать в консоль,
// положительное ли число передали или отрицательное. Замечание: ноль считаем положительным числом.
    private static void checkingPositiveOrNegative(int number) {
        if (number>=0){ System.out.println("Введено положительное число"); }
        else { System.out.println("Введено отрицательное число"); }
    }

//Написать метод, которому в качестве параметра передается целое число. Метод должен вернуть true,
//если число отрицательное, и вернуть false если положительное.
    private static boolean isNumberPositiveOrNegative(int number) {
        if (number == 0 ) {
        //Введем исключение на неверный ввод, как минимум т.к. в задаче не предусмотрен ввод целочисленного значения 0
            throw new IllegalArgumentException("Целочисленное значение должно быть строго меньше" +
                    "или больше нуля. Вами был введен " + number);
        } else return number < 0;
    }

//Написать метод, которому в качестве аргументов передается строка и число,
//метод должен отпечатать в консоль указанную строку, указанное количество раз;
    private static void printStringNumberOfTimes(String printedString, int numberOfTimesForPrint) {
        //Обработаем ввод отрицательного числа
        if ( numberOfTimesForPrint < 0) {
            System.out.println("Вы ввели отрицательное значение, обо будет автоматически преобразовано в положительное");
            numberOfTimesForPrint = Math.abs(numberOfTimesForPrint);
        }
        //Обработаем ввод нуля
        if (numberOfTimesForPrint == 0) return;

        for (int i = 0; i < numberOfTimesForPrint; i++) {
            System.out.println(printedString);
        }
    }

//Написать метод, который определяет, является ли год високосным, и возвращает boolean (високосный - true,
//не високосный - false). Каждый 4-й год является високосным, кроме каждого 100-го, при этом каждый 400-й – високосный.
    private static boolean isYearLeap (int year) {
        if (year%4 == 0) {
            return !(year%100 == 0 && year%400 != 0);
        } else {
            return false;
        }
    }

}
