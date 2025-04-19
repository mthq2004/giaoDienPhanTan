package panelThongKe;

import javax.swing.*;
import java.awt.*;

public class PanelThongKeDoanhThu extends JPanel {
    public PanelThongKeDoanhThu() {
        setBackground(Color.WHITE);
        setLayout(new BorderLayout());
        add(new JLabel("Thống kê doanh thu", SwingConstants.CENTER), BorderLayout.CENTER);
    }
}
