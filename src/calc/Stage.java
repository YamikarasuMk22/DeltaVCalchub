package calc;

import java.util.List;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class Stage {

	private int stageID;				//ステージ番号

	private JTabbedPane stageTabPane;	//ステージタブパネル

	private List<Part> parts;			//ステージに登録されているパーツ

	private JButton partAddButton;

	private JPanel partAddButtonPanel;

	/*******************
	 * StageID
	 *******************/
	public int getStageID() {
		return stageID;
	}
	public void setStageID(int stageID) {
		this.stageID = stageID;
	}

	/*******************
	 * StageTabPane
	 *******************/
	public JTabbedPane getStageTabPane() {
		return stageTabPane;
	}
	public void setStageTabPane(JTabbedPane stageTabPane) {
		this.stageTabPane = stageTabPane;
	}

	/*******************
	 * PartsList
	 *******************/
	public List<Part> getParts() {
		return parts;
	}
	public void setParts(List<Part> parts) {
		this.parts = parts;
	}

	/*******************
	 * PartAddButton
	 *******************/
	public JButton getPartAddButton() {
		return partAddButton;
	}
	public void setPartAddButton(JButton partAddButton) {
		this.partAddButton = partAddButton;
	}

	/*******************
	 * PartAddButtonPanel
	 *******************/
	public JPanel getPartAddButtonPanel() {
		return partAddButtonPanel;
	}
	public void setPartAddButtonPanel(JPanel partAddButtonPanel) {
		this.partAddButtonPanel = partAddButtonPanel;
	}
}
