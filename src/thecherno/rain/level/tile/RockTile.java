package thecherno.rain.level.tile;

import thecherno.rain.graphics.Screen;
import thecherno.rain.graphics.Sprite;

public class RockTile extends Tile {

    public RockTile(Sprite sprite) {
        super(sprite);
    }

    @Override
    public void render(int x, int y, Screen screen) {
        screen.renderTile(x << 4, y << 4, this);
    }

    @Override
    public boolean solid() {
        return true;
    }
}
