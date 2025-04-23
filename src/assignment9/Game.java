package assignment9;

import java.awt.Font;
import java.awt.event.KeyEvent;
import edu.princeton.cs.introcs.StdDraw;

public class Game {

	private Snake snake;
	private Food food;
	private int score; 

	public Game() {
		StdDraw.enableDoubleBuffering();
		snake = new Snake();
		food = Food.createRandom();
		score = 0;
	}

	public void play() {
		while (snake.isInbounds()) {
			int dir = getKeypress();
			snake.changeDirection(dir);
			snake.move();

			if (snake.eatFood(food)) {
				food = Food.createRandom();
				score++; 
			}

			updateDrawing();
		}

		// end of game message
		StdDraw.clear();
		StdDraw.text(0.5, 0.5, "Game Over!");
		StdDraw.text(0.5, 0.45, "Final Score: " + score); 
		StdDraw.show();
	}

	private int getKeypress() {
		if(StdDraw.isKeyPressed(KeyEvent.VK_W)) {
			return 1;
		} else if (StdDraw.isKeyPressed(KeyEvent.VK_S)) {
			return 2;
		} else if (StdDraw.isKeyPressed(KeyEvent.VK_A)) {
			return 3;
		} else if (StdDraw.isKeyPressed(KeyEvent.VK_D)) {
			return 4;
		} else {
			return -1;
		}
	}

	private void updateDrawing() {
		StdDraw.clear();
		snake.draw();
		food.draw();

		StdDraw.setPenColor(0, 0, 0); // black text
		StdDraw.setFont(new Font("Arial", Font.PLAIN, 14));
		StdDraw.textLeft(0.01, 0.95, "Score: " + score);

		StdDraw.show();
		StdDraw.pause(50);
	}

	public static void main(String[] args) {
		Game g = new Game();
		g.play();
	}
}


