package by.tms.project.model.validator.impl;

import by.tms.project.model.validator.PatientValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.math.BigDecimal;
import java.util.Map;

import static by.tms.project.controller.command.RequestParameter.*;

/**
 * @author  ShchebetovaEK
 *
 * class PatientValidatorImpl
 */
public class PatientValidatorImpl implements PatientValidator {
    private static final Logger logger = LogManager.getLogger();
    private static PatientValidatorImpl instance;


    private PatientValidatorImpl() {
    }

    /**
     * Gets instance.
     *
     * @return the instance
     */
    public static PatientValidatorImpl getInstance() {
        if (instance == null) {
            instance = new PatientValidatorImpl();
        }

        return instance;
    }

    @Override
    public boolean isDiscount(Integer discount) {
        boolean match = false;
        try {
            if (discount!=null &&  discount > 0 && discount <= 30){
                match = true;
            }
        } catch (IllegalArgumentException e) {
            match = false;
        }
        return match;
    }

    public boolean isMoneyAccount(BigDecimal moneyAccount) {
        boolean match = true;
        try {

            moneyAccount.abs();
        } catch (IllegalArgumentException e) {
            match = false;
        }
        return match;
    }


    public boolean checkUserPatientData(Map<String, String> userData) {
        boolean isValid = true;

        if (!isDiscount(Integer.valueOf(userData.get(DISCOUNT)))) {
            userData.put(DISCOUNT, INVALID_DISCOUNT);
            isValid = false;
        }
        return isValid;
    }
}
