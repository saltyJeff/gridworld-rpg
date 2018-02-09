package rpg;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import info.gridworld.grid.Location;

public class Input {
	private static Input input;
	public static Input getInput() {
		if(input == null) {
			input = new Input();
		}
		return input;
	}
	private KeyListener listener = new KeyListener() {
		@Override
		public void keyPressed(KeyEvent evt) {
			switch(evt.getKeyCode()) {
			case 37:
				direction = Location.LEFT;
				break;
			case 39:
				direction = Location.RIGHT;
				break;
			case 38:
				direction = Location.NORTH;
				break;
			case 40:
				direction = Location.SOUTH;
				break;
			}
		}
		@Override
		public void keyTyped(KeyEvent e) {}
		@Override
		public void keyReleased(KeyEvent arg0) {}
	};
	public KeyListener getListener() {
		return listener;
	}
	private int direction;
	
	public int dir() {
		return direction;
	}
}
