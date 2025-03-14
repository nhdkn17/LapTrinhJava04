package Stream.Bai5;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

class FileReaderThread extends Thread {
    private final File file;

    public FileReaderThread(File file) {
        this.file = file;
    }

    @Override
    public void run() {
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            System.out.println("\n--- Nội dung của file: " + file.getName() + " ---");
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Lỗi khi đọc file: " + file.getName());
            e.printStackTrace();
        }
    }
}
