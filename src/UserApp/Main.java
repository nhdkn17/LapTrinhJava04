package UserApp;

import UserApp.model.User;
import UserApp.utils.BCryptUtils;
import UserApp.utils.XMLUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static List<User> userList = new ArrayList<>();

    public static void main(String[] args) {
        JFrame frame = new JFrame("Quản lý người dùng");
        frame.setSize(500, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());

        JTextField usernameField = new JTextField(15);
        JTextField emailField = new JTextField(15);
        JPasswordField passwordField = new JPasswordField(15);
        DefaultListModel<String> listModel = new DefaultListModel<>();
        JList<String> userListView = new JList<>(listModel);

        JButton registerButton = new JButton("Đăng ký");
        JButton loginButton = new JButton("Đăng nhập");
        JButton exportButton = new JButton("Xuất XML");
        JButton importButton = new JButton("Nhập XML");

        frame.add(new JLabel("Tên đăng nhập:"));
        frame.add(usernameField);
        frame.add(new JLabel("Email:"));
        frame.add(emailField);
        frame.add(new JLabel("Mật khẩu:"));
        frame.add(passwordField);

        frame.add(registerButton);
        frame.add(loginButton);
        frame.add(exportButton);
        frame.add(importButton);

        frame.add(new JScrollPane(userListView));
        frame.setVisible(true);

        registerButton.addActionListener(e -> {
            String username = usernameField.getText();
            String email = emailField.getText();
            String password = new String(passwordField.getPassword());

            if (username.isEmpty() || email.isEmpty() || password.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Vui lòng nhập đầy đủ thông tin.");
                return;
            }

            String hash = BCryptUtils.hashPassword(password);
            userList.add(new User(username, email, hash));
            listModel.addElement(username + " - " + email);
            JOptionPane.showMessageDialog(frame, "Đăng ký thành công.");
        });

        loginButton.addActionListener(e -> {
            String username = usernameField.getText();
            String password = new String(passwordField.getPassword());

            for (User user : userList) {
                if (user.getUsername().equals(username) &&
                        BCryptUtils.checkPassword(password, user.getPasswordHash())) {
                    JOptionPane.showMessageDialog(frame, "Đăng nhập thành công.");
                    return;
                }
            }
            JOptionPane.showMessageDialog(frame, "Sai thông tin đăng nhập.");
        });

        exportButton.addActionListener(e -> {
            JFileChooser chooser = new JFileChooser();
            if (chooser.showSaveDialog(frame) == JFileChooser.APPROVE_OPTION) {
                try {
                    XMLUtils.exportUsers(userList, chooser.getSelectedFile());
                    JOptionPane.showMessageDialog(frame, "Xuất XML thành công.");
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(frame, "Lỗi: " + ex.getMessage());
                }
            }
        });

        importButton.addActionListener(e -> {
            JFileChooser chooser = new JFileChooser();
            if (chooser.showOpenDialog(frame) == JFileChooser.APPROVE_OPTION) {
                try {
                    userList = XMLUtils.importUsers(chooser.getSelectedFile());
                    listModel.clear();
                    for (User user : userList) {
                        listModel.addElement(user.getUsername() + " - " + user.getEmail());
                    }
                    JOptionPane.showMessageDialog(frame, "Nhập XML thành công.");
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(frame, "Lỗi: " + ex.getMessage());
                }
            }
        });
    }
}

