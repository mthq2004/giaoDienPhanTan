package gui;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class HoaDon extends JPanel {

	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public HoaDon() {
		this.setLayout(null);
        this.setBackground(Color.WHITE);
        this.setBounds(0, 0, 1600, 954);
        JPanel panel = new JPanel();
        panel.setBounds(0, 0, 172, 83);
        add(panel);
        
        JLabel lblNewLabel = new JLabel("JPanel Hóa đơn");
        panel.add(lblNewLabel);
	}

}
