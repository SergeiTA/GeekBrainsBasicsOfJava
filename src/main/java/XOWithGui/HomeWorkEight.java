package XOWithGui;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class HomeWorkEight extends JFrame {
    private static final String DOT_EMPTY = "•";
    private static final String DOT_X = "X";
    private static final String DOT_O = "O";
    private static final int FIELD_SIZE = 5;

    private static final JButton[][] gameButtonsField = new JButton[FIELD_SIZE][FIELD_SIZE];


    public HomeWorkEight() {
        setTitle("XOGame");
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setBounds(300, 300, 500, 500);
        setLayout(new GridLayout(FIELD_SIZE, FIELD_SIZE));
        Font timesNRBigBold = new Font("TimesRoman", Font.BOLD, 50);

        for (int i = 0; i < FIELD_SIZE; i++) {
            for (int j = 0; j < FIELD_SIZE; j++) {
                gameButtonsField[i][j] = new JButton();
                gameButtonsField[i][j].setFont(timesNRBigBold);
                gameButtonsField[i][j].setText(DOT_EMPTY);
                final int iF = i;
                final int jF = j;
                gameButtonsField[i][j].addActionListener(e -> {
                    gameButtonsField[iF][jF].setText(DOT_X);
                    gameButtonsField[iF][jF].setEnabled(false);

                    if (isSomeoneWon(DOT_X)) {
                        JOptionPane.showMessageDialog(null, "Победил человек");
                        new HomeWorkEight();
                        dispose();
                    } else if (isFieldFull()) {
                        JOptionPane.showMessageDialog(null, "Ничья");
                        new HomeWorkEight();
                        dispose();
                    } else {
                        advancedCompTurn();
                        if (isSomeoneWon(DOT_O)) {
                            JOptionPane.showMessageDialog(null, "Победил комптьютер");
                            new HomeWorkEight();
                            dispose();
                        } else if (isFieldFull()) {
                            JOptionPane.showMessageDialog(null, "Ничья");
                            new HomeWorkEight();
                            dispose();
                        }

                    }



                });
                add(gameButtonsField[i][j]);
            }
        }

        setVisible(true);
        setResizable(false);

    }

    public static void main(String[] args) {

        new HomeWorkEight();


    }


    //Проверка свободной ячейки поля
    private static boolean isCellFree(int x, int y) {
        boolean outOfBorders = x < 0 || x >= gameButtonsField.length || y < 0 || y >= gameButtonsField.length;
        boolean fullCell = !gameButtonsField[x][y].getText().equals(DOT_EMPTY);
        if (outOfBorders) return false;
        return !fullCell;
    }


    //Ход ПК
    private static void compTurn() {
        Random rand = new Random();
        int x, y;
        do {
            x = rand.nextInt(FIELD_SIZE);
            y = rand.nextInt(FIELD_SIZE);
        } while (!isCellFree(x, y));
        System.out.println("Компьютер походил " + (x + 1) + " " + (y + 1));
        gameButtonsField[x][y].setText(DOT_O);
        gameButtonsField[x][y].setEnabled(false);
    }


    //Увеличенная сложность
    private static void advancedCompTurn() {
        //Понимаю, что можно было переиспользовать похожий код, выведя его в отдельный метод
        //( + можно добавить приортезацию по большему количеству идущих в ряд "X"
        // + алгоритм работает по приоритету заблокировать ходы человека, а не выйгать самому)
        //, но пока не придумал как, время поднее и поджимает
        int x, y;
        ////Алгоритм стремления к выйгрышу при совпадении 3х нулей
        int priorityRowCount;
        int priorityColumnCount;
        int priorityDiagonalCount = 0;
        int priorityReversDiagonalCount = 0;
        for (int i = 0; i < gameButtonsField.length; i++) {
            priorityRowCount = 0;
            priorityColumnCount = 0;

            if (gameButtonsField[i][i].getText().equals(DOT_O)) {
                priorityDiagonalCount++;
                if ( priorityDiagonalCount == 3 && ( (i+1) < gameButtonsField.length)
                        && isCellFree(i+1, i+1) ) {
                    System.out.println("Ага! 1");
                    x = i + 1;
                    y = i + 1;
                    gameButtonsField[x][y].setText(DOT_O);
                    gameButtonsField[x][y].setEnabled(false);
                    return;
                }
            } else {
                priorityDiagonalCount =0;
            }

            if (gameButtonsField[i][gameButtonsField.length - i - 1].getText().equals(DOT_O)) {
                priorityReversDiagonalCount++;
                if (priorityReversDiagonalCount == 3 && ( (i+1) < gameButtonsField.length)
                        && isCellFree(i+1, gameButtonsField.length - i -2)) {
                    System.out.println("Ага! 2");
                    x = i + 1;
                    y = gameButtonsField.length - i -2;
                    gameButtonsField[x][y].setText(DOT_O);
                    gameButtonsField[x][y].setEnabled(false);
                    return;
                }
            } else {
                priorityReversDiagonalCount=0;
            }

            for (int j = 0; j < gameButtonsField.length; j++) {

                if (gameButtonsField[i][j].getText().equals(DOT_O)) {
                    priorityRowCount++;
                    if (priorityRowCount == 3 && ( (j+1) < gameButtonsField.length) && isCellFree(i, j+1)) {
                        System.out.println("Ага! 3");
                        x = i;
                        y = j + 1;
                        gameButtonsField[x][y].setText(DOT_O);
                        gameButtonsField[x][y].setEnabled(false);
                        return;
                    }
                } else {
                    priorityRowCount = 0;
                }

                if (gameButtonsField[j][i].getText().equals(DOT_O)) {
                    priorityColumnCount++;
                    if (priorityColumnCount == 3 && ( (j+1) < gameButtonsField.length)
                            && isCellFree(j+1, i) ) {
                        System.out.println("Ага! 4");
                        x = j + 1;
                        y = i;
                        gameButtonsField[x][y].setText(DOT_O);
                        gameButtonsField[x][y].setEnabled(false);
                        return;
                    }
                } else {
                    priorityColumnCount = 0;
                }
            }
        }


        ////Блоировка ходов игрока
        int priorityBlockRowCount;
        int priorityBlockColumnCount;
        int priorityBlockDiagonalCount = 0;
        int priorityBlockReversDiagonalCount = 0;
        for (int i = 0; i < gameButtonsField.length; i++) {
            priorityBlockRowCount = 0;
            priorityBlockColumnCount = 0;

            if (gameButtonsField[i][i].getText().equals(DOT_X)) {
                priorityBlockDiagonalCount++;
                if (priorityBlockDiagonalCount >= 2 && ( (i+1) < gameButtonsField.length)
                        && isCellFree(i+1, i+1)) {
                    System.out.println("Ага! 1");
                    x = i + 1;
                    y = i + 1;
                    gameButtonsField[x][y].setText(DOT_O);
                    gameButtonsField[x][y].setEnabled(false);
                    return;
                }
            } else {
                priorityBlockDiagonalCount =0;
            }

            if (gameButtonsField[i][gameButtonsField.length - i - 1].getText().equals(DOT_X)) {
                priorityBlockReversDiagonalCount++;
                if (priorityBlockReversDiagonalCount >= 2 && ( (i+1) < gameButtonsField.length)
                        && isCellFree(i+1, gameButtonsField.length - i -2)) {
                    System.out.println("Ага! 2");
                    x = i + 1;
                    y = gameButtonsField.length - i -2;
                    gameButtonsField[x][y].setText(DOT_O);
                    gameButtonsField[x][y].setEnabled(false);
                    return;
                }
            } else {
                priorityBlockReversDiagonalCount=0;
            }

            for (int j = 0; j < gameButtonsField.length; j++) {

                if (gameButtonsField[i][j].getText().equals(DOT_X)) {
                    priorityBlockRowCount++;
                    if (priorityBlockRowCount >= 2 && ( (j+1) < gameButtonsField.length) && isCellFree(i, j+1) ) {
                        System.out.println("Ага! 3");
                        x = i;
                        y = j + 1;
                        gameButtonsField[x][y].setText(DOT_O);
                        gameButtonsField[x][y].setEnabled(false);
                        return;
                    }
                } else {
                    priorityBlockRowCount = 0;
                }

                if (gameButtonsField[j][i].getText().equals(DOT_X)) {
                    priorityBlockColumnCount++;
                    if (priorityBlockColumnCount >= 2 && ( (j+1) < gameButtonsField.length)
                            && isCellFree(j+1, i) ) {
                        System.out.println("Ага! 4");
                        x = j + 1;
                        y = i;
                        gameButtonsField[x][y].setText(DOT_O);
                        gameButtonsField[x][y].setEnabled(false);
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
    private static boolean isSomeoneWon(String xOrO) {
        int winRowCount;
        int winColumnCount;
        int winDiagonalCount = 0;
        int winReversDiagonalCount = 0;
        for (int i = 0; i < gameButtonsField.length; i++) {
            winRowCount = 0;
            winColumnCount = 0;

            if (gameButtonsField[i][i].getText().equals(String.valueOf(xOrO))) {
                winDiagonalCount++;
                if (winDiagonalCount == 4) return true;
            } else {
                winDiagonalCount =0;
            }

            if (gameButtonsField[i][gameButtonsField.length - i - 1].getText().equals(String.valueOf(xOrO))) {
                winReversDiagonalCount++;
                if (winReversDiagonalCount == 4) return true;
            } else {
                winReversDiagonalCount=0;
            }

            for (int j = 0; j < gameButtonsField.length; j++) {

                if (gameButtonsField[i][j].getText().equals(String.valueOf(xOrO))) {
                    winRowCount++;
                    if (winRowCount == 4 ) return true;
                } else {
                    winRowCount = 0;
                }

                if (gameButtonsField[j][i].getText().equals(String.valueOf(xOrO))) {
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
                if (gameButtonsField[i][j].getText().equals(DOT_EMPTY)) return false;
            }
        }
        return true;
    }

}
