package views;

import controller.KhachHangDao;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.KhachHang;

/**
 *
 * @author
 */
public class KhachHangFrame extends javax.swing.JFrame {

    private final String[] tieuDe = {"STT", "Mã khách hàng", "Tên khách hàng", "Số điện thoại", "Địa chỉ", "CMND", "Thân thiết"};
    private ArrayList<KhachHang> danhsach = new ArrayList<>();
    private int viTri;
    private DefaultTableModel model;

    /**
     * Creates new form NhanVienFrame
     */
    public KhachHangFrame() {
        initComponents();
        setLocationRelativeTo(null);

        model = (DefaultTableModel) tblDanhSach.getModel();
        model.setColumnIdentifiers(tieuDe);
        hienThiDanhSach();
    }

    /**
     * Hiển thị các hàng của bảng
     */
    public void hienThiDanhSach() {
        danhsach = new KhachHangDao().layDanhSachPhanTu();
        model.setRowCount(0);
        for (KhachHang ptu : danhsach) {
            model.addRow(new Object[]{
                model.getRowCount() + 1, ptu.getMaKhachHang(), ptu.getTenKhachHang(), ptu.getSoDienThoai(), ptu.getDiaChi(), ptu.getCMND(), ptu.getThanThiet() == 1 ? "Có" : "Không"
            });
        }
    }

    /**
     * Thay đổi trạng thái các nút
     *
     * @param trangThaiThemMoi
     * @param trangThaiCapNhat
     * @param trangThaiXoa
     */
    public void thayDoiTrangThaiButton(boolean trangThaiThemMoi, boolean trangThaiCapNhat, boolean trangThaiXoa, boolean trangThaiThanThiet) {
        btnThemMoi.setEnabled(trangThaiThemMoi);
        btnCapNhat.setEnabled(trangThaiCapNhat);
        btnXoa.setEnabled(trangThaiXoa);
        btnThanThiet.setEnabled(trangThaiThanThiet);
        btnThanThiet.setText("Thân thiết");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        btnQuayLai = new javax.swing.JButton();
        btnThemMoi = new javax.swing.JButton();
        btnCapNhat = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDanhSach = new javax.swing.JTable();
        btnThanThiet = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Quản lý khách hàng thân thiết");

        jLabel1.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Quản lý khách hàng thân thiết");

        btnQuayLai.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        btnQuayLai.setText("Quay lại");
        btnQuayLai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuayLaiActionPerformed(evt);
            }
        });

        btnThemMoi.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        btnThemMoi.setText("Thêm mới");
        btnThemMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemMoiActionPerformed(evt);
            }
        });

        btnCapNhat.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        btnCapNhat.setText("Cập nhật");
        btnCapNhat.setEnabled(false);
        btnCapNhat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCapNhatActionPerformed(evt);
            }
        });

        btnXoa.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        btnXoa.setText("Xoá");
        btnXoa.setToolTipText("");
        btnXoa.setEnabled(false);
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        tblDanhSach.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        tblDanhSach.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblDanhSach.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDanhSachMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblDanhSach);

        btnThanThiet.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        btnThanThiet.setText("Thân thiết");
        btnThanThiet.setToolTipText("");
        btnThanThiet.setEnabled(false);
        btnThanThiet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThanThietActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnThanThiet, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCapNhat, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnThemMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnQuayLai, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(89, 89, 89)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 458, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 215, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnQuayLai, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThemMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCapNhat, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnThanThiet, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 411, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblDanhSachMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDanhSachMouseClicked
        viTri = tblDanhSach.getSelectedRow();

        if (viTri > -1) {
            KhachHang ptu = danhsach.get(viTri);
            thayDoiTrangThaiButton(false, true, true, true);
            if (ptu.getThanThiet() == 1) {
                btnThanThiet.setText("Bỏ thân thiết");
            } else {
                btnThanThiet.setText("Thân thiết");
            }
        } else {
            thayDoiTrangThaiButton(true, false, false, false);
            btnThanThiet.setText("Thân thiết");
        }
    }//GEN-LAST:event_tblDanhSachMouseClicked

    private void btnQuayLaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuayLaiActionPerformed
        new TrangChuFrame().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnQuayLaiActionPerformed

    private void btnThemMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemMoiActionPerformed
        KhachHangFormFrame form = new KhachHangFormFrame(this, rootPaneCheckingEnabled);
        form.setVisible(true);
    }//GEN-LAST:event_btnThemMoiActionPerformed

    private void btnCapNhatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCapNhatActionPerformed
        KhachHangFormFrame form = new KhachHangFormFrame(this, rootPaneCheckingEnabled);
        form.layPhanTuDuocChon(danhsach.get(viTri));
        form.setVisible(true);
    }//GEN-LAST:event_btnCapNhatActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        int isXoa = JOptionPane.showConfirmDialog(this, "Vui lòng xác nhận xóa?");

        if (isXoa == 0) {
            if (new KhachHangDao().xoaPhanTu(danhsach.get(viTri))) {
                JOptionPane.showMessageDialog(this, "Xoá thành công!");
                hienThiDanhSach();
            } else {
                JOptionPane.showMessageDialog(this, "Xuất hiện lỗi!");
            }
        }
        thayDoiTrangThaiButton(true, false, false, false);
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnThanThietActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThanThietActionPerformed
        KhachHang ptu = danhsach.get(viTri);
        
        if (ptu.getThanThiet() == 0) {
            if (new KhachHangDao().capNhatKhachHangThanThiet(ptu, 1)) {
                JOptionPane.showMessageDialog(this, "Lập phiếu khách hàng thân thiết thành công");
                hienThiDanhSach();
            }
        } else {
            if (new KhachHangDao().capNhatKhachHangThanThiet(ptu, 0)) {
                JOptionPane.showMessageDialog(this, "Huỷ bỏ khách hàng thân thiết thành công");
                hienThiDanhSach();
            }
        }
        thayDoiTrangThaiButton(true, false, false, false);
    }//GEN-LAST:event_btnThanThietActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(KhachHangFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(KhachHangFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(KhachHangFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(KhachHangFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new KhachHangFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCapNhat;
    private javax.swing.JButton btnQuayLai;
    private javax.swing.JButton btnThanThiet;
    private javax.swing.JButton btnThemMoi;
    private javax.swing.JButton btnXoa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblDanhSach;
    // End of variables declaration//GEN-END:variables
}