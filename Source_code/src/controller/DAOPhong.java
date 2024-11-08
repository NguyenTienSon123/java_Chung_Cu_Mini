/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import model.Phong;

/**
 *
 * @author MSI
 */
public class DAOPhong {
    private Connection con;

    public DAOPhong() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/QuanLyChungCu";
            String user = "root";  // thay bằng tên người dùng MySQL của bạn
            String password = "";  // thay bằng mật khẩu MySQL của bạn
            con = DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            System.out.println("Kết nối không thành công");
            e.printStackTrace();
        }
    }

    public boolean ThemPhong(Phong phong) {
        String sql = "INSERT INTO Phong (MaSoPhong, SoNguoiO, NgayBatDauThue) VALUES (?, ?, ?)";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, phong.GetMaSoPhong());
            ps.setInt(2, phong.GetSoNguoiO());
            ps.setDate(3, new java.sql.Date(phong.GetNgayBatDauThue().getTime()));
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean SuaPhong(Phong phong) {
        String sql = "UPDATE Phong SET SoNguoiO = ?, NgayBatDauThue = ? WHERE MaSoPhong = ?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, phong.GetSoNguoiO());
            ps.setDate(2, new java.sql.Date(phong.GetNgayBatDauThue().getTime()));
            ps.setString(3, phong.GetMaSoPhong());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean XoaPhong(String MaSoPhong) {
        String sql = "DELETE FROM Phong WHERE MaSoPhong = ?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, MaSoPhong);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public ArrayList<Phong> getListPhong() {
        ArrayList<Phong> dsPhong = new ArrayList<>();
        String sql = "SELECT * FROM Phong";
        try (PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Phong phongMoi = new Phong();
                phongMoi.SetMaSoPhong(rs.getString("MaSoPhong"));
                phongMoi.SetSoNguoiO(rs.getInt("SoNguoiO"));
                phongMoi.SetNgayBatDauThue(rs.getDate("NgayBatDauThue"));
                dsPhong.add(phongMoi);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dsPhong;
    }

    public static void main(String[] args) {
        DAOPhong dao = new DAOPhong();
    }
}
