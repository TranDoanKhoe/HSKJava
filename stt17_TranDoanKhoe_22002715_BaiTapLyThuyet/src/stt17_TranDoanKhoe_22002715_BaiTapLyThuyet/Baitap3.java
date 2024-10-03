package stt17_TranDoanKhoe_22002715_BaiTapLyThuyet;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Baitap3 {
    
    public Baitap3() {
   
        File dataDir = new File("Data");
        if (!dataDir.exists()) {
            dataDir.mkdir();
        }

     
        try (FileWriter writer = new FileWriter(new File(dataDir, "file.txt"))) {
            String content = "Nội dung mẫu để sao chép.";
            writer.write(content);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void copyFile() throws IOException {
        FileReader inputStream = null;
        FileWriter outputStream = null;
        try {
            inputStream = new FileReader("Data/file.txt");
            outputStream = new FileWriter("Data/copyFile.txt");
            int c;
            while ((c = inputStream.read()) != -1) {
                outputStream.write(c);
            }
        } finally {
            try {
                if (inputStream != null) {
                    inputStream.close(); 
                }
                if (outputStream != null) {
                    outputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace(); 
            }
        }
    }

    public static void main(String[] args) {
        Baitap3 demo = new Baitap3(); 
        try {
            demo.copyFile(); 
        } catch (IOException e) {
            e.printStackTrace(); 
        }
    }
}
