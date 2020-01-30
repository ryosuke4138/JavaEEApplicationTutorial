package dataLayer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DB_user {
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/webapptutorial";
    static final String USER = "webapp";
    static final String PASS = "12AS12as,";

    public DB_user() {
    }

    public boolean isValidUserLogin(String sUserName, String sUserPassword) {
        boolean isValidUser = false;
        Connection conn = null;
        Statement stmt = null;
        String sql = "";

        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection("jdbc:mysql://localhost/webapptutorial", "webapp", "12AS12as,");
            System.out.println("Creating a statement...");
            stmt = conn.createStatement();
            sql = "SELECT * FROM users WHERE user_name = \"" + sUserName + "\" AND user_password = \"" + sUserPassword + "\"";
            System.out.println(sql);
            ResultSet rs = stmt.executeQuery(sql);
            if (rs.next()) {
                isValidUser = true;
            }

            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException var23) {
            var23.printStackTrace();
        } catch (Exception var24) {
            var24.printStackTrace();
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
            } catch (SQLException var22) {
            }

            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException var21) {
                var21.printStackTrace();
            }

        }

        System.out.println("Closing DB Connection - Goodbye!");
        return isValidUser;
    }
}
