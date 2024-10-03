 package stt17_TranDoanKhoe_22002715_TTNhanVien;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.io.IOException;

public class ThongTinNhanVien extends JFrame implements ActionListener {
    JLabel lblMaNv, lblHo, lblTenNv, lblTuoi, lblPhai, lblTienLuong, lblTimKiem;
    JTextField txtMaNV, txtHo, txtTenNV, txtTuoi, txtTienLuong, txtTimKiem;
    JRadioButton b_Nam, b_Nu;
    JButton bTimKiem, bThem, bXoaTrang, bXoa, bLuu;
    JTable table;
    ButtonGroup group;

    public ThongTinNhanVien() {
        super("Thông Tin Nhân Viên");
        setSize(1000, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        
        createUI();

   
        setVisible(true);
    }

    private void createUI() {
    
        JPanel pnNorth = new JPanel();
        JLabel lblTieuDe = new JLabel("THÔNG TIN NHÂN VIÊN");
        lblTieuDe.setForeground(Color.BLUE);
        lblTieuDe.setFont(new Font("Arial", Font.BOLD, 25));
        pnNorth.add(lblTieuDe);

      
        JPanel pnCenter = new JPanel();
        pnCenter.setLayout(new BoxLayout(pnCenter, BoxLayout.Y_AXIS));
        Font font_cen = new Font("Tahoma", Font.PLAIN, 13);

   
        JPanel pnMaNv = new JPanel();
        Box box_MaNV = new Box(BoxLayout.X_AXIS);
        box_MaNV.add(lblMaNv = new JLabel("Mã nhân viên:"));
        lblMaNv.setFont(font_cen);
        box_MaNV.add(Box.createHorizontalStrut(5));
        box_MaNV.add(txtMaNV = new JTextField(75));
        pnMaNv.add(box_MaNV);

        JPanel pnHoTen = new JPanel();
        Box box_HoTen = new Box(BoxLayout.X_AXIS);
        box_HoTen.add(lblHo = new JLabel("Họ:"));
        lblHo.setFont(font_cen);
        box_HoTen.add(Box.createHorizontalStrut(40));
        box_HoTen.add(txtHo = new JTextField(35));
        box_HoTen.add(Box.createHorizontalStrut(5));
        box_HoTen.add(lblTenNv = new JLabel("Tên nhân viên:"));
        lblTenNv.setFont(font_cen);
        box_HoTen.add(Box.createHorizontalStrut(5));
        box_HoTen.add(txtTenNV = new JTextField(33));
        pnHoTen.add(box_HoTen);

        JPanel pnTuoiPhai = new JPanel();
        Box box_TuoiPhai = new Box(BoxLayout.X_AXIS);
        box_TuoiPhai.add(lblTuoi = new JLabel("Tuổi:"));
        lblTuoi.setFont(font_cen);
        box_TuoiPhai.add(Box.createHorizontalStrut(60));
        box_TuoiPhai.add(txtTuoi = new JTextField(55));
        box_TuoiPhai.add(Box.createHorizontalStrut(5));
        box_TuoiPhai.add(lblPhai = new JLabel("Phái:"));
        lblPhai.setFont(font_cen);
        box_TuoiPhai.add(Box.createHorizontalStrut(10));
        box_TuoiPhai.add(b_Nam = new JRadioButton("Nam"));
        b_Nam.setFont(font_cen);
        box_TuoiPhai.add(Box.createHorizontalStrut(10));
        box_TuoiPhai.add(b_Nu = new JRadioButton("Nữ"));
        b_Nu.setFont(font_cen);
        group = new ButtonGroup();
        group.add(b_Nam);
        group.add(b_Nu);
        pnTuoiPhai.add(box_TuoiPhai);

        JPanel pnTienLuong = new JPanel();
        Box Box_TienLuong = new Box(BoxLayout.X_AXIS);
        Box_TienLuong.add(lblTienLuong = new JLabel("Tiền lương:"));
        lblTienLuong.setFont(font_cen);
        Box_TienLuong.add(Box.createHorizontalStrut(20));
        Box_TienLuong.add(txtTienLuong = new JTextField(75));
        pnTienLuong.add(Box_TienLuong);

        // Bảng chứa dữ liệu nhân viên
        String[] columnName = { "Mã NV", "Họ", "Tên", "Phái", "Tuổi", "Tiền lương" };
        DefaultTableModel model = new DefaultTableModel(columnName, 0);
        table = new JTable(model);
        JScrollPane pane = new JScrollPane(table);
        pane.setPreferredSize(new Dimension(805, 240));
        table.setRowHeight(25);

        // Thêm các panel vào pnCenter
        pnCenter.add(pnMaNv);
        pnCenter.add(pnHoTen);
        pnCenter.add(pnTuoiPhai);
        pnCenter.add(pnTienLuong);
        pnCenter.add(pane);

    
        JPanel pnSouth = new JPanel();
        pnSouth.setLayout(new GridLayout(1, 2));

    
        JPanel pnTimKiem = new JPanel();
        pnTimKiem.setBorder(BorderFactory.createTitledBorder(""));
        Box box_timKiem = new Box(BoxLayout.X_AXIS);
        box_timKiem.add(lblTimKiem = new JLabel("Nhập mã số cần tìm:"));
        lblTimKiem.setFont(font_cen);
        box_timKiem.add(txtTimKiem = new JTextField(15));
        box_timKiem.add(bTimKiem = new JButton("Tìm"));
        bTimKiem.setFont(font_cen);
        pnTimKiem.add(box_timKiem);

   
        JPanel pnTacVu = new JPanel();
        pnTacVu.setBorder(BorderFactory.createTitledBorder(""));
        Box box_tacVu = new Box(BoxLayout.X_AXIS);
        box_tacVu.add(bThem = new JButton("Thêm"));
        bThem.setFont(font_cen);
        box_tacVu.add(bXoaTrang = new JButton("Xóa trắng"));
        bXoaTrang.setFont(font_cen);
        box_tacVu.add(bXoa = new JButton("Xóa"));
        bXoa.setFont(font_cen);
        box_tacVu.add(bLuu = new JButton("Lưu"));
        bLuu.setFont(font_cen);
        pnTacVu.add(box_tacVu);

       
        pnSouth.add(pnTimKiem);
        pnSouth.add(pnTacVu);

 
        add(pnNorth, BorderLayout.NORTH);
        add(pnCenter, BorderLayout.CENTER);
        add(pnSouth, BorderLayout.SOUTH);

      
        bTimKiem.addActionListener(this);
        bThem.addActionListener(this);
        bXoaTrang.addActionListener(this);
        bXoa.addActionListener(this);
        bLuu.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object o = e.getSource();
        if (o == bTimKiem) {
            String maNVTim = txtTimKiem.getText();
            boolean found = false;
            for (int i = 0; i < table.getRowCount(); i++) {
                String maNV = (String) table.getValueAt(i, 0);
                if (maNV.equals(maNVTim)) {
                    table.setRowSelectionInterval(i, i);
                    found = true;
                    break;
                }
            }
            if (!found) {
                JOptionPane.showMessageDialog(this, "Không tìm thấy mã nhân viên.");
            }
        } else if (o == bThem) {
            DefaultTableModel model = (DefaultTableModel) table.getModel();
            String phai = b_Nam.isSelected() ? "Nam" : "Nữ";
            String[] row = { txtMaNV.getText(), txtHo.getText(), txtTenNV.getText(), phai, txtTuoi.getText(), txtTienLuong.getText() };
            model.addRow(row);
        } else if (o == bXoaTrang) {
            txtMaNV.setText("");
            txtHo.setText("");
            txtTenNV.setText("");
            txtTuoi.setText("");
            txtTienLuong.setText("");
            group.clearSelection();
            txtMaNV.requestFocus();
        } else if (o == bXoa) {
            DefaultTableModel model = (DefaultTableModel) table.getModel();
            int rowIndex = table.getSelectedRow();
            if (rowIndex != -1) {
                model.removeRow(rowIndex);
            } else {
                JOptionPane.showMessageDialog(this, "Vui lòng chọn dòng cần xóa.");
            }
        } else if (o == bLuu) {
            try {
                GhiVaoFile.saveToFile(table);
                JOptionPane.showMessageDialog(this, "Dữ liệu đã được lưu vào file: " + GhiVaoFile.tenFile);
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Lỗi khi lưu file: " + ex.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        new ThongTinNhanVien();
    }
}
