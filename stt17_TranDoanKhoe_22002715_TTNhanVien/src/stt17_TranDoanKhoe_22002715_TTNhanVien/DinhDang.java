package stt17_TranDoanKhoe_22002715_TTNhanVien;

import java.awt.Component;
import java.text.DecimalFormat;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class DinhDang extends DefaultTableCellRenderer {
    private final DecimalFormat formatter;

    public DinhDang(DecimalFormat formatter) {
        this.formatter = formatter;
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        value = formatter.format((Number) value);
        return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
    }
}
