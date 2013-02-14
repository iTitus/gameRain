package t321.entity.mob;

import t321.graphics.Screen;
import t321.graphics.Sprite;
import t321.input.Keyboard;

public class Player extends Mob {

	private Keyboard input;

	public Player(Keyboard input) {
		this.input = input;
	}

	public Player(int x, int y, Keyboard input) {
		this.x = x;
		this.y = y;
		this.input = input;
	}

	public void update() {
		// if(input.up) y--;
		// if(input.down) y++;
		// if(input.left) x--;
		// if(input.right) x++;

		int xa = 0, ya = 0;
		if (input.up) ya--;
		if (input.down) ya++;
		if (input.left) xa--;
		if (input.right) xa++;

		if (xa != 0 || ya != 0) move(xa, ya);

	}

	public void render(Screen screen) {
		screen.renderPlayer(x - 16, y - 16, Sprite.player);

	}

}