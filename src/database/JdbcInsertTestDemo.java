package database;

import java.sql.*;
import java.util.Scanner;

public class JdbcInsertTestDemo {
    public static void main(String[] args) {
        try (
                Connection conn = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/danhSachSanPham",
                        "root",""
                );
                Statement stmt = conn.createStatement();
                ) {
//            Delete
//            Scanner ip = new Scanner(System.in);
//            System.out.println("Enter delete from table where ");
//            String sc = ip.nextLine();
//
//            String sqlDelete = "delete from SanPham where "+ sc;
//            System.out.println("The SQL statement is: " + sqlDelete + "\n");
//            int countDeleted = stmt.executeUpdate(sqlDelete);
//
//            //Insert
//            Scanner ip1 = new Scanner(System.in);
//            System.out.println("Enter insert from table where ");
//            String sc1 = ip1.nextLine();
//
//            String sqlInsert = "Insert into SanPham values "+sc1;
//            System.out.println("The SQL statement is: " + sqlInsert+ "\n");
//            int countInsert = stmt.executeUpdate(sqlInsert);

            //Update
//            Scanner ip2 = new Scanner(System.in);
//            System.out.println("Enter update SanPham set ");
//            String sc2 = ip2.nextLine();
//            Scanner ip3 = new Scanner(System.in);
//            System.out.println("End enter update SanPham where ");
//            String sc3 = ip3.nextLine();
//
//            String sqlUpdate = "Update SanPham set "+sc2+" where "+sc3;
//            System.out.println("The SQL statement is: "+sqlUpdate+"\n");
//            int countUpdate = stmt.executeUpdate(sqlUpdate);

            //Search
            Scanner ip4 = new Scanner(System.in);
            System.out.println("Enter search SanPham where ");
            String sc4 = ip4.nextLine();

            Scanner ip5 = new Scanner(System.in);
            System.out.println("Enter SanPham like  ");
            String sc5 = ip5.nextLine();
            String sqlSearch = "Select * from SanPham where "+sc4 + "like"+ sc5;

//            String query[] = {sc4,sc5};
//            for(String q: query) {
//                ResultSet resultSet1 = stmt.executeQuery(q);
//                System.out.println("Student for query "+q+" is(id, name, qnt, price): ");
//            }

            //Select ALL
            String strSelect = "select * from SanPham";
            System.out.println("The SQL statement is: "+ strSelect+"\n");


            ResultSet rset = stmt.executeQuery(strSelect);
            while (rset.next()) {
                System.out.println(rset.getInt("id") + ", "
                    + rset.getString("name") + ", "
                    + rset.getInt("qnt") + ", "
                    + rset.getDouble("price")
                );
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
