package by.tms.project.model.validator.impl;

import by.tms.project.model.entity.Application;
import by.tms.project.model.entity.Payer;
import by.tms.project.model.entity.Status;
import by.tms.project.model.validator.ProtocolValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @author ShchebetovaEK
 *
 * class ProtocolValidatorImpl
 *
 */
public class ProtocolValidatorImpl implements ProtocolValidator {
    private static final Logger logger = LogManager.getLogger();
    private static ProtocolValidatorImpl instance;

    private ProtocolValidatorImpl() {
    }

    /**
     * Gets instance.
     *
     * @return the instance
     */
    public static ProtocolValidatorImpl getInstance() {
        if (instance == null) {
            instance = new ProtocolValidatorImpl();
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
