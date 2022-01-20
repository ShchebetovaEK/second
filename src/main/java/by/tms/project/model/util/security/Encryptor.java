package by.tms.project.model.util.security;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public  final class Encryptor {
    private static final Logger logger = LogManager.getLogger();
    private static final String HASH_FUNCTION = "SHA-256";
    private static final String SALT_KEY = "5hr8Uh32Hr";

    private Encryptor() {
    }

    public static String encrypt(String password) {
        StringBuilder hash = new StringBuilder();
        byte[] passwordBytes = password.getBytes(StandardCharsets.UTF_8);
        byte[] saltBytes = SALT_KEY.getBytes(StandardCharsets.UTF_8);
        try {
            MessageDigest digest = MessageDigest.getInstance(HASH_FUNCTION);
            digest.update(saltBytes);
            byte[] resultBytes = digest.digest(passwordBytes);
            for (byte next : resultBytes) {
                hash.append(next);
            }
        } catch (NoSuchAlgorithmException e) {
            logger.warn("Password wasn't encrypted.", e);
        }
        return hash.toString();
    }
}
