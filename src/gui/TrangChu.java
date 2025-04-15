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
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

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
		
		panelTrangChu = new JPanel();
		main.add(panelTrangChu, BorderLayout.CENTER);
		
		trangChu = new JPanel();
		trangChu.setBorder(new EmptyBorder(25, 0, 25, 0));
		trangChu.setBackground(new Color(255, 255, 255));
		navbar.add(trangChu);
		trangChu.setLayout(new BorderLayout(0, 0));
		
		btnTrangChu = new JButton("Trang chủ");
		btnTrangChu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnTrangChu.setForeground(new Color(128, 128, 128));
		btnTrangChu.setBackground(new Color(128, 128, 128));
		btnTrangChu.setIcon(new ImageIcon(TrangChu.class.getResource("/img/icons8-home-32.png")));
		btnTrangChu.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnTrangChu.setContentAreaFilled(false);
		btnTrangChu.setHorizontalAlignment(SwingConstants.LEFT);
		btnTrangChu.setBorderPainted(false);
		trangChu.add(btnTrangChu);
		
		sanPham = new JPanel();
		sanPham.setBorder(new EmptyBorder(25, 0, 25, 0));
		sanPham.setBackground(Color.WHITE);
		navbar.add(sanPham);
		sanPham.setLayout(new BorderLayout(0, 0));
		
		btnSanPham = new JButton("Sản phẩm");
		btnSanPham.setIcon(new ImageIcon(TrangChu.class.getResource("/img/icons8-medicine-32.png")));
		btnSanPham.setHorizontalAlignment(SwingConstants.LEFT);
		btnSanPham.setForeground(Color.GRAY);
		btnSanPham.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnSanPham.setContentAreaFilled(false);
		btnSanPham.setBorderPainted(false);
		btnSanPham.setBackground(Color.GRAY);
		sanPham.add(btnSanPham, BorderLayout.CENTER);
		
		khachHang = new JPanel();
		khachHang.setBorder(new EmptyBorder(25, 0, 25, 0));
		khachHang.setBackground(Color.WHITE);
		navbar.add(khachHang);
		khachHang.setLayout(new BorderLayout(0, 0));
		
		btnKhachHang = new JButton("Khách hàng");
		btnKhachHang.setIcon(new ImageIcon(TrangChu.class.getResource("/img/icons8-customers-32.png")));
		btnKhachHang.setHorizontalAlignment(SwingConstants.LEFT);
		btnKhachHang.setForeground(Color.GRAY);
		btnKhachHang.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnKhachHang.setContentAreaFilled(false);
		btnKhachHang.setBorderPainted(false);
		btnKhachHang.setBackground(Color.GRAY);
		khachHang.add(btnKhachHang, BorderLayout.CENTER);
		
		nhanVien = new JPanel();
		nhanVien.setBorder(new EmptyBorder(25, 0, 25, 0));
		nhanVien.setBackground(Color.WHITE);
		navbar.add(nhanVien);
		nhanVien.setLayout(new BorderLayout(0, 0));
		
		btnNhanVien = new JButton("Nhân viên");
		btnNhanVien.setIcon(new ImageIcon(TrangChu.class.getResource("/img/icons8-employees-32.png")));
		btnNhanVien.setHorizontalAlignment(SwingConstants.LEFT);
		btnNhanVien.setForeground(Color.GRAY);
		btnNhanVien.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNhanVien.setContentAreaFilled(false);
		btnNhanVien.setBorderPainted(false);
		btnNhanVien.setBackground(Color.GRAY);
		nhanVien.add(btnNhanVien, BorderLayout.CENTER);
		
		nhaCungCap = new JPanel();
		nhaCungCap.setBorder(new EmptyBorder(25, 0, 25, 0));
		nhaCungCap.setBackground(Color.WHITE);
		navbar.add(nhaCungCap);
		nhaCungCap.setLayout(new BorderLayout(0, 0));
		
		btnNhaCungCap = new JButton("Nhà cung cấp");
		btnNhaCungCap.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNhaCungCap.setIcon(new ImageIcon(TrangChu.class.getResource("/img/icons8-supplier-32.png")));
		btnNhaCungCap.setHorizontalAlignment(SwingConstants.LEFT);
		btnNhaCungCap.setForeground(Color.GRAY);
		btnNhaCungCap.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNhaCungCap.setContentAreaFilled(false);
		btnNhaCungCap.setBorderPainted(false);
		btnNhaCungCap.setBackground(Color.GRAY);
		nhaCungCap.add(btnNhaCungCap, BorderLayout.CENTER);
		
		hoaDon = new JPanel();
		hoaDon.setBorder(new EmptyBorder(25, 0, 25, 0));
		hoaDon.setBackground(Color.WHITE);
		navbar.add(hoaDon);
		hoaDon.setLayout(new BorderLayout(0, 0));
		
		btnHoaDon = new JButton("Hóa đơn");
		btnHoaDon.setIcon(new ImageIcon(TrangChu.class.getResource("/img/icons8-bill-32.png")));
		btnHoaDon.setHorizontalAlignment(SwingConstants.LEFT);
		btnHoaDon.setForeground(Color.GRAY);
		btnHoaDon.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnHoaDon.setContentAreaFilled(false);
		btnHoaDon.setBorderPainted(false);
		btnHoaDon.setBackground(Color.GRAY);
		hoaDon.add(btnHoaDon, BorderLayout.CENTER);
		
		thongKe = new JPanel();
		thongKe.setBorder(new EmptyBorder(25, 0, 25, 0));
		thongKe.setBackground(Color.WHITE);
		navbar.add(thongKe);
		thongKe.setLayout(new BorderLayout(0, 0));
		
		btnThongKe = new JButton("Thống kê");
		btnThongKe.setIcon(new ImageIcon(TrangChu.class.getResource("/img/icons8-statistic-32.png")));
		btnThongKe.setHorizontalAlignment(SwingConstants.LEFT);
		btnThongKe.setForeground(Color.GRAY);
		btnThongKe.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnThongKe.setContentAreaFilled(false);
		btnThongKe.setBorderPainted(false);
		btnThongKe.setBackground(Color.GRAY);
		thongKe.add(btnThongKe, BorderLayout.CENTER);
		
		about = new JPanel();
		about.setBorder(new EmptyBorder(25, 0, 25, 0));
		about.setBackground(Color.WHITE);
		navbar.add(about);
		about.setLayout(new BorderLayout(0, 0));
		
		btnAbout = new JButton("Về chúng tôi");
		btnAbout.setIcon(new ImageIcon(TrangChu.class.getResource("/img/icons8-about-32.png")));
		btnAbout.setHorizontalAlignment(SwingConstants.LEFT);
		btnAbout.setForeground(Color.GRAY);
		btnAbout.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnAbout.setContentAreaFilled(false);
		btnAbout.setBorderPainted(false);
		btnAbout.setBackground(Color.GRAY);
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
	}   

	@Override
	public void mouseExited(MouseEvent e) {
	   
	}

	
}