package model;

/**
 *
 * @author 
 */
public class CTDonNhap {
    private String maDonNhap;
    private String maSanPham;
    private int soLuongNhap;
    private float donGia;
    private String tenSanPham;

    public CTDonNhap() {
    }

    public CTDonNhap(String maDonNhap, String maSanPham, int soLuongNhap, float donGia) {
        this.maDonNhap = maDonNhap;
        this.maSanPham = maSanPham;
        this.soLuongNhap = soLuongNhap;
        this.donGia = donGia;
    }

    public String getMaDonNhap() {
        return maDonNhap;
    }

    public void setMaDonNhap(String maDonNhap) {
        this.maDonNhap = maDonNhap;
    }

    public String getMaSanPham() {
        return maSanPham;
    }

    public void setMaSanPham(String maSanPham) {
        this.maSanPham = maSanPham;
    }

    public int getSoLuongNhap() {
        return soLuongNhap;
    }

    public void setSoLuongNhap(int soLuongNhap) {
        this.soLuongNhap = soLuongNhap;
    }

    public float getDonGia() {
        return donGia;
    }

    public void setDonGia(float donGia) {
        this.donGia = donGia;
    }

    public String getTenSanPham() {
        return tenSanPham;
    }

    public void setTenSanPham(String tenSanPham) {
        this.tenSanPham = tenSanPham;
    }
}
