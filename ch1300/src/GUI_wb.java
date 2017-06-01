import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;


public class GUI_wb extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tfQryEmployeeid;
	private JTextField tfQryFirstname;
	private JTextField tfQryLastname;
	private JPanel panelQryCond;	
	private JTable table;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JCheckBox ckbQryIsCaseInsensitive;
	//------------------------------------------------------//
	private JComboBox<String> cmbobxQryOrderbyField;
	//------------------------------------------------------//
	
	
	//------------------------------------------------------//	
	private String[][] empTable = 
	  new String[][]{		
		{"1","Nancy","Davolio",	"Sales Representative",		"1948-12-08","1992-05-01","507 - 20th Ave. E. Apt. 2A","Seattle"},
		{"2","Andrew","Fuller",	"Vice President, Sales",	"1952-02-19","1992-08-14","908 W. Capital Way","Tacoma"},
		{"3","Janet","Leverling","Sales Representative",	"1963-08-30","1992-04-01","722 Moss Bay Blvd.","Kirkland"},
		{"4","Margaret","Peacock","Sales Representative",	"1937-09-19","1993-05-03","4110 Old Redmond Rd.","Redmond"},
		{"5","Steven","Buchanan","Sales Manager",		 	"1955-03-04","1993-10-17","14 Garrett Hill","London"},
		{"6","Michael","Suyama","Sales Representative",		"1963-07-02","1993-10-17","Coventry House Miner Rd.","London"},
		{"7","Robert","King",	"Sales Representative",		"2015-03-11","1994-01-02","Edgeham Hollow Winchester Way","London"},
		{"8","Laura","Callahan","Inside Sales Coordinator",	"2015-03-19","1994-03-05","4726 - 11th Ave. N.E.","Seattle"},
		{"9","anne","Dodsworth","Sales Representative",		"2015-03-04","1994-11-15","7 Houndstooth Rd.","London"}
	};		
	private String[] jtblColTitles_emp = new String[]{"員工編號","名字","姓氏","職稱","生日","到職日","地址-街道","地址-市鎮"};
	private int[] jtblColWidths_emp = new int[]{100,150,150,220,120,120,300,120};														  
	private int[] jtblColAligns_emp = new int[]{SwingConstants.CENTER,SwingConstants.LEFT,SwingConstants.LEFT,SwingConstants.LEFT,SwingConstants.CENTER,SwingConstants.CENTER,SwingConstants.LEFT,SwingConstants.CENTER};
	private ArrayList<String[]> resultSet = new ArrayList<String[]>();
	//------------------------------------------------------//
	


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI_wb frame = new GUI_wb();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GUI_wb() {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(GUI_wb.class.getResource("/resource/III.png")));
		
		setTitle("\u54E1\u5DE5\u8CC7\u6599\u67E5\u8A62\u8996\u7A97");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1009, 654);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panelTop = new JPanel();
		panelTop.setPreferredSize(new Dimension(10, 170));
		contentPane.add(panelTop, BorderLayout.NORTH);
		panelTop.setLayout(new BorderLayout(0, 0));
		
		JToolBar toolBar = new JToolBar();
		toolBar.setBorder(new EmptyBorder(5, 30, 5, 30));
		panelTop.add(toolBar, BorderLayout.NORTH);
		
		JButton btnQuery = new JButton("\u67E5\u8A62");//查詢
		btnQuery.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				//-----------------------------------------------//
				queryData();				
				//-----------------------------------------------//
			}
		});
		btnQuery.setBorder(new CompoundBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null), new EmptyBorder(5, 5, 5, 10)));
		btnQuery.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		btnQuery.setRolloverIcon(new ImageIcon(GUI_wb.class.getResource("/resource/search16h.png")));
		btnQuery.setIcon(new ImageIcon(GUI_wb.class.getResource("/resource/search16.png")));
		toolBar.add(btnQuery);
		
		JButton btnReset = new JButton("\u6E05\u9664"); //清除
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//-----------------------------------------------//
				Util.resetQueryConditions(panelQryCond);	
				//-----------------------------------------------//				
				/* 關鍵技術A-2
				 * void resetQueryConditions(Container c){
				 * 	for( Component comp: c.getComponents()){
				 * 		if(comp instanceof JTextComponent){
				 * 			((JTextComponent) comp).setText("");
				 * 		}
				 * 	}
				 * }  
				 */
			}
		});
		btnReset.setRolloverIcon(new ImageIcon(GUI_wb.class.getResource("/resource/reset16h.png")));
		btnReset.setIcon(new ImageIcon(GUI_wb.class.getResource("/resource/reset16.png")));
		btnReset.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		btnReset.setBorder(new CompoundBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null), new EmptyBorder(5, 5, 5, 10)));
		toolBar.add(btnReset);
		
		panelQryCond = new JPanel();
		panelQryCond.setBackground(new Color(176, 196, 222));
		panelQryCond.setBorder(new EmptyBorder(10, 50, 10, 50));
		panelTop.add(panelQryCond, BorderLayout.CENTER);
		GridBagLayout gbl_panelQryCond = new GridBagLayout();
		gbl_panelQryCond.columnWidths = new int[] {0, 0, 100, 0, 0, 0};
		gbl_panelQryCond.rowHeights = new int[]{0, 0, 0, 0};
		gbl_panelQryCond.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panelQryCond.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		panelQryCond.setLayout(gbl_panelQryCond);
		
		JLabel lblQryEmpId = new JLabel("\u54E1\u5DE5\u7DE8\u865F");//員工編號
		lblQryEmpId.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		GridBagConstraints gbc_lblQryEmpId = new GridBagConstraints();
		gbc_lblQryEmpId.insets = new Insets(0, 0, 5, 5);
		gbc_lblQryEmpId.anchor = GridBagConstraints.EAST;
		gbc_lblQryEmpId.gridx = 0;
		gbc_lblQryEmpId.gridy = 0;
		panelQryCond.add(lblQryEmpId, gbc_lblQryEmpId);
		
		tfQryEmployeeid = new JTextField();
		tfQryEmployeeid.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		tfQryEmployeeid.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		GridBagConstraints gbc_tfQryEmployeeid = new GridBagConstraints();
		gbc_tfQryEmployeeid.insets = new Insets(0, 0, 5, 5);
		gbc_tfQryEmployeeid.anchor = GridBagConstraints.WEST;
		gbc_tfQryEmployeeid.gridx = 1;
		gbc_tfQryEmployeeid.gridy = 0;
		panelQryCond.add(tfQryEmployeeid, gbc_tfQryEmployeeid);
		tfQryEmployeeid.setColumns(10);
		
		JLabel lblQryFirstname = new JLabel("\u540D  \u5B57");//名 字
		lblQryFirstname.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		GridBagConstraints gbc_lblQryFirstname = new GridBagConstraints();
		gbc_lblQryFirstname.anchor = GridBagConstraints.EAST;
		gbc_lblQryFirstname.insets = new Insets(0, 0, 5, 5);
		gbc_lblQryFirstname.gridx = 0;
		gbc_lblQryFirstname.gridy = 1;
		panelQryCond.add(lblQryFirstname, gbc_lblQryFirstname);
		
		tfQryFirstname = new JTextField();
		tfQryFirstname.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		tfQryFirstname.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		GridBagConstraints gbc_tfQryFirstname = new GridBagConstraints();
		gbc_tfQryFirstname.insets = new Insets(0, 0, 5, 5);
		gbc_tfQryFirstname.anchor = GridBagConstraints.WEST;
		gbc_tfQryFirstname.gridx = 1;
		gbc_tfQryFirstname.gridy = 1;
		panelQryCond.add(tfQryFirstname, gbc_tfQryFirstname);
		tfQryFirstname.setColumns(10);
		
		JLabel lblQryLastname = new JLabel("\u59D3  \u6C0F");//姓 氏
		lblQryLastname.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		GridBagConstraints gbc_lblQryLastname = new GridBagConstraints();
		gbc_lblQryLastname.anchor = GridBagConstraints.EAST;
		gbc_lblQryLastname.insets = new Insets(0, 0, 0, 5);
		gbc_lblQryLastname.gridx = 0;
		gbc_lblQryLastname.gridy = 2;
		panelQryCond.add(lblQryLastname, gbc_lblQryLastname);
		
		tfQryLastname = new JTextField();
		tfQryLastname.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		tfQryLastname.setColumns(10);
		tfQryLastname.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		GridBagConstraints gbc_tfQryLastname = new GridBagConstraints();
		gbc_tfQryLastname.anchor = GridBagConstraints.WEST;
		gbc_tfQryLastname.insets = new Insets(0, 0, 0, 5);
		gbc_tfQryLastname.gridx = 1;
		gbc_tfQryLastname.gridy = 2;
		panelQryCond.add(tfQryLastname, gbc_tfQryLastname);
															//排序欄位
		JLabel lblQryOrderbyField = new JLabel("<html>\u6392\u5E8F\u6B04\u4F4D<span style='color:red'>*</span><html>");
		/* 關鍵技術A-3
		 * JLabel文字夾雜不同樣式(使用CSS樣式表)
		 * new JLabel("<html>排序欄位<span style='color:red'>*</span><html>");  
		 */	
		
		GridBagConstraints gbc_lblQryOrderbyField = new GridBagConstraints();
		gbc_lblQryOrderbyField.anchor = GridBagConstraints.WEST;
		gbc_lblQryOrderbyField.insets = new Insets(0, 0, 5, 5);
		gbc_lblQryOrderbyField.gridx = 3;
		gbc_lblQryOrderbyField.gridy = 0;
		panelQryCond.add(lblQryOrderbyField, gbc_lblQryOrderbyField);
		lblQryOrderbyField.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		
		cmbobxQryOrderbyField = new JComboBox<String>();
		cmbobxQryOrderbyField.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				
				//-----------------------------------------------//
				if(e.getStateChange()==ItemEvent.SELECTED)				
					queryData();
				//-----------------------------------------------//				
				/* 關鍵技術A-4
				 * (1). JComboBox<E>為generic type
				 * (2). JComboBox<E>下拉選單的選項被點選時,將觸發itemStateChanged之 Item事件
				 * (3). JComboBox<E>動態載入選項的方法(請參考下面)
				 */
			}
		});
		cmbobxQryOrderbyField.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		cmbobxQryOrderbyField.setPreferredSize(new Dimension(120, 25));
		GridBagConstraints gbc_cmbobxQryOrderbyField = new GridBagConstraints();
		gbc_cmbobxQryOrderbyField.anchor = GridBagConstraints.WEST;
		gbc_cmbobxQryOrderbyField.insets = new Insets(0, 0, 5, 0);
		gbc_cmbobxQryOrderbyField.gridx = 4;
		gbc_cmbobxQryOrderbyField.gridy = 0;
		panelQryCond.add(cmbobxQryOrderbyField, gbc_cmbobxQryOrderbyField);
		
		//------------------------------------------------------//
		Util.loadSelectionItemsToComboBox(cmbobxQryOrderbyField, jtblColTitles_emp);		
		/* 關鍵技術A-4
		 * (3). JComboBox<E>動態載入選項的方法
		 * 
		 * 		void loadSelectionItemsToComboBox(JComboBox<String> comboBox, String[] items){
		 * 			DefaultComboBoxModel<String> model = new DefaultComboBoxModel<String>();
		 * 			for(int i=0;i<items.length;i++){
		 * 				model.addElement(items[i]);
		 * 			}
		 * 			comboBox.setModel(model);
		 * 		} 
		 */
		
		//------------------------------------------------------//
		
		
		JPanel pnlQryOrderMode = new JPanel();
		pnlQryOrderMode.setBackground(new Color(176, 196, 222));
		GridBagConstraints gbc_pnlQryOrderMode = new GridBagConstraints();
		gbc_pnlQryOrderMode.anchor = GridBagConstraints.WEST;
		gbc_pnlQryOrderMode.fill = GridBagConstraints.VERTICAL;
		gbc_pnlQryOrderMode.gridwidth = 2;
		gbc_pnlQryOrderMode.insets = new Insets(0, 0, 5, 0);
		gbc_pnlQryOrderMode.gridx = 3;
		gbc_pnlQryOrderMode.gridy = 1;
		panelQryCond.add(pnlQryOrderMode, gbc_pnlQryOrderMode);
		GridBagLayout gbl_pnlQryOrderMode = new GridBagLayout();
		gbl_pnlQryOrderMode.columnWidths = new int[]{50, 0, 0};
		gbl_pnlQryOrderMode.rowHeights = new int[]{0, 0};
		gbl_pnlQryOrderMode.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_pnlQryOrderMode.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		pnlQryOrderMode.setLayout(gbl_pnlQryOrderMode);
												  //由小到大
		JRadioButton rdbtnAsc = new JRadioButton("\u7531\u5C0F\u5230\u5927");
		rdbtnAsc.setSelected(true);
		
		rdbtnAsc.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				
				//-----------------------------------------------//
				if(e.getStateChange()==ItemEvent.SELECTED)				
					queryData();
				//-----------------------------------------------//
				/* 關鍵技術A-5
				 * JRadioButton點選時,將觸發itemStateChanged之 Item事件
				 */
			}
		});
		
		//------------------------------------------------------//
		rdbtnAsc.setActionCommand("ASC");
		//------------------------------------------------------//
		buttonGroup.add(rdbtnAsc);
		rdbtnAsc.setBackground(new Color(176, 196, 222));
		rdbtnAsc.setFont(new Font("微軟正黑體", Font.PLAIN, 15));
		GridBagConstraints gbc_rdbtnAsc = new GridBagConstraints();
		gbc_rdbtnAsc.anchor = GridBagConstraints.WEST;
		gbc_rdbtnAsc.insets = new Insets(0, 0, 0, 5);
		gbc_rdbtnAsc.gridx = 0;
		gbc_rdbtnAsc.gridy = 0;
		pnlQryOrderMode.add(rdbtnAsc, gbc_rdbtnAsc);
												   //由大到小
		JRadioButton rdbtnDesc = new JRadioButton("\u7531\u5927\u5230\u5C0F");
		rdbtnDesc.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				
				//-----------------------------------------------//
				if(e.getStateChange()==ItemEvent.SELECTED)
					queryData();				
				//-----------------------------------------------//
				/* 關鍵技術A-5
				 * JRadioButton點選時,將觸發itemStateChanged之 Item事件
				 */
			}
		});
		//------------------------------------------------------//
		rdbtnDesc.setActionCommand("DESC");
		//------------------------------------------------------//
		buttonGroup.add(rdbtnDesc);
		rdbtnDesc.setBackground(new Color(176, 196, 222));
		rdbtnDesc.setFont(new Font("微軟正黑體", Font.PLAIN, 15));
		GridBagConstraints gbc_rdbtnDesc = new GridBagConstraints();
		gbc_rdbtnDesc.anchor = GridBagConstraints.WEST;
		gbc_rdbtnDesc.gridx = 1;
		gbc_rdbtnDesc.gridy = 0;
		pnlQryOrderMode.add(rdbtnDesc, gbc_rdbtnDesc);
		
												//搜尋排序不分大小寫
		ckbQryIsCaseInsensitive = new JCheckBox("\u641C\u5C0B\u6392\u5E8F\u4E0D\u5206\u5927\u5C0F\u5BEB");		
		ckbQryIsCaseInsensitive.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {				

				//-----------------------------------------------//
				queryData();
				//-----------------------------------------------//
			}
		});		
		ckbQryIsCaseInsensitive.setHorizontalTextPosition(SwingConstants.LEADING);
		ckbQryIsCaseInsensitive.setBackground(new Color(176, 196, 222));
		GridBagConstraints gbc_ckbQryIsCaseInsensitive = new GridBagConstraints();
		gbc_ckbQryIsCaseInsensitive.anchor = GridBagConstraints.WEST;
		gbc_ckbQryIsCaseInsensitive.gridwidth = 2;
		gbc_ckbQryIsCaseInsensitive.gridx = 3;
		gbc_ckbQryIsCaseInsensitive.gridy = 2;
		panelQryCond.add(ckbQryIsCaseInsensitive, gbc_ckbQryIsCaseInsensitive);
		ckbQryIsCaseInsensitive.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
				
		
		JPanel panelBottom = new JPanel();
		panelBottom.setPreferredSize(new Dimension(10, 50));
		contentPane.add(panelBottom, BorderLayout.CENTER);
		panelBottom.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		panelBottom.add(scrollPane, BorderLayout.CENTER);
		scrollPane.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		
		table = new JTable();
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null, null},
			},
			new String[] {
				"\u54E1\u5DE5\u7DE8\u865F", "\u540D\u5B57", "\u59D3\u6C0F", "\u8077\u7A31", "\u751F\u65E5", "\u5230\u8077\u65E5", "\u5730\u5740-\u8857\u9053", "\u5730\u5740-\u5E02\u93AE"
			}
		));
		table.setRowHeight(26);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		scrollPane.setViewportView(table);
		
		//-----------------------------------------------//
		//關鍵技術A-6. JTable設定"欄位寬度"與每個欄位內"儲存格文字"之對齊方式
		Util.setJtableColumnsConfig(table, jtblColWidths_emp, jtblColAligns_emp);
		
		table.getTableHeader().setFont(new Font("微軟正黑體", Font.PLAIN, 18));	
		
		this.setLocationRelativeTo(null);		
		//------------------------------------------------------//	
	}	
	
	
	
	//------------------------------------------------------//
	private void queryData(){
				
		HashMap<Integer,String> qryKeywords = new HashMap<>(); //qryKeywords之key對應"查詢關鍵字"相關之"欄位序號"
		qryKeywords.put(0,tfQryEmployeeid.getText());
		qryKeywords.put(1,tfQryFirstname.getText());
		qryKeywords.put(2,tfQryLastname.getText());	
		
		Util.queryData(
			empTable, resultSet, qryKeywords, GUI_wb.this, table, 
			jtblColTitles_emp, jtblColWidths_emp, jtblColAligns_emp, 			
			cmbobxQryOrderbyField.getSelectedIndex(),
			buttonGroup.getSelection().getActionCommand(),
			ckbQryIsCaseInsensitive.isSelected() );		
		/* 關鍵技術A-1 
		 * (1). cmbobxQryOrderbyField.getSelectedIndex()
		 * (2). buttonGroup.getSelection().getActionCommand(): 
		 * 			buttonGroup內之JRadioButton須先設定setActionCommand()
		 * (3). ckbQryIsCaseInsensitive.isSelected() 
		 */

	}
	//------------------------------------------------------//
	

	/*
	public JCheckBox getCkbQryIsCaseInsensitive() {
		return ckbQryIsCaseInsensitive;
	}
	public JComboBox<String> getCbQryOrderbyField() {
		return cmbobxQryOrderbyField;
	}
	*/

	
}
