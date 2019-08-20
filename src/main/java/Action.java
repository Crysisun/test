import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.Scanner;

public class Action {
    private Scanner scanner;
    public Action(Scanner scanner) {
        this.scanner = scanner;
    }
    private int c1 = 2004;
    private String dbURL = "jdbc:mysql://localhost:3306/bankDB";
    private String username = "root";
    private String password = "1234";
    private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private Connection con = null;
    private PreparedStatement pmt = null;
    private String query = null;
    private Statement stmt = null;
    private ResultSet rs = null;

    public void createAccount() {
        try {
            con = DriverManager.getConnection(dbURL, username, password);
            query = "insert into customerdb values(?,?,?,?,?)";
            pmt = con.prepareStatement(query);

            Integer accNo = c1++;
            System.out.print("PIN Number = ");
            Integer en = Integer.parseInt(scanner.nextLine());
            System.out.print("CUSTOMER NAME = ");
            String name = scanner.nextLine();
            System.out.print("ACCOUNT BALANCE = ");
            Integer s = Integer.parseInt(scanner.nextLine());
            System.out.print("PASSWORD = ");
            String c = scanner.nextLine();

            //setting values to placeholders
            pmt.setInt(1,en);
            pmt.setString(2,name);
            pmt.setInt(3,s);
            pmt.setString(4,c);
            pmt.setInt(5,c1);

            //execute query
            int r = pmt.executeUpdate();
            if (r > 0) {
                System.out.println("RECORD INSERTED SUCCESSFULLY");
                updateLog(en, name, "Create Account", accNo, s);
            } else {
                System.out.println("ERROR IN INSERTION!");
            }
        }  catch(SQLException se) {
            se.printStackTrace();
        }
    }

    public void deleteAccount() {
        try {
            con = DriverManager.getConnection(dbURL, username, password);
            query = "delete from customerdb where pin=? and password=?";
            pmt = con.prepareStatement(query);
            System.out.print("TO DELETE CUSTOMER ACCOUNT, ENTER PIN Number = ");
            int en = Integer.parseInt(scanner.nextLine());
            System.out.print("PASSWORD = ");
            String p = scanner.nextLine();

            //setting values to placeholders
            pmt.setInt(1, en);
            pmt.setString(2, p);

            //execute query
            int r = pmt.executeUpdate();
            if (r > 0) {
                System.out.println("RECORD DELETED SUCCESSFULLY");
//                updateLog(en, null, "delete account", null, null);
            } else {
                System.out.println("ERROR IN DELETION!");
            }
        } catch(SQLException se) {
            se.printStackTrace();
        }
    }

    public void deposit() {
        try {
            con = DriverManager.getConnection(dbURL, username, password);
            query = "update customerdb set balance=balance+? where pin= ?";// here ? is to put any value
            pmt = con.prepareStatement(query);
            System.out.print("PIN Number = ");
            int en = Integer.parseInt(scanner.nextLine());
            System.out.print("ENTER AMOUNT TO DEPOSIT = ");
            int m = Integer.parseInt(scanner.nextLine());

            //setting values to place holders
            pmt.setInt(1, m);
            pmt.setInt(2, en);

            //execute query
            int r = pmt.executeUpdate();
            if (r > 0) {
                System.out.println("RECORD UPDATED SUCCESSFULLY");
//                updateLog(en, null, "deposit", null, m);
            } else {
                System.out.println("ERROR IN UPDATION!");
            }
        } catch(SQLException se) {
            se.printStackTrace();
        }
    }

    public void passwordChange() {
        try {
            con = DriverManager.getConnection(dbURL, username, password);
            query = "update customerdb set password=? where password= ? and pin= ?";// here ? is to putany value
            pmt = con.prepareStatement(query);
            System.out.print("PIN = ");
            int en = Integer.parseInt(scanner.nextLine());
            System.out.print("OLD PASSWORD = ");
            String p = scanner.nextLine();
            System.out.print("NEW PASSWORD = ");
            String pa = scanner.nextLine();

            //setting values to place holders
            pmt.setInt(3, en);
            pmt.setString(2, p);
            pmt.setString(1, pa);

            //execute query
            int r = pmt.executeUpdate();
            if (r > 0) {
                System.out.println("PASSWORD UPDATED SUCCESSFULLY");
//                updateLog(en, null, "password change", null, null);
            } else {
                System.out.println("ERROR IN UPDATION!");
            }
        } catch(SQLException se) {
            se.printStackTrace();
        }
    }

