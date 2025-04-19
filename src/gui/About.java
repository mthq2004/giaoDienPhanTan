package gui;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.ImageIcon;

public class About extends JPanel {

	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public About() {
		this.setLayout(null);
        this.setBackground(Color.WHITE);
        this.setBounds(0, 0, 1681, 954);
        JPanel panel = new JPanel();
        panel.setBounds(0, 0, 1681, 954);
        add(panel);
        panel.setLayout(null);
        
        JLabel lblNewLabel = new JLabel("JPanel About");
        lblNewLabel.setIcon(new ImageIcon(About.class.getResource("/img/ABOUT.png")));
        lblNewLabel.setBounds(0, 0, 1691, 954);
        panel.add(lblNewLabel);
	}

}