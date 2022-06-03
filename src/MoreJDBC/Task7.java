package MoreJDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Task7 {
    public static void main(String[] args) throws SQLException {
        Scanner sc = new Scanner(System.in);
        int id ;
        String name ;
        int PublishingYear;
        float price;
        String author;
        int qty;
        int ip;
        try (
                Connection conn = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/QBookShop",
                        "root",""
                );
                PreparedStatement pstmtInsert = conn.prepareStatement(
                        "insert into book(id, name, PublishingYear, price, author, qty) values(?, ?, ?, ?, ?, ?)"
                );
                PreparedStatement pstmtUpdate = conn.prepareStatement(
                        "update book set price = ? where id = ?"
                );
                PreparedStatement pstmtDelete = conn.prepareStatement(
                        "delete from book where id = ?"
                );

        ) {
            try {
                conn.setAutoCommit(false);
                do {
                    System.out.println("1.Them Sach   2.Sua Gia Sach   3.Xoa Sach  4.Thoat ");
                    ip = sc.nextInt();
                    if(ip==1) {

                        System.out.println("Nhap ID Sach");
                        id = sc.nextInt();
                        System.out.println("Nhap Ten Sach");
                        sc.nextLine();
                        name = sc.nextLine();
                        System.out.println("Nhap Nam Xuat Ban");
                        PublishingYear = sc.nextInt();
                        System.out.println("Nhap Gia");
                        price = sc.nextFloat();
                        System.out.println("Nhap Ten Tac Gia");
                        sc.nextLine();
                        author = sc.nextLine();
                        System.out.println("Nhap So Luong");
                        qty  = sc.nextInt();
                        pstmtInsert.setInt(1, id);
                        pstmtInsert.setString(2, name);
                        pstmtInsert.setInt(3, PublishingYear);
                        pstmtInsert.setDouble(4, price);
                        pstmtInsert.setString(5, author);
                        pstmtInsert.setInt(6, qty);

                        pstmtInsert.executeUpdate();
                        System.out.println("Complete");
                    }else if(ip==2) {
                        sc.nextLine();
                        System.out.println("Nhap id Gia ma Sach muon sua");
                        id = sc.nextInt();
                        System.out.println("Nhap Gia muon sua");
                        price = sc.nextFloat();
                        pstmtUpdate.setInt(1, id);
                        pstmtUpdate.setDouble(2, price);
                        pstmtUpdate.executeUpdate();
                        System.out.println("Complete");
                    }else if(ip==3) {
                        sc.nextLine();
                        System.out.println("Nhap id sach ban muon xoa");
                        id = sc.nextInt();
                        pstmtDelete.setInt(1, id);
                        pstmtDelete.executeUpdate();
                        System.out.println("Complete");
                    } conn.commit();
                    if (ip==4) {
                        break;
                    }
                }while (ip != 1 || ip != 2 || ip != 3 || ip == 4);


            }catch (SQLException ex) {
                System.out.println("ERR");
                conn.rollback();
                ex.printStackTrace();
            }
        }
    }
}
