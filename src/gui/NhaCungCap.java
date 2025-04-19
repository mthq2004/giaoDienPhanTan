
package gui;

import javax.swing.*;

import javax.swing.border.LineBorder;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import form.FormThemNhaCungCap;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class NhaCungCap extends JPanel {
    private static final long serialVersionUID = 1L;
    private JTable tableSanPham;
    private DefaultTableModel modelSanPham;
    private JTextField txtTimKiem;
	private DefaultTableModel modelNhanVien;
	private JTable tableNhanVien;
	private JButton btnThemNhanVien;
	private JButton btnLamMoi;
	private JButton btnInDanhSach;
	private JButton btnTim;
	private JScrollPane scrollPane;
	private JTableHeader header;
	private JButton btnThemNhaCungCap;
	private DefaultTableModel modelNCC;
	private JTable tableNCC;

    public NhaCungCap() {
        setLayout(null);
        setBackground(Color.WHITE);
        setPreferredSize(new Dimension(1720, 1000));
        // Tiêu đề
        JLabel lblTitle = new JLabel("Danh sách nhà cung cấp");
        lblTitle.setFont(new Font("Tahoma", Font.BOLD, 24));
        lblTitle.setBounds(30, 20, 400, 40);
        add(lblTitle);

        // Nút thêm sản phẩm
        btnThemNhaCungCap = new JButton("+ Thêm nhà cung cấp");
        btnThemNhaCungCap.setBackground(Colors.MAIN_COLOR);
        btnThemNhaCungCap.setForeground(Color.WHITE);
        btnThemNhaCungCap.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnThemNhaCungCap.setBounds(30, 80, 180, 40);
        add(btnThemNhaCungCap);
        btnThemNhaCungCap.addActionListener(e -> {
            // Mở cửa sổ Thêm sản phẩm dưới dạng JDialog
            FormThemNhaCungCap form = new FormThemNhaCungCap((Frame) SwingUtilities.getWindowAncestor(this)); // Truyền cửa sổ cha
            form.setVisible(true);  // Hiển thị form
        });

        // Nút in danh sách
        btnInDanhSach = new JButton("In danh sách");
        btnInDanhSach.setIcon(new ImageIcon(SanPham.class.getResource("/img/icons8-print-30.png")));
        btnInDanhSach.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });
        btnInDanhSach.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnInDanhSach.setBounds(220, 80, 163, 40);
        add(btnInDanhSach);

        // Nút làm mới
        btnLamMoi = new JButton("Làm mới");
        btnLamMoi.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });
        btnLamMoi.setIcon(new ImageIcon(SanPham.class.getResource("/img/icons8-load-30.png")));
        btnLamMoi.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnLamMoi.setBounds(393, 80, 130, 40);
        add(btnLamMoi);

        // Ô tìm kiếm
        txtTimKiem = new JTextField();
        txtTimKiem.setFont(new Font("Tahoma", Font.PLAIN, 14));
        txtTimKiem.setBounds(1330, 81, 300, 40);
        add(txtTimKiem);


        // Nút tìm kiếm
        btnTim = 	new JButton();
        btnTim.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });
        btnTim.setIcon(new ImageIcon(SanPham.class.getResource("/img/icons8-search-30.png"))); // Kiểm tra lại đường dẫn hình
        btnTim.setBounds(1640, 81, 40, 40);
        add(btnTim);

        // Tên cột
        String[] colNames = {
            "Mã NCC", "Tên nhà cung cấp", "Email", "Số điện thoại", "Địa chỉ", "Hành động"
        };

        modelNCC = new DefaultTableModel(colNames, 0);
        tableNCC = new JTable(modelNCC);

        // Header bảng
        header = tableNCC.getTableHeader();
        header.setFont(new Font("Tahoma", Font.PLAIN, 14));
        header.setBackground(Colors.MAIN_COLOR);
        header.setForeground(Color.WHITE);

        // Scroll pane chứa bảng
        scrollPane = new JScrollPane(tableNCC);
        scrollPane.setBounds(30, 131, 1650, 830); // Gần full màn hình 1600x954
        scrollPane.setBorder(new LineBorder(Color.LIGHT_GRAY));
        add(scrollPane);
        
        JLabel lblNewLabel = new JLabel("Tìm kiếm: ");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblNewLabel.setBounds(1323, 49, 133, 30);
        add(lblNewLabel);
    }
}