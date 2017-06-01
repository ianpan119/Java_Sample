import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.BevelBorder;
import java.awt.Color;
import javax.swing.JCheckBox;


public class JDBC2_wb extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JButton btnQryEmpData;
	private JTextField tfFirstName;
	
	private Connection conn;
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;	
	private CallableStatement cstmt;
	private DefaultTableModel dtm;
	private JLabel lblEmpId;
	private JTextField tfEmpId;
	private JButton btnStoredProc;
	private JLabel lblOrderId;
	private JTextField tfOrderId;
	private JLabel lblTotalAmt;
	private JTextField tfTotalAmt;
	private JTextField tfReturnCode;
	private JButton btnTransaction;
	private JLabel lblReturnCode;	
	private JCheckBox ckbxTestSQLInjection;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JDBC2_wb frame = new JDBC2_wb();
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
	public JDBC2_wb() {
		setTitle("JDBC\u9032\u968E");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1028, 578);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panelTop = new JPanel();
		panelTop.setBackground(new Color(176, 196, 222));
		panelTop.setBorder(new EmptyBorder(15, 30, 15, 30));
		panelTop.setPreferredSize(new Dimension(10, 160));
		contentPane.add(panelTop, BorderLayout.NORTH);
		
		GridBagLayout gbl_panelTop = new GridBagLayout();
		gbl_panelTop.columnWidths = new int[]{0, 0, 0, 150, 0, 0, 0, 0, 0};
		gbl_panelTop.rowHeights = new int[]{0, 0, 0, 0, 0};
		gbl_panelTop.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panelTop.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
				
		panelTop.setLayout(gbl_panelTop);		
		
		lblEmpId = new JLabel("\u54E1\u5DE5\u7DE8\u865F");//���u�s��
		lblEmpId.setFont(new Font("�L�n������", Font.PLAIN, 16));		
		GridBagConstraints gbc_lblEmpId = new GridBagConstraints();
		gbc_lblEmpId.anchor = GridBagConstraints.EAST;
		gbc_lblEmpId.insets = new Insets(0, 0, 5, 5);
		gbc_lblEmpId.gridx = 0;
		gbc_lblEmpId.gridy = 0;
		panelTop.add(lblEmpId, gbc_lblEmpId);
		
		tfEmpId = new JTextField();
		tfEmpId.setFont(new Font("�L�n������", Font.PLAIN, 16));		
		GridBagConstraints gbc_tfEmpId = new GridBagConstraints();
		gbc_tfEmpId.anchor = GridBagConstraints.WEST;
		gbc_tfEmpId.insets = new Insets(0, 0, 5, 5);
		gbc_tfEmpId.gridx = 1;
		gbc_tfEmpId.gridy = 0;
		panelTop.add(tfEmpId, gbc_tfEmpId);
		tfEmpId.setColumns(10);
		
		btnQryEmpData = new JButton("\u54E1\u5DE5\u8CC7\u6599\u67E5\u8A62");
		btnQryEmpData.setPreferredSize(new Dimension(120, 27));
		btnQryEmpData.setFont(new Font("�L�n������", Font.PLAIN, 16));
		
		btnQryEmpData.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				queryData();							
			}			
		});
		
		
		GridBagConstraints gbc_btnQryEmpData = new GridBagConstraints();
		gbc_btnQryEmpData.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnQryEmpData.insets = new Insets(0, 0, 5, 5);
		gbc_btnQryEmpData.gridx = 2;
		gbc_btnQryEmpData.gridy = 0;
		panelTop.add(btnQryEmpData, gbc_btnQryEmpData);
		
		lblOrderId = new JLabel("\u8A02\u55AE\u7DE8\u865F");
		lblOrderId.setFont(new Font("�L�n������", Font.PLAIN, 16));
		GridBagConstraints gbc_lblOrderId = new GridBagConstraints();
		gbc_lblOrderId.anchor = GridBagConstraints.EAST;
		gbc_lblOrderId.insets = new Insets(0, 0, 5, 5);
		gbc_lblOrderId.gridx = 4;
		gbc_lblOrderId.gridy = 0;
		panelTop.add(lblOrderId, gbc_lblOrderId);
		
		tfOrderId = new JTextField();
		tfOrderId.setFont(new Font("�L�n������", Font.PLAIN, 16));
		tfOrderId.setText("11077");
		GridBagConstraints gbc_tfOrderId = new GridBagConstraints();
		gbc_tfOrderId.anchor = GridBagConstraints.WEST;
		gbc_tfOrderId.insets = new Insets(0, 0, 5, 5);
		gbc_tfOrderId.gridx = 5;
		gbc_tfOrderId.gridy = 0;
		panelTop.add(tfOrderId, gbc_tfOrderId);
		tfOrderId.setColumns(5);
				
		JLabel lblFirstName = new JLabel("\u540D  \u5B57");
		lblFirstName.setFont(new Font("�L�n������", Font.PLAIN, 16));
		GridBagConstraints gbc_lblFirstName = new GridBagConstraints();
		gbc_lblFirstName.anchor = GridBagConstraints.EAST;
		gbc_lblFirstName.insets = new Insets(0, 0, 5, 5);
		gbc_lblFirstName.gridx = 0;
		gbc_lblFirstName.gridy = 1;
		panelTop.add(lblFirstName, gbc_lblFirstName);
		
		tfFirstName = new JTextField();
		tfFirstName.setFont(new Font("�L�n������", Font.PLAIN, 16));
		GridBagConstraints gbc_tfFirstName = new GridBagConstraints();
		gbc_tfFirstName.anchor = GridBagConstraints.WEST;
		gbc_tfFirstName.insets = new Insets(0, 0, 5, 5);
		gbc_tfFirstName.gridx = 1;
		gbc_tfFirstName.gridy = 1;
		panelTop.add(tfFirstName, gbc_tfFirstName);
		tfFirstName.setColumns(10);
		
		ckbxTestSQLInjection = new JCheckBox("\u6E2C\u8A66SQL\u690D\u5165\u5F0F\u653B\u64CA");
		ckbxTestSQLInjection.setBackground(new Color(176, 196, 222));
		ckbxTestSQLInjection.setFont(new Font("�L�n������", Font.PLAIN, 15));
		GridBagConstraints gbc_ckbxTestSQLInjection = new GridBagConstraints();
		gbc_ckbxTestSQLInjection.insets = new Insets(0, 0, 5, 5);
		gbc_ckbxTestSQLInjection.gridx = 2;
		gbc_ckbxTestSQLInjection.gridy = 1;
		panelTop.add(ckbxTestSQLInjection, gbc_ckbxTestSQLInjection);
		
		lblTotalAmt = new JLabel("\u7E3D\u91D1\u984D");
		lblTotalAmt.setFont(new Font("�L�n������", Font.PLAIN, 16));
		GridBagConstraints gbc_lblTotalAmt = new GridBagConstraints();
		gbc_lblTotalAmt.insets = new Insets(0, 0, 5, 5);
		gbc_lblTotalAmt.anchor = GridBagConstraints.EAST;
		gbc_lblTotalAmt.gridx = 4;
		gbc_lblTotalAmt.gridy = 1;
		panelTop.add(lblTotalAmt, gbc_lblTotalAmt);
		
		tfTotalAmt = new JTextField();
		tfTotalAmt.setEditable(false);
		tfTotalAmt.setFont(new Font("�L�n������", Font.PLAIN, 16));
		tfTotalAmt.setColumns(5);
		GridBagConstraints gbc_tfTotalAmt = new GridBagConstraints();
		gbc_tfTotalAmt.anchor = GridBagConstraints.WEST;
		gbc_tfTotalAmt.insets = new Insets(0, 0, 5, 5);
		gbc_tfTotalAmt.gridx = 5;
		gbc_tfTotalAmt.gridy = 1;
		panelTop.add(tfTotalAmt, gbc_tfTotalAmt);
		
		lblReturnCode = new JLabel("\u56DE\u50B3\u78BC");
		lblReturnCode.setFont(new Font("�L�n������", Font.PLAIN, 16));
		GridBagConstraints gbc_lblReturnCode = new GridBagConstraints();
		gbc_lblReturnCode.insets = new Insets(0, 0, 5, 5);
		gbc_lblReturnCode.anchor = GridBagConstraints.EAST;
		gbc_lblReturnCode.gridx = 6;
		gbc_lblReturnCode.gridy = 1;
		panelTop.add(lblReturnCode, gbc_lblReturnCode);
		
		tfReturnCode = new JTextField();
		tfReturnCode.setFont(new Font("�L�n������", Font.PLAIN, 16));
		tfReturnCode.setEditable(false);
		GridBagConstraints gbc_tfReturnCode = new GridBagConstraints();
		gbc_tfReturnCode.anchor = GridBagConstraints.WEST;
		gbc_tfReturnCode.insets = new Insets(0, 0, 5, 0);
		gbc_tfReturnCode.gridx = 7;
		gbc_tfReturnCode.gridy = 1;
		panelTop.add(tfReturnCode, gbc_tfReturnCode);
		tfReturnCode.setColumns(3);
		
		btnStoredProc = new JButton("\u547C\u53EB\u9810\u5B58\u7A0B\u5E8F");//�I�s�w�s�{��
		btnStoredProc.setPreferredSize(new Dimension(140, 27));
		btnStoredProc.addActionListener(new ActionListener() {
			
			//�I�s�w�s�{��--------------------------------------//
			public void actionPerformed(ActionEvent arg0) {
				/* SQL Server �w�s�{�ǽd��
				CREATE PROCEDURE sp_OrdTotAmt
					@OrdID int,	@TotAmt Numeric(10,2) OUTPUT
				AS
				   SELECT @TotAmt = Sum(UnitPrice*Quantity)
				   FROM [Order Details]
				   WHERE OrderID = @OrdID
				  IF  @TotAmt IS NULL --�Y���w���q�椣�s�b��,@TotAmt��NULL (@@ROWCOUNT=1)
				      RETURN  0
				  ELSE
				      RETURN  1 
				GO
				*/
				try{
					String sql = " {  ? = call sp_OrdTotAmt(?,?)   }";
					cstmt = conn.prepareCall(sql);
				    cstmt.registerOutParameter(1, Types.INTEGER);
				    cstmt.setInt(2, Integer.parseInt( tfOrderId.getText()) );
				    cstmt.registerOutParameter(3, Types.DECIMAL);
				    cstmt.execute(); //SQL�S���Ǧ^ResultSet��,���i�ϥ�cstmt.executeQuery();
				    tfTotalAmt.setText(  (cstmt.getBigDecimal(3)==null)? "NULL" : String.format( "%.2f", cstmt.getBigDecimal(3) ) ); 
				    //cstmt.getBigDecimal()�N�Ǧ^null��(�p�G��Ʈw�^�ǭȬOSQL NULL)	
				    tfReturnCode.setText( String.valueOf( cstmt.getInt(1) ) );
				}catch(SQLException e){
					e.printStackTrace();
				}
			}
			//----------------------------------------------//			
		});
		
		btnStoredProc.setFont(new Font("�L�n������", Font.PLAIN, 16));
		GridBagConstraints gbc_btnStoredProc = new GridBagConstraints();
		gbc_btnStoredProc.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnStoredProc.gridwidth = 2;
		gbc_btnStoredProc.insets = new Insets(0, 0, 5, 5);
		gbc_btnStoredProc.gridx = 4;
		gbc_btnStoredProc.gridy = 2;
		panelTop.add(btnStoredProc, gbc_btnStoredProc);
		
		btnTransaction = new JButton("\u9AD4\u9A57\u4EA4\u6613\u4F5C\u696D");//�������@�~
		btnTransaction.setPreferredSize(new Dimension(130, 27));
		btnTransaction.addActionListener(new ActionListener() {
			
			//�Ұʥ�� �P �妸����SQL--------------------------------------//
			public void actionPerformed(ActionEvent arg0) {
								
				if(conn == null)
					return;	
				
				String sql1=null, sql2=null;
				
				try{
					Statement stmt = conn.createStatement();
					
					conn.setAutoCommit(false); //�Ұʥ��					
					
					sql1 = "INSERT INTO ORDERS(CUSTOMERID,ORDERDATE) VALUES('XXXXX','2014/1/1')";
					sql2 = "INSERT INTO EMPLOYEES(FIRSTNAME,LASTNAME) VALUES('Kitty','Hello')";
					//�W�CSQL�N����: INSERT ���z���P FOREIGN KEY ������� "FK_Orders_Customers" �Ĭ�C�Ĭ�o�ͦb��Ʈw "Northwind"�A��ƪ� "dbo.Customers", column 'CustomerID'�C
					
					//(1)�榸����SQL
					stmt.executeUpdate(sql1);
					stmt.executeUpdate(sql2);
					
					//(2)�妸����SQL
//					stmt.addBatch(sql1);
//					stmt.addBatch(sql2);
//					stmt.executeBatch(); 
					
					//�Y���ϥ�PreparedStatement�Ӱ���妸�B�z,�ϥΤ覡�p�U:
					//1. pstmt.setString(1,"xxx"); .....
					//2. pstmt.addBatch();
					//3. �C�DSQL���O����1~2�B�J,�̫�A����pstmt.executeBatch();
					
					conn.commit();//�Hcommit�������
					JOptionPane.showMessageDialog(JDBC2_wb.this,sql1+"\n"+sql2+"\nDatabase commit...");
					
				} catch (SQLException e) {
					
					try {
						if (conn != null) {
							conn.rollback();//�Hrollback�������
							JOptionPane.showMessageDialog(JDBC2_wb.this, sql1+"\n"+sql2+"\nDatabase rollback...\n��Ʈw���~�T��: "+e.getMessage());
						}
					} catch (SQLException ex) {
						ex.printStackTrace();						
					}
				}
				
			}			
			//------------------------------------------------------//
			
		});
		
		btnTransaction.setFont(new Font("�L�n������", Font.PLAIN, 16));
		GridBagConstraints gbc_btnTransaction = new GridBagConstraints();
		gbc_btnTransaction.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnTransaction.gridwidth = 2;
		gbc_btnTransaction.insets = new Insets(0, 0, 0, 5);
		gbc_btnTransaction.gridx = 4;
		gbc_btnTransaction.gridy = 3;
		panelTop.add(btnTransaction, gbc_btnTransaction);
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable();
		table.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		table.setFont(new Font("�L�n������", Font.PLAIN, 16));
		table.setRowHeight(26);		
		//�]�wJTable���Y��column�e�׳Q�վ��,��Lcolumns���n��۽վ�
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		
		scrollPane.setViewportView(table);
		
		
		//-------------------------------------------------------//
		this.setLocationRelativeTo(null);
		table.getTableHeader().setFont(new Font("�L�n������", Font.PLAIN, 16));		
		//-------------------------------------------------------//
		
	}
	
	//�����l�϶�
	{
		if(!connectToDB()){
			JOptionPane.showMessageDialog(JDBC2_wb.this, "��Ʈw�s�u����,�t�ΧY�N����...");
			System.exit(0);
		}		  
	}
	private boolean connectToDB(){
		try{
			String url = "jdbc:sqlserver://localhost:1433;databaseName=northwind;";
			conn = DriverManager.getConnection(url,"sa","as");	
			return true;
		}catch(SQLException e){
			JOptionPane.showMessageDialog(JDBC2_wb.this, "SQL exception: " + e.getMessage());
			return false;
		}
	}	
	private void queryData(){
		if(fetchDBData())  					
			loadDataToTable();	
	}
	private boolean fetchDBData(){
		if(conn==null)
			return false;
		try{			
			
			if(ckbxTestSQLInjection.isSelected()){
				if(stmt==null)
					stmt = conn.createStatement();
				
				String sql =
					"SELECT EMPLOYEEID ���u�s��,FIRSTNAME �W�r,LASTNAME �m��,TITLE ¾��,BIRTHDATE �ͤ� " +
					"FROM EMPLOYEES " +
					"WHERE EMPLOYEEID = '" + tfEmpId.getText() + 
					"' AND FIRSTNAME = '" + tfFirstName.getText() + "' ORDER BY 1"; 			
				    //WHERE EMPLOYEEID='100' AND FIRSTNAME='xxx' OR '1'='1' -->SQL Injection(SQL�ӤJ������) 
				rs = stmt.executeQuery(sql);//�i����æ�SQL Injection�ü{			
			}
			else{				
				if(pstmt==null){
					String sql = 
						"SELECT EMPLOYEEID ���u�s��,FIRSTNAME �W�r,LASTNAME �m��,TITLE ¾��,BIRTHDATE �ͤ� " + 
						"FROM EMPLOYEES " +						
						"WHERE EMPLOYEEID LIKE ? AND FIRSTNAME LIKE ? ORDER BY 1";
					pstmt = conn.prepareStatement(sql);
				}
				pstmt.setString(1, "%"+tfEmpId.getText()+"%");
				pstmt.setString(2, "%"+tfFirstName.getText()+"%");		
				
				rs = pstmt.executeQuery();		
			}
			
			return true;
			
		}catch(SQLException e){
			JOptionPane.showMessageDialog(JDBC2_wb.this, "SQL exception: " + e.getMessage());
			return false;
		}
		catch(NumberFormatException e){
			JOptionPane.showMessageDialog(JDBC2_wb.this, "�z��J�D�k���,�Э��s��J...");	
			tfEmpId.requestFocus();
			return false;
		}
	}
	private void loadDataToTable(){
		try{
			if(rs==null) return;
			
			dtm = new DefaultTableModel();//1.�ǳ�TableModel����
			
			//2.�N�q��Ʈw�d�ߩұo����ƶפJTableModel
			ResultSetMetaData rsmd = rs.getMetaData();
			for(int i=1;i<=rsmd.getColumnCount();i++){
				dtm.addColumn(rsmd.getColumnName(i));				
			}
			while(rs.next()){
				String[] row = new String[rsmd.getColumnCount()];
				for(int i=1;i<=rsmd.getColumnCount();i++){
					switch(rsmd.getColumnType(i)){
					case Types.NVARCHAR:
						row[i-1] = rs.getString(i);
						break;
					case Types.INTEGER:
						row[i-1] = String.valueOf(rs.getInt(i));
						break;
					case Types.TIMESTAMP://�۷��SQL��DateTime
						row[i-1] = String.format("%tY/%<tm/%<td",rs.getDate(i)); //rs.getTimestamp(i)->�t�~,��,��,��,��,��
						break;					
					}
				}					
				dtm.addRow(row);				
			}	
			
			//3.��JTable�PTableModel�إ����Y
			table.setModel(dtm);
			
			//4.�]�wJTable�C�Ӹ�Ʀ檺�̤p�e��(�D���n)
			for(int i=0;i<table.getColumnCount();i++){
				table.getColumnModel().getColumn(i).setMinWidth(180);
			}
			
		}catch(SQLException e){
			JOptionPane.showMessageDialog(JDBC2_wb.this, e.getMessage());
		}		
	}
	//JDBC�D�D���� ---------------------------------------//
}
