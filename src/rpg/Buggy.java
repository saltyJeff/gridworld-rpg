package rpg;

import java.awt.Color;

import info.gridworld.actor.Actor;
import info.gridworld.actor.Bug;
import info.gridworld.actor.Rock;
import info.gridworld.grid.Location;
import upgrades.Upgrade;
import upgrades.UpgradeTree;

public class Buggy extends Bug {
	private Buggy() {
		applyUpgrade(UpgradeTree.root);
	};

	private static Buggy buggy;

	public static Buggy getBuggy() {
		if (buggy == null) {
			buggy = new Buggy();
		}
		return buggy;
	}

	public int boost = 1;
	public int level;
	public int xp = 0;
	public int hp;
	public Upgrade lastUpgrade;

	private boolean thicc = false;
	private boolean keyboard = false;
	private boolean burst = false;
	private boolean tasty = false;
	private boolean bright = false;

	public void applyUpgrade(Upgrade u) {
		// System.out.println("Called");
		lastUpgrade = u;
		switch (u.name) {
		case "tasty":
			tasty = true;
			break;
		case "UpgradeXP":
			boost = 4;
			break;
		case "burst":
			boost = 2;
			break;
		case "keyboard":
			keyboard = true;
			break;
		case "mass":
			thicc = true;
			break;
		case "bright":
			bright = true;
			break;
		}
	}

	@Override
	public boolean canMove() {
		if (super.canMove()) {
			return true;
		}
		if (!thicc) {
			return false;
		}
		Location fwd = getLocation().getAdjacentLocation(getDirection());
		if (getGrid().isValid(fwd)) {
			Actor actor = getGrid().get(fwd);
			if (actor instanceof Rock || (tasty && actor instanceof Bug)) {
				if (tasty && actor instanceof Bug) {
					xp += 100;
				}
				xp += 10;
				actor.removeSelfFromGrid();
				return true;
			}
		}
		return false;
	}

	@Override
	public void act() {
		if (bright)
			Buggy.getBuggy().setColor(new Color((int) (Math.random() * 256),
					(int) (Math.random() * 256), (int) (Math.random() * 256)));
		if (keyboard) {
			setDirection(Input.getInput().dir());
			if (canMove()) {
				xp += 1 * boost + boost;
				move();
			}
		} else {
			super.act();
			xp += 1 * boost + boost;
		}
	}
}
