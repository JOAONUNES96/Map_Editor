package org.academiadecodigo.bootcamp.porto.glass.graphics.grid.position;

import org.academiadecodigo.bootcamp.porto.glass.graphics.grid.position.Grid;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

public class Movement implements KeyboardHandler {

    private Grid rectangle;
    private Keyboard keyboard;

    private boolean keepPainting;

    public Movement(Grid rectangle) {
        this.rectangle = rectangle;
        keyboard = new Keyboard(this);
        createKeyboardEvents();
    }

    public void createKeyboardEvents() {

        KeyboardEvent keyboardEventRight = new KeyboardEvent();
        keyboardEventRight.setKey(KeyboardEvent.KEY_RIGHT);
        keyboardEventRight.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(keyboardEventRight);

        KeyboardEvent keyboardEventLeft = new KeyboardEvent();
        keyboardEventLeft.setKey(KeyboardEvent.KEY_LEFT);
        keyboardEventLeft.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(keyboardEventLeft);

        KeyboardEvent keyboardEventUp = new KeyboardEvent();
        keyboardEventUp.setKey(KeyboardEvent.KEY_UP);
        keyboardEventUp.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(keyboardEventUp);

        KeyboardEvent keyboardEventDown = new KeyboardEvent();
        keyboardEventDown.setKey(KeyboardEvent.KEY_DOWN);
        keyboardEventDown.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(keyboardEventDown);

        KeyboardEvent keyboardEventSpace = new KeyboardEvent();
        keyboardEventSpace.setKey(KeyboardEvent.KEY_SPACE);
        keyboardEventSpace.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(keyboardEventSpace);

        KeyboardEvent keyboardEventSpaceRelease = new KeyboardEvent();
        keyboardEventSpaceRelease.setKey(KeyboardEvent.KEY_SPACE);
        keyboardEventSpaceRelease.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        keyboard.addEventListener(keyboardEventSpaceRelease);


    }


    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
        KeyboardEventType keyboardEventType = null;
        switch (keyboardEvent.getKey()) {
            case KeyboardEvent.KEY_RIGHT:
                rectangle.moveRight();
                if(keepPainting) {
                    rectangle.paintSquare();
                }
                break;
            case KeyboardEvent.KEY_LEFT:
                rectangle.moveLeft();
                if(keepPainting) {
                    rectangle.paintSquare();
                }
                break;
            case KeyboardEvent.KEY_UP:
                rectangle.moveUp();
                if(keepPainting){
                    rectangle.paintSquare();
                }
                break;
            case KeyboardEvent.KEY_DOWN:
                rectangle.moveDown();
                if(keepPainting){
                    rectangle.paintSquare();
                }
                break;
            case KeyboardEvent.KEY_SPACE:
                keepPainting = true;
                while(keepPainting){
                    rectangle.paintSquare();
                    System.out.println("painting");
                    break;
                }
                break;
        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {
        if (keyboardEvent.getKey() == KeyboardEvent.KEY_SPACE) {
            keepPainting = false;
        }
    }

}


