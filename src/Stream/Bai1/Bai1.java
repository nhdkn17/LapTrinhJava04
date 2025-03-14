package Stream.Bai1;

import java.io.*;

public class Bai1 {
    public static void main(String[] args) throws IOException{
        FileInputStream in = null;
        FileOutputStream out = null;

        try {
            in = new FileInputStream("./src/Stream/Bai1/input.txt");
            out = new FileOutputStream("./src/Stream/Bai1/output.txt");

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

        System.out.println("END");
    }
}
