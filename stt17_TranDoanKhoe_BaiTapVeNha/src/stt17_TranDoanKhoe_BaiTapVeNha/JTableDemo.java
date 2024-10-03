package stt17_TranDoanKhoe_BaiTapVeNha;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class JTableDemo extends JFrame {

    private DefaultTableModel moHinhBang; 
    private JTable bang; 

    public JTableDemo() {
        setTitle("Demo JTable");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(400, 300);
        taoGiaoDien();
    }

    private void taoGiaoDien() {
       
        String[] tieuDe = {"Ma mon", "Ten mon", "So tin chi"};

        
        moHinhBang = new DefaultTableModel(tieuDe, 0);

        // Tạo JTable dựa trên table model
        bang = new JTable(moHinhBang);
        this.add(new JScrollPane(bang)); 

       
        bang.setRowHeight(30);

      
        String[][] duLieu = {
            {"001", "Windows programming", "5"},
            {"002", "Computer generated", "4"},
            {"003", "Design analysis", "5"}
        };

        // Thêm từng hàng vào model của bảng
        for (String[] hang : duLieu) {
            moHinhBang.addRow(hang);
        }
    }

    public static void main(String[] args) {
        // Tạo và hiển thị JFrame
        SwingUtilities.invokeLater(() -> {
            JTableDemo frame = new JTableDemo();
            frame.setVisible(true);
        });
    }
}
