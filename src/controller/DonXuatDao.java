package controller;

import model.DonXuat;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author
 */
public class DonXuatDao extends Dao {

    private final String order_by = "ngay_xuat";
    private final String order_dir = "DESC";
    private final String table = "don_xuat";

    public DonXuatDao() {
        super();
    }

    /**
     * Lấy danh sách phần tử
     *
     * @return
     */
    public ArrayList<DonXuat> layDanhSachPhanTu() {
        ArrayList<DonXuat> danhsach = new ArrayList<>();
        String sql = "SELECT * FROM " + table + " ORDER BY " + order_by + " " + order_dir;

        try {
            PreparedStatement ps = connect.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                DonXuat ptu = new DonXuat();

                ptu.setMaDonXuat(rs.getString("ma_don_xuat"));
                ptu.setNgayXuat(rs.getDate("ngay_xuat"));
                ptu.setMaKhachHang(rs.getString("ma_khach_hang"));

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
    public boolean themPhanTu(DonXuat ptu) {
        String sql = "INSERT INTO " + table + "(ma_don_xuat, ngay_xuat, ma_khach_hang) VALUES(?, ?, ?)";

        try {
            PreparedStatement ps = connect.prepareStatement(sql);

            ps.setString(1, ptu.getMaDonXuat());
            ps.setDate(2, new Date(ptu.getNgayXuat().getTime()));
            ps.setString(3, ptu.getMaKhachHang());

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
    public boolean capNhatPhanTu(DonXuat ptu) {
        String sql = "UPDATE " + table + " SET ngay_xuat = ? WHERE ma_don_xuat = ?";

        try {
            PreparedStatement ps = connect.prepareStatement(sql);

            ps.setDate(1, new Date(ptu.getNgayXuat().getTime()));
            ps.setString(2, ptu.getMaDonXuat());

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
    public boolean xoaPhanTu(DonXuat ptu) {
        String sql = "DELETE FROM " + table + " WHERE ma_don_xuat = ?";

        try {
            PreparedStatement ps = connect.prepareStatement(sql);

            ps.setString(1, ptu.getMaKhachHang());

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
