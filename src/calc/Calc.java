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

public class Calc extends JFrame {

	/** Part List Data File **/
	//private static final File PART_LIST_DATA = new File("PartList.xml");

	/** Main UI Frame **/
	static JFrame mainFrame = new JFrame("DeltaVCalc");

	/** Stage Objects ArrayList **/
	static List<Stage> stages = new ArrayList<Stage>();

	/** Stage TabbedPane **/
	static JTabbedPane tabbedPane = new JTabbedPane();

	/** UI Size **/
	private static final int FRAME_WIDTH = 800;
	private static final int FRAME_HEIGHT = 400;
	private static final int PART_LIST_HEIGHT = 40;

	/** Default List Size **/
	private static final int DEFAULT_STAGE_TAB_NUM = 5;

	public static void drawUI() {
		mainFrame.setVisible(false);
		mainFrame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
		mainFrame.setLocationRelativeTo(null);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		drawStageTab();

		mainFrame.setVisible(true);
	}

	public static void drawStageTab() {
		JButton addButton = new JButton("Add Stage");

		for(int i = 1; i <= DEFAULT_STAGE_TAB_NUM; i++) {

			addStage(i, tabbedPane);

		}
		mainFrame.add(tabbedPane, BorderLayout.CENTER);
	    mainFrame.add(addButton, BorderLayout.SOUTH);
	}

	public static void addStage(int stageID, JTabbedPane tabbedPane) {
		Stage stage = new Stage();

		String tabTitle = "Stage" + stageID;
		JPanel tabPanel = new JPanel();
		JPanel partsPanel = new JPanel();		//partPanelをaddするPanel

		partsPanel.setLayout(new BoxLayout(partsPanel, BoxLayout.Y_AXIS));

		JScrollPane scrollPartsPanel = new JScrollPane(tabPanel);
		scrollPartsPanel.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

		JPanel partPanel = new JPanel();
		partPanel.setSize(new Dimension(tabPanel.getWidth(), PART_LIST_HEIGHT + 6));

		//初期値Partを追加
		Part part = new Part();
		part = addPart(stageID, 1, partPanel);
		List<Part> parts = new ArrayList<Part>();
		parts.add(part);
		partsPanel.add(partPanel);

		//PartAddButtonを追加
		JButton partAddButton = new JButton("Add Part");
		JPanel partAddButtonPanel = new JPanel();
		partAddButtonPanel.setSize(new Dimension(tabPanel.getWidth(), PART_LIST_HEIGHT + 6));
		partAddButtonPanel.add(partAddButton);
		setCursorSwitch(partAddButton);
		partAddButton.addActionListener(new AddPartButtonListener());
		partAddButton.setActionCommand(Integer.toString(stageID));		//StageID
		partsPanel.add(partAddButtonPanel);

		//Stageオブジェクト登録
		stage.setStageID(stageID);
		stage.setStageTabPane(tabbedPane);
		stage.setParts(parts);
		stage.setPartAddButton(partAddButton);
		stage.setPartAddButtonPanel(partAddButtonPanel);
		stages.add(stage);

		tabPanel.add(partsPanel);
		tabbedPane.addTab(tabTitle, scrollPartsPanel);
	}

