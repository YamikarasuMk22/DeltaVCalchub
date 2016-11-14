package calc;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;

public class CalcUtil {
	public static void loadPartList(File xmlfile, List<Part> parts) {
		//パーツオブジェクト
		Part part = null;
		//Partタグ内フラグ
		boolean tagflag = false;
		BufferedReader br;

		try {
			br = new BufferedReader(new FileReader(xmlfile));

			while (br.ready()) {
				String readed = br.readLine();

				//Partタグ内判定
				if (tagflag == true && readed.matches(".*/>.*") && readed.length() != 0) {
					tagflag = false;
					//パーツオブジェクトをリストに格納
					parts.add(part);
				}

				//要素読み込み
				if (tagflag == true) {
					readed = readed.replaceAll("\t", "");	//タブ削除
					readed = readed.replaceAll("\"", "");	//ダブルクオーテーション削除

					//値の右辺と左辺を分ける
					String[] splitstr = readed.split("=", 0);

					//パーツオブジェクトに代入
					switch (splitstr[0]){
						case "ID":
							part.setPartID(splitstr[1].replaceAll(" ", ""));
						break;
						case "Category1":
							part.setCategory1(splitstr[1].replaceAll(" ", ""));
						break;
						case "Category2":
							part.setCategory2(splitstr[1].replaceAll(" ", ""));
						break;
						case "Name":
							part.setPartName(splitstr[1]);
						break;
						case "TotalMass":
							part.setTotalMass(Double.parseDouble(splitstr[1].replaceAll(" ", "")));
						break;
						case "DryMass":
							part.setDryMass(Double.parseDouble(splitstr[1].replaceAll(" ", "")));
						break;
						case "IspA":
							part.setIspA(Integer.parseInt(splitstr[1].replaceAll(" ", "")));
						break;
						case "IspS":
							part.setIspS(Integer.parseInt(splitstr[1].replaceAll(" ", "")));
						break;
					}
				}

				//Partタグ内判定
				if (tagflag == false && readed.matches(".*<Part.*") && readed.length() != 0) {
					tagflag = true;
					//新しいパーツオブジェクト作成
					part = new Part();
				}
			}

			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static JTree loadTreeList(JTree partTree, List<Part> parts) {
		DefaultMutableTreeNode partListRoot = new DefaultMutableTreeNode("Parts");
		DefaultMutableTreeNode nodeCategory1 = null;
		DefaultMutableTreeNode nodeCategory2 = null;
		DefaultMutableTreeNode nodepart = null;

		String tmpstr1 = "";
		String tmpstr2 = "";
		String category1str = "";
		String category2str = "";
		String partName = "";

		for(int i = 0; i < parts.size(); i++) {
			Part part = parts.get(i);
			tmpstr1 = part.getCategory1();
			tmpstr2 = part.getCategory2();

			if(!category1str.equals(tmpstr1)) {
				category1str = tmpstr1;
				nodeCategory1 = new DefaultMutableTreeNode(category1str);
				partListRoot.add(nodeCategory1);
			}
			if(!category2str.equals(tmpstr2)) {
				category2str = tmpstr2;
				nodeCategory2 = new DefaultMutableTreeNode(category2str);
				nodeCategory1.add(nodeCategory2);
			}

			partName = part.getPartName();
			nodepart = new DefaultMutableTreeNode(partName);
			nodeCategory2.add(nodepart);
		}

		partTree = new JTree(partListRoot);

		return partTree;
	}
}
