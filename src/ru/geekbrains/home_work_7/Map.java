package ru.geekbrains.home_work_7;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

public class Map extends JPanel {
    public static final int GM_HVA = 0;
    public static final int GM_HVH = 1;

    public static final int DOT_EMPTY = 0;
    public static final int DOT_HUMAN = 1;
    public static final int DOT_AI = 2;
    public static final int DOT_PADDING = 5;

    private int stateGameOver;
    public static final int STATE_DRAW = 0;
    public static final int STATE_WIN_HUMAN = 1;
    public static final int STATE_WIN_AI = 2;

    public static final String MSG_WIN_HUMAN = "Победил игрок!";
    public static final String MSG_WIN_AI = "Победил компьютер!";
    public static final String MSG_DRAW = "Ничья!";

    private static final Random RANDOM = new Random();

    private int[][] field;
    private int fieldSizeX;
    private int fieldSizeY;
    private int winLength;
    private int cellWidth;
    private int cellHeight;
    private boolean isGameOver;
    private boolean initialized;


    Map() {
        setBackground(Color.WHITE);
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e);
                update(e);
            }
        });
        initialized = false;
    }

    void startNewGame(int gameMode, int fieldSizeX, int fieldSizeY, int winLength) {
        this.fieldSizeX = fieldSizeX;
        this.fieldSizeY = fieldSizeY;
        this.winLength = winLength;
        field = new int[fieldSizeY][fieldSizeX];
        isGameOver = false;
        initialized = true;

        repaint();
    }

    private void update(MouseEvent e) {
        if (!initialized) return;
        if (isGameOver) return;
        int cellX = e.getX() / cellWidth;
        int cellY = e.getY() / cellHeight;
        if (!isValidCell(cellX, cellY) || !isEmptyCell(cellX, cellY))
            return;
        field[cellY][cellX] = DOT_HUMAN;
        if (checkWin(DOT_HUMAN)) {
            setGameOver(STATE_WIN_HUMAN);
            return;
        }
        if (isMapFull()) {
            setGameOver(STATE_DRAW);
            return;
        }
        aiTurn();
        repaint();
        if (checkWin(DOT_AI)) {
            setGameOver(STATE_WIN_AI);
            return;
        }
        if (isMapFull()) {
            setGameOver(STATE_DRAW);
            return;
        }
    }

    private void setGameOver(int gameOverState) {
        isGameOver = true;
        stateGameOver = gameOverState;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        render(g);
    }

    private void render(Graphics g) {
        if (!initialized) return;
        int width = getWidth();
        int height = getHeight();
        cellWidth = width / fieldSizeX;
        cellHeight = height / fieldSizeY;
        g.setColor(Color.BLACK);
        for (int i = 0; i < fieldSizeY; i++) {
            int y = i * cellHeight;
            g.drawLine(0, y, width, y);
        }
        for (int i = 0; i < fieldSizeX; i++) {
            int x = i * cellWidth;
            g.drawLine(x, 0, x, height);
        }
        for (int y = 0; y < fieldSizeY; y++) {
            for (int x = 0; x < fieldSizeX; x++) {
                if (isEmptyCell(x, y)) continue;
                if (field[y][x] == DOT_HUMAN) {
                    g.setColor(Color.BLACK);
                    g.fillOval(x * cellWidth + DOT_PADDING, y * cellHeight + DOT_PADDING,
                            cellWidth - DOT_PADDING * 2, cellHeight - DOT_PADDING * 2);
                } else if (field[y][x] == DOT_AI) {
                    g.setColor(new Color(255, 0,0));
                    g.fillRect(x * cellWidth + DOT_PADDING, y * cellHeight + DOT_PADDING,
                            cellWidth - DOT_PADDING * 2, cellHeight - DOT_PADDING * 2);
                } else {
                    throw new RuntimeException(
                            String.format("Can't recognize cell field[%d][%d]: %d", y, x, field[y][x]));
                }
            }
        }
        if (isGameOver) {
            showMessageGameOver(g);
        }
    }

    private void showMessageGameOver(Graphics g) {
        g.setColor(Color.DARK_GRAY);
        g.fillRect(0, 200, getWidth(), 70);
        g.setColor(Color.YELLOW);
        g.setFont(new Font("Times new roman", Font.BOLD, 48));
        switch (stateGameOver) {
            case STATE_DRAW:
                g.drawString(MSG_DRAW, 180, getHeight() / 2);
                break;
            case STATE_WIN_AI:
                g.drawString(MSG_WIN_AI, 20, getHeight() / 2);
                break;
            case STATE_WIN_HUMAN:
                g.drawString(MSG_WIN_HUMAN, 70, getHeight() / 2);
                break;
            default:
                throw new RuntimeException("Unexpected gameOver state: " + stateGameOver);
        }
    }

    //ничья?
    private boolean isMapFull() {
        for (int i = 0; i < fieldSizeY; i++) {
            for (int j = 0; j < fieldSizeX; j++) {
                if (field[i][j] == DOT_EMPTY) return false;
            }
        }
        return true;
    }

    //ячейка-то вообще правильная?
    private boolean isValidCell(int x, int y) {
        return x >= 0 && x < fieldSizeX && y >= 0 && y < fieldSizeY;
    }

    //а пустая?
    private boolean isEmptyCell(int x, int y) {
        return field[y][x] == DOT_EMPTY;
    }

    //ход компьютера
    private void aiTurn() {
        if (turnAIWinCell()) return; //проверим, не выйграет-ли игрок на следующем ходу
        if (turnHumanWinCell()) return; //проверим, не выйграет-ли комп на следующем ходу
        int x, y;
        do {                           //или комп ходит в случайную клетку
            x = RANDOM.nextInt(fieldSizeX);
            y = RANDOM.nextInt(fieldSizeY);
        } while (!isEmptyCell(x, y));
        field[y][x] = DOT_AI;
    }

    //проверка, может ли выйграть комп
    private boolean turnAIWinCell() {
        for (int i = 0; i < fieldSizeY; i++) {
            for (int j = 0; j < fieldSizeX; j++) {
                if (isEmptyCell(j, i)) {            //поставим нолик в каждую клетку поля по очереди
                    field[i][j] = DOT_AI;
                    if (checkWin(DOT_AI)) return true; //если мы выйграли, вернем истину, оставив нолик в выйгрышной клетке
                    field[i][j] = DOT_EMPTY;           //если нет - вернем обратно пустоту в клетку и пойдем дальше
                }
            }
        }
        return false;
    }

    //Проверка, выйграет-ли игрок своим следующим ходом
    private boolean turnHumanWinCell() {
        for (int i = 0; i < fieldSizeY; i++) {
            for (int j = 0; j < fieldSizeX; j++) {
                if (isEmptyCell(j, i)) {
                    field[i][j] = DOT_HUMAN;    //поставим крестик в каждую клетку
                    if(checkWin(DOT_HUMAN)) {   //если игрок победит
                       field[i][j] = DOT_AI;    //поставим на то место нолик
                       return true;
                    }
                    field[i][j] = DOT_EMPTY;   //в противном случае вернуть
                }
            }
        }
        return false;
    }

    //проверка на победу
    private boolean checkWin(int c) {
        for (int i = 0; i < fieldSizeX; i++) {          //ползем по всему полю
            for (int j = 0; j < fieldSizeY; j++) {
                if (checkLine(i, j, 1, 0, winLength, c)) return true;  //проверим линию по х
                if (checkLine(i, j, 1, 1, winLength, c)) return true;  //проверим по диагонали x и y
                if (checkLine(i, j, 0, 1, winLength, c)) return true;  //проверим линию по y
                if (checkLine(i, j, 1, -1, winLength, c)) return true; //проверим по диагонали x -y
            }
        }
        return false;
    }

//проверка линии
    private boolean checkLine(int x, int y, int vx, int vy, int len, int c) {
        final int far_x = x + (len - 1) * vx;  //посчитаем конец проверяемой линии
        final int far_y = y + (len - 1) * vy;
        if (!isValidCell(far_x, far_y)) return false;   //проверим не выйдет ли проверяемая линия за пределы поля
        for (int i = 0; i < len; i++) {                 //ползем по проверяемой линии
            if (field[y + i * vy][x + i * vx] != c) return false;  //проверим одинаковые-ли символы в ячейках
        }
        return true;
    }

}