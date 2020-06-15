package controller;

import model.DonDatHang;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author
 */
public class DonDatHangDao extends Dao {

    private final String order_by = "ngay_dh";
    private final String order_dir = "DESC";
    private final String table = "don_dat_hang";

    public DonDatHangDao() {
        super();
    }

    /**
     * Lấy danh sách phần tử
     *
     * @return
     */
    public ArrayList<DonDatHang> layDanhSachPhanTu() {
        ArrayList<DonDatHang> danhsach = new ArrayList<>();
        String sql = "SELECT * FROM " + table + " INNER JOIN nha_cung_cap ON don_dat_hang.ma_nha_cc = nha_cung_cap.ma_nha_cc " + " ORDER BY " + order_by + " " + order_dir;

        try {
            PreparedStatement ps = connect.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                DonDatHang ptu = new DonDatHang();

                ptu.setMaDonDH(rs.getString("ma_don_dh"));
                ptu.setNgayDH(rs.getDate("ngay_dh"));
                ptu.setMaNhaCC(rs.getString("ma_nha_cc"));
                ptu.setTenNhaCC(rs.getString("ten_nha_cc"));

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
    public boolean themPhanTu(DonDatHang ptu) {
        String sql = "INSERT INTO " + table + "(ma_don_dh, ngay_dh, ma_nha_cc) VALUES(?, ?, ?)";

        try {
            PreparedStatement ps = connect.prepareStatement(sql);

            ps.setString(1, ptu.getMaDonDH());
            ps.setDate(2, new Date(ptu.getNgayDH().getTime()));
            ps.setString(3, ptu.getMaNhaCC());

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
    public boolean capNhatPhanTu(DonDatHang ptu) {
        String sql = "UPDATE " + table + " SET ngay_dh = ?, ma_nha_cc = ? WHERE ma_don_dh = ?";

        try {
            PreparedStatement ps = connect.prepareStatement(sql);

            ps.setDate(1, new Date(ptu.getNgayDH().getTime()));
            ps.setString(2, ptu.getMaNhaCC());
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
     * Xoá phần tử
     *
     * @param ptu
     * @return
     */
    public boolean xoaPhanTu(DonDatHang ptu) {
        String sql = "DELETE FROM " + table + " WHERE ma_don_dh = ?";

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
