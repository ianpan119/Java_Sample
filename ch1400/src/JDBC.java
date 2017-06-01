import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Types;

public class JDBC {

	public static void main(String[] args) {
		//(1)�O�o�b�M�ת�Java Build Path��,�Q�� "Add JARs...�� Add External JARs..."�NJDBC�X�ʵ{��(�psqljdbc4.jar)�פJ
		
		//(2)SQL Server ��  url�榡:
		String url = "jdbc:sqlserver://localhost:1433;databaseName=northwind;user=sa;password=as;";
		//MYSQL ��  url�榡: "jdbc:mysql://localhost/dbname?user=xxx&password=yyy";
		
		//(3)��Ʈw�ާ@�����ܼ�
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		//A.�J����k
		try{	
			//JDBC4.0 : DriverManager.getConnection() �|�۰ʸ��J��Ʈw�X�ʵ{�� ;�K�ϥ�Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");�H���J��Ʈw�X�ʵ{��
		    conn = DriverManager.getConnection(url);
		    	//��iDriverManager.getConnection(url, user, password);
		    System.out.println("Connection successful...");  
	    
		    stmt = conn.createStatement();
		    String sql="SELECT EMPLOYEEID,FIRSTNAME,BIRTHDATE FROM EMPLOYEES";		    
		    rs = stmt.executeQuery(sql);		    
		    System.out.println("���u��Ʀp�U:");
		    while(rs.next()){
		    	System.out.printf("%3d %-10s %tY/%<tm/%<td\n", rs.getInt("EMPLOYEEID"), 
		    			rs.getString("FIRSTNAME"), rs.getDate("BIRTHDATE"));
		    }
		    //��X�d��:
		    //  1 Nancy      1948/12/08
		    //  2 Andrew     1952/02/19	
		}
		catch(SQLException e){
			System.out.printf("Error Message=%s\nError Code=%d\n", e.getMessage(), e.getErrorCode());
		}
		/* �ݤU��[B.�i����k]������A�N"�s������"
		finally{
			try{
				if(conn!=null)
					conn.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		*/		
				
		//B.�i����k: try with resources	+ ResultSetMetaData		
		try( Connection conn2=conn;){		
			String sql="SELECT EMPLOYEEID,FIRSTNAME,BIRTHDATE FROM EMPLOYEES";
			if(stmt.execute(sql)){				
				rs = stmt.getResultSet();
				System.out.println("���u��Ʀp�U:");
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
				//��X�d��:
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
