package panelThongKe;

import javax.swing.*;
import java.awt.*;

public class PanelThongKeKhachHang extends JPanel {
    public PanelThongKeKhachHang() {
        setBackground(Color.WHITE);
        setLayout(new BorderLayout());
        add(new JLabel("Thống kê khách hàng", SwingConstants.CENTER), BorderLayout.CENTER);
    }
}
