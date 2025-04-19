package gui;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class BanHang extends JPanel {

    private Color primaryColor = new Color(0, 150, 136);
    private Color secondaryColor = new Color(76, 175, 80);
    private Color headerButtonColor = new Color(52, 122, 228); /
    private Border roundedBorder = BorderFactory.createCompoundBorder(
            new LineBorder(primaryColor, 1, true),
            BorderFactory.createEmptyBorder(5, 10, 5, 10)
    );
    private Font placeholderFont = new Font("Segoe UI", Font.ITALIC, 14);
    private Color placeholderColor = Color.GRAY;

    public BanHang() {
        setPreferredSize(new Dimension(1920, 1080));
        setLayout(null);

        // Tiêu đề chính
        JLabel lblTitle = new JLabel("Quản lý bán hàng", JLabel.CENTER);
        lblTitle.setFont(new Font("Segoe UI", Font.BOLD, 28));
        lblTitle.setForeground(new Color(33, 37, 41));
        lblTitle.setBounds(0, 20, 1720, 40);
        add(lblTitle);

        // --- Panel thông tin hóa đơn ---
        JPanel panelInfo = new JPanel(null);
        panelInfo.setBounds(30, 80, 1660, 80);
        panelInfo.setBackground(Color.WHITE);
        panelInfo.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(Color.LIGHT_GRAY),
                "Thông tin hóa đơn", TitledBorder.LEFT, TitledBorder.TOP,
                new Font("Segoe UI", Font.BOLD, 14),
                Color.DARK_GRAY));
        panelInfo.setLayout(null); 
        add(panelInfo);

        JLabel lblNhanVien = new JLabel("* Nhân viên:");
        lblNhanVien.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        lblNhanVien.setBounds(20, 30, 100, 25);
        panelInfo.add(lblNhanVien);

        JTextField txtNhanVien = new JTextField("Võ Ngọc Thúy Vy");
        txtNhanVien.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        txtNhanVien.setBounds(110, 28, 200, 25);
        txtNhanVien.setEditable(false);
        panelInfo.add(txtNhanVien);

        JLabel lblMaHD = new JLabel("* Mã hóa đơn:");
        lblMaHD.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        lblMaHD.setBounds(330, 30, 90, 25);
        panelInfo.add(lblMaHD);

        JTextField txtMaHD = new JTextField("HD0053");
        txtMaHD.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        txtMaHD.setBounds(430, 28, 150, 25);
        txtMaHD.setEditable(false);
        panelInfo.add(txtMaHD);

        JLabel lblNgayTao = new JLabel("* Ngày tạo:");
        lblNgayTao.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        lblNgayTao.setBounds(610, 30, 80, 25);
        panelInfo.add(lblNgayTao);

        JTextField txtNgayTao = new JTextField("19/04/2025 12:21:48");
        txtNgayTao.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        txtNgayTao.setBounds(700, 28, 200, 25);
        txtNgayTao.setEditable(false);
        panelInfo.add(txtNgayTao);

        JButton btnNhapTam = new JButton("Nhập hóa đơn tạm");
        btnNhapTam.setBounds(1350, 25, 200, 35);
        btnNhapTam.setForeground(Color.WHITE);
        btnNhapTam.setFocusPainted(false);
        btnNhapTam.setFont(new Font("Segoe UI", Font.BOLD, 13));
        btnNhapTam.setBackground(headerButtonColor); 
        panelInfo.add(btnNhapTam);

        // --- Panel nhập thông tin sản phẩm ---
        JPanel panelNhapSP = new JPanel(null);
        panelNhapSP.setBounds(30, 180, 1660, 80);
        panelNhapSP.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
        panelNhapSP.setLayout(null); 
        add(panelNhapSP);

        JLabel lblNhapSP = new JLabel("Nhập thông tin sản phẩm");
        lblNhapSP.setFont(new Font("Segoe UI", Font.BOLD, 14));
        lblNhapSP.setForeground(Color.DARK_GRAY);
        lblNhapSP.setBounds(20, 10, 200, 25);
        panelNhapSP.add(lblNhapSP);

        JTextField txtMaSPNhap = new JTextField("Nhập Mã SP");
        txtMaSPNhap.setFont(placeholderFont);
        txtMaSPNhap.setForeground(placeholderColor);
        txtMaSPNhap.setBounds(20, 40, 150, 25);
        txtMaSPNhap.setBorder(roundedBorder);
        txtMaSPNhap.setToolTipText("Nhập Mã SP");
        panelNhapSP.add(txtMaSPNhap);
        addPlaceholderListener(txtMaSPNhap, "Nhập Mã SP");

        JSpinner spinnerSoLuong = new JSpinner(new SpinnerNumberModel(0, 0, 1000, 1));
        spinnerSoLuong.setBounds(190, 40, 80, 25);
        spinnerSoLuong.setBorder(roundedBorder);
        panelNhapSP.add(spinnerSoLuong);

        JTextField txtLieuLuong = new JTextField("Nhập Liều lượng");
        txtLieuLuong.setFont(placeholderFont);
        txtLieuLuong.setForeground(placeholderColor);
        txtLieuLuong.setBounds(290, 40, 227, 25);
        txtLieuLuong.setBorder(roundedBorder);
        txtLieuLuong.setToolTipText("Nhập Liều lượng");
        panelNhapSP.add(txtLieuLuong);
        addPlaceholderListener(txtLieuLuong, "Nhập Liều lượng");

        JButton btnThemSP = new JButton("Thêm");
        btnThemSP.setBounds(527, 39, 120, 30);
        btnThemSP.setForeground(Color.WHITE);
        btnThemSP.setFocusPainted(false);
        btnThemSP.setFont(new Font("Segoe UI", Font.BOLD, 13));
        btnThemSP.setBackground(headerButtonColor); // Sử dụng màu xanh dương
        panelNhapSP.add(btnThemSP);

        JButton btnLamMoiSP = new JButton("Làm mới");
        btnLamMoiSP.setBounds(693, 39, 100, 30);
        btnLamMoiSP.setForeground(Color.WHITE);
        btnLamMoiSP.setFocusPainted(false);
        btnLamMoiSP.setFont(new Font("Segoe UI", Font.BOLD, 13));
        btnLamMoiSP.setBackground(new Color(255, 167, 38));
        panelNhapSP.add(btnLamMoiSP);

        // --- Bảng thông tin sản phẩm ---
        JPanel panelSP = new JPanel(new BorderLayout());
        panelSP.setBounds(30, 270, 1660, 150);
        panelSP.setBackground(Color.WHITE);
        panelSP.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(Color.LIGHT_GRAY),
                "Thông tin sản phẩm", TitledBorder.LEFT, TitledBorder.TOP,
                new Font("Segoe UI", Font.BOLD, 14),
                Color.DARK_GRAY));
        add(panelSP);

        String[] colSP = {"Mã SP", "Tên SP", "Ngày sản xuất", "Hạn sử dụng", "Nhà sản xuất", "Số lượng tồn", "Đơn giá", "Thuế", "Đơn vị tính", "Mô tả", "Trạng thái", "Loại SP", "Danh mục"};
        JTable tableSP = new JTable(new DefaultTableModel(null, colSP));
        JScrollPane scrollPaneSP = new JScrollPane(tableSP);
        panelSP.add(scrollPaneSP, BorderLayout.CENTER);
        scrollPaneSP.setPreferredSize(new Dimension(scrollPaneSP.getWidth(), 120));
        // Thiết lập màu header cho bảng thông tin sản phẩm
        JTableHeader headerSP = tableSP.getTableHeader();
        headerSP.setBackground(headerButtonColor);
        headerSP.setForeground(Color.WHITE);

        // --- Bảng sản phẩm đã thêm ---
        JPanel panelSPThem = new JPanel(new BorderLayout());
        panelSPThem.setBounds(30, 440, 1660, 180);
        panelSPThem.setBackground(Color.WHITE);
        panelSPThem.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(Color.LIGHT_GRAY),
                "Sản phẩm đã thêm", TitledBorder.LEFT, TitledBorder.TOP,
                new Font("Segoe UI", Font.BOLD, 14),
                Color.DARK_GRAY));
        add(panelSPThem);

        String[] colSPThem = {"STT", "Mã SP", "Tên SP", "Số lượng", "Đơn vị tính", "Đơn giá", "Ngày hết hạn", "Liều lượng", "Thành tiền", "Hành động"};
        JTable tableThem = new JTable(new DefaultTableModel(null, colSPThem));
        JScrollPane scrollPaneThem = new JScrollPane(tableThem);
        panelSPThem.add(scrollPaneThem, BorderLayout.CENTER);
        // Thiết lập màu header cho bảng sản phẩm đã thêm
        JTableHeader headerThem = tableThem.getTableHeader();
        headerThem.setBackground(headerButtonColor);
        headerThem.setForeground(Color.WHITE);

        // --- Panel khách hàng và thanh toán ---
        JPanel panelKH = new JPanel(null);
        panelKH.setBounds(30, 640, 1660, 200);
        panelKH.setBackground(Color.WHITE);
        panelKH.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(Color.LIGHT_GRAY),
                "Thông tin khách hàng và thanh toán", TitledBorder.LEFT, TitledBorder.TOP,
                new Font("Segoe UI", Font.BOLD, 14),
                Color.DARK_GRAY));
        panelKH.setLayout(null); 
        add(panelKH);

        JLabel lblSDT = new JLabel("Số điện thoại:");
        lblSDT.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        lblSDT.setBounds(20, 30, 100, 25);
        panelKH.add(lblSDT);

        JTextField txtSDT = new JTextField();
        txtSDT.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        txtSDT.setBounds(120, 28, 200, 25);
        txtSDT.setBorder(roundedBorder);
        panelKH.add(txtSDT);

        JLabel lblKhachHang = new JLabel("* Khách hàng:");
        lblKhachHang.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        lblKhachHang.setBounds(350, 30, 90, 25);
        panelKH.add(lblKhachHang);

        JTextField txtKhachHang = new JTextField("Khách hàng lẻ");
        txtKhachHang.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        txtKhachHang.setBounds(460, 28, 200, 25);
        txtKhachHang.setBorder(roundedBorder);
        panelKH.add(txtKhachHang);

        JLabel lblDiemTV = new JLabel("Sử dụng điểm thành viên:");
        lblDiemTV.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        lblDiemTV.setBounds(700, 30, 170, 25);
        panelKH.add(lblDiemTV);

        JSpinner spinnerDiem = new JSpinner(new SpinnerNumberModel(0, 0, 100, 1));
        spinnerDiem.setBounds(880, 28, 60, 25);
        spinnerDiem.setBorder(roundedBorder);
        panelKH.add(spinnerDiem);

        JButton btnToiDa = new JButton("Tối đa");
        btnToiDa.setBounds(950, 28, 75, 25);
        btnToiDa.setForeground(Color.WHITE);
        btnToiDa.setFocusPainted(false);
        btnToiDa.setFont(new Font("Segoe UI", Font.BOLD, 13));
        btnToiDa.setBackground(headerButtonColor); // Sử dụng màu xanh dương
        panelKH.add(btnToiDa);

        JLabel lblPTTT = new JLabel("Phương thức thanh toán:");
        lblPTTT.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        lblPTTT.setBounds(20, 70, 150, 25);
        panelKH.add(lblPTTT);

        JComboBox<String> cmbPTTT = new JComboBox<>(new String[]{"-- Chọn phương thức thanh toán --", "Tiền mặt", "Chuyển khoản", "Ví điện tử"});
        cmbPTTT.setBounds(190, 68, 250, 30);
        cmbPTTT.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        panelKH.add(cmbPTTT);

        JButton btnThemKH = new JButton("Thêm KH");
        btnThemKH.setBounds(460, 68, 100, 25);
        btnThemKH.setForeground(Color.WHITE);
        btnThemKH.setFocusPainted(false);
        btnThemKH.setFont(new Font("Segoe UI", Font.BOLD, 13));
        btnThemKH.setBackground(headerButtonColor); // Sử dụng màu xanh dương
        panelKH.add(btnThemKH);

        JLabel lblTongSP = new JLabel("Tổng số sản phẩm: ");
        lblTongSP.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        lblTongSP.setBounds(20, 120, 140, 25);
        panelKH.add(lblTongSP);

        JLabel lblSoSP = new JLabel("0 sản phẩm");
        lblSoSP.setForeground(Color.RED);
        lblSoSP.setBounds(160, 120, 200, 25);
        panelKH.add(lblSoSP);

        JLabel lblTongTienCanThanhToan = new JLabel("Tổng tiền cần thanh toán:");
        lblTongTienCanThanhToan.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        lblTongTienCanThanhToan.setBounds(20, 150, 180, 25);
        panelKH.add(lblTongTienCanThanhToan);

        JLabel lblTongTien = new JLabel("0 VND");
        lblTongTien.setForeground(Color.RED);
        lblTongTien.setBounds(200, 150, 200, 25);
        panelKH.add(lblTongTien);

        JLabel lblTienDuocGiam = new JLabel("Tiền được giảm:");
        lblTienDuocGiam.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        lblTienDuocGiam.setBounds(400, 150, 130, 25);
        panelKH.add(lblTienDuocGiam);

        JLabel lblGiam = new JLabel("0 VND");
        lblGiam.setForeground(Color.RED);
        lblGiam.setBounds(530, 150, 200, 25);
        panelKH.add(lblGiam);

        JButton btnLuuTam = new JButton("Lưu tạm hóa đơn");
        btnLuuTam.setBounds(1200, 150, 180, 35);
        btnLuuTam.setForeground(Color.WHITE);
        btnLuuTam.setFocusPainted(false);
        btnLuuTam.setFont(new Font("Segoe UI", Font.BOLD, 13));
        btnLuuTam.setBackground(new Color(52, 122, 228));
        panelKH.add(btnLuuTam);

        JButton btnThanhToan = new JButton("Thanh toán");
        btnThanhToan.setBounds(1400, 150, 180, 35);
        btnThanhToan.setForeground(Color.WHITE);
        btnThanhToan.setFocusPainted(false);
        btnThanhToan.setFont(new Font("Segoe UI", Font.BOLD, 13));
        btnThanhToan.setBackground(new Color(52, 122, 228));
        panelKH.add(btnThanhToan);
    }

    private void addPlaceholderListener(JTextField textField, String placeholderText) {
        textField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if (textField.getText().equals(placeholderText)) {
                    textField.setText("");
                    textField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
                    textField.setForeground(Color.BLACK);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (textField.getText().isEmpty()) {
                    textField.setText(placeholderText);
                    textField.setFont(placeholderFont);
                    textField.setForeground(placeholderColor);
                }
            }
        });

        textField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                if (textField.getText().equals(placeholderText)) {
                    textField.setText("");
                    textField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
                    textField.setForeground(Color.BLACK);
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                if (textField.getText().isEmpty()) {
                    textField.setText(placeholderText);
                    textField.setFont(placeholderFont);
                    textField.setForeground(placeholderColor);
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                // Không cần xử lý sự kiện này cho plain text components
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Giao diện quản lý bán hàng");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(new BanHang());
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}