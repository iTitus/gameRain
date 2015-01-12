package thecherno.rain.graphics;

public class Sprite {

    public static Sprite flower = new Sprite(16, 1, 0, SpriteSheet.tiles);
    // Sprite for rock, flower, grass, etc
    public static Sprite grass = new Sprite(16, 0, 0, SpriteSheet.tiles);
    public static Sprite player_back = new Sprite(32, 2, 5, SpriteSheet.tiles);
    public static Sprite player_back_1 = new Sprite(32, 2, 6, SpriteSheet.tiles);

    public static Sprite player_back_2 = new Sprite(32, 2, 7, SpriteSheet.tiles);

    // Sprite for player
    // x=0 y=5 because you select a square 32x32
    public static Sprite player_foward = new Sprite(32, 0, 5, SpriteSheet.tiles);
    public static Sprite player_foward_1 = new Sprite(32, 0, 6, SpriteSheet.tiles);
    public static Sprite player_foward_2 = new Sprite(32, 0, 7, SpriteSheet.tiles);

    public static Sprite player_side = new Sprite(32, 1, 5, SpriteSheet.tiles);
    public static Sprite player_side_1 = new Sprite(32, 1, 6, SpriteSheet.tiles);
    public static Sprite player_side_2 = new Sprite(32, 1, 7, SpriteSheet.tiles);
    public static Sprite rock = new Sprite(16, 2, 0, SpriteSheet.tiles);
    public static Sprite spawn_floor = new Sprite(16, 1, 1, SpriteSheet.spawn_level);
    // Sprite for spawn_level
    public static Sprite spawn_grass = new Sprite(16, 0, 0, SpriteSheet.spawn_level);

    public static Sprite spawn_hedge = new Sprite(16, 1, 0, SpriteSheet.spawn_level);
    public static Sprite spawn_wall1 = new Sprite(16, 0, 1, SpriteSheet.spawn_level);
    public static Sprite spawn_wall2 = new Sprite(16, 0, 2, SpriteSheet.spawn_level);

    public static Sprite spawn_water = new Sprite(16, 2, 0, SpriteSheet.spawn_level);
    // Sprite void
    public static Sprite voidSprite = new Sprite(16, 0x1B87E0);
    // Sprite color green no blue for example
    // public static Sprite voidSprite = new Sprite(16, 0x12b32d);
    public int[] pixels;

    public final int SIZE;
    private SpriteSheet sheet;
    private int x, y;

    public Sprite(int size, int colour) {
        SIZE = size;
        pixels = new int[SIZE * SIZE];
        setColour(colour);
    }

    public Sprite(int size, int x, int y, SpriteSheet sheet) {
        SIZE = size;
        pixels = new int[SIZE * SIZE];
        this.x = x * size;
        this.y = y * size;
        this.sheet = sheet;
        load();

    }

    private void load() {
        for (int y = 0; y < SIZE; y++) {
            for (int x = 0; x < SIZE; x++) {
                pixels[x + y * SIZE] = sheet.pixels[x + this.x + (y + this.y) * sheet.SIZE];
            }
        }
    }

    private void setColour(int colour) {
        for (int i = 0; i < pixels.length; i++) {
            pixels[i] = colour;
        }
    }

}
