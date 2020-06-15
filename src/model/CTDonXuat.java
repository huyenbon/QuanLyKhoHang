package model;

/**
 *
 * @author 
 */
public class CTDonXuat {
    private String maDonXuat;
    private String maSanPham;
    private int soLuongXuat;
    private float donGia;
    private String tenSanPham;

    public CTDonXuat() {
    }

    public CTDonXuat(String maDonXuat, String maSanPham, int soLuongXuat, float donGia) {
        this.maDonXuat = maDonXuat;
        this.maSanPham = maSanPham;
        this.soLuongXuat = soLuongXuat;
        this.donGia = donGia;
    }

    public String getMaDonXuat() {
        return maDonXuat;
    }

    public void setMaDonXuat(String maDonXuat) {
        this.maDonXuat = maDonXuat;
    }

    public String getMaSanPham() {
        return maSanPham;
    }

    public void setMaSanPham(String maSanPham) {
        this.maSanPham = maSanPham;
    }

    public int getSoLuongXuat() {
        return soLuongXuat;
    }

    public void setSoLuongXuat(int soLuongXuat) {
        this.soLuongXuat = soLuongXuat;
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
