package EncryptionApp;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

public class AESEncryptor implements Encryptable {
    private static final String ALGO = "AES";
    private static final byte[] keyBytes = "1234567890123456".getBytes();
    private final SecretKeySpec key = new SecretKeySpec(keyBytes, ALGO);

    public String encrypt(String input) throws Exception {
        Cipher cipher = Cipher.getInstance(ALGO);
        cipher.init(Cipher.ENCRYPT_MODE, key);
        byte[] enc = cipher.doFinal(input.getBytes());
        return Base64.getEncoder().encodeToString(enc);
    }

    public String decrypt(String input) throws Exception {
        Cipher cipher = Cipher.getInstance(ALGO);
        cipher.init(Cipher.DECRYPT_MODE, key);
        byte[] dec = cipher.doFinal(Base64.getDecoder().decode(input));
        return new String(dec);
    }
}

