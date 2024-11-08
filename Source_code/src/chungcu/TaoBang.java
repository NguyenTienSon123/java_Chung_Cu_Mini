/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package chungcu;

import java.sql.*;

/**
 *
 * @author MSI
 */
public class TaoBang {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String url = "jdbc:mysql://localhost:3306/QuanLyChungCu";
        String us = "root";
        String pass = "";
        
        // Câu lệnh SQL để tạo bảng Phong
//        String createTableSQL = "CREATE TABLE Phong ("
//                + "MaSoPhong VARCHAR(10) PRIMARY KEY, "
//                + "SoNguoiO INT, "
//                + "NgayBatDauThue DATE"
//                + ")";
        
//        String createTableSQL = "CREATE TABLE NguoiThue ("
//                + "MaSoPhong VARCHAR(10), "
//                + "MaNguoiThue VARCHAR(10) PRIMARY KEY, "
//                + "HoTen VARCHAR(50), "
//                + "DiaChi VARCHAR(40), "
//                + "GioiTinh VARCHAR(10), "
//                + "NgaySinh DATE, "
//                + "FOREIGN KEY (MaSoPhong) REFERENCES Phong(MaSoPhong)"
//                + ")";
        
//        String createTableSQL = "CREATE TABLE ChuHo ("
//                + "MaChuHo VARCHAR(10) PRIMARY KEY, "
//                + "MaSoPhong VARCHAR(10), "
//                + "MaNguoiThue VARCHAR(10), "
//                + "HoTen VARCHAR(50), "
//                + "DiaChi VARCHAR(40), "
//                + "GioiTinh VARCHAR(10), "
//                + "NgaySinh DATE, "
//                + "FOREIGN KEY (MaSoPhong) REFERENCES Phong(MaSoPhong), "
//                + "FOREIGN KEY (MaNguoiThue) REFERENCES NguoiThue(MaNguoiThue)"
//                + ")";

        String createTableSQL = "CREATE TABLE HoaDon ("
                + "SoNguoiO INT, "
                + "SoDien INT, "
                + "TienPhong INT, "
                + "TienDichVu INT, "
                + "TienDien INT, "
                + "TienNuoc INT, "
                + "MaHoaDon VARCHAR(10) PRIMARY KEY, "
                + "MaSoPhong VARCHAR(10), "
                + "FOREIGN KEY (MaSoPhong) REFERENCES Phong(MaSoPhong)"
                + ")";
            
        try (Connection con = DriverManager.getConnection(url, us, pass);
            Statement stmt = con.createStatement()) {
            
            // Thực thi câu lệnh SQL để tạo bảng
            stmt.executeUpdate(createTableSQL);
            System.out.println("Bảng Phong đã được tạo thành công.");
            
        } catch (SQLException ex) {
            System.out.println("Lỗi khi tạo bảng: " + ex.getMessage());
        }

        
    }
    
}
