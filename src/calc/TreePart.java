package calc;

public class TreePart {
	private String Category1;			//カテゴリ1

	private String Category2;			//カテゴリ2

	private String partName;			//パーツ名

	private double partTotalMass;		//パーツ総重量

	private double partDryMass;		//パーツ乾燥重量

	private int partIspA;				//パーツ比推力(大気)

	private int partIspS;				//パーツ比推力(真空)

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

	public double getPartTotalMass() {
		return partTotalMass;
	}

	public void setPartTotalMass(double partTotalMass) {
		this.partTotalMass = partTotalMass;
	}

	public double getPartDryMass() {
		return partDryMass;
	}

	public void setPartDryMass(double partDryMass) {
		this.partDryMass = partDryMass;
	}

	public int getPartIspA() {
		return partIspA;
	}

	public void setPartIspA(int partIspA) {
		this.partIspA = partIspA;
	}

	public int getPartIspS() {
		return partIspS;
	}

	public void setPartIspS(int partIspS) {
		this.partIspS = partIspS;
	}
}
