package controller;

import model.NhaCungCap;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author
 */
public class NhaCungCapDao extends Dao {

    private final String order_by = "ten_nha_cc";
    private final String order_dir = "ASC";
    private final String table = "nha_Cung_cap";

    public NhaCungCapDao() {
        super();
    }

    /**
     * Lấy danh sách phần tử
     *
     * @return
     */
    public ArrayList<NhaCungCap> layDanhSachPhanTu() {
        ArrayList<NhaCungCap> danhsach = new ArrayList<>();
        String sql = "SELECT * FROM " + table + " ORDER BY " + order_by + " " + order_dir;

        try {
            PreparedStatement ps = connect.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                NhaCungCap ptu = new NhaCungCap();

                ptu.setMaNhaCC(rs.getString("ma_nha_cc"));
                ptu.setTenNhaCC(rs.getString("ten_nha_cc"));
                ptu.setDiaChi(rs.getString("dia_chi"));
                ptu.setSoDienThoai(rs.getString("so_dien_thoai"));
                
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
    public boolean themPhanTu(NhaCungCap ptu) {
        String sql = "INSERT INTO " + table + "(ma_nha_cc, ten_nha_cc, dia_chi, so_dien_thoai) VALUES(?, ?, ?, ?)";

        try {
            PreparedStatement ps = connect.prepareStatement(sql);

            ps.setString(1, ptu.getMaNhaCC());
            ps.setString(2, ptu.getTenNhaCC());
            ps.setString(3, ptu.getDiaChi());
            ps.setString(4, ptu.getSoDienThoai());

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
    public boolean capNhatPhanTu(NhaCungCap ptu) {
        String sql = "UPDATE " + table + " SET ten_nha_cc = ?, dia_chi = ?, so_dien_thoai = ? WHERE ma_nha_cc = ?";

        try {
            PreparedStatement ps = connect.prepareStatement(sql);

            ps.setString(4, ptu.getMaNhaCC());
            ps.setString(1, ptu.getTenNhaCC());
            ps.setString(2, ptu.getDiaChi());
            ps.setString(3, ptu.getSoDienThoai());

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
    public boolean xoaPhanTu(NhaCungCap ptu) {
        String sql = "DELETE FROM " + table + " WHERE ma_nha_cc = ?";

        try {
            PreparedStatement ps = connect.prepareStatement(sql);

            ps.setString(1, ptu.getMaNhaCC());

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
