package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CardLayoutExample extends JFrame {
    CardLayout cardLayout;
    JPanel cardPanel;

    public CardLayoutExample() {
        setTitle("Ví dụ CardLayout");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Tạo CardLayout và panel chứa các card
        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);

        // Tạo các "thẻ"
        JPanel card1 = new JPanel();
        card1.setBackground(Color.PINK);
        card1.add(new JLabel("Đây là Thẻ 1"));

        JPanel card2 = new JPanel();
        card2.setBackground(Color.CYAN);
        card2.add(new JLabel("Đây là Thẻ 2"));

        // Thêm các thẻ vào cardPanel
        cardPanel.add(card1, "card1");
        cardPanel.add(card2, "card2");

        // Tạo nút để chuyển thẻ
        JButton btnNext = new JButton("Tiếp theo");
        JButton btnBack = new JButton("Quay lại");

        btnNext.addActionListener(e -> cardLayout.next(cardPanel));
        btnBack.addActionListener(e -> cardLayout.previous(cardPanel));

        // Panel chứa nút
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(btnBack);
        buttonPanel.add(btnNext);

        // Thêm vào JFrame
        add(cardPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new CardLayoutExample().setVisible(true);
        });
    }
}
