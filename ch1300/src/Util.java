
import java.awt.Component;
import java.awt.Container;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.JTextComponent;

/* ����޳NB JavaAPI 
 * (1) �ϥ�Regular Expression����SQL's "where ���W��  like '%keyword%'" ����
 * 	   "���r���".matches( '.*'+keyword+'.*'  )	
 * (2) ArrayList<String[]> �����Ƨ�
 * 		Collections.sort(List<String[]>, Comparator<String[]>  )
 */


public class Util {
	//����GUI_wb.java ����޳NA-1
	public static void queryData(String[][] srcTable, ArrayList<String[]> resultSet,
			HashMap<Integer,String> qryKeywords,Component parentOfMsgDialog, 
			JTable table, String[] jtblColTitles, int[] jtblColWidths, int[] jtblColAligns, 
			int orderbyFieldIndex, String orderMode, boolean isCaseInsensitive ){		
		
		if(Util.fetchDBData(srcTable, resultSet, 
				qryKeywords, parentOfMsgDialog,orderbyFieldIndex, 
				orderMode, isCaseInsensitive)){			
			
			Util.loadDataToJTable(resultSet, table, jtblColTitles, jtblColWidths, jtblColAligns);
				
		}
	}	
	public static boolean fetchDBData(String[][] srcTable, 
			ArrayList<String[]> resultSet, HashMap<Integer,String> qryKeywords, 
			Component parentOfMsgDialog, int orderbyFieldIndex, String orderMode, boolean isCaseInsensitive){		
		try{
			
			if(resultSet==null)
				return false;
			
			//�N�W���d�ߤ����G���M��
			resultSet.clear();	
			
			//���ӷ���ƪ����C�@��record->�ˬd��qryColIndex�����ȬO�_�ŦX"�j�M����r"? �Y�����۲ūh�[�J"�d�ߵ��G��"	
			//========================================================//
			for(String[] row : srcTable){
				
				boolean pass = true;
				//�v�@�ˬd"�j�M����r"(qryKeywords)				
				for(Map.Entry<Integer,String> keywordEntry : qryKeywords.entrySet()){
					Integer qryColIndex = keywordEntry.getKey();//���o�j�M�����W��
					String qryColValue = keywordEntry.getValue();//���o�j�M������
					
					if(isCaseInsensitive){//�����j�p�g�j�M
						if(!row[qryColIndex].toUpperCase().matches(".*"+qryColValue.toUpperCase()+".*")){											
							pass = false;
							break;
						}
						/* ����޳NB JavaAPI
						 * (1) �ϥ�Regular Expression����SQL's "where ���W��  like '%keyword%'" ����
						 * 	   "���r���".matches( '.*'+keyword+'.*'  )	
						 */	
					}
					else{//�Ϥ��j�p�g�j�M
						if(!row[qryColIndex].matches(".*"+qryColValue+".*")){											
							pass = false;
							break;
						}
					}					
				}
				
				if(pass)
				  resultSet.add(row);				
			}
			//========================================================//
			
			
						
			
			//-------------"�d�ߵ��G��"��records�ƧǳB�z---------------------//			
			//�إ�"�d�ߵ��G��"��"�ƧǤ����"
			Comparator<String[]> comparator = new Comparator<String[]>(){
				public int compare(String[] row1, String[] row2){
					if(orderMode.equalsIgnoreCase("ASC")){//�Ѥp�ƨ�j
						if(isCaseInsensitive)//�����j�p�g�Ƨ�
							return row1[orderbyFieldIndex].toUpperCase().compareTo(row2[orderbyFieldIndex].toUpperCase());
						else //�Ϥ��j�p�g�Ƨ�
							return row1[orderbyFieldIndex].compareTo(row2[orderbyFieldIndex]);
					}
					else{//�Ѥj�ƨ�p
						if(isCaseInsensitive)//�����j�p�g�Ƨ�
							return row2[orderbyFieldIndex].toUpperCase().compareTo(row1[orderbyFieldIndex].toUpperCase());
						else //�Ϥ��j�p�g�Ƨ�
							return row2[orderbyFieldIndex].compareTo(row1[orderbyFieldIndex]);
					}					
				}
			};			
			//�̫��w��"�ƧǤ����"�N"�d�ߵ��G��"�Ƨ�
			Collections.sort(resultSet,comparator);
			/* ����޳NB JavaAPI 
			 * (2) ArrayList<String[]> �����Ƨ�
			 * 		Collections.sort(List<String[]>, Comparator<String[]>  )
			 */
			//--------------------------------------------------------//
			
			
			return true;			
		}
		catch(Exception e){
			JOptionPane.showMessageDialog(parentOfMsgDialog, e.getMessage(),"��Ʈw�t�εo�Ϳ��~",JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
			return false;
		}				
	}	
	public static void loadDataToJTable(ArrayList<String[]> resultSet, JTable jtable, 
			String[] jtblColTitles, int[] jtblColWidths, int[] jtblColAligns){
		try{
			DefaultTableModel dtm = new DefaultTableModel();			
			
			for(int i=0; i<jtblColTitles.length; i++)	
				dtm.addColumn(jtblColTitles[i]);//�������W��

			//�N"�d�ߵ��G��"���C�@��record�[��JTable��
			for(String[] record :  resultSet){				
				dtm.addRow(record);
			}
			
			jtable.setModel(dtm);			
			Util.setJtableColumnsConfig(jtable, jtblColWidths, jtblColAligns);
		}
		catch(Exception e){e.printStackTrace();}		
	}
	//����GUI_wb.java ����޳NA-2
	public static void resetQueryConditions(Container c){
		for( Component comp: c.getComponents()){
			if(comp instanceof JTextComponent){
				((JTextComponent) comp).setText("");
			}					
		}
	}
	//����GUI_wb.java ����޳NA-4 (3). JComboBox<E>�ʺA���J�ﶵ����k
	public static void loadSelectionItemsToComboBox(JComboBox<String> comboBox, String[] items){
		DefaultComboBoxModel<String> model = new DefaultComboBoxModel<String>();
		
		for(int i=0;i<items.length;i++){
			model.addElement(items[i]);
		}
		comboBox.setModel(model);
	}	
	//����GUI_wb.java ����޳NA-6. JTable�]�w"���e��"�P�C����줺"�x�s���r"������覡
	public static void setJtableColumnsConfig(JTable table, int[] jtblColWidths, int[] jtblColAligns){
	
		for(int i=0; i<jtblColWidths.length; i++){	
			table.getColumnModel().getColumn(i).setMinWidth(jtblColWidths[i]);
			
			//�]�wTable-Cell����Ƥ�����覡
			DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();	
			dtcr.setHorizontalAlignment(jtblColAligns[i]);			
			table.getColumnModel().getColumn(i).setCellRenderer(dtcr);			
			
		}
	}

}

