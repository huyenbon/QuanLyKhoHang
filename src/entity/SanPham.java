/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author ADMIN
 */
public class SanPham {
    private String maSP;
    private String tenSP;
    private float donGia;
    private String loaiSP;
    private String donViTinh;

    public SanPham() {
    }

    public SanPham(String maSP, String tenSP, float donGia, String loaiSP, String donViTinh) {
        this.maSP = maSP;
        this.tenSP = tenSP;
        this.donGia = donGia;
        this.loaiSP = loaiSP;
        this.donViTinh = donViTinh;
    }

    public String getMaSP() {
        return maSP;
    }

    public void setMaSP(String maSP) {
        this.maSP = maSP;
    }

    public String getTenSP() {
        return tenSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public float getDonGia() {
        return donGia;
    }

    public void setDonGia(float donGia) {
        this.donGia = donGia;
    }

    public String getLoaiSP() {
        return loaiSP;
    }

    public void setLoaiSP(String loaiSP) {
        this.loaiSP = loaiSP;
    }

    public String getDonViTinh() {
        return donViTinh;
    }

    public void setDonViTinh(String donViTinh) {
        this.donViTinh = donViTinh;
    }
    
}
