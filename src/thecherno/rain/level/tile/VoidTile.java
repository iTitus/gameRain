package thecherno.rain.level.tile;

import thecherno.rain.graphics.Screen;
import thecherno.rain.graphics.Sprite;

public class VoidTile extends Tile {

    public VoidTile(Sprite sprite) {
        super(sprite);
    }

    @Override
    public void render(int x, int y, Screen screen) {
        screen.renderTile(x << 4, y << 4, this);
    }

}
