import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class HomeWorkThree {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите длину бинароного массива");
        biArrayOfIntWIthReplace(scanner.nextInt());

        System.out.println("\n-------");
        System.out.println("\nЗадать пустой целочисленный массив длиной 100. С помощью цикла заполнить его значениями 1 2 "
                + "3 4 5 6 7 8 … 100");
        sequencedArray();

        System.out.println("\n-------");
        System.out.println("Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ] пройти по нему циклом, и числа "
                + "меньшие 6 умножить на 2");
        arrayItemMultiplication();

        System.out.println("\n-------");
        System.out.println("Введите длину стороны квадрата");
        squareArrayCrossFilling(scanner.nextInt());

        System.out.println("\n-------");
        System.out.println("Введите длину массива");
        int len = scanner.nextInt();
        System.out.println("Введите целое число для заполнения ячееек массива");
        int initValue = scanner.nextInt();
        makeIntArray(len, initValue);

        System.out.println("\n-------");
        System.out.println("\nЗадать одномерный массив и найти в нем минимальный и максимальный элементы");
        minMaxArrayValues();

        System.out.println("\n-------");
        System.out.println("Обрабатываемый для сравнения массив (равносумирование)");
        int[] simpleArray = {2, 0 , 0, 0, 0, 0, 1, 1};
        System.out.println("Утверждение, что массив имеет равносумируемые части является " + compareArraySides(simpleArray));


        scanner.close();
    }


//Задать целочисленный массив, состоящий из элементов 0 и 1. Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ].
//С помощью цикла и условия заменить 0 на 1, 1 на 0;
    private static void biArrayOfIntWIthReplace(int arrayLength) {
        arrayLength = Math.abs(arrayLength); //Небольшая страховка от ввода отрицательного числа
        //byte тоже целочисленный тип, выбрал его для экономии памяти
        Random random = new Random();
        byte[] biArray = new byte[arrayLength];
        System.out.println("\nПервичное значение массива");
        for (int i = 0; i < arrayLength; i++) {
            biArray[i] = (byte) random.nextInt(2);
            System.out.printf(" %d ", biArray[i]);
        }
        System.out.println("\nИнвертированное значение массива");
        //Это можно было сделать до присвоения случайного значения элементу массива в цикле врисвоения значений массиву
        //но условия ДЗ разделяют эти два шага
        for (int i = 0; i < arrayLength; i++) {
            biArray[i] = biArray[i] == 0 ? (byte) 1 : 0;
            System.out.printf(" %d ", biArray[i]);
        }
    }


//Задать пустой целочисленный массив длиной 100. С помощью цикла заполнить его значениями 1 2 3 4 5 6 7 8 … 100;
    private static void sequencedArray() {
        byte[] oneHundredInArray = new byte[100];
        for (byte i = 0; i < 100; i++) {
            oneHundredInArray[i] = (byte) (i + 1);
            System.out.printf(" %d ", oneHundredInArray[i]);
        }
    }

//Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ] пройти по нему циклом, и числа меньшие 6 умножить на 2;
    private static void arrayItemMultiplication() {
        int[] array = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        System.out.println("Первичное значение массива");
        System.out.println(Arrays.toString(array));
        for (int i = 0; i < array.length; i++) {
            if (array[i] < 6) array[i] *= 2;
        }
        System.out.println("Обработанное значение массива");
        System.out.println(Arrays.toString(array));
    }

//Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое)
//, и с помощью цикла(-ов) заполнить его диагональные элементы единицами
//(можно только одну из диагоналей, если обе сложно).
//Определить элементы одной из диагоналей можно по следующему принципу: индексы таких элементов равны
//, то есть [0][0], [1][1], [2][2], …, [n][n];
    private static void squareArrayCrossFilling(int arrayLength) {
        arrayLength = Math.abs(arrayLength); //Небольшая страховка от ввода отрицательного числа
        int[][] sqrArray = new int[arrayLength][arrayLength];

        for (int i = 0; i < arrayLength; i++) {
            sqrArray[i][i] = 1;
            sqrArray[i][arrayLength - i - 1] = 1;
        }

        //Выведем на экран ввиде таблицы
        for (int i = 0; i < arrayLength; i++) {
            for (int j = 0; j < arrayLength; j++) {
                System.out.print(" " + sqrArray[i][j] + " ");
                if (j == arrayLength - 1) System.out.println("");
            }
        }
    }

//Написать метод, принимающий на вход два аргумента: len и initialValue
//, и возвращающий одномерный массив типа int длиной len, каждая ячейка которого равна initialValue;
    private static int[] makeIntArray(int len, int initialValue){
        int[] array = new int[len];
        Arrays.fill(array, initialValue);
        System.out.println(Arrays.toString(array));
        return array;
    }

// * Задать одномерный массив и найти в нем минимальный и максимальный элементы ;
    private static void minMaxArrayValues() {
        Random random = new Random();
        //Если размерность массива не задана в задаче пусть она будет рандомна в обределенных границах
        byte[] array = new byte[random.nextInt(15) + 5];
        random.nextBytes(array);
        System.out.println(Arrays.toString(array));
        byte max = array[0];
        byte min = array[0];
        for (byte arrayItem : array) {
            //К сожалению не нашел Math.min и Math.min для byte
            //, а сохранить удобную генерацию рандомных значений и экономию памяти хочется
            if (max > arrayItem) max = arrayItem;
            if (min < arrayItem) min = arrayItem;
        }
        System.out.println("Минимальное значение = " + min);
        System.out.println("Максимальное значение = " + max);
    }

    /*
    ** Написать метод, в который передается не пустой одномерный целочисленный массив, метод должен вернуть true, если в массиве есть место, в котором сумма левой и правой части массива равны.
        **Примеры:
    checkBalance([2, 2, 2, 1, 2, 2, ||| 10, 1]) → true, т.е. 2 + 2 + 2 + 1 + 2 + 2 = 10 + 1
    checkBalance([1, 1, 1, ||| 2, 1]) → true, т.е. 1 + 1 + 1 = 2 + 1

    граница показана символами |||, эти символы в массив не входят и не имеют никакого отношения к ИЛИ.
    */
    private static boolean compareArraySides(int[] array) {
        System.out.println(Arrays.toString(array));

        int sumLeft;
        int sumRight;

        for (int i = 0; i < array.length; i++) {

            sumLeft = 0;
            sumRight = 0;
            for (int j = 0; j < i; j++) {
                sumLeft += array[j];
            }

            for (int y = array.length - 1; y >= i ; y--) {
                sumRight += array[y];
            }


            /*System.out.println("---------");
            System.out.println("sumLeft =" + sumLeft);
            System.out.println("sumRight =" + sumRight);*/

            if (sumLeft==sumRight) return true;
        }

        return false;
    }
}