	public static Part addPart(int stageID, int partID, JPanel partPanel) {
		Part part = new Part();

		//2番目移行のパーツの場合、PartAddButtonを一旦消してからaddする
		if(partID >= 2) {

		}

		GridBagLayout layout = new GridBagLayout();
		partPanel.setLayout(layout);
		GridBagConstraints gbc = new GridBagConstraints();

		String patrNoStr = Integer.toString(stageID) + "-" + Integer.toString(partID);

		JLabel partNo = new JLabel();
		partNo.setHorizontalAlignment(JLabel.CENTER);
		partNo.setBorder(new LineBorder(Color.black));
		setWidthPercentage(partNo, 3, PART_LIST_HEIGHT);
		layout.setConstraints(partNo, setValueGridBagConstraints(gbc, 0, 0, 2, -1, -1, "BOTH"));

		JButton partDeleteButton = new JButton("Delete");
		partDeleteButton.setBorder(new LineBorder(Color.black));
		setWidthPercentage(partDeleteButton, 5, PART_LIST_HEIGHT);
		layout.setConstraints(partDeleteButton, setValueGridBagConstraints(gbc, 1, 0, 2, -1, -1, "BOTH"));

		String category1Str = "Category1";
		JLabel category1 = new JLabel();
		category1.setBorder(new LineBorder(Color.black));
		setWidthPercentage(category1, 12, PART_LIST_HEIGHT/2);
		layout.setConstraints(category1, setValueGridBagConstraints(gbc, 2, 0, 1, -1, -1, "BOTH"));

		String category2Str = "Category2";
		JLabel category2 = new JLabel();
		category2.setBorder(new LineBorder(Color.black));
		setWidthPercentage(category2, 12, PART_LIST_HEIGHT/2);
		layout.setConstraints(category2, setValueGridBagConstraints(gbc, 2, 1, 1, -1, -1, "BOTH"));

		String partSelectButtonStr = "Select Part";
		JButton partSelectButton = new JButton();
		partSelectButton.setBorder(new LineBorder(Color.black));
		setWidthPercentage(partSelectButton, 35, PART_LIST_HEIGHT);
		layout.setConstraints(partSelectButton, setValueGridBagConstraints(gbc, 3, 0, 2, -1, -1, "BOTH"));

		int partQuantityInt = 0;
		JPanel partQuantityPanel = new JPanel();
		JTextField partQuantity = new JTextField();
		partQuantity.setPreferredSize(new Dimension(30, 25));
		partQuantity.setHorizontalAlignment(JLabel.RIGHT);
		partQuantityPanel.setBorder(new LineBorder(Color.black));
		setWidthPercentage(partQuantityPanel, 5, PART_LIST_HEIGHT);
		partQuantityPanel.add(partQuantity);
		layout.setConstraints(partQuantityPanel, setValueGridBagConstraints(gbc, 4, 0, 2, -1, -1, "BOTH"));

		JLabel totalMassLabel = new JLabel("TotalMass");
		totalMassLabel.setBorder(new LineBorder(Color.black));
		setWidthPercentage(totalMassLabel, 8, PART_LIST_HEIGHT/2);
		layout.setConstraints(totalMassLabel, setValueGridBagConstraints(gbc, 5, 0, 1, -1, -1, "BOTH"));

		double totalMassDbl = 0.00;
		JLabel totalMass = new JLabel();
		totalMass.setHorizontalAlignment(JLabel.RIGHT);
		totalMass.setBorder(new LineBorder(Color.black));
		setWidthPercentage(totalMass, 8, PART_LIST_HEIGHT/2);
		layout.setConstraints(totalMass, setValueGridBagConstraints(gbc, 5, 1, 1, -1, -1, "BOTH"));

		JLabel dryMassLabel = new JLabel("DryMass");
		dryMassLabel.setBorder(new LineBorder(Color.black));
		setWidthPercentage(dryMassLabel, 8, PART_LIST_HEIGHT/2);
		layout.setConstraints(dryMassLabel, setValueGridBagConstraints(gbc, 6, 0, 1, -1, -1, "BOTH"));

		double dryMassDbl = 0.00;
		JLabel dryMass = new JLabel();
		dryMass.setHorizontalAlignment(JLabel.RIGHT);
		dryMass.setBorder(new LineBorder(Color.black));
		setWidthPercentage(dryMass, 8, PART_LIST_HEIGHT/2);
		layout.setConstraints(dryMass, setValueGridBagConstraints(gbc, 6, 1, 1, -1, -1, "BOTH"));

		JLabel ispSLabel = new JLabel("Isp(Space)");
		ispSLabel.setBorder(new LineBorder(Color.black));
		setWidthPercentage(ispSLabel, 8, PART_LIST_HEIGHT/2);
		layout.setConstraints(ispSLabel, setValueGridBagConstraints(gbc, 7, 0, 1, -1, -1, "BOTH"));

		int ispSInt = 0;
		JLabel ispS = new JLabel();
		ispS.setHorizontalAlignment(JLabel.RIGHT);
		ispS.setBorder(new LineBorder(Color.black));
		setWidthPercentage(ispS, 8, PART_LIST_HEIGHT/2);
		layout.setConstraints(ispS, setValueGridBagConstraints(gbc, 7, 1, 1, -1, -1, "BOTH"));

		JLabel ispALabel = new JLabel("Isp(Air)");
		ispALabel.setBorder(new LineBorder(Color.black));
		setWidthPercentage(ispALabel, 8, PART_LIST_HEIGHT/2);
		layout.setConstraints(ispALabel, setValueGridBagConstraints(gbc, 8, 0, 1, -1, -1, "BOTH"));

		int ispAInt = 0;
		JLabel ispA = new JLabel();
		ispA.setHorizontalAlignment(JLabel.RIGHT);
		ispA.setBorder(new LineBorder(Color.black));
		setWidthPercentage(ispA, 8, PART_LIST_HEIGHT/2);
		layout.setConstraints(ispA, setValueGridBagConstraints(gbc, 8, 1, 1, -1, -1, "BOTH"));

		setCursorSwitch(partSelectButton);
		partSelectButton.addActionListener(new SelectPartButtonListener());
		partSelectButton.setActionCommand(patrNoStr);	//(StageID)-(PartID)

		setCursorSwitch(partDeleteButton);
		partDeleteButton.addActionListener(new DeletePartButtonListener());
		partDeleteButton.setActionCommand(patrNoStr);	//(StageID)-(PartID)

		//I/O用UIをPartオブジェクトに格納
		part.setPartIDLabel(stageID, partID ,partNo);
		part.setDeleteButton(partDeleteButton);
		part.setCategory1Label(category1Str, category1);
		part.setCategory2Label(category2Str, category2);
		part.setPartNameButton(partSelectButtonStr, partSelectButton);
		part.setPartQuantityTextField(partQuantityInt, partQuantity);
		part.setPartTotalMassLabel(totalMassDbl, totalMass);
		part.setPartDryMassLabel(dryMassDbl, dryMass);
		part.setPartIspALabel(ispSInt, ispA);
		part.setPartIspSLabel(ispAInt, ispS);

		//各UI部品をpartPanelに集約
		partPanel.add(partNo);
		partPanel.add(partDeleteButton);
		partPanel.add(category1);
		partPanel.add(category2);
		partPanel.add(partSelectButton);
		partPanel.add(partQuantityPanel);
		partPanel.add(totalMassLabel);
		partPanel.add(dryMassLabel);
		partPanel.add(ispALabel);
		partPanel.add(ispSLabel);
		partPanel.add(totalMass);
		partPanel.add(dryMass);
		partPanel.add(ispA);
		partPanel.add(ispS);

		return part;
	}

	public static Part drawPartListByArrayList(Part part, JPanel partPanel, String strPartNo) {

		return part;
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
