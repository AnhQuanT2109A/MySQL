package Java2;

import java.sql.*;
import java.util.Scanner;

public class Exam {
    public static void main(String[] args) throws SQLException {
        Scanner sc = new Scanner(System.in);
        int id;
        String TenPhim;
        String ThoiGianChieu;
        String TenDaoDien;
        int ThoiGian;
        int ip;
        int fix;
        try (
                Connection conn = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/Phim",
                        "root",""
                );
                //Them mot bo Phim
                PreparedStatement pstmtInsert = conn.prepareStatement(
                        "insert into dsPhim(id, TenPhim, ThoiGianChieu, TenDaoDien, ThoiGian) values(?, ?, ?, ?, ?)"
                );
                //Sua Ten Phim, Tac Gia, Thoi Gian, Ngay Chieu
                PreparedStatement pstmtUpdateTen = conn.prepareStatement(
                        "update dsPhim set TenPhim = ? where id = ?"
                );
                PreparedStatement pstmtUpdateNgay = conn.prepareStatement(
                        "update dsPhim set ThoiGianChieu = ? where TenPhim = ?"
                );
                PreparedStatement pstmtUpdateTG = conn.prepareStatement(
                        "update dsPhim set ThoiGian = ? where TenPhim = ?"
                );
                PreparedStatement pstmtUpdateAuthor = conn.prepareStatement(
                        "update dsPhim set TenDaoDien = ? where TenPhim = ?"
                );
                //Xoa
                PreparedStatement pstmtDelete = conn.prepareStatement(
                        "delete from dsPhim where id = ?"
                );
                //Tim Kiem4
                PreparedStatement pstmtSearch = conn.prepareStatement(
                        "select * from dsPhim where TenPhim like ? "
                );
        ) {
            try {
                conn.setAutoCommit(false);
                do {
                    System.out.println("Lua Chon Cac Chuc Nang");
                    System.out.println("1.Them Phim    2.Chinh Sua  3.Xoa   4.Tim Kiem   0.Thoat");
                    ip = sc.nextInt();
                    if(ip==1) {
                        System.out.println("Nhap ID Phim");
                        id = sc.nextInt();
                        System.out.println("Nhap Ten Phim");
                        sc.nextLine();
                        TenPhim = sc.nextLine();
                        System.out.println("Nhap Thoi Gian Chieu (Nam-Thang-Ngay)");
                        ThoiGianChieu = sc.nextLine();
                        System.out.println("Nhap Ten Dao Dien");
                        TenDaoDien = sc.nextLine();
                        System.out.println("Nhap thoi gian");
                        ThoiGian = sc.nextInt();
                        pstmtInsert.setInt(1, id);
                        pstmtInsert.setString(2, TenPhim);
                        pstmtInsert.setString(3, ThoiGianChieu);
                        pstmtInsert.setString(4, TenDaoDien);
                        pstmtInsert.setInt(5, ThoiGian);
                        pstmtInsert.executeUpdate();
                        System.out.println("Thanh Cong");
                    } else if(ip == 2) {
                        do {
                            System.out.println("Lua Chon Muc Ban Muon Sua");
                            System.out.println("1.Sua Ten Phim  2.Sua Thoi Gian Chieu   3.Sua Dao Dien  4.Sua Thoi Gian    0.Thoat");
                            fix = sc.nextInt();
                            if(fix == 1) {
                                System.out.println("Nhap Ten Phim Muon Sua");
                                sc.nextLine();
                                TenPhim = sc.nextLine();
                                System.out.println("Nhap ID Cua Ten Sua");
                                id = sc.nextInt();
                                pstmtUpdateTen.setString(1, TenPhim);
                                pstmtUpdateTen.setInt(2, id);
                                pstmtUpdateTen.executeUpdate();
                                System.out.println("Thanh Cong");
                            } else if(fix == 2) {
                                System.out.println("Nhap Thoi Gian Chieu Muon Sua (Nam-Thang-Ngay)");
                                sc.nextLine();
                                ThoiGianChieu = sc.nextLine();
                                System.out.println("Nhap Ten Phim Cua Thoi Gian Chieu Ban Sua");
                                TenPhim = sc.nextLine();
                                pstmtUpdateNgay.setString(1, ThoiGianChieu);
                                pstmtUpdateNgay.setString(2, TenPhim);
                                pstmtUpdateNgay.executeUpdate();
                                System.out.println("Thanh Cong");
                            } else if(fix == 3) {
                                System.out.println("Nhap Ten Dao Dien Muon Sua");
                                sc.nextLine();
                                TenDaoDien = sc.nextLine();
                                System.out.println("Nhap Ten Phim Cua Dao Dien Ban Sua");
                                TenPhim = sc.nextLine();
                                pstmtUpdateAuthor.setString(1, TenDaoDien);
                                pstmtUpdateAuthor.setString(2, TenPhim);
                                pstmtUpdateAuthor.executeUpdate();
                                System.out.println("Thanh Cong");
                            } else if(fix == 4) {
                                System.out.println("Nhap Thoi Gian Muon Sua");
                                ThoiGian = sc.nextInt();
                                System.out.println("Nhap Tem Phim cua Thoi Gian ban sua");
                                sc.nextLine();
                                TenPhim = sc.nextLine();
                                pstmtUpdateTG.setInt(1, ThoiGian);
                                pstmtUpdateTG.setString(2, TenPhim);
                                pstmtUpdateTG.executeUpdate();
                                System.out.println("Thanh Cong");
                            }conn.commit();
                            if (fix == 0) {

                                break;
                            }
                        }while(fix != 1 || fix != 2 || fix != 3 || fix != 4 || fix == 0);
                    } else if(ip == 3) {
                        System.out.println("Nhap id ma ban muon xoa hang day");
                        id = sc.nextInt();
                        pstmtDelete.setInt(1, id);
                        pstmtDelete.executeUpdate();
                        System.out.println("Thanh Cong");

                    }else if(ip == 4) {
                        System.out.println("Tim Kiem Ten Phim Theo Ki Tu");
                        sc.nextLine();
                        TenPhim = sc.nextLine();
                        pstmtSearch.setString(1, "%"+TenPhim+"%");
                        ResultSet rset = pstmtSearch.executeQuery();
                        while (rset.next()) {
                            System.out.println(rset.getString("id") + ", "
                                    + rset.getString("TenPhim") + ", "
                                    + rset.getString("ThoiGianChieu") + ", "
                                    + rset.getString("TenDaoDien") + ", "
                                    + rset.getInt("ThoiGian"));
                        }
                    }

                    if(ip == 0) {
                        break;
                    }conn.commit();
                }while (ip != 1 || ip != 2 || ip != 3 || ip != 4 || ip == 0);
            }catch (SQLException ex) {
                System.out.println("ERR");
                conn.rollback();
                ex.printStackTrace();
            }
        }
    }
}
