package controller;

import model.DanhMuc;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author
 */
public class DanhMucDao extends Dao {

    private final String order_by = "ten_danh_muc";
    private final String order_dir = "ASC";
    private final String table = "danh_muc";

    public DanhMucDao() {
        super();
    }

    /**
     * Lấy danh sách phần tử
     *
     * @return
     */
    public ArrayList<DanhMuc> layDanhSachPhanTu() {
        ArrayList<DanhMuc> danhsach = new ArrayList<>();
        String sql = "SELECT * FROM " + table + " ORDER BY " + order_by + " " + order_dir;

        try {
            PreparedStatement ps = connect.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                DanhMuc ptu = new DanhMuc();

                ptu.setMaDanhMuc(rs.getString("ma_danh_muc"));
                ptu.setTenDanhMuc(rs.getString("ten_danh_muc"));

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
    public boolean themPhanTu(DanhMuc ptu) {
        String sql = "INSERT INTO " + table + "(ma_danh_muc, ten_danh_muc) VALUES(?, ?)";

        try {
            PreparedStatement ps = connect.prepareStatement(sql);

            ps.setString(1, ptu.getMaDanhMuc());
            ps.setString(2, ptu.getTenDanhMuc());

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
    public boolean capNhatPhanTu(DanhMuc ptu) {
        String sql = "UPDATE " + table + " SET ten_danh_muc = ? WHERE ma_danh_muc = ?";

        try {
            PreparedStatement ps = connect.prepareStatement(sql);

            ps.setString(1, ptu.getTenDanhMuc());
            ps.setString(2, ptu.getMaDanhMuc());

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
    public boolean xoaPhanTu(DanhMuc ptu) {
        String sql = "DELETE FROM " + table + " WHERE ma_danh_muc = ?";

        try {
            PreparedStatement ps = connect.prepareStatement(sql);

            ps.setString(1, ptu.getMaDanhMuc());

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
