package by.tms.project.model.validator;

import by.tms.project.model.entity.Application;
import by.tms.project.model.entity.Payer;
import by.tms.project.model.entity.Status;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @author ShchebetovaEK
 *
 * class ProtocolValidatorImpl
 *
 */
public class ProtocolValidator {
    private static final Logger logger = LogManager.getLogger();
    private static ProtocolValidator instance;

    private ProtocolValidator() {
    }

    /**
     * Gets instance.
     *
     * @return the instance
     */
    public static ProtocolValidator getInstance() {
        if (instance == null) {
            instance = new ProtocolValidator();
        }
        return instance;
    }

    public boolean isPayerValid(String payer) {
        boolean match = true;
        try {
            Payer.valueOf(payer);
        } catch (IllegalArgumentException e) {
            match = false;
        }
        return match;
    }

    public boolean isApplicationValid(String application) {
        boolean match = true;
        try {
            Application.valueOf(application);
        } catch (IllegalArgumentException e) {
            match = false;
        }
        return match;
    }

    public boolean isStatusValid(String status) {
        boolean match = true;
        try {
            Status.valueOf(status);
        } catch (IllegalArgumentException e) {
            match = false;
        }
        return match;
    }
}
