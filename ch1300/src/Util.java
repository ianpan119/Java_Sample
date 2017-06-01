
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

/* 關鍵技術B JavaAPI 
 * (1) 使用Regular Expression模擬SQL's "where 欄位名稱  like '%keyword%'" 條件式
 * 	   "欄位字串值".matches( '.*'+keyword+'.*'  )	
 * (2) ArrayList<String[]> 元素排序
 * 		Collections.sort(List<String[]>, Comparator<String[]>  )
 */


public class Util {
	//對應GUI_wb.java 關鍵技術A-1
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
			
			//將上次查詢之結果集清空
			resultSet.clear();	
			
			//比對來源資料表內之每一筆record->檢查第qryColIndex個欄位值是否符合"搜尋關鍵字"? 若全部相符則加入"查詢結果集"	
			//========================================================//
			for(String[] row : srcTable){
				
				boolean pass = true;
				//逐一檢查"搜尋關鍵字"(qryKeywords)				
				for(Map.Entry<Integer,String> keywordEntry : qryKeywords.entrySet()){
					Integer qryColIndex = keywordEntry.getKey();//取得搜尋之欄位名稱
					String qryColValue = keywordEntry.getValue();//取得搜尋之欄位值
					
					if(isCaseInsensitive){//不分大小寫搜尋
						if(!row[qryColIndex].toUpperCase().matches(".*"+qryColValue.toUpperCase()+".*")){											
							pass = false;
							break;
						}
						/* 關鍵技術B JavaAPI
						 * (1) 使用Regular Expression模擬SQL's "where 欄位名稱  like '%keyword%'" 條件式
						 * 	   "欄位字串值".matches( '.*'+keyword+'.*'  )	
						 */	
					}
					else{//區分大小寫搜尋
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
			
			
						
			
			//-------------"查詢結果集"之records排序處理---------------------//			
			//建立"查詢結果集"之"排序比較器"
			Comparator<String[]> comparator = new Comparator<String[]>(){
				public int compare(String[] row1, String[] row2){
					if(orderMode.equalsIgnoreCase("ASC")){//由小排到大
						if(isCaseInsensitive)//不分大小寫排序
							return row1[orderbyFieldIndex].toUpperCase().compareTo(row2[orderbyFieldIndex].toUpperCase());
						else //區分大小寫排序
							return row1[orderbyFieldIndex].compareTo(row2[orderbyFieldIndex]);
					}
					else{//由大排到小
						if(isCaseInsensitive)//不分大小寫排序
							return row2[orderbyFieldIndex].toUpperCase().compareTo(row1[orderbyFieldIndex].toUpperCase());
						else //區分大小寫排序
							return row2[orderbyFieldIndex].compareTo(row1[orderbyFieldIndex]);
					}					
				}
			};			
			//依指定之"排序比較器"將"查詢結果集"排序
			Collections.sort(resultSet,comparator);
			/* 關鍵技術B JavaAPI 
			 * (2) ArrayList<String[]> 元素排序
			 * 		Collections.sort(List<String[]>, Comparator<String[]>  )
			 */
			//--------------------------------------------------------//
			
			
			return true;			
		}
		catch(Exception e){
			JOptionPane.showMessageDialog(parentOfMsgDialog, e.getMessage(),"資料庫系統發生錯誤",JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
			return false;
		}				
	}	
	public static void loadDataToJTable(ArrayList<String[]> resultSet, JTable jtable, 
			String[] jtblColTitles, int[] jtblColWidths, int[] jtblColAligns){
		try{
			DefaultTableModel dtm = new DefaultTableModel();			
			
			for(int i=0; i<jtblColTitles.length; i++)	
				dtm.addColumn(jtblColTitles[i]);//中文欄位名稱

			//將"查詢結果集"內每一筆record加到JTable裡
			for(String[] record :  resultSet){				
				dtm.addRow(record);
			}
			
			jtable.setModel(dtm);			
			Util.setJtableColumnsConfig(jtable, jtblColWidths, jtblColAligns);
		}
		catch(Exception e){e.printStackTrace();}		
	}
	//對應GUI_wb.java 關鍵技術A-2
	public static void resetQueryConditions(Container c){
		for( Component comp: c.getComponents()){
			if(comp instanceof JTextComponent){
				((JTextComponent) comp).setText("");
			}					
		}
	}
	//對應GUI_wb.java 關鍵技術A-4 (3). JComboBox<E>動態載入選項的方法
	public static void loadSelectionItemsToComboBox(JComboBox<String> comboBox, String[] items){
		DefaultComboBoxModel<String> model = new DefaultComboBoxModel<String>();
		
		for(int i=0;i<items.length;i++){
			model.addElement(items[i]);
		}
		comboBox.setModel(model);
	}	
	//對應GUI_wb.java 關鍵技術A-6. JTable設定"欄位寬度"與每個欄位內"儲存格文字"之對齊方式
	public static void setJtableColumnsConfig(JTable table, int[] jtblColWidths, int[] jtblColAligns){
	
		for(int i=0; i<jtblColWidths.length; i++){	
			table.getColumnModel().getColumn(i).setMinWidth(jtblColWidths[i]);
			
			//設定Table-Cell內資料之對齊方式
			DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();	
			dtcr.setHorizontalAlignment(jtblColAligns[i]);			
			table.getColumnModel().getColumn(i).setCellRenderer(dtcr);			
			
		}
	}

}

