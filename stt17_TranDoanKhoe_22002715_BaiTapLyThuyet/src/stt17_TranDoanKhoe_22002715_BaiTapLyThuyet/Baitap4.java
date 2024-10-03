package stt17_TranDoanKhoe_22002715_BaiTapLyThuyet;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Baitap4 {

    public Baitap4() {
 
        File dataDir = new File("Data");
        if (!dataDir.exists()) {
            dataDir.mkdir();
        }

        try (FileOutputStream fos = new FileOutputStream(new File(dataDir, "baitap4.txt"))) {
            String content = "Nội dung mẫu để sao chép.";
            fos.write(content.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void testBufferStream() {
        FileInputStream fis = null;
        FileOutputStream fos = null;
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        byte buf[] = new byte[65535];

        try {
            fis = new FileInputStream(new File("Data/baitap4.txt"));
            fos = new FileOutputStream(new File("Data/copybaitap4.txt"));
            bis = new BufferedInputStream(fis);
            bos = new BufferedOutputStream(fos);

            int bytesRead;
            while ((bytesRead = bis.read(buf)) != -1) {
                bos.write(buf, 0, bytesRead); // Ghi chính xác số byte đã đọc
            }

            bos.flush();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bos != null) {
                    bos.close();
                }
                if (bis != null) {
                    bis.close();
                }
                if (fis != null) {
                    fis.close();
                }
                if (fos != null) {
                    fos.close();
                }
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Baitap4 demo = new Baitap4();
        demo.testBufferStream(); 
    }
}
