package gui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import com.formdev.flatlaf.FlatLightLaf;


public class Login extends JFrame implements ActionListener, MouseListener {
	private JPanel contentPane;
//	private TaiKhoan_DAO taiKhoan_DAO;
	private JTextField tTenDangNhap;
	private JButton btnDangNhap;
	private JPasswordField tMatKhau;

	public Login() {

//		taiKhoan_DAO = new TaiKhoan_DAO();
		FlatLightLaf.setup();
		UIManager.put("PasswordField.showRevealButton", true);

		this.setTitle("Đăng nhập");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(600, 500);
		this.setResizable(false);
		this.setLocationRelativeTo(null);

		// Content pane
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		// Tiêu đề
		JPanel panelHeader = new JPanel();
		panelHeader.setBackground(new Color(52, 122, 228));
		panelHeader.setLayout(new BoxLayout(panelHeader, BoxLayout.Y_AXIS));
		panelHeader.setBorder(new EmptyBorder(20, 0, 20, 0));
		contentPane.add(panelHeader, BorderLayout.NORTH);

		JLabel lblTitle = new JLabel("ĐĂNG NHẬP VÀO HỆ THỐNG DR.CHEN");
		lblTitle.setForeground(Color.WHITE);
		lblTitle.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 28));
		lblTitle.setAlignmentX(Component.CENTER_ALIGNMENT);
		panelHeader.add(lblTitle);
		
		JPanel panel = new JPanel(new GridBagLayout()); // layout giúp canh giữa
		panel.setBackground(Color.WHITE);
		contentPane.add(panel, BorderLayout.WEST);

		JLabel lblNewLabel = new JLabel();
		lblNewLabel.setIcon(new ImageIcon(Login.class.getResource("/img/logo.png")));
		panel.add(lblNewLabel); // tự động canh giữa

		// Thân
		JPanel panelForm = new JPanel();
		panelForm.setBackground(new Color(255, 255, 255));
		panelForm.setLayout(new BoxLayout(panelForm, BoxLayout.Y_AXIS));
		panelForm.setAlignmentX(Component.CENTER_ALIGNMENT);
		panelForm.setOpaque(false);
		panelForm.setBorder(new EmptyBorder(30, 50, 30, 50));
		contentPane.add(panelForm, BorderLayout.CENTER);

		// ====== Tên đăng nhập ======
		JPanel panelTenDN_Label = new JPanel(new FlowLayout(FlowLayout.LEFT));
		panelTenDN_Label.setBackground(new Color(255, 255, 255));
		JLabel lb1 = new JLabel("Tên đăng nhập:");
		lb1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lb1.setPreferredSize(new Dimension(150, 30));
		panelTenDN_Label.add(lb1);
		panelForm.add(panelTenDN_Label);

		// Panel chứa TextField với BoxLayout để nó co giãn tốt
		JPanel panelTenDN_Field = new JPanel();
		panelTenDN_Field.setBackground(new Color(255, 255, 255));
		panelTenDN_Field.setLayout(new BoxLayout(panelTenDN_Field, BoxLayout.X_AXIS));

		tTenDangNhap = new JTextField("quandz");
		tTenDangNhap.setFont(new Font("Tahoma", Font.PLAIN, 18));
		tTenDangNhap.setMaximumSize(new Dimension(Integer.MAX_VALUE, 45));
		tTenDangNhap.setPreferredSize(new Dimension(400, 45)); // fallback kích thước ban đầu
		tTenDangNhap.setMinimumSize(new Dimension(200, 45));

		panelTenDN_Field.add(tTenDangNhap);
		panelForm.add(panelTenDN_Field);

		// Khoảng cách phía dưới
		panelForm.add(Box.createVerticalStrut(20));
		
		// ====== Mật khẩu ======
		JPanel panelMatKhau_Label = new JPanel(new FlowLayout(FlowLayout.LEFT));
		panelMatKhau_Label.setBackground(new Color(255, 255, 255));
		JLabel lb2 = new JLabel("Mật khẩu:");
		lb2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lb2.setPreferredSize(new Dimension(150, 30));
		panelMatKhau_Label.add(lb2);
		panelForm.add(panelMatKhau_Label);

		// Panel chứa field mật khẩu với BoxLayout để co giãn theo chiều ngang
		JPanel panelMatKhau_Field = new JPanel();
		panelMatKhau_Field.setLayout(new BoxLayout(panelMatKhau_Field, BoxLayout.X_AXIS));

		tMatKhau = new JPasswordField("123");
		tMatKhau.setFont(new Font("Tahoma", Font.PLAIN, 18));
		tMatKhau.setMaximumSize(new Dimension(Integer.MAX_VALUE, 45));
		tMatKhau.setPreferredSize(new Dimension(400, 45)); // fallback
		tMatKhau.setMinimumSize(new Dimension(200, 45));

		panelMatKhau_Field.add(tMatKhau);
		panelForm.add(panelMatKhau_Field);

		// Khoảng cách phía dưới
		panelForm.add(Box.createVerticalStrut(10));

		// ====== Quên mật khẩu ======
		JLabel lblQuenMK = new JLabel("Quên mật khẩu?");
		lblQuenMK.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblQuenMK.setForeground(new Color(0, 128, 255));
		lblQuenMK.setAlignmentX(Component.CENTER_ALIGNMENT);
		panelForm.add(lblQuenMK);

		panelForm.add(Box.createVerticalStrut(30));

		// ====== Nút đăng nhập ======
		btnDangNhap = new JButton("ĐĂNG NHẬP");
		btnDangNhap.setFont(new Font("Tahoma", Font.PLAIN, 22));
		btnDangNhap.setIcon(new ImageIcon(Login.class.getResource("/img/icons8-login-40.png")));
		btnDangNhap.setAlignmentX(Component.CENTER_ALIGNMENT);
		panelForm.add(btnDangNhap);

		tMatKhau.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					btnDangNhap.doClick();
				} else if (e.getKeyCode() == KeyEvent.VK_UP) {
					tTenDangNhap.requestFocus();
				}
			}
		});

		tTenDangNhap.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					btnDangNhap.doClick();
				} else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
					tMatKhau.requestFocus();
				}
			}
		});

		btnDangNhap.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(btnDangNhap)) {
			String textUser = tTenDangNhap.getText().trim();
			String textPassword = new String(tMatKhau.getPassword());

			if (textUser.isEmpty()) {
				JOptionPane.showMessageDialog(this, "Vui lòng nhập tên đăng nhập.");
				return;
			}
			if (textPassword.isEmpty()) {
				JOptionPane.showMessageDialog(this, "Vui lòng nhập mật khẩu.");
				return;
			}

//			TaiKhoan_Entity taiKhoan = taiKhoan_DAO.checkUser(textUser, textPassword);
			if (true) {
				try {
					Loading loading = new Loading();
					this.dispose();
					loading.setVisible(true);
					loading.setLocationRelativeTo(null);

					SwingWorker<Void, Integer> worker = new SwingWorker<Void, Integer>() {
						@Override
						protected Void doInBackground() throws Exception {
							for (int i = 0; i <= 100; i++) {
								Thread.sleep(10);
								publish(i);
							}
							return null;
						}

						@Override
						protected void process(java.util.List<Integer> chunks) {
							int progressValue = chunks.get(chunks.size() - 1);
							loading.updateProgress(progressValue);
						}

						@Override
						protected void done() {
							loading.dispose();
						}
					};
					worker.execute();
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			} else {
				JOptionPane.showMessageDialog(null, "Sai thông tin đăng nhập.");
			}
		}
	}

	@Override public void mouseClicked(MouseEvent e) {}
	@Override public void mousePressed(MouseEvent e) {}
	@Override public void mouseReleased(MouseEvent e) {}
	@Override public void mouseEntered(MouseEvent e) {}
	@Override public void mouseExited(MouseEvent e) {}
}
