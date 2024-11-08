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
public class Phong implements Serializable{
    private String MaSoPhong;
    private int SoNguoiO ;
    private Date NgayBatDauThue;
    public Phong() {
        
    }
    public void SetMaSoPhong(String MaSoPhong) {
        this.MaSoPhong = MaSoPhong;
    }
    public String GetMaSoPhong() {
        return MaSoPhong;
    }
    public void SetSoNguoiO(int SoNguoiO) {
        this.SoNguoiO = SoNguoiO;
    }
    public int GetSoNguoiO() {
        return SoNguoiO;
    }
    public void SetNgayBatDauThue(Date NgayBatDauThue) {
        this.NgayBatDauThue = NgayBatDauThue;
    }
    public Date GetNgayBatDauThue() {
        return NgayBatDauThue;
    }
}
