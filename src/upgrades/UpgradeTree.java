package upgrades;

public class UpgradeTree {
	public static Upgrade root = new Upgrade("basic", 0,
			new Upgrade("keyboard", 20, 
					new Upgrade("mass", 80, 
							new Upgrade("tasty", 1000, null, null), 
						null), 
					null),
			new Upgrade("burst", 100, 
					new Upgrade("UpgradeXP", 200, 
							new Upgrade("bright", 500, null, null), 
							new Upgrade("keyboard", 1000, null, null)), 
					null));
}
