package rpg;

import java.awt.Color;

import info.gridworld.actor.Actor;
import info.gridworld.actor.Bug;
import info.gridworld.actor.Rock;
import info.gridworld.grid.Location;
import upgrades.Upgrade;
import upgrades.UpgradeTree;

public class Buggy extends Bug {
	static boolean burst = true;
	private Buggy () {
		applyUpgrade(UpgradeTree.root);
	};
	private static Buggy buggy;
	public static Buggy getBuggy() {
		if(buggy == null) {
			buggy = new Buggy();
		}
		return buggy;
	}
	public int level;
	public int xp = 0;
	public int hp;
	public Upgrade lastUpgrade;
	public void applyUpgrade(Upgrade u) {
		//System.out.println("Called");
		lastUpgrade = u;
		switch(u.name) {
		case "burst":
			break;
		case "thicc":
			//System.out.println(Buggy.getBuggy().getColor());
			Buggy.getBuggy().setColor(Color.BLACK);
			break;
		}
	}
	
	@Override
	public boolean canMove() {
		boolean Valid = Buggy.getBuggy().getGrid().isValid(Buggy.getBuggy().getLocation().getAdjacentLocation(Buggy.getBuggy().getDirection()));
		if(!super.canMove() && Valid && (Buggy.getBuggy().getGrid().get(Buggy.getBuggy().getLocation().getAdjacentLocation(Buggy.getBuggy().getDirection())) instanceof Rock && burst)) {
			Buggy.getBuggy().getGrid().get(Buggy.getBuggy().getLocation().getAdjacentLocation(Buggy.getBuggy().getDirection())).removeSelfFromGrid();
		}
			return super.canMove();
		
	}
	@Override
	public void act() {
			Location ll = Buggy.getBuggy().getLocation();
			//Buggy.getBuggy().moveTo(new Location(6,3));
			
			//System.out.println(ll);
			Actor zz = Buggy.getBuggy().getGrid().get(ll);
			
			
			
			
			super.act();
			if(!ll.equals(Buggy.getBuggy().getLocation()))
				xp += 10;
		
	}
}
