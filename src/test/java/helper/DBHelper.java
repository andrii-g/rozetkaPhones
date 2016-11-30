package helper;
import java.sql.*;

/**
 * Created by User on 29.11.2016.
 */
public class DBHelper {
    // JDBC driver name and database URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/newtestdb";
    //  Database credentials
    static final String USER = "root";
    static final String PASS = "Sqlpass1";
    String tableName = "rozetkadevices";

    static ResultSet rs;

    public void setDBTableData(String id, String name, String price){
        Connection conn = null;
        Statement stmt = null;

        try{
            //Register JDBC driver
            Class.forName(JDBC_DRIVER);

            //Open a connection
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            //Execute a query
            stmt = conn.createStatement();
            String query = "INSERT INTO " + tableName + " (id, name, price)VALUES (" + id + ", '" + name + "', '" + price + "');";

            PreparedStatement pst =  conn.prepareStatement(query);
            int numRowsChanged = pst.executeUpdate(query);
            System.out.println("Query was executed successfully");
        }catch(SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
        }catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
        }finally{
            //finally block used to close resources
            try{
                if(stmt!=null)
                    stmt.close();
            }catch(SQLException se2){
            }
            try{
                if(conn!=null)
                    conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }
        }
    }

    public String getDBCreatedPhoneData(){
        Connection conn = null;
        Statement stmt = null;
        String resultString = null;

        try{
            //Register JDBC driver
            Class.forName(JDBC_DRIVER);

            //Open a connection
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            //Execute a query
            stmt = conn.createStatement();
            String query = "select * from " + tableName + ";";

            rs = stmt.executeQuery(query);
            while (rs.next()) {
                String id = rs.getString(1);
                String data = rs.getString(2);
                resultString = "id: '" + id + "' data: '" + data + "'";
            }
            System.out.println("Query was executed successfully");
        }catch(SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
        }catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
        }finally{
            //finally block used to close resources
            try{
                if(stmt!=null)
                    stmt.close();
            }catch(SQLException se2){
            }
            try{
                if(conn!=null)
                    conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }
        }
        return resultString;
    }
}
