package model;

import java.util.Date;

/**
 *
 * @author 
 */
public class DonXuat {
    private String maDonXuat;
    private Date ngayXuat;
    private String maKhachHang;

    public DonXuat() {
    }

    public DonXuat(String maDonXuat, Date ngayXuat, String maKhachHang) {
        this.maDonXuat = maDonXuat;
        this.ngayXuat = ngayXuat;
        this.maKhachHang = maKhachHang;
    }

    public String getMaDonXuat() {
        return maDonXuat;
    }

    public void setMaDonXuat(String maDonXuat) {
        this.maDonXuat = maDonXuat;
    }

    public Date getNgayXuat() {
        return ngayXuat;
    }

    public void setNgayXuat(Date ngayXuat) {
        this.ngayXuat = ngayXuat;
    }

    public String getMaKhachHang() {
        return maKhachHang;
    }

    public void setMaKhachHang(String maKhachHang) {
        this.maKhachHang = maKhachHang;
    }
}
