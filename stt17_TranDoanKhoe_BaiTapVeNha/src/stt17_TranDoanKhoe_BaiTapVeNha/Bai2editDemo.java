package stt17_TranDoanKhoe_BaiTapVeNha;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Bai2editDemo extends JFrame implements ActionListener {
    JButton btnThem, btnXoa, btnSua;
    JTextField txtHo, txtTen;
    DefaultTableModel tableModel;
    JTable table;

    public Bai2editDemo() {
        super("Edit Table");
        tableModel = new DefaultTableModel(new Object[]{"Ho", "Ten"}, 0);
        table = new JTable(tableModel);

     
        JPanel panelNhapLieu = new JPanel();
        panelNhapLieu.setLayout(new BoxLayout(panelNhapLieu, BoxLayout.Y_AXIS));

        JPanel panelHo = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 0)); // Khoảng cách ngang 5px, dọc 0px
        panelHo.add(new JLabel("Ho:  "));
        panelHo.add(txtHo = new JTextField(15));

        JPanel panelTen = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 0));
        panelTen.add(new JLabel("Ten:"));
        panelTen.add(txtTen = new JTextField(15));

        panelNhapLieu.add(panelHo);
        panelNhapLieu.add(panelTen);

     
        JPanel panelNut = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10)); /**/
        panelNut.add(btnThem = new JButton("Them"));
        panelNut.add(btnXoa = new JButton("Xoa"));
        panelNut.add(btnSua = new JButton("Sua"));

      
        setLayout(new BorderLayout(10, 10));  

        
        JPanel panelTop = new JPanel(new BorderLayout());
        panelTop.add(panelNhapLieu, BorderLayout.CENTER);
        panelTop.add(panelNut, BorderLayout.SOUTH);

        
        add(panelTop, BorderLayout.NORTH);
        add(new JScrollPane(table), BorderLayout.CENTER);

        
        btnThem.addActionListener(this);
        btnXoa.addActionListener(this);
        btnSua.addActionListener(this);

 
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object o = e.getSource();

        if (o == btnThem) {
            String ho = txtHo.getText().trim();
            String ten = txtTen.getText().trim();
            if (ho.isEmpty() || ten.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ Họ và Tên!");
            } else {
                tableModel.addRow(new Object[]{ho, ten});
                txtHo.setText("");
                txtTen.setText("");
            }
        } else if (o == btnXoa) {
            int selectedRow = table.getSelectedRow();
            if (selectedRow != -1) {
                tableModel.removeRow(selectedRow);
            } else {
                JOptionPane.showMessageDialog(this, "Vui lòng chọn một hàng để xóa!");
            }
        } else if (o == btnSua) {
            int selectedRow = table.getSelectedRow();
            if (selectedRow != -1) {
                String ho = txtHo.getText().trim();
                String ten = txtTen.getText().trim();
                if (!ho.isEmpty() && !ten.isEmpty()) {
                    tableModel.setValueAt(ho, selectedRow, 0);
                    tableModel.setValueAt(ten, selectedRow, 1);
                    txtHo.setText("");
                    txtTen.setText("");
                } else {
                    JOptionPane.showMessageDialog(this, "Vui lòng nhập Họ và Tên mới!");
                }
            } else {
                JOptionPane.showMessageDialog(this, "Vui lòng chọn một hàng để sửa!");
            }
        }
    }

    public static void main(String[] args) {
        new Bai2editDemo().setVisible(true);
    }
}
