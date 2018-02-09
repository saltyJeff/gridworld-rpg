package rpg;

import java.awt.Color;

import info.gridworld.actor.Actor;
import info.gridworld.actor.Bug;
import info.gridworld.actor.Rock;
import info.gridworld.grid.Location;
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
	public int xp = 0;
	public int hp;
	public Upgrade lastUpgrade;
	
	private boolean thicc = false;
	private boolean keyboard = false;
	private boolean burst = false;

	public void applyUpgrade(Upgrade u) {
		//System.out.println("Called");
		lastUpgrade = u;
		switch(u.name) {
		case "burst":
			burst = true;
			break;
		case "keyboard":
			keyboard = true;
			break;
		case "thicc":
			//System.out.println(Buggy.getBuggy().getColor());
			setColor(Color.BLACK);
			thicc = true;
			break;
		}
	}
	@Override
	public boolean canMove() {
		if(super.canMove()) {
			return true;
		}
		if(!thicc) {
			return false;
		}
		Location fwd = getLocation().getAdjacentLocation(getDirection());
		if(getGrid().isValid(fwd)) {
			Actor actor = getGrid().get(fwd);
			if(actor instanceof Rock) {
				actor.removeSelfFromGrid();
				return true;
			}
		}
		return false;
	}
	@Override
	public void act() {
		setDirection(Input.getInput().dir());
		if(canMove()) {
			xp += 100;
			move();
		}
	}
}
