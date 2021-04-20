import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class HomeWorkFour {
    private static final char DOT_EMPTY = '•';
    private static final char DOT_X = 'X';
    private static final char DOT_O = 'O';
    private static final int FIELD_SIZE = 5;
    //private static final int WIN_SEQ = 4;

    private static Scanner scanner = new Scanner(System.in);
    private static final char[][] gameField = new char[FIELD_SIZE][FIELD_SIZE];


    public static void main(String[] args) {

        showField(createGameField());
        System.out.println("Введите 1 для выбора легкого режима игры, 2 для выбора среднего режима игры");
        int difficult = scanner.nextInt();

        while (true){
            playerTurn();
            showField(gameField);
            if (isSomeoneWon(DOT_X)) {
                System.out.println("Победил человек");
                break;
            }
            if (isFieldFull()) {
                System.out.println("Ничья");
                break;
            }

            if ( difficult == 1 ) { compTurn();
            } else { advancedCompTurn(); }
            showField(gameField);
            if (isSomeoneWon(DOT_O)) {
                System.out.println("Победил комптьютер");
                break;
            }
            if (isFieldFull()) {
                System.out.println("Ничья");
                break;
            }
        }
        scanner.close();
        System.out.println("Игра закончена");

    }

    //Метод для создания игрового поля
    private static char[][] createGameField() {
        for (char[] row : gameField) {
            Arrays.fill(row, DOT_EMPTY);
        }
        return gameField;
    }

    //Метод для вывода на экран текущего состояния игрового поля
    private static void showField(char[][] gameField) {
        System.out.println("---------------");
        for (char[] chars : gameField) {
            for (int j = 0; j < gameField.length; j++) {
                System.out.print(" " + chars[j] + " ");
                if (j == gameField.length - 1) System.out.println("");
            }
        }
        System.out.println("---------------");
    }

    //Проверка свободной ячейки поля
    private static boolean isCellFree(int x, int y, boolean isPlayer) {
        boolean outOfBorders = x < 0 || x >= gameField.length || y < 0 || y >= gameField.length;
        boolean fullCell = gameField[x][y] != DOT_EMPTY;
        if ( outOfBorders && isPlayer) {
            System.out.println("Введенные координаты выходят за пределы поля");
            return false;
        };
        if (outOfBorders) return false;
        if ( fullCell && isPlayer ) {
            System.out.println("Ячейка с введенными координатами занята");
            return false;
        }
        return !fullCell;
    }

    //Ход игрока
    private static void playerTurn() {
        int x, y;
        do {
            System.out.println("Ваш ход");
            System.out.println("Введите координаты хода X, целое число от 1 до " + (gameField.length + 1));
            x = scanner.nextInt() - 1;
            System.out.println("Введите координаты хода Y, целое число от 1 до " + (gameField.length + 1));
            y = scanner.nextInt() - 1;
        } while (!isCellFree(x, y, true));
        gameField[x][y] = DOT_X;
    }

    //Ход ПК
    private static void compTurn() {
        Random rand = new Random();
        int x, y;
        do {
            x = rand.nextInt(FIELD_SIZE);
            y = rand.nextInt(FIELD_SIZE);
        } while (!isCellFree(x, y, false));
        System.out.println("Компьютер походил " + (x + 1) + " " + (y + 1));
        gameField[x][y] = DOT_O;
    }


    //Увеличенная сложность
    private static void advancedCompTurn() {
        //Понимаю, что можно было переиспользовать похожий код, выведя его в отдельный метод
        //( + можно добавить приортезацию по большему количеству идущих в ряд "X"
        // + алгоритм работает по приоритету заблокировать ходы человека, а не выйгать самому)
        //, но пока не придумал как, время поднее и поджимает
        int x, y;
        ////Алгоритм стремления к выйгрышу при совпадении 3х нулей
        int priorityRowCount = 0;
        int priorityColumnCount = 0;
        int priorityDiagonalCount = 0;
        int priorityReversDiagonalCount = 0;
        for (int i = 0; i < gameField.length; i++) {
            priorityRowCount = 0;
            priorityColumnCount = 0;

            if (gameField[i][i] == DOT_O) {
                priorityDiagonalCount++;
                if (priorityDiagonalCount == 3 && ( (i+1) < gameField.length)
                        && isCellFree(i+1, i+1, false)) {
                    System.out.println("Ага! 1");
                    x = i + 1;
                    y = i + 1;
                    gameField[x][y] = DOT_O;
                    return;
                }
            } else {
                priorityDiagonalCount =0;
            }

            if (gameField[i][gameField.length - i - 1] == DOT_O) {
                priorityReversDiagonalCount++;
                if (priorityReversDiagonalCount == 3 && ( (i+1) < gameField.length)
                        && isCellFree(i+1, gameField.length - i -2, false)) {
                    System.out.println("Ага! 2");
                    x = i + 1;
                    y = gameField.length - i -2;
                    gameField[x][y] = DOT_O;
                    return;
                }
            } else {
                priorityReversDiagonalCount=0;
            }

            for (int j = 0; j < gameField.length; j++) {

                if (gameField[i][j] == DOT_O) {
                    priorityRowCount++;
                    if (priorityRowCount == 3 && ( (j+1) < gameField.length) && isCellFree(i, j+1, false) ) {
                        System.out.println("Ага! 3");
                        x = i;
                        y = j + 1;
                        gameField[x][y] = DOT_O;
                        return;
                    }
                } else {
                    priorityRowCount = 0;
                }

                if (gameField[j][i] == DOT_O) {
                    priorityColumnCount++;
                    if (priorityColumnCount == 3 && ( (j+1) < gameField.length)
                            && isCellFree(j+1, i, false) ) {
                        System.out.println("Ага! 4");
                        x = j + 1;
                        y = i;
                        gameField[x][y] = DOT_O;
                        return;
                    }
                } else {
                    priorityColumnCount = 0;
                }
            }
        }


        ////Блоировка ходов игрока
        int priorityBlockRowCount = 0;
        int priorityBlockColumnCount = 0;
        int priorityBlockDiagonalCount = 0;
        int priorityBlockReversDiagonalCount = 0;
        for (int i = 0; i < gameField.length; i++) {
            priorityBlockRowCount = 0;
            priorityBlockColumnCount = 0;

            if (gameField[i][i] == DOT_X) {
                priorityBlockDiagonalCount++;
                if (priorityBlockDiagonalCount >= 2 && ( (i+1) < gameField.length)
                        && isCellFree(i+1, i+1, false)) {
                    System.out.println("Ага! 1");
                    x = i + 1;
                    y = i + 1;
                    gameField[x][y] = DOT_O;
                    return;
                }
            } else {
                priorityBlockDiagonalCount =0;
            }

            if (gameField[i][gameField.length - i - 1] == DOT_X) {
                priorityBlockReversDiagonalCount++;
                if (priorityBlockReversDiagonalCount >= 2 && ( (i+1) < gameField.length)
                        && isCellFree(i+1, gameField.length - i -2, false)) {
                    System.out.println("Ага! 2");
                    x = i + 1;
                    y = gameField.length - i -2;
                    gameField[x][y] = DOT_O;
                    return;
                }
            } else {
                priorityBlockReversDiagonalCount=0;
            }

            for (int j = 0; j < gameField.length; j++) {

                if (gameField[i][j] == DOT_X) {
                    priorityBlockRowCount++;
                    if (priorityBlockRowCount >= 2 && ( (j+1) < gameField.length) && isCellFree(i, j+1, false) ) {
                        System.out.println("Ага! 3");
                        x = i;
                        y = j + 1;
                        gameField[x][y] = DOT_O;
                        return;
                    }
                } else {
                    priorityBlockRowCount = 0;
                }

                if (gameField[j][i] == DOT_X) {
                    priorityBlockColumnCount++;
                    if (priorityBlockColumnCount >= 2 && ( (j+1) < gameField.length)
                            && isCellFree(j+1, i, false) ) {
                        System.out.println("Ага! 4");
                        x = j + 1;
                        y = i;
                        gameField[x][y] = DOT_O;
                        return;
                    }
                } else {
                    priorityBlockColumnCount = 0;
                }
            }
        }


        System.out.println("Попробуем сюда");
        compTurn();
    }


    //Провека победы
    private static boolean isSomeoneWon(char xOrO) {
        int winRowCount = 0;
        int winColumnCount = 0;
        int winDiagonalCount = 0;
        int winReversDiagonalCount = 0;
        for (int i = 0; i < gameField.length; i++) {
            winRowCount = 0;
            winColumnCount = 0;

            if (gameField[i][i] == xOrO) {
                winDiagonalCount++;
                if (winDiagonalCount == 4) return true;
            } else {
                winDiagonalCount =0;
            }

            if (gameField[i][gameField.length - i - 1] == xOrO) {
                winReversDiagonalCount++;
                if (winReversDiagonalCount == 4) return true;
            } else {
                winReversDiagonalCount=0;
            }

            for (int j = 0; j < gameField.length; j++) {

                if (gameField[i][j] == xOrO) {
                    winRowCount++;
                    if (winRowCount == 4 ) return true;
                } else {
                    winRowCount = 0;
                }

                if (gameField[j][i] == xOrO) {
                    winColumnCount++;
                    if (winColumnCount == 4 ) return true;
                } else {
                    winColumnCount = 0;
                }
            }
        }
        return false;
    }


    private static boolean isFieldFull() {
        for (int i = 0; i < FIELD_SIZE; i++) {
            for (int j = 0; j < FIELD_SIZE; j++) {
                if (gameField[i][j] == DOT_EMPTY) return false;
            }
        }
        return true;
    }





}
