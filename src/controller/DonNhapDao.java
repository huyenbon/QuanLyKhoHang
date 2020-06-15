package controller;

import model.DonNhap;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author
 */
public class DonNhapDao extends Dao {

    private final String order_by = "ngay_nhap";
    private final String order_dir = "DESC";
    private final String table = "don_nhap";

    public DonNhapDao() {
        super();
    }

    /**
     * Lấy danh sách phần tử
     *
     * @return
     */
    public ArrayList<DonNhap> layDanhSachPhanTu() {
        ArrayList<DonNhap> danhsach = new ArrayList<>();
        String sql = "SELECT * FROM " + table + " ORDER BY " + order_by + " " + order_dir;

        try {
            PreparedStatement ps = connect.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                DonNhap ptu = new DonNhap();

                ptu.setMaDonNhap(rs.getString("ma_don_nhap"));
                ptu.setNgayNhap(rs.getDate("ngay_nhap"));
                ptu.setMaDonDH(rs.getString("ma_don_dh"));

                danhsach.add(ptu);
            }

            rs.close();
            ps.close();
            connect.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return danhsach;
    }

    /**
     * Thêm mới phần tử
     *
     * @param ptu
     * @return
     */
    public boolean themPhanTu(DonNhap ptu) {
        String sql = "INSERT INTO " + table + "(ma_don_nhap, ngay_nhap, ma_don_dh) VALUES(?, ?, ?)";

        try {
            PreparedStatement ps = connect.prepareStatement(sql);

            ps.setString(1, ptu.getMaDonNhap());
            ps.setDate(2, new Date(ptu.getNgayNhap().getTime()));
            ps.setString(3, ptu.getMaDonDH());

            int isDone = ps.executeUpdate();
            ps.close();
            connect.close();
            return isDone > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * Cập nhật phần tử
     *
     * @param ptu
     * @return
     */
    public boolean capNhatPhanTu(DonNhap ptu) {
        String sql = "UPDATE " + table + " SET ngay_nhap = ? WHERE ma_don_nhap = ?";

        try {
            PreparedStatement ps = connect.prepareStatement(sql);

            ps.setDate(1, new Date(ptu.getNgayNhap().getTime()));
            ps.setString(2, ptu.getMaDonNhap());

            int isDone = ps.executeUpdate();

            ps.close();
            connect.close();
            return isDone > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * Xoá phần tử
     *
     * @param ptu
     * @return
     */
    public boolean xoaPhanTu(DonNhap ptu) {
        String sql = "DELETE FROM " + table + " WHERE ma_don_nhap = ?";

        try {
            PreparedStatement ps = connect.prepareStatement(sql);

            ps.setString(1, ptu.getMaDonDH());

            int isDone = ps.executeUpdate();

            ps.close();
            connect.close();
            return isDone > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    
    /**
     * Thống kê theo quý
     * @param quy
     * @param nam
     * @return 
     */
    public ArrayList<DonNhap> thongKeTheoQuy(int quy, int nam) {
        ArrayList<DonNhap> danhsach = new ArrayList<>();
        String thang = null;
        switch(quy) {
            case 1: 
                thang = " MONTH(don_nhap.ngay_nhap) BETWEEN 0 AND 2 ";
                break;
            case 2: 
                thang = " MONTH(don_nhap.ngay_nhap) BETWEEN 3 AND 5 ";
                break;
            case 3: 
                thang = " MONTH(don_nhap.ngay_nhap) BETWEEN 6 AND 8 ";
                break;
            case 4: 
                thang = " MONTH(don_nhap.ngay_nhap) BETWEEN 9 AND 11 ";
                break;
        }
        String sql = "SELECT don_nhap.ma_don_nhap, don_nhap.ma_don_dh, SUM(ct_don_nhap.so_luong_nhap * ct_don_nhap.don_gia_nhap) 'tong_tien' "
                + "FROM don_nhap INNER JOIN ct_don_nhap ON don_nhap.ma_don_nhap = ct_don_nhap.ma_don_nhap WHERE YEAR(don_nhap.ngay_nhap) = ? AND" + thang
                + "GROUP BY YEAR(don_nhap.ngay_nhap), MONTH(don_nhap.ngay_nhap)";
        try {
            PreparedStatement ps = connect.prepareStatement(sql);
            ps.setInt(1, nam);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                DonNhap ptu = new DonNhap();

                ptu.setMaDonNhap(rs.getString("ma_don_nhap"));
                ptu.setMaDonDH(rs.getString("ma_don_dh"));
                ptu.setTongTien(rs.getFloat("tong_tien"));

                danhsach.add(ptu);
            }

            rs.close();
            ps.close();
            connect.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return danhsach;
    }
}
