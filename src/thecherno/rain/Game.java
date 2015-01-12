package thecherno.rain;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

import javax.swing.JFrame;

import thecherno.rain.entity.mob.Player;
import thecherno.rain.graphics.Screen;
import thecherno.rain.input.Keyboard;
import thecherno.rain.level.Level;

public class Game extends Canvas implements Runnable {

    public static int width = 300;
    public static int height = width / 16 * 9;
    public static int scale = 3;
    public static String title = "Rain";

    private static final long serialVersionUID = 1L;

    public static void main(String[] args) {
        Game game = new Game();
        game = new Game();
        game.frame.setResizable(false);
        game.frame.setTitle(title);
        game.frame.add(game);
        game.frame.pack();
        game.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        game.frame.setLocationRelativeTo(null);
        game.frame.setVisible(true);

        game.start();

    }

    private final JFrame frame;
    private final BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
    private final Keyboard key;
    private final Level level;
    private final int[] pixels = ((DataBufferInt) image.getRaster().getDataBuffer()).getData();

    private final Player player;

    private boolean running = false;
    private final Screen screen;

    private Thread thread;

    public Game() {
        Dimension size = new Dimension(width * scale, height * scale);
        setPreferredSize(size);

        screen = new Screen(width, height);
        frame = new JFrame();
        key = new Keyboard();
        level = Level.spawn; // new SpawnLevel("/levels/spawn.png");
        player = new Player(30, 30, key);

        addKeyListener(key);
    }

    public void render() {
        BufferStrategy bs = getBufferStrategy();
        if (bs == null) {
            createBufferStrategy(3);
            return;
        }

        screen.clear();

        int xScroll = player.x - screen.width / 2;
        int yScroll = player.y - screen.height / 2;
        level.render(xScroll, yScroll, screen);
        player.render(screen);

        for (int i = 0; i < pixels.length; i++) {
            pixels[i] = screen.pixels[i];
        }

        Graphics g = bs.getDrawGraphics();
        // g.setColor(Color.BLACK);
        // g.fillRect(0, 0, getWidth(), getHeight());
        g.drawImage(image, 0, 0, getWidth(), getHeight(), null);
        g.setColor(Color.WHITE);
        g.setFont(new Font("Verdana", 0, 50));
        // g.drawString("X: " + x + " Y: " + y, 450, 400);
        g.dispose();
        bs.show();
    }

    @Override
    public void run() {
        long lastTime = System.nanoTime();
        long timer = System.currentTimeMillis();
        final double ns = 1000000000.0 / 60.0;
        double delta = 0;
        int frames = 0;
        int updates = 0;

        requestFocus();

        while (running) {
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            while (delta >= 1) {
                update();
                updates++;
                delta--;
            }
            render();
            frames++;

            // one second || 1000 ns = 1 sec
            if (System.currentTimeMillis() - timer > 1000) {
                timer += 1000;
                // System.out.println(updates + " ups, " + frames + " fps");
                frame.setTitle(title + "  | " + updates + " ups, " + frames + " fps");
                frames = 0;
                updates = 0;
            }
        }
        stop();
    }

    // int x = 0, y = 0;

    public synchronized void start() {
        running = true;
        thread = new Thread(this, "Display");
        thread.start();
    }

    public synchronized void stop() {
        running = false;
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public void update() {
        key.update();
        // if (key.up) y--;
        // if (key.down) y++;
        // if (key.right) x++;
        // if (key.left) x--;
        player.update();

    }

}
