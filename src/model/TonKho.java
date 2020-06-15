package model;

import java.util.Date;

/**
 *
 * @author 
 */
public class TonKho {
    private Date ngayThang;
    private String maSanPham;
    private int soLuongDau;
    private int tongSoLuongNhap;
    private int tongSoLuongXuat;
    private int soLuongCuoi;

    public TonKho() {
    }

    public TonKho(Date ngayThang, String maSanPham, int soLuongDau, int tongSoLuongNhap, int tongSoLuongXuat, int soLuongCuoi) {
        this.ngayThang = ngayThang;
        this.maSanPham = maSanPham;
        this.soLuongDau = soLuongDau;
        this.tongSoLuongNhap = tongSoLuongNhap;
        this.tongSoLuongXuat = tongSoLuongXuat;
        this.soLuongCuoi = soLuongCuoi;
    }

    public Date getNgayThang() {
        return ngayThang;
    }

    public void setNgayThang(Date ngayThang) {
        this.ngayThang = ngayThang;
    }

    public String getMaSanPham() {
        return maSanPham;
    }

    public void setMaSanPham(String maSanPham) {
        this.maSanPham = maSanPham;
    }

    public int getSoLuongDau() {
        return soLuongDau;
    }

    public void setSoLuongDau(int soLuongDau) {
        this.soLuongDau = soLuongDau;
    }

    public int getTongSoLuongNhap() {
        return tongSoLuongNhap;
    }

    public void setTongSoLuongNhap(int tongSoLuongNhap) {
        this.tongSoLuongNhap = tongSoLuongNhap;
    }

    public int getTongSoLuongXuat() {
        return tongSoLuongXuat;
    }

    public void setTongSoLuongXuat(int tongSoLuongXuat) {
        this.tongSoLuongXuat = tongSoLuongXuat;
    }

    public int getSoLuongCuoi() {
        return soLuongCuoi;
    }

    public void setSoLuongCuoi(int soLuongCuoi) {
        this.soLuongCuoi = soLuongCuoi;
    }
}
