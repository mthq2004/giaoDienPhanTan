package gui;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.formdev.flatlaf.FlatIntelliJLaf;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JProgressBar;

public class Loading extends JFrame {

    private JPanel contentPane;
    private JProgressBar progress;
    private JLabel txtLoad;
    private JLabel lblH;
    private JLabel value;

    public Loading() {
        FlatIntelliJLaf.setup();
        setUndecorated(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 600, 550);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(52, 122, 228));
        panel.setBounds(0, 0, 600, 550);
        contentPane.add(panel);
        panel.setLayout(null);

        ImageIcon rawIcon = new ImageIcon(Loading.class.getResource("/img/nen.jpg"));
        Image img = rawIcon.getImage();

        int width = img.getWidth(null);
        int height = img.getHeight(null);

        double scaleX = 900.0 / width;
        double scaleY = 364.0 / height;
        double scale = Math.min(scaleX, scaleY);

        Image scaledImage = img.getScaledInstance((int) (width * scale), (int) (height * scale), Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);

        JLabel lblNewLabel = new JLabel(scaledIcon);
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setBounds(0, 70, 600, 364);
        panel.add(lblNewLabel);

        txtLoad = new JLabel("Loading...");
        txtLoad.setFont(new Font("Tahoma", Font.PLAIN, 15));
        txtLoad.setForeground(Color.WHITE);
        txtLoad.setBounds(27, 442, 240, 30);
        panel.add(txtLoad);

        progress = new JProgressBar();
        progress.setBounds(27, 483, 550, 14);
        panel.add(progress);

        lblH = new JLabel("Hệ thống quản lý nhà thuốc DR.CHEN");
        lblH.setForeground(Color.WHITE);
        lblH.setFont(new Font("Dialog", Font.BOLD, 30));
        lblH.setHorizontalAlignment(SwingConstants.CENTER);
        lblH.setBounds(0, 0, 600, 53);
        panel.add(lblH);

        value = new JLabel("0 %");
        value.setHorizontalAlignment(SwingConstants.CENTER);
        value.setForeground(Color.WHITE);
        value.setFont(new Font("Arial", Font.PLAIN, 15));
        value.setBounds(491, 445, 86, 30);
        panel.add(value);
    }

    public void updateProgress(int value) {
        this.value.setText(value + " %");
        this.progress.setValue(value);

        switch (value) {
            case 10:
                txtLoad.setText("Turning On Modules ...");
                break;
            case 20:
                txtLoad.setText("Loading Modules ...");
                break;
            case 50:
                txtLoad.setText("Connecting to database ...");
                break;
            case 70:
                txtLoad.setText("Connection Successful!");
                break;
            case 90:
                txtLoad.setText("Launching Application ...");
                break;
            case 100:
                this.dispose();
                TrangChu trangChu = new TrangChu(); // Giả sử bạn đã có class TrangChu
                trangChu.setVisible(true);
                break;
        }
    }

    // MAIN để test
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            Loading loading = new Loading();
            loading.setVisible(true);

            new Thread(() -> {
                try {
                    for (int i = 0; i <= 100; i++) {
                        Thread.sleep(40); // tốc độ load
                        loading.updateProgress(i);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        });
    }
}
