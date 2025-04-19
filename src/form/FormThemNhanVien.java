package form;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import com.toedter.calendar.JDateChooser;

import java.awt.*;

public class FormThemNhanVien extends JDialog {
    private JTextField txtMaNV, txtHoTen, txtSoDienThoai, txtEmail;
    private JComboBox<String> cmbTrangThai, cmbTrinhDo, cmbChucVu;
    private JDateChooser dateNgayVaoLam, dateNamSinh;
    private DefaultTableModel model;

    public FormThemNhanVien(Frame owner) {
        super(owner, "Thêm mới nhân viên", true);
        getContentPane().setLayout(null);
        setBackground(Color.WHITE);
        setBounds(0, 0, 1200, 290);
        setLocationRelativeTo(null);

        JLabel lblTitle = new JLabel("Thêm mới nhân viên");
        lblTitle.setFont(new Font("Tahoma", Font.BOLD, 20));
        lblTitle.setBounds(500, 10, 300, 30);
        getContentPane().add(lblTitle);

        JLabel lblMaNV = new JLabel("Mã nhân viên:");
        lblMaNV.setBounds(30, 60, 120, 25);
        getContentPane().add(lblMaNV);
        txtMaNV = new JTextField("NV001");
        txtMaNV.setBounds(150, 60, 200, 30);
        txtMaNV.setEditable(false);
        getContentPane().add(txtMaNV);

        JLabel lblHoTen = new JLabel("Họ tên:");
        lblHoTen.setBounds(30, 100, 120, 25);
        getContentPane().add(lblHoTen);
        txtHoTen = new JTextField();
        txtHoTen.setBounds(150, 100, 200, 30);
        getContentPane().add(txtHoTen);

        JLabel lblSoDT = new JLabel("Số điện thoại:");
        lblSoDT.setBounds(30, 140, 120, 25);
        getContentPane().add(lblSoDT);
        txtSoDienThoai = new JTextField();
        txtSoDienThoai.setBounds(150, 140, 200, 30);
        getContentPane().add(txtSoDienThoai);

        JLabel lblEmail = new JLabel("Email:");
        lblEmail.setBounds(400, 60, 100, 30);
        getContentPane().add(lblEmail);
        txtEmail = new JTextField();
        txtEmail.setBounds(500, 60, 200, 30);
        getContentPane().add(txtEmail);

        JLabel lblNgayVaoLam = new JLabel("Ngày vào làm:");
        lblNgayVaoLam.setBounds(400, 100, 100, 30);
        getContentPane().add(lblNgayVaoLam);
        dateNgayVaoLam = new JDateChooser();
        dateNgayVaoLam.setBounds(500, 100, 200, 30);
        dateNgayVaoLam.setDateFormatString("dd/MM/yyyy");
        getContentPane().add(dateNgayVaoLam);

        JLabel lblNamSinh = new JLabel("Năm sinh:");
        lblNamSinh.setBounds(400, 140, 100, 30);
        getContentPane().add(lblNamSinh);
        dateNamSinh = new JDateChooser();
        dateNamSinh.setBounds(500, 140, 200, 30);
        dateNamSinh.setDateFormatString("dd/MM/yyyy");
        getContentPane().add(dateNamSinh);

        JLabel lblTrangThai = new JLabel("Trạng thái:");
        lblTrangThai.setBounds(750, 60, 100, 30);
        getContentPane().add(lblTrangThai);
        cmbTrangThai = new JComboBox<>(new String[]{"-- Chọn trạng thái --", "Đang làm", "Nghỉ việc"});
        cmbTrangThai.setBounds(850, 60, 200, 30);
        getContentPane().add(cmbTrangThai);

        JLabel lblTrinhDo = new JLabel("Trình độ:");
        lblTrinhDo.setBounds(750, 100, 100, 30);
        getContentPane().add(lblTrinhDo);
        cmbTrinhDo = new JComboBox<>(new String[]{"-- Chọn trình độ --", "Cao đẳng", "Đại học", "Thạc sĩ", "Tiến sĩ"});
        cmbTrinhDo.setBounds(850, 100, 200, 30);
        getContentPane().add(cmbTrinhDo);

        JLabel lblChucVu = new JLabel("Chức vụ:");
        lblChucVu.setBounds(750, 140, 100, 30);
        getContentPane().add(lblChucVu);
        cmbChucVu = new JComboBox<>(new String[]{"-- Chọn chức vụ --", "Nhân viên", "Quản lý"});
        cmbChucVu.setBounds(850, 140, 200, 30);
        getContentPane().add(cmbChucVu);
        
        JButton btnHuy = new JButton("x Huỷ");
        btnHuy.setBackground(Color.LIGHT_GRAY);
        btnHuy.setForeground(Color.WHITE);
        btnHuy.setBounds(475, 200, 120, 40);
        getContentPane().add(btnHuy);

        JButton btnThem = new JButton("+ Thêm");
        btnThem.setBounds(600, 200, 120, 40);
        btnThem.setBackground(new Color(0, 200, 0));
        btnThem.setForeground(Color.WHITE);
        getContentPane().add(btnThem);

        JButton btnLamMoi = new JButton(new ImageIcon(FormThemNhanVien.class.getResource("/img/icons8-load-30.png")));
        btnLamMoi.setToolTipText("Làm mới");
        btnLamMoi.setBounds(1110, 20, 40, 40);
        getContentPane().add(btnLamMoi);

        btnLamMoi.addActionListener(e -> {
            txtHoTen.setText("");
            txtSoDienThoai.setText("");
            txtEmail.setText("");
            dateNgayVaoLam.setDate(null);
            dateNamSinh.setDate(null);
            cmbTrangThai.setSelectedIndex(0);
            cmbTrinhDo.setSelectedIndex(0);
            cmbChucVu.setSelectedIndex(0);
        });
    }
}
