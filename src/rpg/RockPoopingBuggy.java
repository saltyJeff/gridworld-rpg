import info.gridworld.actor.Bug;
import info.gridworld.actor.Rock;
import info.gridworld.grid.Location;

public class RockPoopingBuggy extends Bug{

	public void act() {
		if(canMove())
			makeMove();
		else
			turn();
	}
	
	public void makeMove() {
		Location loco = getLocation();
		moveTo(getLocation().getAdjacentLocation(getDirection()));
		Rock poop = new Rock(getColor());
		poop.putSelfInGrid(getGrid(), loco);
	}

}
