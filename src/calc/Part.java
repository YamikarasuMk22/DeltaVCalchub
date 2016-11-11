package calc;

public class Part {

	private String partID;				//パーツID

	private String Category1;			//カテゴリ1

	private String Category2;			//カテゴリ2

	private String partName;			//パーツ名

	private double partTotalMass;		//パーツ総重量

	private double partDryMass;		//パーツ乾燥重量

	private int partSpecificImpulseA;	//パーツ比推力(大気)

	private int partSpecificImpulseS;	//パーツ比推力(真空)

	private int partNumber;			//パーツ搭載数

	public String getPartID() {
		return partID;
	}

	public void setPartID(String partID) {
		this.partID = partID;
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

	public int getSpecificImpulseA() {
		return partSpecificImpulseA;
	}

	public void setSpecificImpulseA(int specificImpulseA) {
		this.partSpecificImpulseA = specificImpulseA;
	}

	public int getSpecificImpulseS() {
		return partSpecificImpulseS;
	}

	public void setSpecificImpulseS(int specificImpulseS) {
		this.partSpecificImpulseS = specificImpulseS;
	}

	public int getNumber() {
		return partNumber;
	}

	public void setNumber(int number) {
		this.partNumber = number;
	}
}
