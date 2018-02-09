package upgrades;

import java.awt.Color;

import info.gridworld.actor.Flower;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;
import rpg.Buggy;

public class BoomFlower extends Flower{
	
	public BoomFlower(Location bb) {
		//super();
		//System.out.println(this.getColor());
		
		//this.removeSelfFromGrid();
		Grid aa = Buggy.getBuggy().getGrid();
		System.out.println(bb);
		aa.remove(bb);
		aa.put(bb, new Flower(Color.ORANGE));
	}
	
}
