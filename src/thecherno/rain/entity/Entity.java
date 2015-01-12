package thecherno.rain.entity;

import java.util.Random;

import thecherno.rain.graphics.Screen;
import thecherno.rain.level.Level;

public abstract class Entity {
    public int x, y;
    private boolean removed = false;
    protected Level level;
    protected final Random random = new Random();

    public boolean isRemoved() {
        return removed;
    }

    public void remove() {
        // remove from level
        removed = true;
    }

    public void render(Screen screen) {
    }

    public void update() {
    }
}
