package rpg;
import java.awt.KeyEventDispatcher;
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
	private KeyEventDispatcher listener = new KeyEventDispatcher() {
		@Override
		public boolean dispatchKeyEvent(KeyEvent evt) {
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
			return false;
		}
	};
	public KeyEventDispatcher getListener() {
		return listener;
	}
	private int direction = Location.RIGHT;
	
	public int dir() {
		return direction;
	}
}
