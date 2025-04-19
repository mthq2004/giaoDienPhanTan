
package gui;

import javax.swing.*;

import javax.swing.border.LineBorder;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import form.FormThemKhachHang;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import com.toedter.calendar.JDateChooser;


public class HoaDon extends JPanel {
    private static final long serialVersionUID = 1L;
    private JTextField txtTimKiem;
	private JButton btnLamMoi;
	private JButton btnInDanhSach;
	private JButton btnTim;
	private JScrollPane scrollPane;
	private JTableHeader header;
	private JTable tableNCC;
	private JButton btnThemKhachHang;
	private DefaultTableModel modelHD;
	private JTable tableHD;
	private JDateChooser dateNgaySinh;
	private JLabel lblNgayBd;

    public HoaDon() {
        setLayout(null);
        setBackground(Color.WHITE);
        setPreferredSize(new Dimension(1720, 1000));
        // Tiêu đề
        JLabel lblTitle = new JLabel("Danh sách hoá đơn");
        lblTitle.setFont(new Font("Tahoma", Font.BOLD, 24));
        lblTitle.setBounds(30, 20, 400, 40);
        add(lblTitle);

        // Nút in danh sách
        btnInDanhSach = new JButton("In danh sách");
        btnInDanhSach.setIcon(new ImageIcon(SanPham.class.getResource("/img/icons8-print-30.png")));
        btnInDanhSach.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });
        btnInDanhSach.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnInDanhSach.setBounds(650, 80, 163, 40);
        add(btnInDanhSach);

        // Nút làm mới
        btnLamMoi = new JButton("Làm mới");
        btnLamMoi.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });
        btnLamMoi.setIcon(new ImageIcon(SanPham.class.getResource("/img/icons8-load-30.png")));
        btnLamMoi.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnLamMoi.setBounds(823, 80, 130, 40);
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
            "Mã hoá đơn", "Tên khách hàng", "Tên nhân viên", "Tổng hoá đơn", "Tiền khách đưa", "Tiền thừa", "Hình thức thanh toán", "Điểm sử dụng", "Thời gian tạo", "Chi tiết hoá đơn"
        };

        modelHD = new DefaultTableModel(colNames, 0);
        tableHD = new JTable(modelHD);

        // Header bảng
        header = tableHD.getTableHeader();
        header.setFont(new Font("Tahoma", Font.PLAIN, 14));
        header.setBackground(Colors.MAIN_COLOR);
        header.setForeground(Color.WHITE);

        // Scroll pane chứa bảng
        scrollPane = new JScrollPane(tableHD);
        scrollPane.setBounds(30, 131, 1650, 830); // Gần full màn hình 1600x954
        scrollPane.setBorder(new LineBorder(Color.LIGHT_GRAY));
        add(scrollPane);
        
        JLabel lblNewLabel = new JLabel("Tìm kiếm: ");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblNewLabel.setBounds(1323, 49, 133, 30);
        add(lblNewLabel);
        
        dateNgaySinh = new JDateChooser();
        dateNgaySinh.setDateFormatString("dd/MM/yyyy");
        dateNgaySinh.setBounds(100, 80, 200, 40);
        add(dateNgaySinh);
        
        lblNgayBd = new JLabel("Từ ngày:");
        lblNgayBd.setBounds(30, 87, 61, 25);
        add(lblNgayBd);
        
        JLabel lblNewLabel_1 = new JLabel("-");
        lblNewLabel_1.setBounds(317, 79, 13, 40);
        add(lblNewLabel_1);
        
        JLabel lblnNgy = new JLabel("Đến ngày:");
        lblnNgy.setBounds(340, 87, 73, 25);
        add(lblnNgy);
        
        JDateChooser dateNgaySinh_1 = new JDateChooser();
        dateNgaySinh_1.setDateFormatString("dd/MM/yyyy");
        dateNgaySinh_1.setBounds(420, 80, 200, 40);
        add(dateNgaySinh_1);
    }
}