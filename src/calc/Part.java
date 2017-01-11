package calc;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Part {

	//値
	private int partID;				//パーツ番号

	private int stageID;				//ステージ番号

	private String Category1;			//カテゴリ1

	private String Category2;			//カテゴリ2

	private String partName;			//パーツ名

	private double partTotalMass;		//パーツ総重量

	private double partDryMass;		//パーツ乾燥重量

	private int partIspA;				//パーツ比推力(大気)

	private int partIspS;				//パーツ比推力(真空)

	private int partQuantity;			//パーツ搭載数

	//コンポーネント
	private JLabel partIDLabel;		//パーツIDラベル

	private JButton deleteButton;		//削除ボタン

	private JLabel Category1Label;		//カテゴリ1ラベル

	private JLabel Category2Label;		//カテゴリ2ラベル

	private JButton partNameButton;	//パーツ名ボタン

	private JLabel partTotalMassLabel;	//パーツ総重量ラベル

	private JLabel partDryMassLabel;	//パーツ乾燥重量ラベル

	private JLabel partIspALabel;		//パーツ比推力(大気)ラベル

	private JLabel partIspSLabel;		//パーツ比推力(真空)ラベル

	private JTextField partQuantityTextField;	//パーツ搭載数フィールド

	/*******************
	 * ID
	 *******************/
	public int getPartID() {
		return partID;
	}
	public int getStageID() {
		return stageID;
	}
	public void setPartID(int stageID, int partID) {
		this.stageID = stageID;
		this.partID = partID;
		if(this.partIDLabel == null) {
			JLabel partIDLabel = new JLabel();
			partIDLabel.setText(Integer.toString(stageID) + "-" + Integer.toString(partID));
			this.partIDLabel = partIDLabel;
		} else {
			this.partIDLabel.setText(Integer.toString(stageID) + "-" + Integer.toString(partID));
		}
	}
	public JLabel getPartIDLabel() {
		return partIDLabel;
	}
	public void setPartIDLabel(int stageID, int partID, JLabel partIDLabel) {
		this.stageID = stageID;
		this.partID = partID;
		this.partIDLabel = partIDLabel;
		this.partIDLabel.setText(Integer.toString(stageID) + "-" + Integer.toString(partID));
	}

	/*******************
	 * DeleteButton
	 *******************/
	public JButton getDeleteButton() {
		return deleteButton;
	}
	public void setDeleteButton(JButton deleteButton) {
		this.deleteButton = deleteButton;
	}
	public void setDeleteButtonStr(String str, JButton deleteButton) {
		this.deleteButton = deleteButton;
		this.deleteButton.setText(str);
	}

	/*******************
	 * Category1
	 *******************/
	public String getCategory1() {
		return Category1;
	}
	public void setCategory1(String category1) {
		Category1 = category1;
		if(this.Category1Label == null) {
			JLabel Category1Label = new JLabel();
			Category1Label.setText(category1);
			this.Category1Label = Category1Label;
		} else {
			this.Category1Label.setText(category1);
		}
	}
	public JLabel getCategory1Label() {
		return Category1Label;
	}
	public void setCategory1Label(String category1, JLabel category1Label) {
		Category1 = category1;
		Category1Label = category1Label;
		this.Category1Label.setText(category1);
	}

	/*******************
	 * Category2
	 *******************/
	public String getCategory2() {
		return Category2;
	}
	public void setCategory2(String category2) {
		Category2 = category2;
		if(this.Category2Label == null) {
			JLabel Category2Label = new JLabel();
			Category2Label.setText(category2);
			this.Category2Label = Category2Label;
		} else {
			this.Category2Label.setText(category2);
		}
	}
	public JLabel getCategory2Label() {
		return Category2Label;
	}
	public void setCategory2Label(String category2, JLabel category2Label) {
		Category2 = category2;
		Category2Label = category2Label;
		this.Category2Label.setText(category2);
	}

	/*******************
	 * PartName
	 *******************/
	public String getPartName() {
		return partName;
	}
	public void setPartName(String partName) {
		this.partName = partName;
		if(this.partNameButton == null) {
			JButton partNameButton = new JButton();
			partNameButton.setText(partName);
			this.partNameButton = partNameButton;
		} else {
			this.partNameButton.setText(partName);
		}
	}
	public JButton getPartNameButton() {
		return partNameButton;
	}
	public void setPartNameButton(String partName, JButton partNameButton) {
		this.partName = partName;
		this.partNameButton = partNameButton;
		this.partNameButton.setText(partName);
	}

	/*******************
	 * TotalMass
	 *******************/
	public double getTotalMass() {
		return partTotalMass;
	}
	public void setTotalMass(double partTotalMass) {
		this.partTotalMass = partTotalMass;
		if(this.partTotalMassLabel == null) {
			JLabel partTotalMassLabel = new JLabel();
			partTotalMassLabel.setText(Double.toString(partTotalMass));
			this.partTotalMassLabel = partTotalMassLabel;
		} else {
			this.partTotalMassLabel.setText(Double.toString(partTotalMass));
		}
	}
	public JLabel getPartTotalMassLabel() {
		return partTotalMassLabel;
	}
	public void setPartTotalMassLabel(double partTotalMass, JLabel partTotalMassLabel) {
		this.partTotalMass = partTotalMass;
		this.partTotalMassLabel = partTotalMassLabel;
		this.partTotalMassLabel.setText(Double.toString(partTotalMass));
	}

	/*******************
	 * DryMass
	 *******************/
	public double getDryMass() {
		return partDryMass;
	}
	public void setDryMass(double dryMass) {
		this.partDryMass = dryMass;
		if(this.partDryMassLabel == null) {
			JLabel partDryMassLabel = new JLabel();
			partDryMassLabel.setText(Double.toString(dryMass));
			this.partDryMassLabel = partDryMassLabel;
		} else {
			this.partDryMassLabel.setText(Double.toString(dryMass));
		}
	}
	public JLabel getPartDryMassLabel() {
		return partDryMassLabel;
	}
	public void setPartDryMassLabel(double dryMass, JLabel partDryMassLabel) {
		this.partDryMass = dryMass;
		this.partDryMassLabel = partDryMassLabel;
		this.partDryMassLabel.setText(Double.toString(dryMass));
	}

	/*******************
	 * IspA
	 *******************/
	public int getIspA() {
		return partIspA;
	}
	public void setIspA(int IspA) {
		this.partIspA = IspA;
		if(this.partIspALabel == null) {
			JLabel partIspALabel = new JLabel();
			partIspALabel.setText(Integer.toString(IspA));
			this.partIspALabel = partIspALabel;
		} else {
			this.partIspALabel.setText(Integer.toString(IspA));
		}
	}
	public JLabel getPartIspALabel() {
		return partIspALabel;
	}
	public void setPartIspALabel(int IspA, JLabel partIspALabel) {
		this.partIspA = IspA;
		this.partIspALabel = partIspALabel;
		this.partIspALabel.setText(Integer.toString(IspA));
	}

	/*******************
	 * IspS
	 *******************/
	public int getIspS() {
		return partIspS;
	}
	public void setIspS(int IspS) {
		this.partIspS = IspS;
		if(this.partIspSLabel == null) {
			JLabel partIspSLabel = new JLabel();
			partIspSLabel.setText(Integer.toString(IspS));
			this.partIspSLabel = partIspSLabel;
		} else {
			this.partIspSLabel.setText(Integer.toString(IspS));
		}
	}
	public JLabel getPartIspSLabel() {
		return partIspSLabel;
	}
	public void setPartIspSLabel(int IspS, JLabel partIspSLabel) {
		this.partIspS = IspS;
		this.partIspSLabel = partIspSLabel;
		this.partIspSLabel.setText(Integer.toString(IspS));
	}

	/*******************
	 * PartQuantity
	 *******************/
	public int getQuantity() {
		return partQuantity;
	}
	public void setQuantity(int quantity) {
		this.partQuantity = quantity;
		if(this.partQuantityTextField == null) {
			JTextField partQuantityTextField = new JTextField();
			partQuantityTextField.setText(Integer.toString(quantity));
			this.partQuantityTextField = partQuantityTextField;
		} else {
			this.partQuantityTextField.setText(Integer.toString(quantity));
		}
	}
	public JTextField getPartQuantityTextField() {
		return partQuantityTextField;
	}
	public void setPartQuantityTextField(int quantity, JTextField partQuantityTextField) {
		this.partQuantity = quantity;
		this.partQuantityTextField = partQuantityTextField;
		this.partQuantityTextField.setText(Integer.toString(quantity));
	}
}
