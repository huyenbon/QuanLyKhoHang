package controller;

import model.NhanVien;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author
 */
public class NhanVienDao extends Dao {

    private final String order_by = "ten_nhan_vien";
    private final String order_dir = "ASC";
    private final String table = "nhan_vien";

    public NhanVienDao() {
        super();
    }

    /**
     * Lấy danh sách phần tử
     *
     * @return
     */
    public ArrayList<NhanVien> layDanhSachPhanTu() {
        ArrayList<NhanVien> danhsach = new ArrayList<>();
        String sql = "SELECT * FROM " + table + " ORDER BY " + order_by + " " + order_dir;

        try {
            PreparedStatement ps = connect.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                NhanVien ptu = new NhanVien();

                ptu.setMaNhanVien(rs.getString("ma_nhan_vien"));
                ptu.setTenNhanVien(rs.getString("ten_nhan_vien"));
                ptu.setNgaySinh(rs.getDate("ngay_sinh"));
                ptu.setDiaChi(rs.getString("dia_chi"));
                ptu.setCMND(rs.getString("CMND"));

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
    public boolean themPhanTu(NhanVien ptu) {
        String sql = "INSERT INTO " + table + "(ma_nhan_vien, ten_nhan_vien, ngay_sinh, dia_chi, CMND) VALUES(?, ?, ?, ?, ?)";

        try {
            PreparedStatement ps = connect.prepareStatement(sql);

            ps.setString(1, ptu.getMaNhanVien());
            ps.setString(2, ptu.getTenNhanVien());
            ps.setDate(3, new Date(ptu.getNgaySinh().getTime()));
            ps.setString(4, ptu.getDiaChi());
            ps.setString(5, ptu.getCMND());

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
    public boolean capNhatPhanTu(NhanVien ptu) {
        String sql = "UPDATE " + table + " SET ten_nhan_vien = ?, ngay_sinh = ?, dia_chi = ?, CMND = ? WHERE ma_nhan_vien = ?";

        try {
            PreparedStatement ps = connect.prepareStatement(sql);

            ps.setString(1, ptu.getTenNhanVien());
            ps.setDate(2, new Date(ptu.getNgaySinh().getTime()));
            ps.setString(3, ptu.getDiaChi());
            ps.setString(4, ptu.getCMND());
            ps.setString(5, ptu.getMaNhanVien());

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
    public boolean xoaPhanTu(NhanVien ptu) {
        String sql = "DELETE FROM " + table + " WHERE ma_nhan_vien = ?";

        try {
            PreparedStatement ps = connect.prepareStatement(sql);

            ps.setString(1, ptu.getMaNhanVien());

            int isDone = ps.executeUpdate();

            ps.close();
            connect.close();
            return isDone > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
     public ArrayList<NhanVien> TimKiem(String query) {
        ArrayList<NhanVien> danhsach = new ArrayList<>();
        String sql = "SELECT * FROM " + table + " WHERE ma_nhan_vien = '" + query + "'";
        
        try {
            Statement sm = connect.createStatement();
            ResultSet rs = sm.executeQuery(sql);

            while (rs.next()) {
                NhanVien ptu = new NhanVien();

                ptu.setMaNhanVien(rs.getString("ma_nhan_vien"));
                ptu.setTenNhanVien(rs.getString("ten_nhan_vien"));
                ptu.setNgaySinh(rs.getDate("ngay_sinh"));
                ptu.setDiaChi(rs.getString("dia_chi"));
                ptu.setCMND(rs.getString("CMND"));

                danhsach.add(ptu);
            }
            rs.close();
            sm.close();
            connect.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return danhsach;
    }
}
