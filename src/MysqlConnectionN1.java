import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MysqlConnectionN1 { 

    public static void main(String[] args) {
 
    final String USER = "root";
    final String PASS = "tbrs00002b";
    final String DB_URL = "jdbc:mysql://localhost:3306/world";
    String QUERY = "select Name, IndepYear, Region, Capital " +
                  "from country " +
                  "where 1 =1 " +
                  "and Name like '%an%'";

    try{
        Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
        Statement stmt = conn.createStatement();
        // ● insert문
        QUERY = "insert into city (ID, NAME, CountryCode, District, Population) "+
                "values(98765, 'NAME', 'AFG', 'Maharashtra', 100)"; //SELECT 해서 MAX값 +1로
        int val = stmt.executeUpdate(QUERY);   //인서트, 델리트는 업데이트로 사용해야함.
        // mysql workbench에서 insert쿼리 실행 후 정상인지 확인을 위해 action output부분을 보는 것과 같음

        ResultSet rs = stmt.executeQuery(QUERY);
        // Extract data from result set
            while (rs.next()){
                // Retrieve by column name
                System.out.print("ID: " + rs.getInt("ID"));
                System.out.print(", NAME: " + rs.getString("NAME"));
                System.out.print(", CountryCode: " + rs.getString("CountryCode"));
                System.out.print(", District: " + rs.getString("District"));
                System.out.print(", Population: " + rs.getInt("Population"));
            }

        // ● select문
        QUERY = "select ID, Name, CountryCode, District, Population " +
                "from city " +
                "where Name = 'Name'";
        rs = stmt.executeQuery(QUERY);
        // Extract data from result set
            while (rs.next()){
                // Retrieve by column name
                System.out.print("ID: " + rs.getInt("ID"));
                System.out.print(", NAME: " + rs.getString("NAME"));
                System.out.print(", CountryCode: " + rs.getString("CountryCode"));
                System.out.print(", District: " + rs.getString("District"));
                System.out.print(", Population: " + rs.getInt("Population"));
            }

        // ● update문
        QUERY = "update city " +
                "set Population = 2000 " +
                "where Name = 'Name'";
        val = stmt.executeUpdate(QUERY);

   //     // ● select문
   //     System.out.println();

        // delete문
        QUERY = "delete from city " +
                 "where Name = 'Name'";
        val = stmt.executeUpdate(QUERY);

        rs = stmt.executeQuery(QUERY);
        // Extract data from result set
            while (rs.next()){
                // Retrieve by column name
                System.out.print("ID: " + rs.getInt("ID"));
                System.out.print(", NAME: " + rs.getString("NAME"));
                System.out.print(", CountryCode: " + rs.getString("CountryCode"));
                System.out.print(", District: " + rs.getString("District"));
                System.out.print(", Population: " + rs.getInt("Population"));
            }


        // rs = stmt.executeQuery(QUERY);
        // // Extract data from result set
        //     while (rs.next()){
        //         // Retrieve by column name
        //         System.out.print("Name: " + rs.getString("columnLabel : Name"));
        //         System.out.print(", IndepYear: " + rs.getInt("columnLabel : IndepYear"));
        //         System.out.print(", Region: " + rs.getString("columnLabel : Region"));
        //         System.out.print(", Capital: " + rs.getInt("columnLabel : Capital"));
            }
             catch (SQLException e) {
                    e.printStackTrace();
        } 

   }
}

