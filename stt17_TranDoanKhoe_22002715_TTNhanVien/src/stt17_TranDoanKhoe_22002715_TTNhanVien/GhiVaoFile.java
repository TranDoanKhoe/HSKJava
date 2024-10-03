package stt17_TranDoanKhoe_22002715_TTNhanVien;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.io.File;

public class GhiVaoFile {
 
    static final String tenFile = "DaTa/nhanvien.txt";

    public static void saveToFile(JTable table) throws IOException {
 
        File directory = new File("DaTa");
        if (!directory.exists()) {
            directory.mkdir();
        }


        BufferedWriter writer = new BufferedWriter(new FileWriter(tenFile));
        DefaultTableModel model = (DefaultTableModel) table.getModel();


        for (int col = 0; col < model.getColumnCount(); col++) {
            writer.write(model.getColumnName(col) + "\t");
        }
        writer.write("\n");

   
        for (int row = 0; row < model.getRowCount(); row++) {
            for (int col = 0; col < model.getColumnCount(); col++) {
                writer.write(model.getValueAt(row, col).toString() + "\t");
            }
            writer.write("\n");
        }

        writer.close();
    }
}
