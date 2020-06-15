package controller;

import model.KhachHang;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author
 */
public class KhachHangDao extends Dao {

    private final String order_by = "ten_khach_hang";
    private final String order_dir = "ASC";
    private final String table = "khach_hang";

    public KhachHangDao() {
        super();
    }

    /**
     * Lấy danh sách phần tử
     *
     * @return
     */
    public ArrayList<KhachHang> layDanhSachPhanTu() {
        ArrayList<KhachHang> danhsach = new ArrayList<>();
        String sql = "SELECT * FROM " + table + " ORDER BY " + order_by + " " + order_dir;

        try {
            PreparedStatement ps = connect.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                KhachHang ptu = new KhachHang();

                ptu.setMaKhachHang(rs.getString("ma_khach_hang"));
                ptu.setTenKhachHang(rs.getString("ten_khach_hang"));
                ptu.setSoDienThoai(rs.getString("so_dien_thoai"));
                ptu.setDiaChi(rs.getString("dia_chi"));
                ptu.setCMND(rs.getString("CMND"));
                ptu.setThanThiet(rs.getInt("than_thiet"));

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
    public boolean themPhanTu(KhachHang ptu) {
        String sql = "INSERT INTO " + table + "(ma_khach_hang, ten_khach_hang, so_dien_thoai, dia_chi, CMND) VALUES(?, ?, ?, ?, ?)";

        try {
            PreparedStatement ps = connect.prepareStatement(sql);

            ps.setString(1, ptu.getMaKhachHang());
            ps.setString(2, ptu.getTenKhachHang());
            ps.setString(3, ptu.getSoDienThoai());
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
    public boolean capNhatPhanTu(KhachHang ptu) {
        String sql = "UPDATE " + table + " SET ten_khach_hang = ?, so_dien_thoai = ?, dia_chi = ?, CMND = ? WHERE ma_khach_hang = ?";

        try {
            PreparedStatement ps = connect.prepareStatement(sql);

            ps.setString(1, ptu.getTenKhachHang());
            ps.setString(2, ptu.getSoDienThoai());
            ps.setString(3, ptu.getDiaChi());
            ps.setString(4, ptu.getCMND());
            ps.setString(5, ptu.getMaKhachHang());

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
    public boolean xoaPhanTu(KhachHang ptu) {
        String sql = "DELETE FROM " + table + " WHERE ma_khach_hang = ?";

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
    
    public boolean capNhatKhachHangThanThiet(KhachHang ptu, int thanThiet) {
        String sql = "UPDATE " + table + " SET than_thiet = ? WHERE ma_khach_hang = ?";
        try {
            PreparedStatement ps = connect.prepareStatement(sql);

            ps.setInt(1, thanThiet);
            ps.setString(2, ptu.getMaKhachHang());

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
