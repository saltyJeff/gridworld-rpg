package upgrades;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.geom.Rectangle2D;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import rpg.Buggy;

public class TreeRender extends JPanel {
	public TreeRender() {
		setPreferredSize(new Dimension(600, 400));
		setLayout(null);
		dropButton(UpgradeTree.root, 0, getPreferredSize().height / 2);
		add(new JLabel("Experience: " + Buggy.getBuggy().xp));
		
	}
	private void dropButton(Upgrade root, int x, int y) {
		if(root == null) {
			return;
		}
		add(new UpgradeButton(root, x, y));
		dropButton(root.left, x + 160, y - 60);
		dropButton(root.right, x + 160, y + 60);
	}
}
