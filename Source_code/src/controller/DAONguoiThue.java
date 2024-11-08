/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.NguoiThue;
import model.Phong;
/**
 *
 * @author MSI
 */
public class DAONguoiThue {
    private Connection con;

    public DAONguoiThue() {
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

    public boolean ThemNguoiThue(NguoiThue nguoiThue) {
        String sql = "INSERT INTO NguoiThue (MaSoPhong, MaNguoiThue, HoTen, DiaChi, GioiTinh, NgaySinh) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, nguoiThue.GetMaPhong());
            ps.setString(2, nguoiThue.GetMaNguoiThue());
            ps.setString(3, nguoiThue.GetHoTen());
            ps.setString(4, nguoiThue.GetDiaChi());
            ps.setString(5, nguoiThue.GetGioiTinh());
            ps.setDate(6, new java.sql.Date(nguoiThue.GetNgaySinh().getTime()));
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean SuaNguoiThue(NguoiThue nguoiThue) {
        String sql = "UPDATE NguoiThue SET MaSoPhong = ?, HoTen = ?, DiaChi = ?, GioiTinh = ?, NgaySinh = ? WHERE MaNguoiThue = ?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, nguoiThue.GetMaPhong());
            ps.setString(2, nguoiThue.GetHoTen());
            ps.setString(3, nguoiThue.GetDiaChi());
            ps.setString(4, nguoiThue.GetGioiTinh());
            ps.setDate(5, new java.sql.Date(nguoiThue.GetNgaySinh().getTime()));
            ps.setString(6, nguoiThue.GetMaNguoiThue());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean XoaNguoiThue(String MaNguoiThue) {
        String sql = "DELETE FROM NguoiThue WHERE MaNguoiThue = ?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, MaNguoiThue);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public ArrayList<NguoiThue> getListNguoiThue() {
        ArrayList<NguoiThue> dsNguoiThue = new ArrayList<>();
        String sql = "SELECT * FROM NguoiThue";
        try (PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                NguoiThue nguoiThue = new NguoiThue();
                nguoiThue.SetMaPhong(rs.getString("MaSoPhong"));
                nguoiThue.SetMaNguoiThue(rs.getString("MaNguoiThue"));
                nguoiThue.SetHoTen(rs.getString("HoTen"));
                nguoiThue.SetDiaChi(rs.getString("DiaChi"));
                nguoiThue.SetGioiTinh(rs.getString("GioiTinh"));
                nguoiThue.SetNgaySinh(rs.getDate("NgaySinh"));
                dsNguoiThue.add(nguoiThue);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dsNguoiThue;
    }

    public static void main(String[] args) {
        DAONguoiThue dao = new DAONguoiThue();
    }
}
