package calc;

import java.awt.Dimension;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTree;

public class PartTreeList extends JFrame {

	/** Part List Data File */
	private static final File PART_LIST_DATA = new File("PartList.xml");

	static JFrame partTreeFrame = new JFrame("SelectPart");
	static List<Part> parts = null;
	static JTree partTree = null;

	public static void drawUIPartTree() {

		partTreeFrame.setSize(500, 400);
		partTreeFrame.setVisible(false);
		partTreeFrame.setLocationRelativeTo(null);
		partTreeFrame.addWindowListener(new PartTreeListWindowListener());

		loadPartsTreeList();

	    partTreeFrame.setVisible(true);
	}

	public static void loadPartsTreeList() {
		JScrollPane treeScrollPane = new JScrollPane();

		parts = new ArrayList<Part>();

		//パーツデータロード
		CalcDataFileIO.loadPartList(PART_LIST_DATA, parts);

		partTree = CalcDataFileIO.loadTreeList(partTree, parts);

		treeScrollPane.getViewport().setView(partTree);
		treeScrollPane.setPreferredSize(new Dimension(partTreeFrame.getWidth(), partTreeFrame.getHeight()));

		partTree.addTreeSelectionListener(new SelectPartTreeListener());

		partTreeFrame.add(treeScrollPane);
	}

	public static JFrame getPartTreeFrame() {
			return partTreeFrame;
	}

	public static JTree getTreeObject() {
		if(partTree != null)
			return partTree;
		else
			return null;
	}

	public static List<Part> getListOfPartTree() {
		if(parts != null)
			return parts;
		else
			return null;
	}
}
