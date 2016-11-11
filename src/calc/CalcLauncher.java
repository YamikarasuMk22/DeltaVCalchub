package calc;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.LineBorder;

public class CalcLauncher extends JFrame {

	/** Part List Data File */
	private static final File PART_LIST_DATA = new File("PartList.xml");
	private static final int PART_LIST_HEIGHT = 40;

	static JFrame mainFrame = new JFrame("DeltaVCalc");
	static JTabbedPane tabbedPane = new JTabbedPane();
	static List<JPanel> stagePanels = new ArrayList<JPanel>();	//タブごとのステージパネル
	static List<JPanel> infoPanels = new ArrayList<JPanel>();	//タブごとの情報パネル

	static List<Part> parts = new ArrayList<Part>();

	public static void main(String[] args) {

		mainFrame.setVisible(true);
		mainFrame.setSize(800, 400);
		mainFrame.setLocationRelativeTo(null);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//パーツデータロード
		loadPartList(PART_LIST_DATA);

		for(int i = 0; i < parts.size(); i++) {
			Part part = parts.get(i);
			System.out.println(part.getPartName());
		}

		//UI描画
		drawUI(mainFrame);
		tabbedPane.updateUI();

	}

	public static void loadPartList(File xmlfile) {
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
						case "SpecificImpulseA":
							part.setSpecificImpulseA(Integer.parseInt(splitstr[1].replaceAll(" ", "")));
						break;
						case "SpecificImpulseS":
							part.setSpecificImpulseS(Integer.parseInt(splitstr[1].replaceAll(" ", "")));
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

	public static void drawUI(JFrame mainFrame) {
		JButton addButton = new JButton("Add Stage");

		for(int i = 1; i <= 5; i++) {
			String tabTitle = "Stage" + i;
			JPanel tabPanel = new JPanel();
			JPanel partsPanel = new JPanel();
			JPanel infoPanel = new JPanel();

			partsPanel.setLayout(new BoxLayout(partsPanel, BoxLayout.Y_AXIS));

			JScrollPane scrollPartsPanel = new JScrollPane(tabPanel);
			scrollPartsPanel.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

			JButton partAddButton = new JButton("Add Part");

			stagePanels.add(tabPanel);
			infoPanels.add(infoPanel);

			for(int j = 1; j <= 10; j++) {
				JPanel partPanel = new JPanel();
				partPanel.setSize(new Dimension(tabPanel.getWidth(), PART_LIST_HEIGHT+6));

				if(j < 10)
					drawPartList(partPanel, i + "-" + j);
				else
					partPanel.add(partAddButton);

				partsPanel.add(partPanel);
			}

			tabPanel.add(partsPanel);

			//tabPanel.add(infoPanel);

			tabbedPane.addTab(tabTitle, scrollPartsPanel);
		}
	    mainFrame.add(tabbedPane, BorderLayout.CENTER);
	    mainFrame.add(addButton, BorderLayout.SOUTH);
	}

	public static void drawPartList(JPanel partPanel, String strPartNo) {
		GridBagLayout layout = new GridBagLayout();
		partPanel.setLayout(layout);
		GridBagConstraints gbc = new GridBagConstraints();

		JLabel partNo = new JLabel(strPartNo);
		partNo.setHorizontalAlignment(JLabel.CENTER);
		partNo.setBorder(new LineBorder(Color.black));
		setWidthPercentage(partNo, 3, PART_LIST_HEIGHT);
		layout.setConstraints(partNo, setValueGridBagConstraints(gbc, 0, 0, 2, -1, -1, "BOTH"));

		JButton partDeleteButton = new JButton("Delete");
		partDeleteButton.setBorder(new LineBorder(Color.black));
		setWidthPercentage(partDeleteButton, 5, PART_LIST_HEIGHT);
		layout.setConstraints(partDeleteButton, setValueGridBagConstraints(gbc, 1, 0, 2, -1, -1, "BOTH"));

		JLabel Category1 = new JLabel("Category1");
		Category1.setBorder(new LineBorder(Color.black));
		setWidthPercentage(Category1, 12, PART_LIST_HEIGHT/2);
		layout.setConstraints(Category1, setValueGridBagConstraints(gbc, 2, 0, 1, -1, -1, "BOTH"));

		JLabel Category2 = new JLabel("Category2");
		Category2.setBorder(new LineBorder(Color.black));
		setWidthPercentage(Category2, 12, PART_LIST_HEIGHT/2);
		layout.setConstraints(Category2, setValueGridBagConstraints(gbc, 2, 1, 1, -1, -1, "BOTH"));

		JButton partSelectButton = new JButton("Select Part");
		partSelectButton.setBorder(new LineBorder(Color.black));
		setWidthPercentage(partSelectButton, 35, PART_LIST_HEIGHT);
		layout.setConstraints(partSelectButton, setValueGridBagConstraints(gbc, 3, 0, 2, -1, -1, "BOTH"));

		JPanel partNumberPanel = new JPanel();
		JTextField partNumber = new JTextField("0", 3);
		partNumber.setHorizontalAlignment(JLabel.RIGHT);
		partNumberPanel.setBorder(new LineBorder(Color.black));
		setWidthPercentage(partNumberPanel, 5, PART_LIST_HEIGHT);
		partNumberPanel.add(partNumber);
		layout.setConstraints(partNumberPanel, setValueGridBagConstraints(gbc, 4, 0, 2, -1, -1, "BOTH"));

		JLabel TotalMassLabel = new JLabel("TotalMass");
		TotalMassLabel.setBorder(new LineBorder(Color.black));
		setWidthPercentage(TotalMassLabel, 8, PART_LIST_HEIGHT/2);
		layout.setConstraints(TotalMassLabel, setValueGridBagConstraints(gbc, 5, 0, 1, -1, -1, "BOTH"));

		JLabel TotalMass = new JLabel("0.00");
		TotalMass.setHorizontalAlignment(JLabel.RIGHT);
		TotalMass.setBorder(new LineBorder(Color.black));
		setWidthPercentage(TotalMass, 8, PART_LIST_HEIGHT/2);
		layout.setConstraints(TotalMass, setValueGridBagConstraints(gbc, 5, 1, 1, -1, -1, "BOTH"));

		JLabel DryMassLabel = new JLabel("DryMass");
		DryMassLabel.setBorder(new LineBorder(Color.black));
		setWidthPercentage(DryMassLabel, 8, PART_LIST_HEIGHT/2);
		layout.setConstraints(DryMassLabel, setValueGridBagConstraints(gbc, 6, 0, 1, -1, -1, "BOTH"));

		JLabel DryMass = new JLabel("0.00");
		DryMass.setHorizontalAlignment(JLabel.RIGHT);
		DryMass.setBorder(new LineBorder(Color.black));
		setWidthPercentage(DryMass, 8, PART_LIST_HEIGHT/2);
		layout.setConstraints(DryMass, setValueGridBagConstraints(gbc, 6, 1, 1, -1, -1, "BOTH"));

		JLabel ispSLabel = new JLabel("Isp(Space)");
		ispSLabel.setBorder(new LineBorder(Color.black));
		setWidthPercentage(ispSLabel, 8, PART_LIST_HEIGHT/2);
		layout.setConstraints(ispSLabel, setValueGridBagConstraints(gbc, 7, 0, 1, -1, -1, "BOTH"));

		JLabel ispS = new JLabel("0");
		ispS.setHorizontalAlignment(JLabel.RIGHT);
		ispS.setBorder(new LineBorder(Color.black));
		setWidthPercentage(ispS, 8, PART_LIST_HEIGHT/2);
		layout.setConstraints(ispS, setValueGridBagConstraints(gbc, 7, 1, 1, -1, -1, "BOTH"));

		JLabel ispALabel = new JLabel("Isp(Air)");
		ispALabel.setBorder(new LineBorder(Color.black));
		setWidthPercentage(ispALabel, 8, PART_LIST_HEIGHT/2);
		layout.setConstraints(ispALabel, setValueGridBagConstraints(gbc, 8, 0, 1, -1, -1, "BOTH"));

		JLabel ispA = new JLabel("0");
		ispA.setHorizontalAlignment(JLabel.RIGHT);
		ispA.setBorder(new LineBorder(Color.black));
		setWidthPercentage(ispA, 8, PART_LIST_HEIGHT/2);
		layout.setConstraints(ispA, setValueGridBagConstraints(gbc, 8, 1, 1, -1, -1, "BOTH"));

		setCursorSwitch(partDeleteButton);
		setCursorSwitch(partSelectButton);

		partPanel.add(partNo);
		partPanel.add(partDeleteButton);
		partPanel.add(Category1);
		partPanel.add(Category2);
		partPanel.add(partSelectButton);
		partPanel.add(partNumberPanel);
		partPanel.add(TotalMassLabel);
		partPanel.add(DryMassLabel);
		partPanel.add(ispALabel);
		partPanel.add(ispSLabel);
		partPanel.add(TotalMass);
		partPanel.add(DryMass);
		partPanel.add(ispA);
		partPanel.add(ispS);
	}

	public static void setCursorSwitch(JButton button) {
		button.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				//マウスカーソルを手の形に変える
				Cursor c = Cursor.getPredefinedCursor(Cursor.HAND_CURSOR);
				Component p = (Component) e.getSource();
				p.setCursor(c);
			}

			public void mouseExited(MouseEvent e) {
				//マウスカーソルをデフォルトに戻す
				Cursor c = Cursor.getDefaultCursor();
				Component p = (Component) e.getSource();
				p.setCursor(c);
			}
		});
	}

	public static void setWidthPercentage(Component component, int widthPercentage, int height) {
		int frameWidth = mainFrame.getWidth();
		int componentWidth = frameWidth * widthPercentage / 100;

		component.setPreferredSize(new Dimension(componentWidth, height));
	}

	public static GridBagConstraints setValueGridBagConstraints(
			GridBagConstraints gbc, int _gridx, int _gridy, int _gridheight, double _weightx, double _weighty, String _fill) {

		gbc.gridx = _gridx;
		gbc.gridy = _gridy;
		gbc.gridheight = _gridheight;
		if(_weightx > 0)
			gbc.weightx = _weightx;
		if(_weighty > 0)
			gbc.weighty = _weighty;

		switch (_fill){
			case "BOTH":
				//コンポーネントを表示領域の最大サイズにします。
				gbc.fill = GridBagConstraints.BOTH;
			break;
			case "HORIZONTAL":
				//コンポーネントの幅を水平表示領域の最大サイズにし、高さは変更しません。
				gbc.fill = GridBagConstraints.HORIZONTAL;
			break;
			case "VERTICAL":
				//コンポーネントの高さを垂直表示領域の最大サイズにし、幅は変更しません。
				gbc.fill = GridBagConstraints.VERTICAL;
			break;
			case "NONE":
				//コンポーネントのサイズを変更しません。
				gbc.fill = GridBagConstraints.NONE;
			break;
		}

		return gbc;
	}
}
