package database;

import java.sql.*;

public class JdbcSelectCate {
    public static void main(String[] args) {
        try (
                Connection conn = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/cate?",
                        "root",""
                );

                Statement stst = conn.createStatement();
        ) {
            String strSelect = "select genre, nameCate from ta1";
            System.out.println("The SQL statement is: "+ strSelect + "\n");

            ResultSet rset = stst.executeQuery(strSelect);

            System.out.println("The record selected are:");
            int rowCount = 0;
            while (rset.next()) {


                int genre = rset.getInt("genre");
                String nameCate = rset.getString("nameCate");
                System.out.println(genre + " " + nameCate);
                ++rowCount;
            }
            System.out.println("Total number of records = "+rowCount);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

}
