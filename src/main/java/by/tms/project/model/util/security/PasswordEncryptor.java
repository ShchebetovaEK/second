package by.tms.project.model.util.security;

import org.mindrot.jbcrypt.BCrypt;

/**
 * @author ShchebetovaEK
 *
 * final class PasswordEncryptor
 *
 */
public  final class PasswordEncryptor {

    /**
     * The SALT.
     */
    private static  final  String SALT = BCrypt.gensalt();

    /**
     * encrypt String.
     * @param password
     * @return String.
     */
    public static String encrypt(String  password){
        return BCrypt.hashpw(password,SALT);
    }

    private PasswordEncryptor(){}
}
