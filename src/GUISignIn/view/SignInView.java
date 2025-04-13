package GUISignIn.view;

import GUISignIn.model.UserConfig;
import GUISignIn.model.UserManager;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.File;

public class SignInView extends JFrame {
    private UserManager userManager = new UserManager();
    private DefaultTableModel tableModel;

    public SignInView() {
        setTitle("Ứng dụng quản lý người dùng");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JTabbedPane tabbedPane = new JTabbedPane();

        tabbedPane.addTab("Đăng ký", createRegisterPanel());
        tabbedPane.addTab("Đăng nhập", createLoginPanel());
        tabbedPane.addTab("Người dùng", createUserListPanel());

        add(tabbedPane);
        setVisible(true);
    }

    private JPanel createRegisterPanel() {
        JPanel panel = new JPanel(new GridLayout(4, 2, 10, 10));
        JTextField usernameField = new JTextField();
        JPasswordField passwordField = new JPasswordField();

        JButton registerButton = new JButton("Đăng ký");

        JLabel message = new JLabel("");

        registerButton.addActionListener((ActionEvent e) -> {
            String username = usernameField.getText();
            String password = new String(passwordField.getPassword());

            if (userManager.register(username, password)) {
                message.setText("Đăng ký thành công!");
                usernameField.setText("");
                passwordField.setText("");
                refreshTable();
            } else {
                message.setText("Tên đăng nhập đã tồn tại!");
            }
        });

        panel.add(new JLabel("Tên đăng nhập:"));
        panel.add(usernameField);
        panel.add(new JLabel("Mật khẩu:"));
        panel.add(passwordField);
        panel.add(registerButton);
        panel.add(message);
        return panel;
    }

    private JPanel createLoginPanel() {
        JPanel panel = new JPanel(new GridLayout(4, 2, 10, 10));
        JTextField usernameField = new JTextField();
        JPasswordField passwordField = new JPasswordField();

        JButton loginButton = new JButton("Đăng nhập");

        JLabel message = new JLabel("");

        loginButton.addActionListener((ActionEvent e) -> {
            String username = usernameField.getText();
            String password = new String(passwordField.getPassword());

            if (userManager.login(username, password)) {
                message.setText("Đăng nhập thành công!");
            } else {
                message.setText("Sai tên đăng nhập hoặc mật khẩu.");
            }
        });

        panel.add(new JLabel("Tên đăng nhập:"));
        panel.add(usernameField);
        panel.add(new JLabel("Mật khẩu:"));
        panel.add(passwordField);
        panel.add(loginButton);
        panel.add(message);
        return panel;
    }

    private JPanel createUserListPanel() {
        JPanel panel = new JPanel(new BorderLayout());

        // Bảng người dùng
        String[] columnNames = {"Tên đăng nhập"};
        tableModel = new DefaultTableModel(columnNames, 0);
        JTable table = new JTable(tableModel);

        JButton exportButton = new JButton("Xuất XML");
        JButton importButton = new JButton("Nhập XML");

        exportButton.addActionListener((ActionEvent e) -> {
            JFileChooser fileChooser = new JFileChooser();
            if (fileChooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
                File file = fileChooser.getSelectedFile();
                try {
                    userManager.exportToXML(file);
                    JOptionPane.showMessageDialog(null, "Xuất thành công!");
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Lỗi khi xuất: " + ex.getMessage());
                }
            }
        });

        importButton.addActionListener((ActionEvent e) -> {
            JFileChooser fileChooser = new JFileChooser();
            if (fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                File file = fileChooser.getSelectedFile();
                try {
                    userManager.importFromXML(file);
                    refreshTable();
                    JOptionPane.showMessageDialog(null, "Nhập thành công!");
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Lỗi khi nhập: " + ex.getMessage());
                }
            }
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(exportButton);
        buttonPanel.add(importButton);

        panel.add(new JScrollPane(table), BorderLayout.CENTER);
        panel.add(buttonPanel, BorderLayout.SOUTH);
        return panel;
    }

    private void refreshTable() {
        tableModel.setRowCount(0);
        for (UserConfig user : userManager.getUsers()) {
            tableModel.addRow(new Object[]{user.getUsername()});
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new SignInView());
    }
}
