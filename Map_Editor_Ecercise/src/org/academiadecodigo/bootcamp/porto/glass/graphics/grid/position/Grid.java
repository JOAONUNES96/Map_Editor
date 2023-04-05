package org.academiadecodigo.bootcamp.porto.glass.graphics.grid.position;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Colorable;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

import java.util.LinkedList;

public class Grid {


    private int cellSize = 30;
    private int fieldHeigh = 800;
    private int fieldWidth = 800;
    private int maxRows = fieldHeigh / cellSize;
    private int maxCols = fieldWidth / cellSize;
    private final int PADDING = 10;

    Rectangle[][] rectangleArray = new Rectangle[maxCols][maxRows];
    Boolean[][] rectangleArrayColor = new Boolean[maxCols][maxRows];
    public Rectangle movableSquare = new Rectangle(cellSize * 10 + PADDING, cellSize * 10 + PADDING, cellSize, cellSize);
    Rectangle x;


    public void gridConstructor() {
        for (int i = 0; i < maxRows; i++) {
            for (int j = 0; j < maxCols; j++) {
                x = new Rectangle(cellSize * i + PADDING, cellSize * j + PADDING, cellSize, cellSize);
                rectangleArray[i][j] = x;
                x.draw();
                rectangleArrayColor[i][j] = false;


            }
        }
    }

    public void paintSquare() {
        if (rectangleArrayColor[movableSquare.getX() / cellSize][movableSquare.getY() / cellSize] == false) {
            x = rectangleArray[movableSquare.getX() / cellSize][movableSquare.getY() / cellSize];
            x.setColor(Color.PINK);
            x.fill();
            rectangleArrayColor[movableSquare.getX() / cellSize][movableSquare.getY() / cellSize] = true;
        } else {
            x = rectangleArray[movableSquare.getX() / cellSize][movableSquare.getY() / cellSize];
            x.setColor(Color.BLACK);
            x.draw();
            rectangleArrayColor[movableSquare.getX() / cellSize][movableSquare.getY() / cellSize] = false;

        }
    }


    public void moveRight() {
        if (movableSquare.getX() + cellSize < fieldWidth - cellSize) {
            movableSquare.translate(cellSize, 0);
        } else {
            return;
        }
    }

    public void moveLeft() {
        if (movableSquare.getX() > cellSize) {
            movableSquare.translate(-cellSize, 0);
        } else {
            return;
        }
    }

    public void moveUp() {
        if ((movableSquare.getY()) > cellSize) {
            movableSquare.translate(0, -cellSize);
        } else {
            return;
        }
    }

    public void moveDown() {
        if ((movableSquare.getY() + cellSize * 2) < fieldHeigh) {
            movableSquare.translate(0, cellSize);
        } else {
            return;
        }
    }
}






