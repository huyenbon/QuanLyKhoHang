package controller;

import model.CTDonXuat;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author
 */
public class CTDonXuatDao extends Dao {

    private final String order_by = "so_luong_xuat";
    private final String order_dir = "DESC";
    private final String table = "ct_don_xuat";

    public CTDonXuatDao() {
        super();
    }

    /**
     * Lấy danh sách phần tử
     *
     * @return
     */
    public ArrayList<CTDonXuat> layDanhSachPhanTu(String maDonXuat) {
        ArrayList<CTDonXuat> danhsach = new ArrayList<>();
        String sql = "SELECT * FROM " + table + " INNER JOIN san_pham ON ct_don_xuat.ma_san_pham = san_pham.ma_san_pham WHERE ma_don_xuat = ?" + " ORDER BY " + order_by + " " + order_dir;

        try {
            PreparedStatement ps = connect.prepareStatement(sql);
            ps.setString(1, maDonXuat);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                CTDonXuat ptu = new CTDonXuat();

                ptu.setMaDonXuat(rs.getString("ma_don_xuat"));
                ptu.setMaSanPham(rs.getString("ma_san_pham"));
                ptu.setSoLuongXuat(rs.getInt("so_luong_xuat"));
                ptu.setDonGia(rs.getFloat("don_gia_xuat"));
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
    public boolean themPhanTu(CTDonXuat ptu) {
        String sql = "INSERT INTO " + table + "(ma_don_xuat, ma_san_pham, so_luong_xuat, don_gia_xuat) VALUES(?, ?, ?, ?)";

        try {
            PreparedStatement ps = connect.prepareStatement(sql);

            ps.setString(1, ptu.getMaDonXuat());
            ps.setString(2, ptu.getMaSanPham());
            ps.setInt(3, ptu.getSoLuongXuat());
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
    public boolean capNhatPhanTu(CTDonXuat ptu) {
        String sql = "UPDATE " + table + " SET so_luong_xuat = ?, don_gia_xuat = ? WHERE ma_don_xuat = ? AND ma_san_pham = ?";

        try {
            PreparedStatement ps = connect.prepareStatement(sql);

            ps.setInt(1, ptu.getSoLuongXuat());
            ps.setFloat(2, ptu.getDonGia());
            ps.setString(3, ptu.getMaDonXuat());
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
    public boolean xoaPhanTu(CTDonXuat ptu) {
        String sql = "DELETE FROM " + table + " WHERE ma_don_xuat = ? AND ma_san_pham = ?";

        try {
            PreparedStatement ps = connect.prepareStatement(sql);

            ps.setString(1, ptu.getMaDonXuat());
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
