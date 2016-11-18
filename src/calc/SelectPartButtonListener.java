package calc;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTree;

public class SelectPartButtonListener implements ActionListener, WindowListener {

	/** Part List Data File */
	private static final File PART_LIST_DATA = new File("PartList.xml");

	static JFrame partSelectFrame = new JFrame("SelectPart");
	static List<Part> parts = new ArrayList<Part>();

	@Override
	public void actionPerformed(ActionEvent e) {

		partSelectFrame.setSize(500, 400);
		partSelectFrame.setVisible(false);
		partSelectFrame.setLocationRelativeTo(null);
		partSelectFrame.addWindowListener(this);

		loadPartsTreeList();

	    partSelectFrame.setVisible(true);
	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void windowClosing(WindowEvent e) {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO 自動生成されたメソッド・スタブ

	}

	public void loadPartsTreeList() {
		JScrollPane treeScrollPane = new JScrollPane();
		JTree partTree = null;

		//パーツデータロード
		CalcDataFileIO.loadPartList(PART_LIST_DATA, parts);

		treeScrollPane.getViewport().setView(CalcDataFileIO.loadTreeList(partTree, parts));
		treeScrollPane.setPreferredSize(new Dimension(partSelectFrame.getWidth(), partSelectFrame.getHeight()));

		partSelectFrame.add(treeScrollPane);
	}
}
