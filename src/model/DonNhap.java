package model;

import java.util.Date;

/**
 *
 * @author 
 */
public class DonNhap {
    private String maDonNhap;
    private Date ngayNhap;
    private String maDonDH;

    public DonNhap() {
    }

    public DonNhap(String maDonNhap, Date ngayNhap, String maDonDH) {
        this.maDonNhap = maDonNhap;
        this.ngayNhap = ngayNhap;
        this.maDonDH = maDonDH;
    }

    public String getMaDonNhap() {
        return maDonNhap;
    }

    public void setMaDonNhap(String maDonNhap) {
        this.maDonNhap = maDonNhap;
    }

    public Date getNgayNhap() {
        return ngayNhap;
    }

    public void setNgayNhap(Date ngayNhap) {
        this.ngayNhap = ngayNhap;
    }

    public String getMaDonDH() {
        return maDonDH;
    }

    public void setMaDonDH(String maDonDH) {
        this.maDonDH = maDonDH;
    }
}
