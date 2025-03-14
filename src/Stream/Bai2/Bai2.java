package Stream.Bai2;

import java.io.*;

public class Bai2 {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter writer = new BufferedWriter(new FileWriter("./src/Stream/Bai2/output.txt"))) {

            System.out.println("Nhập nội dung (gõ 'exit' để kết thúc):");
            String line;
            while (!(line = reader.readLine()).equalsIgnoreCase("exit")) {
                writer.write(line);
                writer.newLine();
            }
            System.out.println("Dữ liệu đã được ghi vào file!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

