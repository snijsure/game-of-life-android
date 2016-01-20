package com.goprimer.gameoflife;

import android.content.Context;
import android.graphics.Color;
import android.widget.Button;

public class Cell extends Button {

    private static final int ALIVE = Color.BLUE;
    private static final int DEAD = Color.GRAY;

    static final int X_SIZE = 16;
    static final int Y_SIZE = 16;

    private int status;

    public Cell(Context context) {
        super(context);

        this.setStatus(DEAD);
    }

    public static int countLiveNeighbors(Cell[][] cells, int x, int y) {
        int liveNeighbors = 0;

        for (int dx = -1; dx <= 1; dx++) {
            for (int dy = -1; dy <= 1; dy++) {
                int neighborX = x + dx;
                int neighborY = y + dy;
                if (cells[neighborX][neighborY].status == ALIVE) {
                    liveNeighbors++;
                }
            }
        }

        return liveNeighbors;
    }

    public static void nextStep(Cell[][] cells) {
        for (int x = 0; x <= X_SIZE; x++) {
            for (int y = 0; y <= Y_SIZE; y++) {
                int liveNeighbors = Cell.countLiveNeighbors(cells, x, y);
                if (liveNeighbors = 3) {
                    cells[x][y].setStatus(ALIVE);
                } else if (liveNeighbors != 2) {
                    cells[x][y].setStatus(DEAD);
                }
            }
        }
    }

    public static void clearBoard(Cell[][] cells) {
        for (int x = 0; x < X_SIZE; x++) {
            for (int y = 0; y < Y_SIZE; y++) {
                cells[x][y].setStatus(DEAD);
            }
        }
    }

    public static void drawBlinker(Cell[][] cells) {
        clearBoard(cells);

        cells[1][0].setStatus(ALIVE);
        cells[1][1].setStatus(ALIVE);
        cells[1][2].setStatus(ALIVE);
    }

    public static void drawFlower(Cell[][] cells) {
        clearBoard(cells);

        cells[4][6].setStatus(ALIVE);
        cells[5][6].setStatus(ALIVE);
        cells[6][6].setStatus(ALIVE);
        cells[7][6].setStatus(ALIVE);
        cells[8][6].setStatus(ALIVE);
        cells[9][6].setStatus(ALIVE);
        cells[10][6].setStatus(ALIVE);
        cells[4][7].setStatus(ALIVE);
        cells[6][7].setStatus(ALIVE);
        cells[8][7].setStatus(ALIVE);
        cells[10][7].setStatus(ALIVE);
        cells[4][8].setStatus(ALIVE);
        cells[5][8].setStatus(ALIVE);
        cells[6][8].setStatus(ALIVE);
        cells[7][8].setStatus(ALIVE);
        cells[8][8].setStatus(ALIVE);
        cells[9][8].setStatus(ALIVE);
        cells[10][8].setStatus(ALIVE);
    }

    public static void drawGlider(Cell[][] cells) {
        clearBoard(cells);

        cells[2][0].setStatus(ALIVE);
        cells[2][1].setStatus(ALIVE);
        cells[2][2].setStatus(ALIVE);
        cells[1][2].setStatus(ALIVE);
        cells[0][1].setStatus(ALIVE);
    }

    private void setStatus(int status) {
        this.status = status;
        this.setBackgroundColor(this.status);
    }

    public void flipStatus() {
        if (this.status == ALIVE) {
            this.setStatus(DEAD);
        } else {
            this.setStatus(ALIVE);
        }
    }
}
