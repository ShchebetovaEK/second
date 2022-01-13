package by.tms.project.exception;

/**
 * @author ShchebetovaEK
 *
 * class MailException
 */
public class MailException extends Exception{
    public MailException() {
        super();
    }

    public MailException(String message) {
        super(message);
    }

    public MailException(String message, Throwable cause) {
        super(message, cause);
    }

    public MailException(Throwable cause) {
        super(cause);
    }
}
