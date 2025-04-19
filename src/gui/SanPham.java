
package gui;

import javax.swing.*;

import javax.swing.border.LineBorder;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import form.FormThemSanPham;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class SanPham extends JPanel {
    private static final long serialVersionUID = 1L;
    private JTable tableSanPham;
    private DefaultTableModel modelSanPham;
    private JTextField txtTimKiem;
	private JButton btnThemSanPham;
	JComboBox<String> cmbLoai;
	private JButton btnInDanhSach;
	private JButton btnLamMoi;
	private JButton btnTim;

    public SanPham() {
        setLayout(null);
        setBackground(Color.WHITE);
        setPreferredSize(new Dimension(1720, 1000));
        // Tiêu đề
        JLabel lblTitle = new JLabel("Danh sách sản phẩm");
        lblTitle.setFont(new Font("Tahoma", Font.BOLD, 24));
        lblTitle.setBounds(30, 20, 400, 40);
        add(lblTitle);

        // Nút thêm sản phẩm
        btnThemSanPham = new JButton("+ Thêm sản phẩm");
        btnThemSanPham.setBackground(Colors.MAIN_COLOR);
        btnThemSanPham.setForeground(Color.WHITE);
        btnThemSanPham.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnThemSanPham.setBounds(30, 80, 180, 40);
        add(btnThemSanPham);
        btnThemSanPham.addActionListener(e -> {
            // Mở cửa sổ Thêm sản phẩm dưới dạng JDialog
            FormThemSanPham form = new FormThemSanPham((Frame) SwingUtilities.getWindowAncestor(this)); // Truyền cửa sổ cha
            form.setVisible(true);  // Hiển thị form
        });
        // Combobox loại sản phẩm
        cmbLoai = new JComboBox<>(new String[]{
            "Tất cả sản phẩm", "Thuốc", "Vitamin", "Kháng sinh"
        });
        cmbLoai.setFont(new Font("Tahoma", Font.PLAIN, 14));
        cmbLoai.setBounds(220, 80, 180, 40);
        add(cmbLoai);

        // Nút in danh sách
        btnInDanhSach = new JButton("In danh sách");
        btnInDanhSach.setIcon(new ImageIcon(SanPham.class.getResource("/img/icons8-print-30.png")));
        btnInDanhSach.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });
        btnInDanhSach.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnInDanhSach.setBounds(410, 80, 163, 40);
        add(btnInDanhSach);

        // Nút làm mới
        btnLamMoi = new JButton("Làm mới");
        btnLamMoi.setIcon(new ImageIcon(SanPham.class.getResource("/img/icons8-load-30.png")));
        btnLamMoi.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnLamMoi.setBounds(583, 80, 130, 40);
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
        btnTim.setBounds(1640, 80, 40, 40);
        add(btnTim);

        // Tên cột
        String[] colNames = {
            "Mã SP", "Tên SP", "Ngày sản xuất", "Hạn sử dụng",
            "Nhà sản xuất", "Số lượng tồn", "Đơn giá", "Thuế",
            "Đơn vị tính", "Mô tả", "Trạng thái", "Loại SP",
            "Danh mục", "Hành động"
        };

        modelSanPham = new DefaultTableModel(colNames, 0);
        tableSanPham = new JTable(modelSanPham);

        // Header bảng
        JTableHeader header = tableSanPham.getTableHeader();
        header.setFont(new Font("Tahoma", Font.PLAIN, 14));
        header.setBackground(Colors.MAIN_COLOR);
        header.setForeground(Color.WHITE);

        // Scroll pane chứa bảng
        JScrollPane scrollPane = new JScrollPane(tableSanPham);
        scrollPane.setBounds(30, 131, 1650, 830); // Gần full màn hình 1600x954
        scrollPane.setBorder(new LineBorder(Color.LIGHT_GRAY));
        add(scrollPane);
        
        JLabel lblNewLabel = new JLabel("Tìm kiếm: ");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblNewLabel.setBounds(1323, 49, 133, 30);
        add(lblNewLabel);
    }
}