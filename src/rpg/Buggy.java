package rpg;

import info.gridworld.actor.Bug;
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
	public int xp;
	public int hp;
	public Upgrade lastUpgrade;
	public void applyUpgrade(Upgrade u) {
		lastUpgrade = u;
		switch(u.name) {
		//stupid shit
		}
	}
	//ARAUUVIND DONT TOUCH ABOVE THIS LINE
}
