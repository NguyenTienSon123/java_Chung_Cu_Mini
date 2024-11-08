/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author MSI
 */
public class HoaDon {
    private int SoNguoiO, SoDien,TienDien, TienNuoc;
    private int TienPhong = 4000000, TienDichVu = 100000;
    private String MaHoaDon, MaPhong;
    public HoaDon() {
        
    }
    public void SetSoNguoiO(int SoNguoiO) {
        this.SoNguoiO = SoNguoiO;
    }
    public int GetSoNguoiO() {
        return SoNguoiO;
    }
    public void SetTienDien() {
        this.TienDien = SoDien * 2000;
    }
    public int GetTienDien() {
        return TienDien;
    }
    public void SetTienNuoc() {
        this.TienNuoc = SoNguoiO * 70000;
    }
    public int GetTienNuoc() {
        return TienNuoc;
    }
    public void SetMaHoaDon(String MaHoaDon){
        this.MaHoaDon = MaHoaDon;
    }
    public String GetMaHoaDon(){
        return MaHoaDon;
    }
    public void SetMaPhong(String MaPhong){
        this.MaPhong = MaPhong;
    }
    public String GetMaPhong(){
        return MaPhong;
    }
    public void SetSoDien(int SoDien){
        this.SoDien = SoDien;
    }
    public int GetSoDien(){
        return SoDien;
    }
    public void SetTienPhong(){
        this.TienPhong = 4000000;
    }
    public int GetTienPhong(){
        return TienPhong;
    }
    public void SetTienDichVu(){
        this.TienDichVu = 1000000;
    }
    public int GetTienDichVu(){
        return TienDichVu;
    }
}
