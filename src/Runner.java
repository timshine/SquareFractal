
// Lab17bvst.java
// The student, starting version of the Lab17b assignment.

import java.awt.*;
import java.applet.*;

public class Runner extends Applet {
	public void init() {
		setSize(1024, 768);
	}

	public void paint(Graphics g) {
		drawSquare1(g, 1024, 768);
	}

	//Middle black square
	public void drawSquare1(Graphics g, int maxX, int maxY) {
		int midX = maxX / 2;// 512
		int midY = maxY / 2;// 384
		int startWidth = maxX / 4;// 256
		int startHeight = maxY / 4;// 192
		int tlX = midX - (startWidth / 2);// 384
		int tlY = midY - (startHeight / 2);// 288
		g.fillRect(tlX, tlY, startWidth, startHeight);

		// Draws original 4 to the side
		g.setColor(Color.red);
		drawFourSquares(g, tlX - startWidth / 2, tlY - startHeight / 2, startWidth / 2, startHeight / 2, 1);
		g.setColor(Color.blue);
		drawFourSquares(g, tlX + startWidth, tlY - startHeight / 2, startWidth / 2, startHeight / 2, 2);
		g.setColor(Color.yellow);
		drawFourSquares(g, tlX + startWidth, tlY + startHeight, startWidth / 2, startHeight / 2, 3);
		g.setColor(Color.green);
		drawFourSquares(g, tlX - startWidth / 2, tlY + startHeight, startWidth / 2, startHeight / 2, 4);
	}

	public void delay(long n) {
		n *= 1000;
		long startDelay = System.nanoTime();
		long endDelay = 0;
		while (endDelay - startDelay < n)
			endDelay = System.nanoTime();
	}

	// Recursion and switch case to see if what rectangle it is and draw to only sides that are necessary
	public void drawFourSquares(Graphics g, int x, int y, int w, int h, int side) {
		if (w >= 1) {
			g.fillRect(x, y, w, h);

			switch (side) {
			// Draws in the top left
			case 1:
				g.setColor(Color.red);
				drawFourSquares(g, x - w / 2, y - h / 2, w / 2, h / 2, 1);
				g.setColor(Color.blue);
				drawFourSquares(g, x + w, y - h / 2, w / 2, h / 2, 2);
				g.setColor(Color.green);
				drawFourSquares(g, x - w / 2, y + h, w / 2, h / 2, 4);
				break;
			// Draws in the top right
			case 2:
				g.setColor(Color.red);
				drawFourSquares(g, x - w / 2, y - h / 2, w / 2, h / 2, 1);
				g.setColor(Color.blue);
				drawFourSquares(g, x + w, y - h / 2, w / 2, h / 2, 2);
				g.setColor(Color.yellow);
				drawFourSquares(g, x + w, y + h, w / 2, h / 2, 3);
				break;
			// Draws in the bottom right
			case 3:
				g.setColor(Color.blue);
				drawFourSquares(g, x + w, y - h / 2, w / 2, h / 2, 2);
				g.setColor(Color.yellow);
				drawFourSquares(g, x + w, y + h, w / 2, h / 2, 3);
				g.setColor(Color.green);
				drawFourSquares(g, x - w / 2, y + h, w / 2, h / 2, 4);
				break;
			// Draws in the bottom left
			case 4:
				g.setColor(Color.red);
				drawFourSquares(g, x - w / 2, y - h / 2, w / 2, h / 2, 1);
				g.setColor(Color.yellow);
				drawFourSquares(g, x + w, y + h, w / 2, h / 2, 3);
				g.setColor(Color.green);
				drawFourSquares(g, x - w / 2, y + h, w / 2, h / 2, 4);
				break;
			default:
				break;
			}
		}
	}

}
