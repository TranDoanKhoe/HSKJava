package tuan04_Sach;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import org.w3c.dom.events.MouseEvent;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.time.LocalDate;

public class QLSach extends JFrame implements ActionListener, MouseListener {
	fileDocVaGhi fi;
	private Sach_Collection listSach;
	private LocalDate date = LocalDate.now();
    private JButton them, xoaRong, xoa, sua, luu;
    private JTextField textMaSach, textTuaSach, textNamXB, textSoTrang, textISBN, textTacGia, textNXB, textDonGia;
    private JLabel maSach, tuaSach, namXB, soTrang, ISBN, tacGia, NXB, donGia, timSach;
    private JTable tableSach;
    private JComboBox searchMaSach;
    private DefaultTableModel modelSach;
	private String tenFile;
	
	
    public QLSach() {
        super("Quản lý Sách");
        setVisible(true);
        setSize(950, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel pNorth = new JPanel();
        pNorth.setLayout(new BorderLayout());
        Box boxNorth = Box.createVerticalBox();
        Box box1 = Box.createHorizontalBox();
        Box box2 = Box.createHorizontalBox();
        Box box3 = Box.createHorizontalBox();
        Box box4 = Box.createHorizontalBox();
        Box box5 = Box.createHorizontalBox();

        box1.setBorder(BorderFactory.createEmptyBorder(10, 10, -1, 600));
        box2.setBorder(BorderFactory.createEmptyBorder(10, 10, -1, 15));
        box3.setBorder(BorderFactory.createEmptyBorder(10, 10, -1, 15));
        box4.setBorder(BorderFactory.createEmptyBorder(10, 10, -1, 15));
        box5.setBorder(BorderFactory.createEmptyBorder(10, 10, -1, 480));

        box1.add(maSach = new JLabel("Mã sách:"));
        maSach.setPreferredSize(new Dimension(90, 23));
        box1.add(textMaSach = new JTextField());
        boxNorth.add(box1);
        boxNorth.add(Box.createVerticalStrut(5));

        box2.add(tuaSach = new JLabel("Tựa sách: "));
        tuaSach.setPreferredSize(new Dimension(90, 23));
        box2.add(textTuaSach = new JTextField(20));
        box2.add(Box.createHorizontalStrut(25));
        box2.add(tacGia = new JLabel("Tác giả: "));
        tacGia.setPreferredSize(new Dimension(90, 23));
        box2.add(textTacGia = new JTextField(20));
        boxNorth.add(box2);
        boxNorth.add(Box.createVerticalStrut(5));

        box3.add(namXB = new JLabel("Năm xuất bản: "));
        namXB.setPreferredSize(new Dimension(90, 23));
        box3.add(textNamXB = new JTextField(20));
        box3.add(Box.createHorizontalStrut(25));
        box3.add(NXB = new JLabel("Nhà xuất bản: "));
        NXB.setPreferredSize(new Dimension(90, 23));
        box3.add(textNXB = new JTextField(20));
        boxNorth.add(box3);
        boxNorth.add(Box.createVerticalStrut(5));

        box4.add(soTrang = new JLabel("Số trang: "));
        soTrang.setPreferredSize(new Dimension(90, 23));
        box4.add(textSoTrang = new JTextField(20));
        box4.add(Box.createHorizontalStrut(25));
        box4.add(donGia = new JLabel("Đơn giá: "));
        donGia.setPreferredSize(new Dimension(90, 23));
        box4.add(textDonGia = new JTextField(20));
        boxNorth.add(box4);
        boxNorth.add(Box.createVerticalStrut(5));
        box5.add(ISBN = new JLabel("International Standard Book Number:"));
        ISBN.setPreferredSize(new Dimension(230, 23));
        box5.add(textISBN = new JTextField(20));
        boxNorth.add(box5);
        boxNorth.add(Box.createVerticalStrut(5));
        pNorth.setBorder(BorderFactory.createTitledBorder("Record Editor"));
        pNorth.add(boxNorth);
        add(pNorth, BorderLayout.NORTH);
       
        JPanel searchSach = new JPanel();
        timSach = new JLabel("Tìm theo mã sách:");
        searchSach.add(timSach);
        searchMaSach = new JComboBox<>();
        searchMaSach.setPreferredSize(new Dimension(100, 25));
        searchSach.add(searchMaSach);
        
        JPanel pCenter = new JPanel();
        pCenter.setLayout(new BorderLayout());
        JPanel pCenter1 = new JPanel();
        pCenter1.add(them = new JButton("Thêm"));
        pCenter1.add(xoaRong = new JButton("Xóa rỗng"));
        pCenter1.add(xoa = new JButton("Xóa"));
        pCenter1.add(sua = new JButton("Sửa"));
        pCenter1.add(luu = new JButton("Lưu"));
        pCenter1.add(timSach);
        pCenter1.add(searchSach);
        pCenter.add(pCenter1, BorderLayout.NORTH);

        modelSach = new DefaultTableModel();
        modelSach.addColumn("Mã sách");
        modelSach.addColumn("Tựa sách");
        modelSach.addColumn("Năm xuất bản");
        modelSach.addColumn("Số trang");
        modelSach.addColumn("ISBN");
        modelSach.addColumn("Tác giả");
        modelSach.addColumn("Nhà xuất bản");
        modelSach.addColumn("Đơn giá");

        tableSach = new JTable(modelSach);
        JScrollPane scrollPane = new JScrollPane(tableSach);
        scrollPane.setBorder(BorderFactory.createTitledBorder("Danh sách các cuốn sách"));
        pCenter.add(scrollPane, BorderLayout.CENTER);

        add(pCenter, BorderLayout.CENTER);
        
        them.addActionListener(this);
        xoaRong.addActionListener(this);
        xoa.addActionListener(this);
        luu.addActionListener(this);
        sua.addActionListener(this);
        tableSach.addMouseListener(this);
        searchMaSach.addActionListener(this);
        
        listSach = new Sach_Collection();
        fi = new fileDocVaGhi();
        try {
			listSach = (Sach_Collection)fi.readFromFile(tenFile);
		} catch (Exception e) {
			System.out.println("Không tìm thấy file");
		}
        setTableData();
        setVisible(true);
    }

    public static void main(String[] args) {
        new QLSach();
    }

    private void setTableData() {
    	xoaHetDuLieuTrenTableModel();
    	DocDuLieuTuArrayListVaoModel();
    	tableSach.setModel(modelSach);
    	capNhatDanhSachMaSach();
    }
    
    private void capNhatDanhSachMaSach() {
        searchMaSach.removeAllItems();
        int rowCount = modelSach.getRowCount();
        for (int i = 0; i < rowCount; i++) {
            String maSach = (String) modelSach.getValueAt(i, 0);
            searchMaSach.addItem(maSach);
        }
    }

	private void xoaHetDuLieuTrenTableModel()  {
		DefaultTableModel dm = (DefaultTableModel)tableSach.getModel();
		dm.getDataVector().removeAllElements();
	}
	
	private void DocDuLieuTuArrayListVaoModel() {
		for(int i = 0; i < listSach.getSize(); i++) 
		{
			Sach sach = listSach.getElement(i);
			modelSach.addRow(new Object[] {
					sach.getMaSach(), sach.getTuaSach(), sach.getNamXuatBan(), sach.getSoTrang(),
    				sach.getTacGia(), sach.getNhaXuatBan(), sach.getDonGia(), sach.getISBN()
			});
		}
	}
	
    private void xoaTrangDuLieu() {
		textMaSach.setText("");
		textTuaSach.setText("");
		textNamXB.setText("");
		textSoTrang.setText("");
		textTacGia.setText("");
		textNXB.setText("");
		textDonGia.setText("");
		textISBN.setText("");
	}
    
    @Override
    public void actionPerformed(ActionEvent e) {
    	Object source = e.getSource();
    	if(source.equals(them)) {
    		String maSach = textMaSach.getText();
    		String tuaSach = textTuaSach.getText();
    		int namXuatBan = Integer.parseInt(textNamXB.getText());
    		int soTrang = Integer.parseInt(textSoTrang.getText());
    		String tacGia = textTacGia.getText();
    		String nhaXuatBan = textNXB.getText();
    		double donGia = Double.parseDouble(textDonGia.getText());
    		String ISBN = textISBN.getText();
    		int currentYear = date.getYear();
    		if(maSach.isEmpty() || tuaSach.isEmpty() || tacGia.isEmpty()|| ISBN.isEmpty())
    		{
    			JOptionPane.showMessageDialog(this, "Vui lòng điền đầy đủ thông tin sách.");
    		}else if(!maSach.matches("[A-Z]\\d{3}")){
    			JOptionPane.showMessageDialog(this, "Mã sách không hợp lệ. Mã sách Có ký tự đầu là ký tự chữ HOA, theo sau luôn có 3 ký số.");
    		}else if(!tuaSach.matches("[\\w\\d\\s\\-()]+")) {
    			JOptionPane.showMessageDialog(this, "Tựa sách không hợp lệ. Không chứa các ký tự đặc biệt khác.");
    		}else if(!tacGia.matches("[\\w\\s']+")) {
    			JOptionPane.showMessageDialog(this, "Tác giả không hợp lệ. Không chứa ký số hoặc các ký tự đặc biệt khác, ngoại trừ ký tự ‘.");
    		}else if(soTrang<0) {
    			JOptionPane.showMessageDialog(this, "Số trang phải là số nguyên dương.");
    		}else if(namXuatBan<1900 || namXuatBan > currentYear) {
    	        JOptionPane.showMessageDialog(this, "Năm xuất bản không hợp lệ. Năm xuất bản phải trong khoảng từ 1900 đến năm hiện tại.");
    		}else if(donGia<0) {
    			JOptionPane.showMessageDialog(this, "Đơn giá phải là số dương.");
    		}else if(!ISBN.matches("\\d{1,}-\\d{1,}-\\d{1,}-\\d{1,}-?\\d*")) {
    	        JOptionPane.showMessageDialog(this, "ISBN không hợp lệ. ISBN phải theo định dạng X-X-X-X (hoặc X-X-X-X-X), trong đó X chỉ chứa các ký số, ít nhất là 1 ký số.");
    		} else {
    			Sach sachNew = new Sach(maSach, tuaSach, namXuatBan, soTrang, tacGia, nhaXuatBan, donGia, ISBN);
    			if(!listSach.themSach(sachNew)) {
    				JOptionPane.showMessageDialog(this, "Thêm Sách Thất Bại");
    			}else {
    				modelSach.addRow(new Object[] {
    						sachNew.getMaSach(), sachNew.getTuaSach(), sachNew.getNamXuatBan(), sachNew.getSoTrang(),
    						sachNew.getTacGia(), sachNew.getNhaXuatBan(), sachNew.getDonGia(), sachNew.getISBN()
    					});
    				xoaTrangDuLieu();
    				capNhatDanhSachMaSach();
    			}
    		}
    	}else if(source.equals(xoaRong)) {
    		xoaTrangDuLieu();
    	}else if(source.equals(xoa)) {
    		int r = tableSach.getSelectedRow();
    		if(r!=-1) {
    			int option = JOptionPane.showConfirmDialog(this, "Bạn có muốn xóa cuốn sách này không?", "Xác nhận xóa", JOptionPane.YES_NO_OPTION);
    			if(option == JOptionPane.YES_OPTION) {
    	    		modelSach.removeRow(r);
    	    		Sach sachXoa = listSach.getElement(r);
    	    		listSach.xoaSach(sachXoa.getMaSach());
    	    		xoaTrangDuLieu();
    	    		capNhatDanhSachMaSach();
    			}
    		}else{
    			JOptionPane.showMessageDialog(this, "Vui lòng chọn sách cần xóa!");
    		}
    	}else if(source.equals(sua)) {
    		int r = tableSach.getSelectedRow();
    		if(r!=-1) {
    			String maSachCu = (String) modelSach.getValueAt(r, 0);
    			String maSachMoi = textMaSach.getText();
    			if(!maSachCu.equals(maSachMoi)) {
    				JOptionPane.showMessageDialog(this, "Không được thay đổi mã sách.", "Lỗi", JOptionPane.ERROR_MESSAGE);
    				xoaTrangDuLieu();
    				return;
    			}
    	        String tuaSach = textTuaSach.getText();
    	        int namXuatBan = Integer.parseInt(textNamXB.getText());
    	        int soTrang = Integer.parseInt(textSoTrang.getText());
    	        String tacGia = textTacGia.getText();
    	        String nhaXuatBan = textNXB.getText();
    	        double donGia = Double.parseDouble(textDonGia.getText());
    	        String ISBN = textISBN.getText();

    	        Sach suaSach = new Sach(maSachCu, tuaSach, namXuatBan, soTrang, tacGia, nhaXuatBan, donGia, ISBN);

    	        listSach.suaSach(maSachCu, suaSach);
    	        modelSach.setValueAt(maSachCu, r, 0);
    	        modelSach.setValueAt(tuaSach, r, 1);
    	        modelSach.setValueAt(namXuatBan, r, 2);
    	        modelSach.setValueAt(soTrang, r, 3);
    	        modelSach.setValueAt(tacGia, r, 4);
    	        modelSach.setValueAt(nhaXuatBan, r, 5);
    	        modelSach.setValueAt(donGia, r, 6);
    	        modelSach.setValueAt(ISBN, r, 7);

    	        xoaTrangDuLieu();
    		}else {
    			JOptionPane.showMessageDialog(this, "Chọn sách cần sửa!");
    		}
    	}else if(source.equals(luu)) {
    		fi = new fileDocVaGhi();
    		try {
				fi.writeToFile(listSach, tenFile);
			} catch (Exception e2) {
				e2.printStackTrace();
			}
    	}
    	
    	searchMaSach.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String maSachTim = (String)searchMaSach.getSelectedItem();
				
				Sach sachTim = listSach.timKiemSach(maSachTim);
				
				if(sachTim != null) {
					textMaSach.setText(sachTim.getMaSach());
				    textTuaSach.setText(sachTim.getTuaSach());
				    textNamXB.setText(String.valueOf(sachTim.getNamXuatBan()));
				    textSoTrang.setText(String.valueOf(sachTim.getSoTrang()));
				    textTacGia.setText(sachTim.getTacGia());
				    textNXB.setText(sachTim.getNhaXuatBan());
				    textDonGia.setText(String.valueOf(sachTim.getDonGia()));
				    textISBN.setText(sachTim.getISBN());
				    
				    for (int i = 0; i < modelSach.getRowCount(); i++) {
				        String maSachTrongTable = (String) modelSach.getValueAt(i, 0);

				        if (maSachTrongTable.equals(maSachTim)) {
				            tableSach.setRowSelectionInterval(i, i);
				            tableSach.scrollRectToVisible(tableSach.getCellRect(i, 0, true));
				            break;
				        }
				    }
				}
			}
		});
    }

	@Override
	public void mouseClicked(java.awt.event.MouseEvent e) {
		int row = tableSach.getSelectedRow();
		textMaSach.setText(modelSach.getValueAt(row, 0).toString());
		textTuaSach.setText(modelSach.getValueAt(row, 1).toString());
		textNamXB.setText(modelSach.getValueAt(row, 2).toString());
		textSoTrang.setText(modelSach.getValueAt(row, 3).toString());
		textTacGia.setText(modelSach.getValueAt(row, 4).toString());
		textNXB.setText(modelSach.getValueAt(row, 5).toString());
		textDonGia.setText(modelSach.getValueAt(row, 6).toString());
		textISBN.setText(modelSach.getValueAt(row, 7).toString());
	}
	
	
	@Override
	public void mousePressed(java.awt.event.MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(java.awt.event.MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(java.awt.event.MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(java.awt.event.MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
