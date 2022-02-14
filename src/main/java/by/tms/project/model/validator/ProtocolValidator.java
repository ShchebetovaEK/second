package by.tms.project.model.validator;

public interface ProtocolValidator {

    boolean isPayerValid(String payer);

    boolean isApplicationValid(String application);

    boolean isStatusValid(String status);
}
