package controller;

import model.SanPham;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author
 */
public class SanPhamDao extends Dao {

    private final String order_by = "ten_san_pham";
    private final String order_dir = "ASC";
    private final String table = "san_pham";

    public SanPhamDao() {
        super();
    }

    /**
     * Lấy danh sách phần tử
     *
     * @return
     */
    public ArrayList<SanPham> layDanhSachPhanTu() {
        ArrayList<SanPham> danhsach = new ArrayList<>();
        String sql = "SELECT * FROM " + table + " INNER JOIN danh_muc ON san_pham.ma_danh_muc = danh_muc.ma_danh_muc " + " ORDER BY " + order_by + " " + order_dir;

        try {
            PreparedStatement ps = connect.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                SanPham ptu = new SanPham();

                ptu.setMaSanPham(rs.getString("ma_san_pham"));
                ptu.setTenSanPham(rs.getString("ten_san_pham"));
                ptu.setDonViTinh(rs.getString("don_vi_tinh"));
                ptu.setDonGia(rs.getFloat("don_gia"));
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
    public boolean themPhanTu(SanPham ptu) {
        String sql = "INSERT INTO " + table + "(ma_san_pham, ten_san_pham, don_vi_tinh, don_gia, ma_danh_muc) VALUES(?, ?, ?, ?, ?)";

        try {
            PreparedStatement ps = connect.prepareStatement(sql);

            ps.setString(1, ptu.getMaSanPham());
            ps.setString(2, ptu.getTenSanPham());
            ps.setString(3, ptu.getDonViTinh());
            ps.setFloat(4, ptu.getDonGia());
            ps.setString(5, ptu.getMaDanhMuc());

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
    public boolean capNhatPhanTu(SanPham ptu) {
        String sql = "UPDATE " + table + " SET ten_san_pham = ?, don_vi_tinh = ?, don_gia = ?, ma_danh_muc = ? WHERE ma_san_pham = ?";

        try {
            PreparedStatement ps = connect.prepareStatement(sql);

            ps.setString(5, ptu.getMaSanPham());
            ps.setString(1, ptu.getTenSanPham());
            ps.setString(2, ptu.getDonViTinh());
            ps.setFloat(3, ptu.getDonGia());
            ps.setString(4, ptu.getMaDanhMuc());

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
    public boolean xoaPhanTu(SanPham ptu) {
        String sql = "DELETE FROM " + table + " WHERE ma_san_pham = ?";

        try {
            PreparedStatement ps = connect.prepareStatement(sql);

            ps.setString(1, ptu.getMaSanPham());

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
