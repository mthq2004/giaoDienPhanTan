package form;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FormThemKhachHang extends JDialog {
    private JTextField txtMaKH, txtHoTen, txtSdt, txtGhiChu;
    private JComboBox<String> cmbGioiTinh;
    private JDateChooser dateNgaySinh;
    private DefaultTableModel model;

    public FormThemKhachHang(Frame owner) {
        super(owner, "Thêm mới khách hàng", true);  // Chế độ modal (chặn cửa sổ chính)
        getContentPane().setLayout(null);
        setBackground(Color.WHITE);
        setBounds(0, 0, 390, 404);
        
        setLocationRelativeTo(null);

        JLabel lblTitle = new JLabel("Thêm mới khách hàng");
        lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
        lblTitle.setFont(new Font("Tahoma", Font.BOLD, 20));
        lblTitle.setBounds(6, 10, 393, 30);
        getContentPane().add(lblTitle);

        // Mã SP
        JLabel lblMaKH = new JLabel("Mã khách hàng:");
        lblMaKH.setBounds(30, 60, 120, 25);
        getContentPane().add(lblMaKH);
        txtMaKH = new JTextField("KH0001");
        txtMaKH.setBounds(150, 60, 200, 25);
        getContentPane().add(txtMaKH);

        // Tên SP
        JLabel lblHoTen = new JLabel("Họ tên:");
        lblHoTen.setBounds(30, 100, 120, 25);
        getContentPane().add(lblHoTen);
        txtHoTen = new JTextField();
        txtHoTen.setBounds(150, 100, 200, 25);
        getContentPane().add(txtHoTen);

        // Loại SP
        JLabel lblGioiTinh = new JLabel("Giới tính:");
        lblGioiTinh.setBounds(30, 180, 120, 25);
        getContentPane().add(lblGioiTinh);
        cmbGioiTinh = new JComboBox<>(new String[]{"-- Hãy chọn loại sản phẩm --", "Thuốc", "Vitamin", "Kháng sinh"});
        cmbGioiTinh.setModel(new DefaultComboBoxModel(new String[] {"-- Hãy chọn giới tính--", "Nam", "Nữ", "Khác"}));
        cmbGioiTinh.setBounds(150, 180, 200, 25);
        getContentPane().add(cmbGioiTinh);

        // Số lượng
        JLabel lblSdt = new JLabel("Số điện thoại:");
        lblSdt.setBounds(30, 140, 100, 25);
        getContentPane().add(lblSdt);
        txtSdt = new JTextField();
        txtSdt.setBounds(150, 140, 200, 25);
        getContentPane().add(txtSdt);

        // Đơn giá
        JLabel lblGhiChu = new JLabel("Ghi chú");
        lblGhiChu.setBounds(30, 260, 100, 25);
        getContentPane().add(lblGhiChu);
        txtGhiChu = new JTextField();
        txtGhiChu.setBounds(150, 260, 200, 25);
        getContentPane().add(txtGhiChu);

        // Hạn sử dụng
        JLabel lblNgaySinh = new JLabel("Ngày sinh:");
        lblNgaySinh.setBounds(30, 220, 100, 25);
        getContentPane().add(lblNgaySinh);
        dateNgaySinh = new JDateChooser();
        dateNgaySinh.setBounds(150, 220, 200, 25);
        dateNgaySinh.setDateFormatString("dd/MM/yyyy");
        getContentPane().add(dateNgaySinh);

        // Nút huỷ
        JButton btnHuy = new JButton("x Huỷ");
        btnHuy.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });
        btnHuy.setBounds(70, 310, 120, 40);
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
        btnThem.setBounds(200, 310, 120, 40);
        getContentPane().add(btnThem);
    }
}