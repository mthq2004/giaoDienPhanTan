package panelThongKe;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.border.TitledBorder;

public class PanelThongKeThongSoChiTiet extends JPanel {
    public PanelThongKeThongSoChiTiet() {
        setBackground(Color.WHITE);
        setLayout(new BorderLayout());

        JPanel panelWrapper = new JPanel();
        TitledBorder border = new TitledBorder(
        	    BorderFactory.createLineBorder(Color.LIGHT_GRAY),
        	    "Thống kê thông số chi tiết",
        	    TitledBorder.LEADING,
        	    TitledBorder.TOP
        	);

    	// Set font tùy ý — ví dụ font to và đậm
    	border.setTitleFont(new Font("Segoe UI", Font.BOLD, 18));

    	// Gán lại cho panel
    	panelWrapper.setBorder(border);
        panelWrapper.setLayout(new BorderLayout());
        
        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new GridLayout(3, 3, 20, 20));
        contentPanel.setBackground(Color.WHITE);
        contentPanel.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));

        contentPanel.add(createCard("Tổng số thuốc", "110", getImage("/img/medicines-icon.png"), new Color(255, 69, 69)));
        contentPanel.add(createCard("Sản phẩm sắp hết tồn", "11", getImage("/img/available-medecine-icon.png"), new Color(0, 153, 0)));
        contentPanel.add(createCard("Tổng số nhân viên", "10", getImage("/img/employee-icon-2.png"), new Color(255, 187, 0)));

        contentPanel.add(createCard("Tổng số đơn hàng", "52", getImage("/img/invoice-icon.png"), new Color(255, 105, 180)));
        contentPanel.add(createCard("Sản phẩm sắp hết hạn", "17", getImage("/img/expire-medicine-icon.png"), new Color(0, 170, 255)));
        contentPanel.add(createCard("Tổng số nhà cung cấp", "6", getImage("/img/supplier-icon-2.png"), new Color(255, 102, 0)));

        contentPanel.add(createCard("Tổng số khách hàng", "12", getImage("/img/customer-icon-2.png"), new Color(0, 204, 204)));
        contentPanel.add(createCard("Tổng doanh thu", "29.734.200 VND", getImage("/img/chart-icon-2.png"), new Color(0, 200, 0)));
        panelWrapper.add(contentPanel, BorderLayout.CENTER);
        
        add(panelWrapper, BorderLayout.CENTER);
    }

    private JPanel createCard(String title, String value, ImageIcon icon, Color numberColor) {
        JPanel card = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2 = (Graphics2D) g;
                g2.setColor(Color.LIGHT_GRAY);
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 20, 20);
            }
        };
        card.setPreferredSize(new Dimension(240, 100));
        card.setLayout(new BorderLayout(10, 10));
        card.setBackground(Color.WHITE);
        card.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(220, 220, 220)),
            BorderFactory.createEmptyBorder(10, 10, 10, 10)
        ));

        JLabel iconLabel = new JLabel(icon);
        iconLabel.setPreferredSize(new Dimension(150, 150));
        iconLabel.setHorizontalAlignment(SwingConstants.CENTER);

        JLabel numberLabel = new JLabel(value);
        numberLabel.setFont(new Font("Segoe UI", Font.BOLD, 26));
        numberLabel.setForeground(numberColor);
        numberLabel.setHorizontalAlignment(SwingConstants.LEFT);

        JLabel titleLabel = new JLabel(title); // <-- Đúng ở đây nè
        titleLabel.setHorizontalAlignment(SwingConstants.LEFT);
        titleLabel.setFont(new Font("Segoe UI", Font.PLAIN, 20));

        JPanel centerPanel = new JPanel(new BorderLayout(5, 5));
        centerPanel.setOpaque(false);
        centerPanel.add(numberLabel, BorderLayout.CENTER);
        card.add(titleLabel, BorderLayout.SOUTH); // Cho title vào trong panel này luôn

        card.add(iconLabel, BorderLayout.WEST);
        card.add(centerPanel, BorderLayout.CENTER);

        return card;
    }

    private ImageIcon getImage(String path) {
        try {
            URL url = PanelThongKeThongSoChiTiet.class.getResource(path);
            if (url != null) {
                BufferedImage img = ImageIO.read(url);
                Image scaled = img.getScaledInstance(150, 150, Image.SCALE_SMOOTH);
                return new ImageIcon(scaled);
            }
        } catch (Exception e) {
            System.err.println("Không thể load ảnh: " + path);
        }
        return new ImageIcon(); // fallback icon trống
    }
}
