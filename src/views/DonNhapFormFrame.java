package views;

import controller.DonDatHangDao;
import controller.DonNhapDao;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import model.DonDatHang;
import model.DonNhap;

/**
 *
 * @author
 */
public class DonNhapFormFrame extends javax.swing.JDialog {

    private DonNhapFrame home;
    private boolean isCapNhat = false;
    private ArrayList<DonDatHang> dsDonDatHang = new ArrayList<>();
    private String[] dsMaDonDatHang;

    /**
     * Creates new form NhanVienFormFrame
     */
    public DonNhapFormFrame(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        home = (DonNhapFrame) parent;
        thietLapMaDonHang();
    }
    
    /**
     * Lấy dữ liệu chuyển sang
     * @param isCN
     * @param ptu 
     */
    public void layPhanTuDuocChon(DonNhap ptu) {
        isCapNhat = true;

        txtMaDonHangNhap.setText(ptu.getMaDonNhap());
        txtMaDonHangNhap.setEnabled(false);
        txtNgayNhap.setText("" + new SimpleDateFormat("dd/MM/yyyy").format(ptu.getNgayNhap()));
        cbMaDonHangDat.setSelectedItem(ptu.getMaDonDH());
        cbMaDonHangDat.setEnabled(false);
    }
    
    /**
     * Tạo combobox tên nhà cung cấp
     */
    public void thietLapMaDonHang() {
        dsDonDatHang = new DonDatHangDao().layDanhSachPhanTu();
        dsMaDonDatHang = new String[dsDonDatHang.size()];

        for (int i = 0; i < dsDonDatHang.size(); i++) {
            dsMaDonDatHang[i] = dsDonDatHang.get(i).getMaDonDH();
        }
        cbMaDonHangDat.setModel(new javax.swing.DefaultComboBoxModel(dsMaDonDatHang));
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
        jLabel2 = new javax.swing.JLabel();
        txtMaDonHangNhap = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtNgayNhap = new javax.swing.JTextField();
        btnLuu = new javax.swing.JButton();
        btnDong = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        cbMaDonHangDat = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Thông tin đơn hàng nhập");

        jLabel1.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Thông tin đơn hàng nhập");

        jLabel2.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        jLabel2.setText("Mã đơn hàng nhập");

        txtMaDonHangNhap.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        txtMaDonHangNhap.setToolTipText("");

        jLabel3.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        jLabel3.setText("Ngày nhập");

        txtNgayNhap.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        txtNgayNhap.setToolTipText("");

        btnLuu.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        btnLuu.setText("Lưu ");
        btnLuu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLuuActionPerformed(evt);
            }
        });

        btnDong.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        btnDong.setText("Đóng");
        btnDong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDongActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        jLabel7.setText("Mã đơn hàng đặt");

        cbMaDonHangDat.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(151, 151, 151)
                        .addComponent(btnLuu, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDong, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cbMaDonHangDat, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 384, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtNgayNhap, javax.swing.GroupLayout.DEFAULT_SIZE, 243, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtMaDonHangNhap)))))
                .addContainerGap(65, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMaDonHangNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNgayNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                    .addComponent(cbMaDonHangDat))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 247, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLuu, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDong, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnDongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDongActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnDongActionPerformed

    private void btnLuuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLuuActionPerformed
        String maDonNhap = null, maDonDH = null;
        Date ngayNhap = null;
        boolean isDone = true;

        if (txtMaDonHangNhap.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Mã đơn nhập không được để trống");
            isDone = false;
        } else {
            maDonNhap = txtMaDonHangNhap.getText();
        }
        
        try {
            ngayNhap = new SimpleDateFormat("dd/MM/yyyy").parse(txtNgayNhap.getText());
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(this, "Ngày nhập hàng không đúng định dạng");
            isDone = false;
        }

        int viTriMaDonDH = cbMaDonHangDat.getSelectedIndex();
        maDonDH = dsDonDatHang.get(viTriMaDonDH).getMaDonDH();
        
        if (isDone) {
            DonNhap ptu = new DonNhap(maDonNhap, ngayNhap, maDonDH);
            if (!isCapNhat) {
                if (new DonNhapDao().themPhanTu(ptu)) {
                    JOptionPane.showMessageDialog(this, "Thêm mới thành công!");
                    home.hienThiDanhSach();
                    this.dispose();
                } else {
                    JOptionPane.showMessageDialog(this, "Mã đơn nhập đã tồn tại!");
                }
            } else {
                if (new DonNhapDao().capNhatPhanTu(ptu)) {
                    JOptionPane.showMessageDialog(this, "Cập nhật thành công!");
                    home.hienThiDanhSach();
                    this.dispose();
                } else {
                    JOptionPane.showMessageDialog(this, "Xảy ra lỗi!");
                }
            }
            home.thayDoiTrangThaiButton(true, false, false, false);
        }
    }//GEN-LAST:event_btnLuuActionPerformed

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
            java.util.logging.Logger.getLogger(DonNhapFormFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DonNhapFormFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DonNhapFormFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DonNhapFormFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                DonNhapFormFrame dialog = new DonNhapFormFrame(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDong;
    private javax.swing.JButton btnLuu;
    private javax.swing.JComboBox<String> cbMaDonHangDat;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JTextField txtMaDonHangNhap;
    private javax.swing.JTextField txtNgayNhap;
    // End of variables declaration//GEN-END:variables
}
