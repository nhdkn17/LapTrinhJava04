package EncryptionApp;

import javax.crypto.Cipher;
import java.security.*;
import java.util.Base64;

public class RSAEncryptor implements Encryptable {
    private static KeyPair keyPair;

    public RSAEncryptor() throws Exception {
        if (keyPair == null) {
            KeyPairGenerator generator = KeyPairGenerator.getInstance("RSA");
            generator.initialize(2048);
            keyPair = generator.generateKeyPair();
        }
    }

    public String encrypt(String input) throws Exception {
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.ENCRYPT_MODE, keyPair.getPublic());
        byte[] enc = cipher.doFinal(input.getBytes());
        return Base64.getEncoder().encodeToString(enc);
    }

    public String decrypt(String input) throws Exception {
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.DECRYPT_MODE, keyPair.getPrivate());
        byte[] dec = cipher.doFinal(Base64.getDecoder().decode(input));
        return new String(dec);
    }
}

