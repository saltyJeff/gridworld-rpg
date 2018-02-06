package rpg;

import info.gridworld.actor.Bug;
import upgrades.Upgrade;
import upgrades.UpgradeTree;

public class Buggy extends Bug {
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
	public static void applyUpgrade(Upgrade u) {
		switch(u.name) {
		//stupid shit
		}
	}
	//ARAUUVIND DONT TOUCH ABOVE THIS LINE
}
