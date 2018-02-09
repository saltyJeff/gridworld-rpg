package upgrades;

import java.awt.Dimension;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;

import rpg.Buggy;

public class UpgradeUI extends JFrame {
	public UpgradeUI () {
		TreeRender treeRender = new TreeRender();
		getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.PAGE_AXIS));
		JScrollPane scrolly = new JScrollPane(treeRender);
		scrolly.setPreferredSize(new Dimension(400, 400));
		add(scrolly);
		JLabel label = new JLabel();
		add(label);
		pack();
		
		Timer timer = new Timer();
		timer.scheduleAtFixedRate(new TimerTask () {
			@Override
			public void run () {
				UpgradeButton.tapButts(Buggy.getBuggy().lastUpgrade);
				label.setText("XP: "+Buggy.getBuggy().xp);
			}
		}, 0L, 500L);
	}
}
