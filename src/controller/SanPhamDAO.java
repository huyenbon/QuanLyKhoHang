/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.SanPham;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author ADMIN
 */
public class SanPhamDAO extends DAO {

    public SanPhamDAO() {
        super();
    }

    /**
     * Lấy danh sách sản phẩm
     *
     * @return
     */
    public ArrayList<SanPham> getItems() {
        ArrayList<SanPham> items = new ArrayList<>();
        String sql = "SELECT * FROM sanpham"; // Câu lệnh sql

        try {
            PreparedStatement ps = conn.prepareStatement(sql); // Thực hiện câu lệnh sql
            ResultSet rs = ps.executeQuery(); // Lấy danh sách sản phẩm vào biến rs

            // Lặp mảng kết quả rs
            while (rs.next()) {
                SanPham item = new SanPham();

                item.setMaSP(rs.getString("maSP"));
                item.setTenSP(rs.getString("tenSP"));
                item.setLoaiSP(rs.getString("loaiSP"));
                item.setDonViTinh(rs.getString("donViTinh"));
                item.setDonGia(rs.getFloat("donGia"));

                items.add(item);
            }
        } catch (SQLException e) {
        }
        return items;
    }

    /**
     * Thêm mới sản phẩm vào CSDL
     */
    public boolean addItem(SanPham sp) {
        String sql = "INSERT INTO sanpham(maSP, tenSP, donGia, donViTinh, loaiSP) VALUES(?, ?, ?, ?, ?)";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);

            // Set giá trị vào từng dấu ? trên câu lệnh sql
            ps.setString(1, sp.getMaSP());
            ps.setString(2, sp.getTenSP());
            ps.setFloat(3, sp.getDonGia());
            ps.setString(4, sp.getDonViTinh());
            ps.setString(5, sp.getLoaiSP());

            // Thực hiện câu truy vấn
            // giá trị < 0 -> thất bại, > 0 -> thành công
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
        }
        return false;
    }

    /**
     * Xóa sản phẩm
     */
    public boolean deleteItem(SanPham sp) {
        String sql = "DELETE FROM sanpham WHERE maSP = ?";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, sp.getMaSP());

            return ps.executeUpdate() > 0;
        } catch (Exception e) {
        }
        return false;
    }

    /**
     * Cập nhật sản phẩm
     */
    public boolean updateItem(SanPham sp) {
        String sql = "UPDATE sanpham SET tenSP = ?, donGia = ?, loaiSP = ?, donViTinh = ?";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, sp.getTenSP());
            ps.setFloat(2, sp.getDonGia());
            ps.setString(3, sp.getLoaiSP());
            ps.setString(4, sp.getDonViTinh());

            return ps.executeUpdate() > 0;

        } catch (Exception e) {
        }
        return false;
    }
}
