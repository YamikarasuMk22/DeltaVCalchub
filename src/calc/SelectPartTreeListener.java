package calc;

import javax.swing.JTree;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;

public class SelectPartTreeListener implements TreeSelectionListener {

	@Override
	public void valueChanged(TreeSelectionEvent e) {

		JTree treeObject = PartTreeList.getTreeObject();
		DefaultMutableTreeNode node = (DefaultMutableTreeNode) treeObject.getLastSelectedPathComponent();

	}

}
