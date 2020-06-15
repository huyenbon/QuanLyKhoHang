package controller;

import model.CTDonDatHang;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author
 */
public class CTDonDatHangDao extends Dao {

    private final String order_by = "so_luong_dat";
    private final String order_dir = "DESC";
    private final String table = "ct_don_dat_hang";

    public CTDonDatHangDao() {
        super();
    }

    /**
     * Lấy danh sách phần tử
     *
     * @return
     */
    public ArrayList<CTDonDatHang> layDanhSachPhanTu(String maDonDH) {
        ArrayList<CTDonDatHang> danhsach = new ArrayList<>();
        String sql = "SELECT * FROM " + table + " INNER JOIN san_pham ON ct_don_dat_hang.ma_san_pham = san_pham.ma_san_pham WHERE ma_don_dh = ?" + " ORDER BY " + order_by + " " + order_dir;

        try {
            PreparedStatement ps = connect.prepareStatement(sql);
            ps.setString(1, maDonDH);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                CTDonDatHang ptu = new CTDonDatHang();

                ptu.setMaDonDH(rs.getString("ma_don_dh"));
                ptu.setMaSanPham(rs.getString("ma_san_pham"));
                ptu.setSoLuongDat(rs.getInt("so_luong_dat"));
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
    public boolean themPhanTu(CTDonDatHang ptu) {
        String sql = "INSERT INTO " + table + "(ma_don_dh, ma_san_pham, so_luong_dat) VALUES(?, ?, ?)";

        try {
            PreparedStatement ps = connect.prepareStatement(sql);

            ps.setString(1, ptu.getMaDonDH());
            ps.setString(2, ptu.getMaSanPham());
            ps.setInt(3, ptu.getSoLuongDat());

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
    public boolean capNhatPhanTu(CTDonDatHang ptu) {
        String sql = "UPDATE " + table + " SET so_luong_dat = ? WHERE ma_don_dh = ? AND ma_san_pham = ?";

        try {
            PreparedStatement ps = connect.prepareStatement(sql);

            ps.setInt(1, ptu.getSoLuongDat());
            ps.setString(2, ptu.getMaDonDH());
            ps.setString(3, ptu.getMaSanPham());

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
    public boolean xoaPhanTu(CTDonDatHang ptu) {
        String sql = "DELETE FROM " + table + " WHERE ma_don_dh = ? AND ma_san_pham = ?";

        try {
            PreparedStatement ps = connect.prepareStatement(sql);

            ps.setString(1, ptu.getMaDonDH());
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
