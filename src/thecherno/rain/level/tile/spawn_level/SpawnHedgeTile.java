package thecherno.rain.level.tile.spawn_level;

import thecherno.rain.graphics.Screen;
import thecherno.rain.graphics.Sprite;
import thecherno.rain.level.tile.Tile;

public class SpawnHedgeTile extends Tile {

    public SpawnHedgeTile(Sprite sprite) {
        super(sprite);
    }

    public boolean breakable() {
        return true;
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
