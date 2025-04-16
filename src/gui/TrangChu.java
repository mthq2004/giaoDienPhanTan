package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;

import com.formdev.flatlaf.FlatLightLaf;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridBagLayout;

import javax.swing.SwingConstants;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Map;
import java.awt.FlowLayout;

public class TrangChu extends JFrame implements ActionListener, MouseListener{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel panel_1;
	private JPanel trangChu;
	private JButton btnTrangChu;
	private JPanel right_main;
	private JPanel right_header;
	private JPanel tenKH;
	private JLabel ten_lab;
	private JTextField tfTenKH;
	private JPanel soDT;
	private JLabel soDT_lab;
	private JTextField tfSoDT;
	private JTable table;
	private JPanel panelLogo;
	private JPanel paneTrong_2;
//	private Mon_DAO mon_dao = new Mon_DAO();
//	private ArrayList<Mon> dsMon;
	private JLabel lbTenMon;
	private JButton btnThem;
	private JPanel body;
	private Object selectedButton;
	private JPopupMenu manageMenu;
	private DefaultTableModel model;
	private JPanel header;
	private JPanel main;
	private JPanel sanPham;
	private JButton btnSanPham;
	private JPanel khachHang;
	private JButton btnKhachHang;
	private JPanel nhanVien;
	private JButton btnNhanVien;
	private JPanel nhaCungCap;
	private JButton btnNhaCungCap;
	private JPanel hoaDon;
	private JPanel thongKe;
	private JButton btnThongKe;
	private JButton btnHoaDon;
	private JPanel about;
	private JButton btnAbout;
	private JPanel paneTrong;
	private JPanel panelTrangChu;
	private JLabel lbLogo;
	private JPanel panelNameApp;
	private JPanel panelAccount;
	private JLabel lbAnh;
	private JPanel panelAccountInformation;
	private JLabel lbNameApp;
	private JLabel lbNameUser;
	private JLabel lbRoleUser;
	private JPanel nav;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TrangChu frame = new TrangChu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TrangChu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);getContentPane().setLayout(new BorderLayout(0, 0));
		setResizable(false);
		setTitle("Quản lý quán cà phê");
		setSize(new Dimension(1920, 1080));
		setLocationRelativeTo(null);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel navbar = new JPanel();
		navbar.setBackground(new Color(255, 255, 255));
		navbar.setBorder(new MatteBorder(0, 0, 0, 2, new Color(52, 122, 228)));
		contentPane.add(navbar, BorderLayout.WEST);
		navbar.setLayout(new BoxLayout(navbar, BoxLayout.Y_AXIS));
		
		panelLogo = new JPanel();
		panelLogo.setBackground(new Color(255, 255, 255));
		navbar.add(panelLogo);
		panelLogo.setLayout(new BorderLayout(0, 0));
		
		lbLogo = new JLabel("");
		lbLogo.setIcon(new ImageIcon(TrangChu.class.getResource("/img/logo.png")));
		panelLogo.add(lbLogo, BorderLayout.NORTH);
		
		body = new JPanel();
		body.setLayout(new BorderLayout());
		contentPane.add(body, BorderLayout.CENTER);
		
		header = new JPanel();
		header.setBackground(new Color(52, 122, 228));
		body.add(header, BorderLayout.NORTH);
		header.setLayout(new BorderLayout(0, 0));
		
		panelNameApp = new JPanel(new GridBagLayout()); // căn giữa cả ngang và dọc
		panelNameApp.setPreferredSize(new Dimension(400, 80)); // tăng kích thước panel
		panelNameApp.setBackground(new Color(52, 122, 228));
		header.add(panelNameApp, BorderLayout.CENTER);

		lbNameApp = new JLabel("DR.CHEN ");
		lbNameApp.setForeground(new Color(255, 255, 255));
		lbNameApp.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 21));
		panelNameApp.setPreferredSize(new Dimension(0, 80)); // rộng tự giãn, cao 80
		panelNameApp.add(lbNameApp); // tự động căn giữa nhờ GridBagLayout

		
		panelAccount = new JPanel();
		panelAccount.setBackground(new Color(52, 122, 228));
		panelAccount.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // padding nhẹ
		header.add(panelAccount, BorderLayout.EAST);
		panelAccount.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		// Ảnh đại diện
		lbAnh = new JLabel("");
		lbAnh.setIcon(new ImageIcon(TrangChu.class.getResource("/img/icons8-account-40.png")));
		lbAnh.setAlignmentX(Component.CENTER_ALIGNMENT); // căn giữa trong BoxLayout
		panelAccount.add(lbAnh);

		// Thông tin người dùng
		panelAccountInformation = new JPanel();
		panelAccountInformation.setBackground(new Color(52, 122, 228));
		panelAccountInformation.setLayout(new GridLayout(2, 1, 0, 0));
		panelAccountInformation.setAlignmentX(Component.CENTER_ALIGNMENT); // căn giữa
		panelAccount.add(panelAccountInformation);

		// Tên người dùng
		lbNameUser = new JLabel("Name user");
		lbNameUser.setForeground(new Color(255, 255, 255));
		lbNameUser.setFont(new Font("Tahoma", Font.BOLD, 18));
		lbNameUser.setHorizontalAlignment(SwingConstants.LEFT); // căn giữa trong ô Grid
		panelAccountInformation.add(lbNameUser);

		// Vai trò người dùng
		lbRoleUser = new JLabel("Role user");
		lbRoleUser.setFont(new Font("Tahoma", Font.BOLD, 16));
		lbRoleUser.setForeground(new Color(0, 255, 0));
		lbRoleUser.setHorizontalAlignment(SwingConstants.LEFT); // căn giữa trong ô Grid
		panelAccountInformation.add(lbRoleUser);

		
		main = new JPanel();
		body.add(main, BorderLayout.CENTER);
		main.setLayout(new BorderLayout(0, 0));
		
		nav = new JPanel();
		nav.setBackground(new Color(255, 255, 255));
		navbar.add(nav);
		
		nav.setLayout(new BoxLayout(nav, BoxLayout.Y_AXIS));
		panelTrangChu = new JPanel();
		main.add(panelTrangChu, BorderLayout.CENTER);
		
		trangChu = new JPanel();
		trangChu.setBorder(new EmptyBorder(20, 0, 20, 0));
		trangChu.setBackground(new Color(255, 255, 255));
		nav.add(trangChu);
		trangChu.setLayout(new BorderLayout(0, 0));
		
		btnTrangChu = new JButton("Trang chủ");
		btnTrangChu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnTrangChu.setHorizontalAlignment(SwingConstants.LEFT);
		btnTrangChu.setIcon(new ImageIcon(TrangChu.class.getResource("/img/icons8-home-32.png")));
		btnTrangChu.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnTrangChu.setVerticalAlignment(SwingConstants.CENTER); // Căn giữa theo chiều dọc
		btnTrangChu.setIconTextGap(15); // Tùy chỉnh khoảng cách
		btnTrangChu.setPreferredSize(new Dimension(200, 50)); // Chiều rộng 200, chiều cao 50
		btnTrangChu.setBorder(null);
		btnTrangChu.setBorderPainted(false);
		btnTrangChu.setFocusPainted(false);
		btnTrangChu.setContentAreaFilled(false);
		btnTrangChu.setOpaque(false);
		btnTrangChu.setForeground(Color.GRAY);
		btnTrangChu.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 10)); // top, left, bottom, right

		trangChu.add(btnTrangChu);
		
		sanPham = new JPanel();
		sanPham.setBorder(new EmptyBorder(20, 0, 20, 0));
		sanPham.setBackground(Color.WHITE);
		nav.add(sanPham);
		sanPham.setLayout(new BorderLayout(0, 0));
		
		btnSanPham = new JButton("Sản phẩm");
		btnSanPham.setHorizontalAlignment(SwingConstants.LEFT);
		btnSanPham.setIcon(new ImageIcon(TrangChu.class.getResource("/img/icons8-medicine-32.png")));
		btnSanPham.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnSanPham.setVerticalAlignment(SwingConstants.CENTER);
		btnSanPham.setIconTextGap(15);
		btnSanPham.setPreferredSize(new Dimension(200, 50));
		btnSanPham.setBorder(null);
		btnSanPham.setBorderPainted(false);
		btnSanPham.setFocusPainted(false);
		btnSanPham.setContentAreaFilled(false);
		btnSanPham.setOpaque(false);
		btnSanPham.setForeground(Color.GRAY);
		btnSanPham.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 10)); // top, left, bottom, right
		
		sanPham.add(btnSanPham, BorderLayout.CENTER);
		
		khachHang = new JPanel();
		khachHang.setBorder(new EmptyBorder(20, 0, 20, 0));
		khachHang.setBackground(Color.WHITE);
		nav.add(khachHang);
		khachHang.setLayout(new BorderLayout(0, 0));
		
		btnKhachHang = new JButton("Khách hàng");
		btnKhachHang.setHorizontalAlignment(SwingConstants.LEFT);
		btnKhachHang.setIcon(new ImageIcon(TrangChu.class.getResource("/img/icons8-customers-32.png")));
		btnKhachHang.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnKhachHang.setVerticalAlignment(SwingConstants.CENTER);
		btnKhachHang.setIconTextGap(15);
		btnKhachHang.setPreferredSize(new Dimension(200, 50));
		btnKhachHang.setBorder(null);
		btnKhachHang.setBorderPainted(false);
		btnKhachHang.setFocusPainted(false);
		btnKhachHang.setContentAreaFilled(false);
		btnKhachHang.setOpaque(false);
		btnKhachHang.setForeground(Color.GRAY);
		btnKhachHang.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 10)); // top, left, bottom, right
		
		khachHang.add(btnKhachHang, BorderLayout.CENTER);
		
		nhanVien = new JPanel();
		nhanVien.setBorder(new EmptyBorder(20, 0, 20, 0));
		nhanVien.setBackground(Color.WHITE);
		nav.add(nhanVien);
		nhanVien.setLayout(new BorderLayout(0, 0));
		
		btnNhanVien = new JButton("Nhân viên");
		btnNhanVien.setHorizontalAlignment(SwingConstants.LEFT);
		btnNhanVien.setIcon(new ImageIcon(TrangChu.class.getResource("/img/icons8-employees-32.png")));
		btnNhanVien.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNhanVien.setVerticalAlignment(SwingConstants.CENTER);
		btnNhanVien.setIconTextGap(15);
		btnNhanVien.setPreferredSize(new Dimension(200, 50));
		btnNhanVien.setBorder(null);
		btnNhanVien.setBorderPainted(false);
		btnNhanVien.setFocusPainted(false);
		btnNhanVien.setContentAreaFilled(false);
		btnNhanVien.setOpaque(false);
		btnNhanVien.setForeground(Color.GRAY);
		btnNhanVien.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 10)); // top, left, bottom, right
		
		nhanVien.add(btnNhanVien, BorderLayout.CENTER);
		
		nhaCungCap = new JPanel();
		nhaCungCap.setBorder(new EmptyBorder(20, 0, 20, 0));
		nhaCungCap.setBackground(Color.WHITE);
		nav.add(nhaCungCap);
		nhaCungCap.setLayout(new BorderLayout(0, 0));
		
		btnNhaCungCap = new JButton("Nhà cung cấp");
		btnNhaCungCap.setHorizontalAlignment(SwingConstants.LEFT);
		btnNhaCungCap.setIcon(new ImageIcon(TrangChu.class.getResource("/img/icons8-supplier-32.png")));
		btnNhaCungCap.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNhaCungCap.setVerticalAlignment(SwingConstants.CENTER);
		btnNhaCungCap.setIconTextGap(15);
		btnNhaCungCap.setPreferredSize(new Dimension(200, 50));
		btnNhaCungCap.setBorder(null);
		btnNhaCungCap.setBorderPainted(false);
		btnNhaCungCap.setFocusPainted(false);
		btnNhaCungCap.setContentAreaFilled(false);
		btnNhaCungCap.setOpaque(false);
		btnNhaCungCap.setForeground(Color.GRAY);
		btnNhaCungCap.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 10)); // top, left, bottom, right
		
		nhaCungCap.add(btnNhaCungCap, BorderLayout.CENTER);
		
		hoaDon = new JPanel();
		hoaDon.setBorder(new EmptyBorder(20, 0, 20, 0));
		hoaDon.setBackground(Color.WHITE);
		nav.add(hoaDon);
		hoaDon.setLayout(new BorderLayout(0, 0));
		

		btnHoaDon = new JButton("Hóa đơn");
		btnHoaDon.setHorizontalAlignment(SwingConstants.LEFT);
		btnHoaDon.setIcon(new ImageIcon(TrangChu.class.getResource("/img/icons8-bill-32.png")));
		btnHoaDon.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnHoaDon.setVerticalAlignment(SwingConstants.CENTER);
		btnHoaDon.setIconTextGap(15);
		btnHoaDon.setPreferredSize(new Dimension(200, 50));
		btnHoaDon.setBorder(null);
		btnHoaDon.setBorderPainted(false);
		btnHoaDon.setFocusPainted(false);
		btnHoaDon.setContentAreaFilled(false);
		btnHoaDon.setOpaque(false);
		btnHoaDon.setForeground(Color.GRAY);
		btnHoaDon.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 10)); // top, left, bottom, right
		
		hoaDon.add(btnHoaDon, BorderLayout.CENTER);
		
		thongKe = new JPanel();
		thongKe.setBorder(new EmptyBorder(20, 0, 20, 0));
		thongKe.setBackground(Color.WHITE);
		nav.add(thongKe);
		thongKe.setLayout(new BorderLayout(0, 0));
		
		btnThongKe = new JButton("Thống kê");
		btnThongKe.setHorizontalAlignment(SwingConstants.LEFT);
		btnThongKe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnThongKe.setIcon(new ImageIcon(TrangChu.class.getResource("/img/icons8-statistic-32.png")));
		btnThongKe.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnThongKe.setVerticalAlignment(SwingConstants.CENTER);
		btnThongKe.setIconTextGap(15);
		btnThongKe.setPreferredSize(new Dimension(200, 50));
		btnThongKe.setBorder(null);
		btnThongKe.setBorderPainted(false);
		btnThongKe.setFocusPainted(false);
		btnThongKe.setContentAreaFilled(false);
		btnThongKe.setOpaque(false);
		btnThongKe.setForeground(Color.GRAY);
		btnThongKe.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 10)); // top, left, bottom, right
		
		thongKe.add(btnThongKe, BorderLayout.CENTER);
		
		about = new JPanel();
		about.setBorder(new EmptyBorder(20, 0, 20, 0));
		about.setBackground(Color.WHITE);
		nav.add(about);
		about.setLayout(new BorderLayout(0, 0));
		
		btnAbout = new JButton("About");
		btnAbout.setHorizontalAlignment(SwingConstants.LEFT);
		btnAbout.setIcon(new ImageIcon(TrangChu.class.getResource("/img/icons8-about-32.png")));
		btnAbout.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnAbout.setVerticalAlignment(SwingConstants.CENTER);
		btnAbout.setIconTextGap(15);
		btnAbout.setPreferredSize(new Dimension(200, 50));
		btnAbout.setBorder(null);
		btnAbout.setBorderPainted(false);
		btnAbout.setFocusPainted(false);
		btnAbout.setContentAreaFilled(false);
		btnAbout.setOpaque(false);
		btnAbout.setForeground(Color.GRAY);
		btnAbout.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 10)); // top, left, bottom, right
		
		about.add(btnAbout, BorderLayout.CENTER);
		
		paneTrong = new JPanel();
		paneTrong.setPreferredSize(new Dimension(0,140));
		paneTrong.setBackground(Color.WHITE);
		navbar.add(paneTrong);
		paneTrong.setLayout(new BorderLayout(0, 0));
		
		
		
		btnTrangChu.addMouseListener(this);
		btnSanPham.addMouseListener(this);
		btnKhachHang.addMouseListener(this);
		btnNhanVien.addMouseListener(this);
		btnNhaCungCap.addMouseListener(this);
		btnHoaDon.addMouseListener(this);
		btnThongKe.addMouseListener(this);
		btnAbout.addMouseListener(this);
	}
	

	
	

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
	    Object o = e.getSource();
	    
	    if (o.equals(btnTrangChu)) {
	        main.removeAll();
	        main.add(panelTrangChu);
	        main.revalidate();
	        main.repaint();
	    }
	    
	    if (o.equals(btnSanPham)) {
	        main.removeAll();
	        main.add(new SanPham());
	        main.revalidate();
	        main.repaint();
	    }
	    
	    if (o.equals(btnKhachHang)) {
	        main.removeAll();
	        main.add(new KhachHang());
	        main.revalidate();
	        main.repaint();
	    }
	    
	    if (o.equals(btnNhanVien)) {
	        main.removeAll();
	        main.add(new NhanVien());
	        main.revalidate();
	        main.repaint();
	    }
	    
	    if (o.equals(btnNhaCungCap)) {
	        main.removeAll();
	        main.add(new NhaCungCap());
	        main.revalidate();
	        main.repaint();
	    }
	    
	    if (o.equals(btnHoaDon)) {
	        main.removeAll();
	        main.add(new HoaDon());
	        main.revalidate();
	        main.repaint();
	    }
	    
	    if (o.equals(btnThongKe)) {
	        main.removeAll();
	        main.add(new ThongKe());
	        main.revalidate();
	        main.repaint();
	    }
	    
	    if (o.equals(btnAbout)) {
	        main.removeAll();
	        main.add(new About());
	        main.revalidate();
	        main.repaint();
	    }
	    
	    
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		Object o = e.getSource();
		resetButtonColors(); // reset hết trước

		if (o instanceof JButton) {
			JButton hoveredButton = (JButton) o;
			hoveredButton.setForeground(Color.WHITE);
			hoveredButton.setBackground(new Color(52, 122, 228));
			hoveredButton.setOpaque(true);
		}
	}


	@Override
	public void mouseExited(MouseEvent e) {
		resetButtonColors(); // tùy chọn, có thể bỏ nếu thấy không cần
	}

	private void resetButtonColors() {
		Color defaultColor = Color.WHITE;
		Color defaultTextColor = Color.GRAY;

		JButton[] buttons = {
		    btnTrangChu, btnSanPham, btnKhachHang, btnNhanVien,
		    btnNhaCungCap, btnHoaDon, btnThongKe, btnAbout
		};

		for (JButton btn : buttons) {
		    btn.setBackground(defaultColor);
		    btn.setForeground(defaultTextColor);
		    btn.setOpaque(true);
		}
	}

	
}