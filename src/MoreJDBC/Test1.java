package MoreJDBC;

import java.sql.*;
import java.util.Scanner;

public class Test1 {
    public static void main(String[] args) throws SQLException {
        try (
                Connection conn = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/Account?",
                        "root",""
                );
                Statement stmt = conn.createStatement();
        ) {
            try {
                conn.setAutoCommit(false);
                Scanner sc = new Scanner(System.in);
                System.out.println("Nhap ID nguoi chuyen");
                String ip = sc.nextLine();

                Scanner sc1 = new Scanner(System.in);
                System.out.println("Nhap So Tien Can Chuyen");
                String ip1 = sc1.nextLine();

                String sqlMoney = "update tAccount set balance=balance-"+ip1 +" where id="+ip;
                int countInsert = stmt.executeUpdate(sqlMoney);
                conn.commit();

                Scanner sc2 = new Scanner(System.in);
                System.out.println("Nhap ID nguoi Nhan");
                String ip2 = sc2.nextLine();


                String sqlMoney2 = "update tAccount set balance=balance+"+ip1 +" where id="+ip2;
                int countInsert2 = stmt.executeUpdate(sqlMoney2);
                conn.commit();

                String sqlSelect = "select * from tAccount";
                ResultSet rset = stmt.executeQuery(sqlSelect);
                while (rset.next()) {
                    System.out.println(rset.getInt("id") + ", "
                            + rset.getString("name") + ", "
                            + rset.getDouble("balance")
                    );
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
                conn.rollback();
            }

        }
    }
}