    public void withdraw() {
        try {
            con = DriverManager.getConnection(dbURL, username, password);
            query = "update customerdb set balance=balance-? where pin= ? and password =?";// here ? is to putany value
            pmt = con.prepareStatement(query);
            System.out.print("PIN Number = ");
            int en = Integer.parseInt(scanner.nextLine());
            System.out.print("PASSWORD = ");
            String p = scanner.nextLine();
            System.out.print("ENTER AMOUNT TO WITHDRAW = ");
            int m = Integer.parseInt(scanner.nextLine());

            //setting values to place holders
            pmt.setInt(1, m);
            pmt.setInt(2, en);
            pmt.setString(3, p);

            //execute query
            int r = pmt.executeUpdate();
            if (r > 0) {
                System.out.println("AMOUNT WITHDRAWN SUCCESSFULLY");
//                updateLog(en, null, "withdraw", null, m);
            } else {
                System.out.println("ERROR IN WITHDRAW!");
            }
        } catch(SQLException se) {
            se.printStackTrace();
        }
    }

    public void display() {
        stmt = null;
        rs = null;
        try {
            con = DriverManager.getConnection(dbURL, username, password);
            stmt = con.createStatement();
            query = "select * from customerdb";
            rs = stmt.executeQuery(query);
            System.out.println("-------------------------------------------CUSTOMER RECORDS------------------------------------------\n\n    PIN                NAME                 BALANCE                  PASSWORD               ACCOUNT NO.\n");
            System.out.println("=====================================================================================================");
            while (rs.next()) {
                int pin = rs.getInt(1);
                String name = rs.getString(2);
                int bal = rs.getInt(3);
                String pass = rs.getString(4);
                int accNo = rs.getInt(5);
                System.out.printf("%8d   |%18s   |%18d   |%20s  |%17d\n", pin, name, bal, pass, accNo);
                System.out.println("------------------------------------------------------------------------------------------------------");
            }
        } catch(SQLException se) {
            se.printStackTrace();
        }
    }

    public void logs() {
        stmt = null;
        rs = null;
        try {
            con = DriverManager.getConnection(dbURL, username, password);
            query = "select * from transactiondb where pin= ?";
            pmt = con.prepareStatement(query);
            System.out.print("PIN Number = ");
            int en = Integer.parseInt(scanner.nextLine());
//            System.out.print("PASSWORD = ");
//            String p = scanner.nextLine();
            pmt.setInt(1, en);
//            pmt.setString(2, p);
            rs = pmt.executeQuery();
            System.out.println("-----------------------------------------TRANSACTION RECORDS-----------------------------------------\n\n    PIN                NAME                   TYPE                   ACCOUNT NO.               AMOUNT\n");
            System.out.println("=====================================================================================================");
            while (rs.next()) {
                Integer pin = rs.getInt(1);
                String name = rs.getString(2);
                String type = rs.getString(3);
                Integer acc_num = rs.getInt(4);
                Integer amount = rs.getInt(5);
                System.out.printf("%8d   |%18s   |%18s   |%20d  |%17d\n", pin, name, type, acc_num, amount);
                System.out.println("------------------------------------------------------------------------------------------------------");
            }
        } catch(SQLException se) {
            se.printStackTrace();
        }
    }

    private void updateLog(Integer pin, String name, String type, Integer accNum, Integer amount) throws SQLException {
        try {
            con = DriverManager.getConnection(dbURL, username, password);
            query = "insert into transactiondb values(?,?,?,?,?)";
            pmt = con.prepareStatement(query);
            pmt.setInt(1, pin);
            pmt.setString(2, name);
            pmt.setString(3, type);
            pmt.setInt(4, accNum);
            pmt.setInt(5, amount);
            pmt.executeUpdate();
        } catch(SQLException se) {
            se.printStackTrace();
        }
    }
}
