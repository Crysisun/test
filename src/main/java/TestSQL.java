import java.sql.*;

public class TestSQL {
    public static void main(String[] args) throws SQLException {
        String dbURL = "jdbc:mysql://localhost:3306/bankDB";
        String username = "root";
        String password = "1234";

        Connection dbCon = null;
        Statement stmt = null;
        ResultSet rs = null;

        String query = "select * from accounts";

        try {
            dbCon = DriverManager.getConnection(dbURL, username, password);
            stmt = dbCon.prepareStatement(query);

            rs = stmt.executeQuery(query);

            while (rs.next()) {
                System.out.println("Account num : " + rs.getInt(1) + " balance: " + rs.getInt(2));
            }

        } catch (SQLException ex) {
            System.out.println("Exception.");
        } finally {
            if (dbCon != null) {
                dbCon.close();
            }
        }
    }
}
