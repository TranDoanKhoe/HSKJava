package stt17_TranDoanKhoe_22002715_BaiTapLyThuyet;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.FileWriter;

public class BaiTap1 {
    
    public BaiTap1() {
        // Khởi tạo thư mục Data nếu chưa tồn tại
        File dataDir = new File("Data");
        if (!dataDir.exists()) {
            dataDir.mkdir();
        }

     
        try {
            File topFile = new File(dataDir, "top.jpg");
            if (!topFile.exists()) {
              
                try (FileWriter writer = new FileWriter(topFile)) {
                    writer.write("Nội dung mẫu cho file top.jpg");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void copyFile() {
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            fis = new FileInputStream("Data/top.jpg");
            fos = new FileOutputStream("Data/copyTop.jpg");
            int c;
            while ((c = fis.read()) != -1) {
                fos.write(c);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace(); 
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fis != null) {
                    fis.close(); 
                }
                if (fos != null) {
                    fos.close(); 
                }
            } catch (IOException e) {
                e.printStackTrace(); 
            }
        }
    }

    public static void main(String[] args) {
        BaiTap1 demo = new BaiTap1(); 
        demo.copyFile();
    }
}
