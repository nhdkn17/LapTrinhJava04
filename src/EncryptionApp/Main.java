package EncryptionApp;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Mã hóa & Giải mã");
        frame.setSize(500, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        JTextArea inputArea = new JTextArea(5, 40);
        JTextArea outputArea = new JTextArea(5, 40);
        outputArea.setEditable(false);

        JComboBox<String> algoBox = new JComboBox<>(new String[]{"AES", "RSA"});

        JButton encryptBtn = new JButton("Mã hóa");
        JButton decryptBtn = new JButton("Giải mã");

        JPanel top = new JPanel();
        top.setLayout(new GridLayout(3, 1));
        top.add(new JLabel("Nhập dữ liệu:"));
        top.add(new JScrollPane(inputArea));
        top.add(new JLabel("Thuật toán:"));
        top.add(algoBox);

        JPanel buttons = new JPanel();
        buttons.add(encryptBtn);
        buttons.add(decryptBtn);

        frame.add(top, BorderLayout.NORTH);
        frame.add(buttons, BorderLayout.CENTER);
        frame.add(new JScrollPane(outputArea), BorderLayout.SOUTH);

        Runnable action = (boolean encrypt) -> {
            try {
                String input = inputArea.getText();
                String selected = (String) algoBox.getSelectedItem();
                Encryptable encryptor = selected.equals("AES") ? new AESEncryptor() : new RSAEncryptor();

                new Thread(new CryptoTask(encryptor, input, encrypt, outputArea)).start();
            } catch (Exception e) {
                outputArea.setText("Lỗi: " + e.getMessage());
            }
        };

        encryptBtn.addActionListener(e -> action.run(true));
        decryptBtn.addActionListener(e -> action.run(false));

        frame.setVisible(true);
    }
}

