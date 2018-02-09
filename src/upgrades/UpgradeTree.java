package upgrades;

public class UpgradeTree {
	public static Upgrade root = new Upgrade("basic", 0,
			new Upgrade("keyboard", 20, 
					new Upgrade("thicc", 20, null, null), null),
			new Upgrade("burst", 40, null, null));
}
