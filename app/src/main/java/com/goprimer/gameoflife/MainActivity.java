package com.goprimer.gameoflife;

import android.app.Activity;
import android.graphics.Point;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;

public class MainActivity extends Activity {

    private Cell[][] cells;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Point size = new Point();
        getWindowManager().getDefaultDisplay().getSize(size);
        int screenWidth = size.x;
        int cellSize = screenWidth / Cell.X_SIZE;

        GridLayout gridLayout = (GridLayout) findViewById(R.id.grid_layout);
        gridLayout.setColumnCount(Cell.X_SIZE);

        cells = new Cell[Cell.X_SIZE][Cell.Y_SIZE];
        for(int x = 0; x < Cell.X_SIZE; x++) {
            for(int y = 0; y < Cell.Y_SIZE; y++) {
                cells[x][y] = new Cell(this);
                cells[x][y].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Cell cell = (Cell) v;
                        cell.flipStatus();
                    }
                });

                GridLayout.LayoutParams layoutParams = new GridLayout.LayoutParams(
                        GridLayout.spec(y),
                        GridLayout.spec(x)
                );
                layoutParams.height = cellSize;
                layoutParams.width = cellSize;
                layoutParams.bottomMargin = 1;
                layoutParams.leftMargin = 1;
                layoutParams.rightMargin = 1;
                layoutParams.topMargin = 1;
                gridLayout.addView(cells[x][y], layoutParams);
            }
        }

        Button nextStep = (Button) findViewById(R.id.next_step);
        nextStep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cell.nextStep(cells);
            }
        });

        Button drawBlinker = (Button) findViewById(R.id.draw_blinker);
        drawBlinker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cell.drawBlinker(cells);
            }
        });

        Button drawFlower = (Button) findViewById(R.id.draw_flower);
        drawFlower.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cell.drawFlower(cells);
            }
        });

        Button drawGlider = (Button) findViewById(R.id.draw_glider);
        drawGlider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cell.drawGlider(cells);
            }
        });
    }
}
