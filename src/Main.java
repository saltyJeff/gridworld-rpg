import copypasta.BoxBug;
import copypasta.ChameleonKid;
import copypasta.DancingBug;
import copypasta.JumperBug;
import copypasta.KingCrab;
import copypasta.QuickCrab;
import info.gridworld.actor.Actor;

import java.awt.KeyboardFocusManager;

import info.gridworld.actor.ActorWorld;
import info.gridworld.actor.Flower;
import info.gridworld.actor.Rock;
import info.gridworld.grid.BoundedGrid;
import info.gridworld.grid.Location;
import rpg.Buggy;
import rpg.RockPoopingBuggy;
import upgrades.Upgrade;
import upgrades.UpgradeUI;
import rpg.Input;


public class Main {
	public static void main(String[] args) {
		ActorWorld world = new ActorWorld();
		world.setGrid(new BoundedGrid<Actor>(16, 16));
		world.add(new Location(9, 0), Buggy.getBuggy());
		world.add(new Location(2, 7), new JumperBug());
		world.add(new Location(6, 15), new BoxBug(5));
		world.add(new Location(5, 10), new KingCrab());
		world.add(new Location(1, 6), new RockPoopingBuggy());
		world.add(new Location(5, 15), new QuickCrab());
		//world.add(new Location(5,3), new ChameleonKid());
		world.show();
		//world.setGrid();
		UpgradeUI upgradeUi = new UpgradeUI();
		upgradeUi.setLocation(700, 30);
		upgradeUi.setVisible(true);
		KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(Input.getInput().getListener());
		//Buggy.getBuggy().applyUpgrade(new Upgrade("Thicc", 20, null, null));
	}

}
