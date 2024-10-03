package stt17_TranDoanKhoe_22002715_BaiTapLyThuyet;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

public class BaiTap2 {
    
    public BaiTap2() {
   
        File dataDir = new File("Data");
        if (!dataDir.exists()) {
            dataDir.mkdir();
        }

        try (FileWriter writer = new FileWriter(new File(dataDir, "test.txt"))) {
            String content = "Nội dung mẫu để sao chép.";
            writer.write(content);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void copyFile() throws IOException {
        FileInputStream in = null;
        FileOutputStream out = null;
        try {
            in = new FileInputStream("Data/test.txt");
            out = new FileOutputStream("Data/copyTest.txt");
            int c;
            while ((c = in.read()) != -1) {
                out.write(c);
            }
        } finally {
            if (in != null) {
                in.close(); 
            }
            if (out != null) {
                out.close(); 
            }
        }
    }

    public static void main(String[] args) {
        BaiTap2 demo = new BaiTap2();
        try {
            demo.copyFile(); 
        } catch (IOException e) {
            e.printStackTrace(); 
        }
    }
}
