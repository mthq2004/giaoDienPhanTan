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

public class FormThemNhaCungCap extends JDialog {
    private JTextField txtMaNcc, txtTenNcc, txtSdt, txtDiaChi;
    private DefaultTableModel model;
    private JTextField txtEmail;

    public FormThemNhaCungCap(Frame owner) {
        super(owner, "Thêm mới nhà cung cấp", true);  // Chế độ modal (chặn cửa sổ chính)
        getContentPane().setLayout(null);
        setBackground(Color.WHITE);
        setBounds(0, 0, 390, 367);
        
        setLocationRelativeTo(null);

        JLabel lblTitle = new JLabel("Thêm mới nhà cung cấp");
        lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
        lblTitle.setFont(new Font("Tahoma", Font.BOLD, 20));
        lblTitle.setBounds(6, 10, 393, 30);
        getContentPane().add(lblTitle);

        // Mã
        JLabel lblMaNcc = new JLabel("Mã nhà cung cấp:");
        lblMaNcc.setBounds(30, 60, 120, 30);
        getContentPane().add(lblMaNcc);
        txtMaNcc = new JTextField("NCC0001");
        txtMaNcc.setBounds(150, 60, 200, 30);
        getContentPane().add(txtMaNcc);

        // Tên SP
        JLabel lblTen = new JLabel("Tên nhà cung cấp:");
        lblTen.setBounds(30, 100, 120, 30);
        getContentPane().add(lblTen);
        txtTenNcc = new JTextField();
        txtTenNcc.setBounds(150, 100, 200, 30);
        getContentPane().add(txtTenNcc);

        // Số lượng
        JLabel lblSdt = new JLabel("Số điện thoại:");
        lblSdt.setBounds(30, 140, 100, 25);
        getContentPane().add(lblSdt);
        txtSdt = new JTextField();
        txtSdt.setBounds(150, 140, 200, 30);
        getContentPane().add(txtSdt);

        // Đơn giá
        JLabel lblDiaChi = new JLabel("Địa chỉ");
        lblDiaChi.setBounds(30, 220, 100, 25);
        getContentPane().add(lblDiaChi);
        txtDiaChi = new JTextField();
        txtDiaChi.setBounds(150, 220, 200, 30);
        getContentPane().add(txtDiaChi);

        // Nút huỷ
        JButton btnHuy = new JButton("x Huỷ");
        btnHuy.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });
        btnHuy.setBounds(70, 270, 120, 40);
        btnHuy.setBackground(Color.LIGHT_GRAY);
        btnHuy.setForeground(Color.WHITE);
        getContentPane().add(btnHuy);
        
        JButton btnThem = new JButton("+ Thêm");
        btnThem.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });
        btnThem.setForeground(Color.WHITE);
        btnThem.setBackground(new Color(0, 200, 0));
        btnThem.setBounds(200, 270, 120, 40);
        getContentPane().add(btnThem);
        
        JLabel lblEmail = new JLabel("Email:");
        lblEmail.setBounds(30, 180, 100, 25);
        getContentPane().add(lblEmail);
        
        txtEmail = new JTextField();
        txtEmail.setBounds(150, 180, 200, 30);
        getContentPane().add(txtEmail);
    }
}