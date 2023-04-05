package org.academiadecodigo.bootcamp.porto.glass.graphics.grid.position;

import org.academiadecodigo.simplegraphics.graphics.Color;

public class Map {

    Grid backround = new Grid();
    Movement movement = new Movement(backround);

    public void init() {
       backround.gridConstructor();
       backround.movableSquare.fill();

    }

}
