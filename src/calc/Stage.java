package calc;

import java.util.List;

import javax.swing.JPanel;

public class Stage {

	private int stageID;				//ステージ番号

	private JPanel stageUIPanel;		//ステージ表示パネル

	private List<Part> stageParts;		//パーツリスト

	private double stageTotalMass;	//ステージ総重量

	private double stageDryMass;		//ステージ総乾燥重量

	private int stageIspA;				//ステージ総比推力(大気)

	private int stageIspS;				//ステージ総比推力(真空)

	public int getStageID() {
		return stageID;
	}

	public void setStageID(int stageID) {
		this.stageID = stageID;
	}

	public JPanel getStageUIPanel() {
		return stageUIPanel;
	}

	public void setStageUIPanel(JPanel stageUIPanel) {
		this.stageUIPanel = stageUIPanel;
	}

	public List<Part> getStageParts() {
		return stageParts;
	}

	public void setStageParts(List<Part> stageParts) {
		this.stageParts = stageParts;
	}

	public double getStageTotalMass() {
		return stageTotalMass;
	}

	public void setStageTotalMass(double stageTotalMass) {
		this.stageTotalMass = stageTotalMass;
	}

	public double getStageDryMass() {
		return stageDryMass;
	}

	public void setStageDryMass(double stageDryMass) {
		this.stageDryMass = stageDryMass;
	}

	public int getStageIspA() {
		return stageIspA;
	}

	public void setStageIspA(int stageIspA) {
		this.stageIspA = stageIspA;
	}

	public int getStageIspS() {
		return stageIspS;
	}

	public void setStageIspS(int stageIspS) {
		this.stageIspS = stageIspS;
	}
}
