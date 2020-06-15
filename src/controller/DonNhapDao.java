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
}
