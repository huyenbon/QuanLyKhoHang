package controller;

import model.CTDonNhap;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author
 */
public class CTDonNhapDao extends Dao {

    private final String order_by = "so_luong_nhap";
    private final String order_dir = "DESC";
    private final String table = "ct_don_nhap";

    public CTDonNhapDao() {
        super();
    }

    /**
     * Lấy danh sách phần tử
     *
     * @return
     */
    public ArrayList<CTDonNhap> layDanhSachPhanTu(String maDonNhap) {
        ArrayList<CTDonNhap> danhsach = new ArrayList<>();
        String sql = "SELECT * FROM " + table + " INNER JOIN san_pham ON ct_don_nhap.ma_san_pham = san_pham.ma_san_pham WHERE ma_don_nhap = ?" + " ORDER BY " + order_by + " " + order_dir;

        try {
            PreparedStatement ps = connect.prepareStatement(sql);
            ps.setString(1, maDonNhap);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                CTDonNhap ptu = new CTDonNhap();

                ptu.setMaDonNhap(rs.getString("ma_don_nhap"));
                ptu.setMaSanPham(rs.getString("ma_san_pham"));
                ptu.setSoLuongNhap(rs.getInt("so_luong_nhap"));
                ptu.setDonGia(rs.getFloat("don_gia_nhap"));
                ptu.setTenSanPham(rs.getString("ten_san_pham"));

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
    public boolean themPhanTu(CTDonNhap ptu) {
        String sql = "INSERT INTO " + table + "(ma_don_nhap, ma_san_pham, so_luong_nhap, don_gia_nhap) VALUES(?, ?, ?, ?)";

        try {
            PreparedStatement ps = connect.prepareStatement(sql);

            ps.setString(1, ptu.getMaDonNhap());
            ps.setString(2, ptu.getMaSanPham());
            ps.setInt(3, ptu.getSoLuongNhap());
            ps.setFloat(4, ptu.getDonGia());

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
    public boolean capNhatPhanTu(CTDonNhap ptu) {
        String sql = "UPDATE " + table + " SET so_luong_nhap = ?, don_gia_nhap = ? WHERE ma_don_nhap = ? AND ma_san_pham = ?";

        try {
            PreparedStatement ps = connect.prepareStatement(sql);

            ps.setInt(1, ptu.getSoLuongNhap());
            ps.setFloat(2, ptu.getDonGia());
            ps.setString(3, ptu.getMaDonNhap());
            ps.setString(4, ptu.getMaSanPham());

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
    public boolean xoaPhanTu(CTDonNhap ptu) {
        String sql = "DELETE FROM " + table + " WHERE ma_don_nhap = ? AND ma_san_pham = ?";

        try {
            PreparedStatement ps = connect.prepareStatement(sql);

            ps.setString(1, ptu.getMaDonNhap());
            ps.setString(2, ptu.getMaSanPham());

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
