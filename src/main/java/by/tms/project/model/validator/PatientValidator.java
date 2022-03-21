package by.tms.project.model.validator;

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
public class PatientValidator {
    private static final Logger logger = LogManager.getLogger();
    private static PatientValidator instance;


    private PatientValidator() {
    }

    /**
     * Gets instance.
     *
     * @return the instance
     */
    public static PatientValidator getInstance() {
        if (instance == null) {
            instance = new PatientValidator();
        }

        return instance;
    }

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
