package MoreJDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PreparedStatementDemo {
    public static void main(String[] args) {
        try (
                Connection conn = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/ebookshop",
                        "root", ""
                );

                PreparedStatement pstmt =  conn.prepareStatement(
                        "insert into books values(?, ?, ?, ?, ?)"
                );
        ) {


            conn.setAutoCommit(false);
            pstmt.setInt(1,80011);
            pstmt.setString(2,"Java 123");
            pstmt.setString(3,"Kevin Jones");
            pstmt.setDouble(4, 12.34);
            pstmt.setInt(5, 88);
            pstmt.addBatch();

            pstmt.setInt(1,80012);
            pstmt.setString(2,"Java 456");
            pstmt.addBatch();

            int[] returnCodes = pstmt.executeBatch();

            System.out.println("Return codes are: ");
            for (int code : returnCodes) System.out.println(code + ", ");
            System.out.println();

            conn.commit();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
