package Stream.Bai5;

import java.io.File;

public class Bai5 {
    public static void main(String[] args) {
        File directory = new File("D:/Lap_Trinh_Mang_Java/src/Stream/Bai5");

        if (directory.exists() && directory.isDirectory()) {
            File[] files = directory.listFiles((dir, name) -> name.endsWith(".txt"));
            if (files != null && files.length > 0) {
                System.out.println("Danh sách file trong thư mục:");
                for (File file : files) {
                    System.out.println(file.getName());
                    new FileReaderThread(file).start();
                }
            } else {
                System.out.println("Không có file .txt nào trong thư mục!");
            }
        } else {
            System.out.println("Thư mục không tồn tại hoặc không hợp lệ!");
        }
    }
}
