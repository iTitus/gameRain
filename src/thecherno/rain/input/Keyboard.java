package thecherno.rain.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Keyboard implements KeyListener {

    public boolean up, down, left, right, exit;
    private final boolean[] keys = new boolean[120];

    @Override
    public void keyPressed(KeyEvent e) {
        keys[e.getKeyCode()] = true;
    }

    @Override
    public void keyReleased(KeyEvent e) {
        keys[e.getKeyCode()] = false;
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    public void update() {
        up = keys[KeyEvent.VK_UP] || keys[KeyEvent.VK_W];
        down = keys[KeyEvent.VK_DOWN] || keys[KeyEvent.VK_S];
        right = keys[KeyEvent.VK_RIGHT] || keys[KeyEvent.VK_D];
        left = keys[KeyEvent.VK_LEFT] || keys[KeyEvent.VK_A];
        exit = keys[KeyEvent.VK_ESCAPE];
    }

}
