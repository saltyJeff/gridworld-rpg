package upgrades;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.geom.Rectangle2D;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import rpg.Buggy;

public class TreeRender extends JPanel {
	public TreeRender() {
		setPreferredSize(new Dimension(300, 200));
		setLayout(null);
		dropButton(UpgradeTree.root, 0, 100);
		
	}
	private void dropButton(Upgrade root, int x, int y) {
		if(root == null) {
			return;
		}
		System.out.println("hello");
		JButton butt = new JButton();
		butt.setText(root.toString());
		if(root == Buggy.getBuggy().lastUpgrade) {
			butt.setBackground(Color.yellow);
		}
		butt.setBounds(x,  y, 140, 40);
		add(butt);
		dropButton(root.left, x + 160, y - 60);
		dropButton(root.right, x + 160, y + 60);
	}
}
