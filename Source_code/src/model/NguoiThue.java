/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author MSI
 */
public class NguoiThue implements Serializable{
    private String MaPhong, MaNguoiThue, HoTen, DiaChi, GioiTinh;
    private Date NgaySinh;
    public NguoiThue() {
        
    }
    public void SetMaPhong(String MaPhong) {
        this.MaPhong = MaPhong;
    }
    public String GetMaPhong() {
        return MaPhong;
    }
    public void SetMaNguoiThue(String MaNguoiThue) {
        this.MaNguoiThue = MaNguoiThue;
    }
    public String GetMaNguoiThue() {
        return MaNguoiThue;
    }
    public void SetHoTen(String HoTen) {
        this.HoTen = HoTen;
    }
    public String GetHoTen() {
        return HoTen;
    }
    public void SetDiaChi(String DiaChi) {
        this.DiaChi = DiaChi;
    }
    public String GetDiaChi() {
        return DiaChi;
    }
    public void SetGioiTinh(String GioiTinh) {
        this.GioiTinh = GioiTinh;
    }
    public String GetGioiTinh() {
        return GioiTinh;
    }
    public void SetNgaySinh(Date NgaySinh) {
        this.NgaySinh = NgaySinh;
    }
    public Date GetNgaySinh() {
        return NgaySinh;
    }
}
