package thecherno.rain.entity.mob;

import thecherno.rain.entity.Entity;
import thecherno.rain.graphics.Sprite;

public abstract class Mob extends Entity {

    protected int dir = 0;
    protected boolean moving = false;
    protected Sprite sprite;

    public void move(int xa, int ya) {
        if (xa > 0) {
            dir = 1;
        }
        if (xa < 0) {
            dir = 3;
        }
        if (ya > 0) {
            dir = 2;
        }
        if (ya < 0) {
            dir = 0;
        }

        if (!collision()) {
            x += xa;
            y += ya;
        }
    }

    public void render() {
    }

    @Override
    public void update() {
    }

    private boolean collision() {
        return false;
    }
}
