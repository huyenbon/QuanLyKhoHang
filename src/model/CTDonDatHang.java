package model;

/**
 *
 * @author 
 */
public class CTDonDatHang {
    private String maDonDH;
    private String maSanPham;
    private int soLuongDat;
    private String tenSanPham;

    public CTDonDatHang() {
    }

    public CTDonDatHang(String maDonDH, String maSanPham, int soLuongDat) {
        this.maDonDH = maDonDH;
        this.maSanPham = maSanPham;
        this.soLuongDat = soLuongDat;
    }

    public String getMaDonDH() {
        return maDonDH;
    }

    public void setMaDonDH(String maDonDH) {
        this.maDonDH = maDonDH;
    }

    public String getMaSanPham() {
        return maSanPham;
    }

    public void setMaSanPham(String maSanPham) {
        this.maSanPham = maSanPham;
    }

    public int getSoLuongDat() {
        return soLuongDat;
    }

    public void setSoLuongDat(int soLuongDat) {
        this.soLuongDat = soLuongDat;
    }

    public String getTenSanPham() {
        return tenSanPham;
    }

    public void setTenSanPham(String tenSanPham) {
        this.tenSanPham = tenSanPham;
    }
}
