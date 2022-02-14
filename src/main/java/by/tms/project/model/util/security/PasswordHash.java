package by.tms.project.model.util.security;

import com.google.common.hash.Hashing;

import java.nio.charset.StandardCharsets;

/**
 * @author ShchebetovaEK
 * <p>
 * final class PasswordHash
 */
public final class PasswordHash {

    private PasswordHash() {
    }

    public static String encrypt(String password) {

        String passwordHash = Hashing.sha256()
                .hashString(password, StandardCharsets.UTF_8)
                .toString();

        return passwordHash;
    }

}
