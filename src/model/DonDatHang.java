package model;

import java.util.Date;

/**
 *
 * @author
 */
public class DonDatHang {

    private String maDonDH;
    private Date ngayDH;
    private String maNhaCC;
    private String tenNhaCC;

    public DonDatHang() {
    }

    public DonDatHang(String maDonDH, Date ngayDH, String maNhaCC) {
        this.maDonDH = maDonDH;
        this.ngayDH = ngayDH;
        this.maNhaCC = maNhaCC;
    }

    public String getMaDonDH() {
        return maDonDH;
    }

    public void setMaDonDH(String maDonDH) {
        this.maDonDH = maDonDH;
    }

    public Date getNgayDH() {
        return ngayDH;
    }

    public void setNgayDH(Date ngayDH) {
        this.ngayDH = ngayDH;
    }

    public String getMaNhaCC() {
        return maNhaCC;
    }

    public void setMaNhaCC(String maNhaCC) {
        this.maNhaCC = maNhaCC;
    }

    public String getTenNhaCC() {
        return tenNhaCC;
    }

    public void setTenNhaCC(String tenNhaCC) {
        this.tenNhaCC = tenNhaCC;
    }

}
