package upgrades;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

import javax.swing.JButton;

import rpg.Buggy;

public class UpgradeButton extends JButton {
	public static LinkedList<UpgradeButton> butts = new LinkedList<>();
	public Upgrade upgrade;
	public UpgradeButton(Upgrade u, int x, int y) {
		upgrade = u;
		setBounds(x, y, 150, 40);
		setText(upgrade.toString());
		addActionListener(new ActionListener () {
			@Override
			public void actionPerformed(ActionEvent evt) {
				Buggy.getBuggy().applyUpgrade(upgrade);
			}
		});
		butts.add(this);
	}
	public static void tapButts(Upgrade u) {
		for(UpgradeButton butt : butts) {
			if(butt.upgrade == u) {
				butt.setCurrent();
			}
			else if(butt.upgrade == u.left) {
				if(Buggy.getBuggy().xp >= u.left.xpRequired) {
					butt.setWithinReachAffordable();
				}
				else {
					butt.setWithinReachExpensive();
				}
			}
			else if(butt.upgrade == u.right) {
				if(Buggy.getBuggy().xp >= u.left.xpRequired) {
					butt.setWithinReachAffordable();
				}
				else {
					butt.setWithinReachExpensive();
				}
			}
			else {
				butt.setOutOfReach();
			}
		}
	}
	public void setOutOfReach() {
		setEnabled(false);
		setBackground(Color.LIGHT_GRAY);
	}
	public void setWithinReachExpensive() {
		setEnabled(false);
		setBackground(Color.RED);
	}
	public void setWithinReachAffordable() {
		setEnabled(true);
		setBackground(Color.GREEN);
	}
	public void setCurrent() {
		setEnabled(false);
		setBackground(Color.CYAN);
	}
}
