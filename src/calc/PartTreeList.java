package calc;

import java.awt.Dimension;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;

public class PartTreeList extends JFrame implements TreeSelectionListener {

	/** Part List Data File */
	private static final File PART_LIST_DATA = new File("PartList.xml");

	static JFrame partTreeFrame = null;
	static List<TreePart> partTreeList = null;
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

		partTreeList = new ArrayList<TreePart>();

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
			TreePart listpart = partTreeList.get(i);

			if(listpart.getPartName().equals(partName)) {

				Stage stage = Calc.stages.get(stageID-1);
				List<Part> parts = stage.getParts();
				Part part = parts.get(partID-1);

				part.setCategory1(listpart.getCategory1());
				part.setCategory2(listpart.getCategory2());
				part.setDryMass(listpart.getPartDryMass());
				part.setTotalMass(listpart.getPartTotalMass());
				part.setIspA(listpart.getPartIspA());
				part.setIspS(listpart.getPartIspS());

				Calc.mainFrame.repaint();

				partTreeFrame.dispose();
			}
		}
	}
}
