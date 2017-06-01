import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Types;

public class JDBC {

	public static void main(String[] args) {
		//(1)記得在專案的Java Build Path內,利用 "Add JARs...或 Add External JARs..."將JDBC驅動程式(如sqljdbc4.jar)匯入
		
		//(2)SQL Server 之  url格式:
		String url = "jdbc:sqlserver://localhost:1433;databaseName=northwind;user=sa;password=as;";
		//MYSQL 之  url格式: "jdbc:mysql://localhost/dbname?user=xxx&password=yyy";
		
		//(3)資料庫操作相關變數
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		//A.入門方法
		try{	
			//JDBC4.0 : DriverManager.getConnection() 會自動載入資料庫驅動程式 ;免使用Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");以載入資料庫驅動程式
		    conn = DriverManager.getConnection(url);
		    	//亦可DriverManager.getConnection(url, user, password);
		    System.out.println("Connection successful...");  
	    
		    stmt = conn.createStatement();
		    String sql="SELECT EMPLOYEEID,FIRSTNAME,BIRTHDATE FROM EMPLOYEES";		    
		    rs = stmt.executeQuery(sql);		    
		    System.out.println("員工資料如下:");
		    while(rs.next()){
		    	System.out.printf("%3d %-10s %tY/%<tm/%<td\n", rs.getInt("EMPLOYEEID"), 
		    			rs.getString("FIRSTNAME"), rs.getDate("BIRTHDATE"));
		    }
		    //輸出範例:
		    //  1 Nancy      1948/12/08
		    //  2 Andrew     1952/02/19	
		}
		catch(SQLException e){
			System.out.printf("Error Message=%s\nError Code=%d\n", e.getMessage(), e.getErrorCode());
		}
		/* 待下面[B.進階方法]完成後再將"連接關閉"
		finally{
			try{
				if(conn!=null)
					conn.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		*/		
				
		//B.進階方法: try with resources	+ ResultSetMetaData		
		try( Connection conn2=conn;){		
			String sql="SELECT EMPLOYEEID,FIRSTNAME,BIRTHDATE FROM EMPLOYEES";
			if(stmt.execute(sql)){				
				rs = stmt.getResultSet();
				System.out.println("員工資料如下:");
				ResultSetMetaData rsmd = rs.getMetaData();
				for(int i=1;i<=rsmd.getColumnCount();i++){
					System.out.printf("%-15s",rsmd.getColumnName(i));
				}
				System.out.println();
				while(rs.next()){
					for(int i=1;i<=rsmd.getColumnCount();i++){
						switch(rsmd.getColumnType(i)){
						case Types.VARCHAR:
						case Types.NVARCHAR:
							System.out.printf("%-15s", rs.getString(i));
							break;
						case Types.TIMESTAMP: //date+time
						case Types.DATE:
							System.out.printf("%tY/%<tm/%<td", rs.getTimestamp(i));
							break;
						case Types.INTEGER:
							System.out.printf("%-15d", rs.getInt(i));
							break;							
						}
					}
					System.out.println();			    	
			    }
				//輸出範例:
				//EMPLOYEEID FIRSTNAME  BIRTHDATE          
				//1          Nancy      1948/12/08
				//2          Andrew     1952/02/19				
			}				
		}
		catch(SQLException e){
			e.printStackTrace();			
		}		
	}
}
