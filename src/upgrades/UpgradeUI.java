package upgrades;

import javax.swing.JFrame;

public class UpgradeUI extends JFrame {
	public UpgradeUI () {
		TreeRender treeRender = new TreeRender();
		UpgradeDraw upgradeDraw = new UpgradeDraw();
		this.add(treeRender);
		this.add(upgradeDraw);
	}
}
