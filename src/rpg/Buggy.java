package rpg;

import java.awt.Color;



import info.gridworld.actor.Bug;
import info.gridworld.grid.Location;
import upgrades.BoomFlower;
import upgrades.Upgrade;
import upgrades.UpgradeTree;

public class Buggy extends Bug {
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
	public int xp =10000;
	public int hp;
	public Upgrade lastUpgrade;
	public void applyUpgrade(Upgrade u) {
		lastUpgrade = u;
		switch(u.name) {
		case "Burst":
			Buggy.getBuggy().getGrid().put(Buggy.getBuggy().getLocation().getAdjacentLocation(0), new Buggy());
		case "Thicc":
			Buggy.getBuggy().setColor(Color.BLACK);
		}
	}
	
	@Override
	public void act() {
			Location ll = Buggy.getBuggy().getLocation();
			super.act();
			Buggy.getBuggy().getGrid().put(ll, new BoomFlower());
			

		
	}
}
