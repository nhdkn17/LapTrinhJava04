package EncryptionApp;

public class CryptoTask implements Runnable {
    private final Encryptable encryptor;
    private final String input;
    private final boolean isEncrypt;
    private final javax.swing.JTextArea outputArea;

    public CryptoTask(Encryptable encryptor, String input, boolean isEncrypt, javax.swing.JTextArea outputArea) {
        this.encryptor = encryptor;
        this.input = input;
        this.isEncrypt = isEncrypt;
        this.outputArea = outputArea;
    }

    public void run() {
        try {
            String result = isEncrypt ? encryptor.encrypt(input) : encryptor.decrypt(input);
            javax.swing.SwingUtilities.invokeLater(() -> outputArea.setText(result));
        } catch (Exception e) {
            e.printStackTrace();
            javax.swing.SwingUtilities.invokeLater(() -> outputArea.setText("Lỗi: " + e.getMessage()));
        }
    }
}

