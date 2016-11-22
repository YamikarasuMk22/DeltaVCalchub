package calc;

import java.awt.Dimension;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;

public class PartTreeList extends JFrame implements TreeSelectionListener {

	/** Part List Data File */
	private static final File PART_LIST_DATA = new File("PartList.xml");

	static JFrame partTreeFrame = null;
	static List<Part> partTreeList = null;
	static JTree partTree = null;

	static int stageID = 0;
	static int partID = 0;

	public static void drawUIPartTree(String strPartNo) {

		partTreeFrame = new JFrame("SelectPart" + strPartNo);

		partTreeFrame.setSize(500, 400);
		partTreeFrame.setVisible(false);
		partTreeFrame.setLocationRelativeTo(null);
		partTreeFrame.addWindowListener(new PartTreeListWindowListener());

		//値の右辺と左辺を分ける(StageID)-(PartID)
		String[] splitstr = strPartNo.split("-", 0);
		stageID = Integer.parseInt(splitstr[0].replaceAll(" ", ""));
		partID = Integer.parseInt(splitstr[1].replaceAll(" ", ""));

		loadPartsTreeList();

		partTreeFrame.setVisible(true);
	}

	public static void loadPartsTreeList() {
		JScrollPane treeScrollPane = new JScrollPane();

		partTreeList = new ArrayList<Part>();

		// パーツデータロード
		CalcDataFileIO.loadPartList(PART_LIST_DATA, partTreeList);

		partTree = CalcDataFileIO.loadTreeList(partTree, partTreeList);

		treeScrollPane.getViewport().setView(partTree);
		treeScrollPane.setPreferredSize(new Dimension(partTreeFrame.getWidth(), partTreeFrame.getHeight()));

		partTree.addTreeSelectionListener(new PartTreeList());

		partTreeFrame.add(treeScrollPane);
	}

	@Override
	public void valueChanged(TreeSelectionEvent e) {

		DefaultMutableTreeNode node = (DefaultMutableTreeNode) partTree.getLastSelectedPathComponent();

		String partName = (String) node.getUserObject();

		for (int i = 0; i < partTreeList.size(); i++) {
			Part listpart = partTreeList.get(i);

			if(listpart.getPartName().equals(partName)) {

				for (int j = 0; j < Calc.parts.size(); j++) {
					Part part = Calc.parts.get(j);

					if(part.getStageID() == stageID && part.getPartID() == partID) {
						part.setCategory1(listpart.getCategory1());
						part.setCategory2(listpart.getCategory2());

						JLabel category1Label = part.getCategory1Label();
						category1Label.setText(listpart.getCategory1());
						JLabel category2Label = part.getCategory2Label();
						category2Label.setText(listpart.getCategory2());

						Calc.mainFrame.repaint();
					}
				}
			}
		}
	}
}
