package upgrades;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JScrollPane;

public class UpgradeUI extends JFrame {
	public UpgradeUI () {
		TreeRender treeRender = new TreeRender();
		UpgradeDraw upgradeDraw = new UpgradeDraw();
		getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.PAGE_AXIS));
		add(new JScrollPane(treeRender));
		add(upgradeDraw);
		pack();
	}
}
