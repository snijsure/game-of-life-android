package com.goprimer.gameoflife;

import android.content.Context;
import android.graphics.Color;
import android.widget.Button;
public class Cell extends Button {

    private static final int ALIVE = Color.BLUE;
    private static final int DEAD = Color.GRAY;
    private static final String TAG = "GOL/Cell";
    static final int X_SIZE = 16;
    static final int Y_SIZE = 16;
    Element mElements[];


    // TODO:
    // From OO perspective Cell class should create array of
    // Elements, shown below and move all the static methods
    // from Cell object to operational methods on object Element.

    class Element {
        private int status = DEAD;
        private int neighbors = 0;
        public int  getState() { return status; }
        public void setState(int i) { status = i; }
        public void setNeighbor(int c) { neighbors = c; }
        public int  getNeighbors() { return neighbors; }
    };

    private int status;
    private int neighbors;

    public Cell(Context context) {
        super(context);
        mElements = new Element[X_SIZE * Y_SIZE];
        this.setStatus(DEAD);
    }

    private static int getState(Cell[][] cells, int row, int col) {
        try {
            if (cells[row][col].status == ALIVE)
                return 1;
            else
                return 0;
        }
        catch( ArrayIndexOutOfBoundsException outOfBoundException) {
            // Indicates that there is no such neighbour
            return 0;
        }
    }
    private static int getNeighbors(Cell[][] cells,int row, int col) {
        int count = 0;
        count += Cell.getState(cells,row-1, col-1);
        count += Cell.getState(cells,row-1, col);
        count += Cell.getState(cells,row-1, col+1);

        count += Cell.getState(cells,row, col-1);
        count += Cell.getState(cells,row, col+1);

        count += Cell.getState(cells,row+1, col-1);
        count += Cell.getState(cells,row+1, col);
        count += Cell.getState(cells,row+1, col+1);
        return count;
    }

    public static void nextStep(Cell[][] cells) {

        // Cache neighbors before we go about setting the state.
        for (int x = 0; x < X_SIZE; x++) {
            for (int y = 0; y < Y_SIZE; y++) {
                cells[x][y].neighbors = Cell.getNeighbors(cells, x, y);
            }
        }
        for (int x = 0; x < X_SIZE; x++) {
            for (int y = 0; y < Y_SIZE; y++) {
                int liveNeighbors = cells[x][y].neighbors;
                if (liveNeighbors == 3) {
                    cells[x][y].setStatus(ALIVE);
                } else if (liveNeighbors != 2) {
                    try {
                        cells[x][y].setStatus(DEAD);
                    }
                    catch( ArrayIndexOutOfBoundsException outOfBoundException) {
                        // Indicates that there is no such neighbour
                    }
                }
            }
        }
    }

    private static void clearBoard(Cell[][] cells) {
        for (int x = 0; x < X_SIZE; x++) {
            for (int y = 0; y < Y_SIZE; y++) {
                cells[x][y].setStatus(DEAD);
                cells[x][y].neighbors = 0;
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
