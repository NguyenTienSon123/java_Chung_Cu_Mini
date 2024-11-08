/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.HashSet;
import java.sql.PreparedStatement;
import model.ChuHo;
import model.NguoiThue;
import model.Phong;

/**
 *
 * @author MSI
 */
public class DAOChuHo {
    private Connection con;

    public DAOChuHo() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/QuanLyChungCu", "root", "");
        } catch (Exception e) {
            System.out.println("Kết nối không thành công");
            e.printStackTrace();
        }
    }

    public boolean ThemChuHo(ChuHo chuHo) {
        String sql2 = "INSERT INTO ChuHo (MaChuHo, MaSoPhong, MaNguoiThue, HoTen, DiaChi, GioiTinh, NgaySinh) VALUES (?,?,?,?,?,?,?)";
        try (PreparedStatement ps2 = con.prepareStatement(sql2)) {
            ps2.setString(1, chuHo.GetMaChuHo());
            ps2.setString(2, chuHo.GetMaPhong());
            ps2.setString(3, chuHo.GetMaNguoiThue());
            ps2.setString(4, chuHo.GetHoTen());
            ps2.setString(5, chuHo.GetDiaChi());
            ps2.setString(6, chuHo.GetGioiTinh());
            ps2.setDate(7, new java.sql.Date(chuHo.GetNgaySinh().getTime()));
            return ps2.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean XoaCHuHo(String MaChuHo) {
        String sql = "DELETE FROM ChuHo WHERE MaChuHo = ?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, MaChuHo);
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public ArrayList<ChuHo> getlistChuHo() {
        ArrayList<ChuHo> dsChuHo = new ArrayList<>();
        String sql = "SELECT * FROM ChuHo";
        try {
            var ps = con.prepareStatement(sql);
            var rs = ps.executeQuery();
            while (rs.next()) {
                ChuHo chuHo = new ChuHo();
                chuHo.SetMaChuHo(rs.getString("MaChuHo"));
                chuHo.SetMaPhong(rs.getString("MaSoPhong"));
                chuHo.SetMaNguoiThue(rs.getString("MaNguoiThue"));
                chuHo.SetHoTen(rs.getString("HoTen"));
                chuHo.SetDiaChi(rs.getString("DiaChi"));
                chuHo.SetGioiTinh(rs.getString("GioiTinh"));
                chuHo.SetNgaySinh(rs.getDate("NgaySinh"));
                dsChuHo.add(chuHo);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dsChuHo;
    }

    public static void main(String[] args) {
        new DAOChuHo();
    }
}
