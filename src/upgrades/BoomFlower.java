package upgrades;

import java.awt.Color;

import info.gridworld.actor.Flower;
import info.gridworld.grid.Location;

public class BoomFlower extends Flower{
	@Override
	public void act() {
		super.act();
		for(Location zz : this.getGrid().getEmptyAdjacentLocations(this.getLocation())) {
			this.getGrid().put(zz, new Flower(Color.ORANGE));
		}
		
	}
}
