package Regex_QLSach_rong;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.xml.crypto.Data;

public class FrmDanhMucSach extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JTextField txtMaSach;
	private JTextField txtTuaSach;
	private JTextField txtTacGia;
	private JTextField txtNamXB;
	private JTextField txtNhaXB;
	private JTextField txtSoTrang;
	private JTextField txtDonGia;
	private JTextField txtISBN;
	private JButton btnThem;
	private JButton btnXoa;
	private JButton btnSua;
	private JButton btnLuu;
	private JComboBox<String> cboMaSach;
	private JTable table;
	private JTextField txtMess;
	private JButton btnXoaRong;

	// private SachTableModel tableModel;
	private DefaultTableModel tableModel;
	private JButton btnLoc;

	public FrmDanhMucSach() {
		setTitle("Quản lý sách");
		setSize(900, 600);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		buildUI();
	}

	private void buildUI() {

		// Pháº§n North
		JPanel pnlNorth;
		add(pnlNorth = new JPanel(), BorderLayout.NORTH);
		pnlNorth.setPreferredSize(new Dimension(0, 180));
		pnlNorth.setBorder(BorderFactory.createTitledBorder("Records Editor"));
		pnlNorth.setLayout(null); // Absolute layout

		JLabel lblMaSach, lblTuaSach, lblTacGia, lblNamXB, lblNhaXB, lblSoTrang, lblDonGia, lblISBN;
		pnlNorth.add(lblMaSach = new JLabel("Mã Sách: "));
		pnlNorth.add(lblTuaSach = new JLabel("Tên Sách "));
		pnlNorth.add(lblTacGia = new JLabel("Tác Giả: "));
		pnlNorth.add(lblNamXB = new JLabel("Năm Xuất Bản: "));
		pnlNorth.add(lblNhaXB = new JLabel("Nhà  Xuất Bản "));
		pnlNorth.add(lblSoTrang = new JLabel("Số Trang: "));
		pnlNorth.add(lblDonGia = new JLabel("Đơn Giá: "));
		pnlNorth.add(lblISBN = new JLabel("International Standard Book Number: "));

		pnlNorth.add(txtMaSach = new JTextField());
		pnlNorth.add(txtTuaSach = new JTextField());
		pnlNorth.add(txtTacGia = new JTextField());
		pnlNorth.add(txtNamXB = new JTextField());
		pnlNorth.add(txtNhaXB = new JTextField());
		pnlNorth.add(txtSoTrang = new JTextField());
		pnlNorth.add(txtDonGia = new JTextField());
		pnlNorth.add(txtISBN = new JTextField());

		pnlNorth.add(txtMess = new JTextField());
		txtMess.setEditable(false);
		txtMess.setBorder(null);
		txtMess.setForeground(Color.red);
		txtMess.setFont(new Font("Arial", Font.ITALIC, 12));

		int w1 = 100, w2 = 300, h = 20;
		lblMaSach.setBounds(20, 20, w1, h);
		txtMaSach.setBounds(120, 20, 200, h);

		lblTuaSach.setBounds(20, 45, w1, h);
		txtTuaSach.setBounds(120, 45, w2, h);
		lblTacGia.setBounds(450, 45, w1, h);
		txtTacGia.setBounds(570, 45, w2, h);

		lblNamXB.setBounds(20, 70, w1, h);
		txtNamXB.setBounds(120, 70, w2, h);
		lblNhaXB.setBounds(450, 70, w1, h);
		txtNhaXB.setBounds(570, 70, w2, h);

		lblSoTrang.setBounds(20, 95, w1, h);
		txtSoTrang.setBounds(120, 95, w2, h);
		lblDonGia.setBounds(450, 95, w1, h);
		txtDonGia.setBounds(570, 95, w2, h);

		lblISBN.setBounds(20, 120, 220, h);
		txtISBN.setBounds(240, 120, 180, h);
		txtMess.setBounds(20, 145, 550, 20);

		// Pháº§n Center
		JPanel pnlCenter;
		add(pnlCenter = new JPanel(), BorderLayout.CENTER);
		pnlCenter.add(btnThem = new JButton("Thêm"));
		pnlCenter.add(btnXoaRong = new JButton("Làm rỗng"));
		pnlCenter.add(btnXoa = new JButton("Xóa"));
		pnlCenter.add(btnSua = new JButton("Sủa"));
		pnlCenter.add(btnLuu = new JButton("Lưu"));
		pnlCenter.add(new JLabel("Tìm theo mã sách: "));
		pnlCenter.add(cboMaSach = new JComboBox<String>());
		cboMaSach.setPreferredSize(new Dimension(100, 25));
		pnlCenter.add(btnLoc = new JButton("Lọc Theo Tựa Sách"));

		// Pháº§n South
		JScrollPane scroll;
		String[] headers = "MaSach;TuaSach;TacGia;NamXuatBan;NhaXuatBan;SoTrang;DonGia;ISBN".split(";");

			tableModel = new DefaultTableModel(headers, 0);
		add(scroll = new JScrollPane(table = new JTable(tableModel), JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED), BorderLayout.SOUTH);
		scroll.setBorder(BorderFactory.createTitledBorder("Danh sách các cuốn sách"));
		table.setRowHeight(20);
		scroll.setPreferredSize(new Dimension(0, 350));

		cboMaSach.addActionListener(this);
		btnThem.addActionListener(this);
		btnXoa.addActionListener(this);
		btnXoaRong.addActionListener(this);
		btnSua.addActionListener(this);
		btnLuu.addActionListener(this);
		btnLoc.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (o.equals(btnThem)) {
		
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
		
		    String maSach = txtMaSach.getText().trim();
	        String tuaSach = txtTuaSach.getText().trim();
	        String tacGia = txtTacGia.getText().trim();
		        String namXB = txtNamXB.getText().trim();
		        String nhaXB = txtNhaXB.getText().trim();
	        String soTrang = txtSoTrang.getText().trim();
	        String donGia = txtDonGia.getText().trim();		        String isbn = txtISBN.getText().trim(); 		
		        if (maSach.isEmpty() || tuaSach.isEmpty() || tacGia.isEmpty() || namXB.isEmpty() || nhaXB.isEmpty() || soTrang.isEmpty() || donGia.isEmpty() || isbn.isEmpty()) {
		            txtMess.setText("Vui lòng nhập đầy đủ thông tin!");
		            return;
		        }
 
		        if (!maSach.matches(tuaSach.substring(0, 1) + "\\d{3}")) {
	            txtMess.setText("Mã sách phải bắt đầu bằng ký tự đầu của tựa sách và theo sau là 3 chữ số.");
		            txtMaSach.requestFocus();
		            return;
		        }

	  
	        if (!tuaSach.matches("[a-zA-Z'\\s]+")) {
	            txtMess.setText("Tựa sách không được chứa số hoặc ký tự đặc biệt.");
	            txtTuaSach.requestFocus();          
	            return;
	        }
	        if (!tacGia.matches("[a-zA-Z'\\s]+")) {
		            txtMess.setText("Tên tác giả không được chứa số hoặc ký tự đặc biệt.");
	            txtTacGia.requestFocus();
		            return;
	        }

	       
		        if (!isbn.matches("\\d+-\\d+-\\d+-\\d+(-\\d+)?")) {
		            txtMess.setText("ISBN phải có dạng X-X-X-X hoặc X-X-X-X-X.");
		            txtISBN.requestFocus();
		            return;
		        }

		        
		        Object[] rowData = { maSach, tuaSach, tacGia, namXB, nhaXB, soTrang, donGia, isbn };
		        tableModel.addRow(rowData);
		        txtMess.setText("Thêm thành công!");
		        txtMaSach.requestFocus();
	        clearTextFields();
		}

		else if (o.equals(btnXoaRong)) {
			clearTextFields();
		 }		 
	}
	public void clearTextFields() {
		 txtDonGia.setText("");
		 txtISBN.setText("");
		 txtMaSach.setText("");
		 txtMess.setText("");
		 txtNamXB.setText("");
		 txtNhaXB.setText("");
		 txtSoTrang.setText("");
		 txtTacGia.setText("");
		 txtTuaSach.setText("");
	}
	}

	

