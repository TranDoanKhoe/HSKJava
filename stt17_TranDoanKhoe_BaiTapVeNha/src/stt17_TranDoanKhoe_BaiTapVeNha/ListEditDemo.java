package stt17_TranDoanKhoe_BaiTapVeNha;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ListEditDemo extends JFrame implements ActionListener {
    JButton btnThem, btnXoa, btnSua;
    JTextField txtTen;
    DefaultListModel<String> listmodelTen;
    JList<String> listTen;

    public ListEditDemo() {
        super("List Edit Demo");

   
        listmodelTen = new DefaultListModel<>();
        listTen = new JList<>(listmodelTen);
        add(new JScrollPane(listTen), BorderLayout.CENTER);
        setSize(500, 320);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   
        JPanel pPhai = new JPanel(new BorderLayout());
        JPanel pTren = new JPanel();
        JPanel pDuoi = new JPanel();

  
        pTren.add(new JLabel("Nhap Ten:"));
        pTren.add(txtTen = new JTextField(15));

       
        pDuoi.add(btnThem = new JButton("Them Item"));
        pDuoi.add(btnXoa = new JButton("Xoa Item"));
        pDuoi.add(btnSua = new JButton("Sua Item"));

        
        pPhai.add(pTren, BorderLayout.NORTH);
        pPhai.add(pDuoi, BorderLayout.CENTER);

 
        add(pPhai, BorderLayout.EAST);

   
        txtTen.addActionListener(this);
        btnThem.addActionListener(this);
        btnXoa.addActionListener(this);
        btnSua.addActionListener(this);

       
       
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object o = e.getSource();

        if (o == btnThem) {
            String ten = txtTen.getText().trim();
            if (ten.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Vui long nhap ten!");
            } else {
                listmodelTen.addElement(ten);
                txtTen.setText("");
            }
        } else if (o == btnXoa) {
            String tenChon = listTen.getSelectedValue();
            if (tenChon != null) {
                listmodelTen.removeElement(tenChon);
            } else {
                JOptionPane.showMessageDialog(this, "Vui long chon mot muc de xoa!");
            }
        } else if (o == btnSua) {
            int viTriChon = listTen.getSelectedIndex();
            if (viTriChon != -1) {
                String tenMoi = txtTen.getText().trim();
                if (!tenMoi.isEmpty()) {
                    listmodelTen.setElementAt(tenMoi, viTriChon);
                    txtTen.setText("");
                } else {
                    JOptionPane.showMessageDialog(this, "Vui long nhap ten moi!");
                }
            } else {
                JOptionPane.showMessageDialog(this, "Vui long chon mot muc de sua!");
            }
        }
    }

    public static void main(String[] args) {
        new ListEditDemo().setVisible(true);
    }
}
