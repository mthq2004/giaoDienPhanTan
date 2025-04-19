package gui;

import javax.swing.*;

import panelThongKe.PanelThongKeDoanhThu;
import panelThongKe.PanelThongKeKhachHang;
import panelThongKe.PanelThongKeThongSoChiTiet;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ThongKe extends JPanel {

    private CardLayout cardLayout;
    private JPanel cardPanel;

    public ThongKe() {
        setLayout(null);
        setBackground(Color.WHITE);
        setBounds(0, 0, 1720, 1000);

        // Tạo các button chuyển panel
        JButton btnThongKeThongSoChiTiet = new JButton("Thống kê thông số chi tiết");
        btnThongKeThongSoChiTiet.setFont(new Font("Tahoma", Font.PLAIN, 13));
        JButton btnThongKeDoanhThu = new JButton("Thống kê doanh thu");
        btnThongKeDoanhThu.setFont(new Font("Tahoma", Font.PLAIN, 13));
        JButton btnThongKeKhachHang = new JButton("Thống kê khách hàng");
        btnThongKeKhachHang.setFont(new Font("Tahoma", Font.PLAIN, 13));

        btnThongKeThongSoChiTiet.setBounds(50, 20, 250, 40);
        btnThongKeDoanhThu.setBounds(310, 20, 200, 40);
        btnThongKeKhachHang.setBounds(520, 20, 200, 40);

        add(btnThongKeThongSoChiTiet);
        add(btnThongKeDoanhThu);
        add(btnThongKeKhachHang);

        // CardLayout để chứa các panel thống kê con
        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);
        cardPanel.setBounds(50, 80, 1623, 850);
        add(cardPanel);

        // Thêm các panel con
        PanelThongKeThongSoChiTiet panelChiTiet = new PanelThongKeThongSoChiTiet();
        PanelThongKeDoanhThu panelDoanhThu = new PanelThongKeDoanhThu();
        PanelThongKeKhachHang panelKhachHang = new PanelThongKeKhachHang();

        cardPanel.add(panelChiTiet, "ChiTiet");
        cardPanel.add(panelDoanhThu, "DoanhThu");
        cardPanel.add(panelKhachHang, "KhachHang");

        // Gán sự kiện cho nút
        btnThongKeThongSoChiTiet.addActionListener(e -> cardLayout.show(cardPanel, "ChiTiet"));
        btnThongKeDoanhThu.addActionListener(e -> cardLayout.show(cardPanel, "DoanhThu"));
        btnThongKeKhachHang.addActionListener(e -> cardLayout.show(cardPanel, "KhachHang"));

        // Mặc định hiển thị panel đầu tiên
        cardLayout.show(cardPanel, "ChiTiet");
    }
}
