package form;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.toedter.calendar.JDateChooser;

public class FormThemSanPham extends JDialog {
    private JTextField txtMaSP, txtTenSP, txtSoLuong, txtDonGia, txtNhaSX, txtMoTa;
    private JComboBox<String> cmbLoai, cmbDanhMuc, cmbDonViTinh, cmbThue;
    private JDateChooser dateNSX, dateHSD;
    private DefaultTableModel model;

    public FormThemSanPham(Frame owner) {
        super(owner, "Thêm mới sản phẩm", true);  // Chế độ modal (chặn cửa sổ chính)
        getContentPane().setLayout(null);
        setBackground(Color.WHITE);
        setBounds(0, 0, 1200, 350);
        
        setLocationRelativeTo(null);

        JLabel lblTitle = new JLabel("Thêm mới sản phẩm");
        lblTitle.setFont(new Font("Tahoma", Font.BOLD, 20));
        lblTitle.setBounds(500, 10, 300, 30);
        getContentPane().add(lblTitle);

        // Thời gian tạo
        JLabel lblThoiGian = new JLabel("Thời gian tạo:");
        lblThoiGian.setBounds(30, 60, 120, 30);
        getContentPane().add(lblThoiGian);
        JTextField txtThoiGian = new JTextField(java.time.LocalDateTime.now().toString());
        txtThoiGian.setEditable(false);
        txtThoiGian.setBounds(150, 60, 200, 30);
        getContentPane().add(txtThoiGian);

        // Mã SP
        JLabel lblMaSP = new JLabel("Mã sản phẩm:");
        lblMaSP.setBounds(30, 100, 120, 30);
        getContentPane().add(lblMaSP);
        txtMaSP = new JTextField("SP0115");
        txtMaSP.setBounds(150, 100, 200, 30);
        getContentPane().add(txtMaSP);

        // Tên SP
        JLabel lblTenSP = new JLabel("Tên sản phẩm:");
        lblTenSP.setBounds(30, 140, 120, 30);
        getContentPane().add(lblTenSP);
        txtTenSP = new JTextField();
        txtTenSP.setBounds(150, 140, 200, 30);
        getContentPane().add(txtTenSP);

        // Loại SP
        JLabel lblLoaiSP = new JLabel("Loại sản phẩm:");
        lblLoaiSP.setBounds(30, 180, 120, 30);
        getContentPane().add(lblLoaiSP);
        cmbLoai = new JComboBox<>(new String[]{"-- Hãy chọn loại sản phẩm --", "Thuốc", "Vitamin", "Kháng sinh"});
        cmbLoai.setBounds(150, 180, 200, 30);
        getContentPane().add(cmbLoai);

        // Số lượng
        JLabel lblSoLuong = new JLabel("Số lượng:");
        lblSoLuong.setBounds(400, 60, 100, 25);
        getContentPane().add(lblSoLuong);
        txtSoLuong = new JTextField();
        txtSoLuong.setBounds(500, 60, 200, 30);
        getContentPane().add(txtSoLuong);

        // Đơn giá
        JLabel lblDonGia = new JLabel("Đơn giá:");
        lblDonGia.setBounds(400, 100, 100, 25);
        getContentPane().add(lblDonGia);
        txtDonGia = new JTextField();
        txtDonGia.setBounds(500, 100, 200, 30);
        getContentPane().add(txtDonGia);

        // Nhà SX
        JLabel lblNSX = new JLabel("Nhà sản xuất:");
        lblNSX.setBounds(400, 140, 100, 25);
        getContentPane().add(lblNSX);
        txtNhaSX = new JTextField();
        txtNhaSX.setBounds(500, 140, 200, 30);
        getContentPane().add(txtNhaSX);

        // Ngày sản xuất
        JLabel lblNgaySX = new JLabel("Ngày sản xuất:");
        lblNgaySX.setBounds(400, 180, 100, 25);
        getContentPane().add(lblNgaySX);
        dateNSX = new JDateChooser();
        dateNSX.setBounds(500, 180, 200, 30);
        dateNSX.setDateFormatString("dd/MM/yyyy");
        getContentPane().add(dateNSX);

        // Hạn sử dụng
        JLabel lblHSD = new JLabel("Ngày hết hạn:");
        lblHSD.setBounds(750, 60, 100, 25);
        getContentPane().add(lblHSD);
        dateHSD = new JDateChooser();
        dateHSD.setBounds(850, 60, 200, 30);
        dateHSD.setDateFormatString("dd/MM/yyyy");
        getContentPane().add(dateHSD);

        // Danh mục
        JLabel lblDanhMuc = new JLabel("Danh mục:");
        lblDanhMuc.setBounds(750, 100, 100, 25);
        getContentPane().add(lblDanhMuc);
        cmbDanhMuc = new JComboBox<>(new String[]{"-- Hãy chọn danh mục --", "Thuốc kê đơn", "Thực phẩm chức năng"});
        cmbDanhMuc.setBounds(850, 100, 200, 30);
        getContentPane().add(cmbDanhMuc);

        // Đơn vị tính
        JLabel lblDonVi = new JLabel("Đơn vị tính:");
        lblDonVi.setBounds(750, 140, 100, 25);
        getContentPane().add(lblDonVi);
        cmbDonViTinh = new JComboBox<>(new String[]{"-- Hãy chọn đơn vị tính --", "Viên", "Hộp", "Chai"});
        cmbDonViTinh.setBounds(850, 140, 200, 30);
        getContentPane().add(cmbDonViTinh);

        // Thuế
        JLabel lblThue = new JLabel("Thuế:");
        lblThue.setBounds(750, 180, 100, 25);
        getContentPane().add(lblThue);
        cmbThue = new JComboBox<>(new String[]{"-- Hãy chọn thuế --", "5%", "10%", "0%"});
        cmbThue.setBounds(850, 180, 200, 30);
        getContentPane().add(cmbThue);

        // Mô tả
        JLabel lblMoTa = new JLabel("Mô tả thêm:");
        lblMoTa.setBounds(30, 220, 100, 25);
        getContentPane().add(lblMoTa);
        txtMoTa = new JTextField();
        txtMoTa.setBounds(150, 220, 900, 30);
        getContentPane().add(txtMoTa);
        
     // Nút huỷ
        JButton btnHuy = new JButton("x Huỷ");
        btnHuy.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });
        btnHuy.setBounds(475, 260, 120, 40);
        btnHuy.setBackground(Color.LIGHT_GRAY);
        btnHuy.setForeground(Color.WHITE);
        getContentPane().add(btnHuy);

        // Nút Thêm
        JButton btnThem = new JButton("+ Thêm");
        btnThem.setBounds(605, 260, 120, 40);
        btnThem.setBackground(new Color(0, 200, 0));
        btnThem.setForeground(Color.WHITE);
        getContentPane().add(btnThem);

        // Nút Làm mới
        JButton btnLamMoi = new JButton(new ImageIcon(FormThemSanPham.class.getResource("/img/icons8-load-30.png")));
        btnLamMoi.setToolTipText("Làm mới");
        btnLamMoi.setBounds(1110, 20, 40, 40);
        getContentPane().add(btnLamMoi);
    }
}