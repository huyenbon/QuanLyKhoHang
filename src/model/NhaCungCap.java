package model;

/**
 *
 * @author
 */
public class NhaCungCap {
    private String maNhaCC;
    private String tenNhaCC;
    private String diaChi;
    private String soDienThoai;

    public NhaCungCap() {
    }

    public NhaCungCap(String maNhaCC, String tenNhaCC, String diaChi, String soDienThoai) {
        this.maNhaCC = maNhaCC;
        this.tenNhaCC = tenNhaCC;
        this.diaChi = diaChi;
        this.soDienThoai = soDienThoai;
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

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }
    
}
