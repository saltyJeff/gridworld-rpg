package upgrades;

public class Upgrade {
	public Upgrade left;
	public Upgrade right;
	public String name;
	public int xpRequired;
	public Upgrade(String s, int x, Upgrade l, Upgrade r) {
		name = s;
		xpRequired = x;
		left = l;
		right = r;
	}
	@Override
	public String toString() {
		return String.format("%s (%s xp)", name, xpRequired);
	}
}
