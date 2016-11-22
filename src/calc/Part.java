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

	private int partNumber;			//パーツ搭載数

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

	private JTextField partNumberTextField;	//パーツ搭載数フィールド

	public int getPartID() {
		return partID;
	}

	public void setPartID(int partID) {
		this.partID = partID;
	}

	public int getStageID() {
		return stageID;
	}

	public void setStageID(int stageID) {
		this.stageID = stageID;
	}

	public String getCategory1() {
		return Category1;
	}

	public void setCategory1(String category1) {
		Category1 = category1;
	}

	public String getCategory2() {
		return Category2;
	}

	public void setCategory2(String category2) {
		Category2 = category2;
	}

	public String getPartName() {
		return partName;
	}

	public void setPartName(String partName) {
		this.partName = partName;
	}

	public double getTotalMass() {
		return partTotalMass;
	}

	public void setTotalMass(double d) {
		this.partTotalMass = d;
	}

	public double getDryMass() {
		return partDryMass;
	}

	public void setDryMass(double dryMass) {
		this.partDryMass = dryMass;
	}

	public int getIspA() {
		return partIspA;
	}

	public void setIspA(int IspA) {
		this.partIspA = IspA;
	}

	public int getIspS() {
		return partIspS;
	}

	public void setIspS(int IspS) {
		this.partIspS = IspS;
	}

	public int getNumber() {
		return partNumber;
	}

	public void setNumber(int number) {
		this.partNumber = number;
	}

	public JLabel getPartIDLabel() {
		return partIDLabel;
	}

	public void setPartIDLabel(JLabel partIDLabel) {
		this.partIDLabel = partIDLabel;
	}

	public JButton getDeleteButton() {
		return deleteButton;
	}

	public void setDeleteButton(JButton deleteButton) {
		this.deleteButton = deleteButton;
	}

	public JLabel getCategory1Label() {
		return Category1Label;
	}

	public void setCategory1Label(JLabel category1Label) {
		Category1Label = category1Label;
	}

	public JLabel getCategory2Label() {
		return Category2Label;
	}

	public void setCategory2Label(JLabel category2Label) {
		Category2Label = category2Label;
	}

	public JButton getPartNameButton() {
		return partNameButton;
	}

	public void setPartNameButton(JButton partNameButton) {
		this.partNameButton = partNameButton;
	}

	public JLabel getPartTotalMassLabel() {
		return partTotalMassLabel;
	}

	public void setPartTotalMassLabel(JLabel partTotalMassLabel) {
		this.partTotalMassLabel = partTotalMassLabel;
	}

	public JLabel getPartDryMassLabel() {
		return partDryMassLabel;
	}

	public void setPartDryMassLabel(JLabel partDryMassLabel) {
		this.partDryMassLabel = partDryMassLabel;
	}

	public JLabel getPartIspALabel() {
		return partIspALabel;
	}

	public void setPartIspALabel(JLabel partIspALabel) {
		this.partIspALabel = partIspALabel;
	}

	public JLabel getPartIspSLabel() {
		return partIspSLabel;
	}

	public void setPartIspSLabel(JLabel partIspSLabel) {
		this.partIspSLabel = partIspSLabel;
	}

	public JTextField getPartNumberTextField() {
		return partNumberTextField;
	}

	public void setPartNumberTextField(JTextField partNumberTextField) {
		this.partNumberTextField = partNumberTextField;
	}
}
