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
import model.HoaDon;
/**
 *
 * @author MSI
 */
public class DAOHoaDon {
    private Connection con;

    public DAOHoaDon() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/QuanLyChungCu";
            String user = "root";  // thay bằng tên người dùng MySQL của bạn
            String password = "";  // thay bằng mật khẩu MySQL của bạn
            con = DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean ThemHoaDon(HoaDon hoaDon) {
        String sql = "INSERT INTO HoaDon (SoNguoiO, SoDien, TienPhong, TienDichVu, TienDien, TienNuoc, MaHoaDon, MaSoPhong) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, hoaDon.GetSoNguoiO());
            ps.setInt(2, hoaDon.GetSoDien());
            ps.setInt(3, hoaDon.GetTienPhong());
            ps.setInt(4, hoaDon.GetTienDichVu());
            ps.setInt(5, hoaDon.GetTienDien());
            ps.setInt(6, hoaDon.GetTienNuoc());
            ps.setString(7, hoaDon.GetMaHoaDon());
            ps.setString(8, hoaDon.GetMaPhong());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean XoaHoaDon(String MaHoaDon) {
        String sql = "DELETE FROM HoaDon WHERE MaHoaDon = ?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, MaHoaDon);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public ArrayList<HoaDon> getListHoaDon() {
        ArrayList<HoaDon> dsHoaDon = new ArrayList<>();
        String sql = "SELECT * FROM HoaDon";
        try (PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                HoaDon hoaDon = new HoaDon();
                hoaDon.SetSoNguoiO(rs.getInt("SoNguoiO")); 
                hoaDon.SetSoDien(rs.getInt("SoDien"));
                hoaDon.SetTienPhong();
                hoaDon.SetTienDichVu();
                hoaDon.SetTienDien();
                hoaDon.SetTienNuoc();
                hoaDon.SetMaHoaDon(rs.getString("MaHoaDon"));
                hoaDon.SetMaPhong(rs.getString("MaSoPhong"));
                dsHoaDon.add(hoaDon);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dsHoaDon;
    }

    public static void main(String[] args) {
        DAOHoaDon dao = new DAOHoaDon();
    }
}
