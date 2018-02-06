import info.gridworld.actor.ActorWorld;
import info.gridworld.actor.Flower;
import info.gridworld.actor.Rock;
import info.gridworld.grid.Location;
import rpg.Buggy;
import upgrades.UpgradeUI;

public class Main {

	public static void main(String[] args) {
		ActorWorld world = new ActorWorld();
        world.add(new Location(9,0), Buggy.getBuggy());
        world.add(new Location(8,0), new Rock());
        world.add(new Location(6,0), new Rock());
        world.add(new Location(5,0), new Rock());
        world.add(new Location(1,6), new Flower());
        world.show();
        UpgradeUI upgradeUi = new UpgradeUI();
        upgradeUi.setVisible(true);
	}

}
