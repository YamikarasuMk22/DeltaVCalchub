package calc;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SelectPartButtonListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		PartTreeList.drawUIPartTree(e.getActionCommand());
	}
}
