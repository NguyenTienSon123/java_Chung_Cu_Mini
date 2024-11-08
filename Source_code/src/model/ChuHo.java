/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.Serializable;

/**
 *
 * @author MSI
 */
public class ChuHo extends NguoiThue implements Serializable{
    private String MaChuHo;
    public ChuHo() {
        
    }
    public void SetMaChuHo(String MaChuHo){
        this.MaChuHo = MaChuHo;
    }
    public String GetMaChuHo() {
        return MaChuHo;
    }
}
